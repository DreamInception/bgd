package com.doro.background.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baofoo.entity.BaofooFopay;
import com.baofoo.sdk.base.response.TransContent;
import com.baofoo.sdk.base.response.TransHead;
import com.baofoo.sdk.base.response.TransRespBF0040001;
import com.baofoo.service.IBaofooFopayService;
import com.doro.background.dal.entity.BaofooBind;
import com.doro.background.dal.entity.BaofooOutgo;
import com.doro.background.dal.entity.PayBank;
import com.doro.background.dal.entity.UserAcct;
import com.doro.background.dal.entity.UserAcctChange;
import com.doro.background.dal.entity.UserOutgoApplication;
import com.doro.background.dal.mapper.BaofooBindMapper;
import com.doro.background.dal.mapper.BaofooOutgoMapper;
import com.doro.background.dal.mapper.PayBankMapper;
import com.doro.background.dal.mapper.UserAcctChangeMapper;
import com.doro.background.dal.mapper.UserAcctMapper;
import com.doro.background.dal.mapper.UserOutgoApplicationMapper;
import com.doro.component.utils.common.IdFactory;
import com.doro.component.utils.page.PageDealUtil;

@Service
public class UserOutgoApplicationService {

	Logger logger = LoggerFactory.getLogger(UserOutgoApplicationService.class);
	@Autowired
	UserOutgoApplicationMapper userOutgoApplicationMapper;
	@Autowired
	IBaofooFopayService baofooFopayService;
	@Autowired
	BaofooBindMapper baofooBindMapper;
	@Autowired
	PayBankMapper payBankMapper;
	@Autowired
	BaofooOutgoMapper baofooOutgoMapper;
	@Autowired
	UserAcctMapper userAcctMapper;
	@Autowired
	UserAcctChangeMapper userAcctChangeMapper;

	public List<UserOutgoApplication> selectListPage(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<UserOutgoApplication> result = userOutgoApplicationMapper.selectPage(param);
		logger.info("查询列表result:{}", result);
		return result;
	}

	public int count(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		int reunt = userOutgoApplicationMapper.count(param);
		logger.info("查询列表result:{}", reunt);
		return reunt;
	}

	public Map<String, Object> fopay(Long applicationId, Map<String, Object> map) {
		UserOutgoApplication userOutgoApplication = userOutgoApplicationMapper.selectByPrimaryKey(applicationId);
		if (userOutgoApplication == null) {
			map.put("msg", "申请记录不存在");
			return map;
		} else {
			if (userOutgoApplication.getEnumWithdrawState().intValue() != UserOutgoApplication.EnumWithdrawState.DRSH
					.getCode()) {
				map.put("msg", "申请记录状态异常");
				return map;
			}
		}
		BaofooBind baofooBind = baofooBindMapper.selectByPrimaryKey(userOutgoApplication.getUserId());
		if (baofooBind == null || !baofooBind.getIsBind()) {
			map.put("msg", "用户绑定信息不正确");
			return map;
		}
		PayBank payBank = payBankMapper.selectBankName(baofooBind.getPayCode());
		long no = IdFactory.applicationId.nextId();
		saveBaofooOutgo(applicationId, baofooBind, userOutgoApplication, payBank.getBankName(), no);
		BaofooFopay baofooFopay = new BaofooFopay();
		baofooFopay.setToAccName(baofooBind.getIdHolder());
		baofooFopay.setToAccNo(baofooBind.getAccNo());
		baofooFopay.setToBankName(payBank.getBankName());
		baofooFopay.setTransmoney(userOutgoApplication.getActualAmount().toString());
		baofooFopay.setTransNo("TX" + no);
		baofooFopay.setTransSummary("用户提现");
		TransContent<TransRespBF0040001> transContent = baofooFopayService.baofooFopay(baofooFopay);
		TransHead trans_head = transContent.getTrans_head();
		if ("0000".equals(trans_head.getReturn_code()) || "200".equals(trans_head.getReturn_code())) {
			map.put("msg", "付款成功");
			return map;
		} else {
			userOutgoApplication.setEnumWithdrawState(UserOutgoApplication.EnumWithdrawState.YC.getCode());
			userOutgoApplication.setRemark(userOutgoApplication.getRemark() + trans_head.getReturn_msg() + "|");
			int i = userOutgoApplicationMapper.updateByPrimaryKey(userOutgoApplication);
			if (i == 1) {
				map.put("msg", "付款失败");
			} else {
				map.put("msg", "付款失败,更新本地数据库失败");
			}
		}
		return map;
	}

	@Transactional
	public void saveBaofooOutgo(Long applicationId, BaofooBind baofooBind, UserOutgoApplication userOutgoApplication,
			String payBank, Long no) {
		BaofooOutgo baofooOutgo = new BaofooOutgo();
		baofooOutgo.setApplicationId(applicationId);
		baofooOutgo.setCreateTime(new Date());
		baofooOutgo.setEnumTradeState(BaofooOutgo.EnumTradeState.LOADING.getCode());
		baofooOutgo.setRemark("放款前置|");
		baofooOutgo.setToAccDept("");
		baofooOutgo.setToAccName(baofooBind.getIdHolder());
		baofooOutgo.setToAccNo(baofooBind.getAccNo());
		baofooOutgo.setToBankName(payBank);
		baofooOutgo.setToCityName("");
		baofooOutgo.setToProName("");
		baofooOutgo.setTransMoney(userOutgoApplication.getActualAmount());
		;
		baofooOutgo.setTransSummary("用户提现");
		baofooOutgo.setTransNo("TX" + no);
		baofooOutgoMapper.insertSelective(baofooOutgo);
		userOutgoApplication.setEnumWithdrawState(UserOutgoApplication.EnumWithdrawState.YTJFK.getCode());
		userOutgoApplication.setRemark(userOutgoApplication.getRemark() + "已提交付款|");
		userOutgoApplicationMapper.updateByPrimaryKeySelective(userOutgoApplication);
	}

	public Map<String, Object> assetBack(Long applicationId,Map<String, Object> map){
		UserOutgoApplication userOutgoApplication = userOutgoApplicationMapper.selectByPrimaryKey(applicationId);
		if(userOutgoApplication == null){
			map.put("msg", "该笔订单不存在");
			return map;
		}
		if(userOutgoApplication.getEnumWithdrawState().intValue() == UserOutgoApplication.EnumWithdrawState.YC.getCode()){
			Long userId = userOutgoApplication.getUserId();
			BigDecimal deductAmount = userOutgoApplication.getDeductAmount();
			UserAcct userAcct = userAcctMapper.selectByPrimaryKey(userId);
			if(userAcct == null){
				map.put("msg", "用户资产数据不存在");
			}else{
				if(userAcct.getAcctFrozen().compareTo(deductAmount)<0){
					map.put("msg", "退回金额大于用户冻结金额");
				}else{
					boolean flag = updateAcctFrozen(deductAmount, userId,  userOutgoApplication);
					if(flag){
						map.put("msg", "回退成功");
					}else{
						map.put("msg", "回退失败");
					}
				}
			}
		}else{
			map.put("msg", "订单状态异常");
		}
		return map;
	}
	@Transactional(rollbackFor=Exception.class)
	public boolean updateAcctFrozen(BigDecimal deductAmount,Long userId,UserOutgoApplication userOutgoApplication){
		int i = userAcctMapper.updateAcctFrozen(deductAmount, userId);
		if(i==1){
			UserAcctChange change = new UserAcctChange();
			change.setAmount(deductAmount);
			change.setCreateTime(new Date());
			change.setEnumAcctType(UserAcctChange.EnumAcctType.KYYE.getCode());
			change.setRemark("放款回退余额增加");
			change.setUserId(userId);
			userAcctChangeMapper.insertSelective(change);
			change.setAmount(new BigDecimal("0").subtract(deductAmount));
			change.setEnumAcctType(UserAcctChange.EnumAcctType.DJYE.getCode());
			change.setRemark("放款回退冻结减少");
			userAcctChangeMapper.insertSelective(change);
			userOutgoApplication.setRemark(userOutgoApplication.getRemark()+"|提现回退成功|");
			userOutgoApplication.setEnumWithdrawState(UserOutgoApplication.EnumWithdrawState.YCYCL.getCode());
			userOutgoApplicationMapper.updateByPrimaryKey(userOutgoApplication);
			return true;
		}else{
			return false;
		}
	}
	public Map<String, Object> alertMsg(Long applicationId,Map<String, Object> map){
		UserOutgoApplication userOutgoApplication = userOutgoApplicationMapper.selectByPrimaryKey(applicationId);
		if(userOutgoApplication == null){
			map.put("msg", "该笔订单不存在");
			return map;
		}
		map.put("msg", userOutgoApplication.getRemark());
		return map;
	}
}
