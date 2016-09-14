package com.doro.background.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doro.background.dal.entity.UserAcct;
import com.doro.background.dal.entity.UserAcctChange;
import com.doro.background.dal.entity.UserAcctChange.EnumAcctType;
import com.doro.background.dal.entity.UserAsset;
import com.doro.background.dal.entity.UserHqRedeemApplication;
import com.doro.background.dal.entity.UserWithdrawApplication;
import com.doro.background.dal.mapper.PayExpenseIncomeMapper;
import com.doro.background.dal.mapper.PaySinaTradeSellMapper;
import com.doro.background.dal.mapper.UserAcctChangeMapper;
import com.doro.background.dal.mapper.UserAcctMapper;
import com.doro.background.dal.mapper.UserAssetMapper;
import com.doro.background.dal.mapper.UserHqRedeemApplicationMapper;
import com.doro.background.dal.mapper.UserSinaMapper;
import com.doro.background.dal.mapper.UserWithdrawApplicationMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.sina.service.impl.SinaService;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.page.PageDealUtil;

@Service
public class UserWithdrawApplicationService {
	@Autowired
	UserWithdrawApplicationMapper userWithdrawApplicationMapper;
	@Autowired
	UserSinaMapper userSinaMapper;
	@Autowired
	SinaService sinaService;
	@Autowired
	PaySinaTradeSellMapper paySinaTradeSellMapper;
	@Autowired
	PayExpenseIncomeMapper payExpenseIncomeMapper;
	@Autowired
	UserHqRedeemApplicationMapper userHqRedeemApplicationMapper;
	@Autowired
	UserAssetMapper userAssetMapper;
	@Autowired
	UserAcctMapper userAcctMapper;
	@Autowired
	UserAcctChangeMapper userAcctChangeMapper;

	/**
	 * 
	 * TODO 方法作用：赎回列表页
	 * 
	 * @param record
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 下午2:07:34
	 */
	public List<Map<String, Object>> queryWithdraw(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		return userHqRedeemApplicationMapper.selectPageList(param);
	}

	/**
	 * 
	 * TODO 方法作用：统计条数
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 下午2:16:44
	 */
	public int count(Map<String, Object> param) {
		return userHqRedeemApplicationMapper.count(param);
	}

	public UserWithdrawApplication queryUserWithdraw(Long applicationId) {
		return userWithdrawApplicationMapper.selectByPrimaryKey(applicationId);
	}

	/**
	 * 
	 * TODO 方法作用：赎回审核通过
	 * 
	 * @param jsonMessage
	 * @param applicationId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 下午4:16:23
	 */
	@Transactional
	public JsonMessage loan(Long applicationId) {
		JsonMessage jsonMessage = new JsonMessage(true, "");
		if (applicationId == null) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("参数错误");
			return jsonMessage;
		}
		UserHqRedeemApplication userHqRedeem = userHqRedeemApplicationMapper.selectByPrimaryKeyForUpdate(applicationId);
		if (userHqRedeem == null) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("赎回申请不存在");
			return jsonMessage;
		}
		// 申请赎回的金额
		BigDecimal amount = userHqRedeem.getAmount();
		// 减少冻结资产
		UserAsset asset = userAssetMapper.selectHqByUserIdForUpdate(userHqRedeem.getUserId());
		if (asset == null) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("活期记录不存在");
			return jsonMessage;
		}
		asset.setAssetFrozen(asset.getAssetFrozen().subtract(amount));
		userAssetMapper.updateByPrimaryKeySelective(asset);
		// 增加可用资金
		UserAcct acct = userAcctMapper.selectByUserIdForUpdate(userHqRedeem.getUserId());
		acct.setAcctBalance(acct.getAcctBalance().add(amount));
		userAcctMapper.updateByPrimaryKeySelective(acct);
		// 创建用户资金变更记录
		UserAcctChange acctChange = new UserAcctChange();
		acctChange.setUserId(userHqRedeem.getUserId());
		acctChange.setEnumAcctType(EnumAcctType.KYYE.getCode());
		acctChange.setAmount(amount);
		acctChange.setRemark("赎回申请|");
		acctChange.setCreateTime(DRDateUtil.getNow(DRDateUtil.YYYYMMDDHHMMSSMS));
		userAcctChangeMapper.insert(acctChange);
		// 修改赎回申请记录状态
		userHqRedeem.setRemark("后台审核通过|");
		userHqRedeem.setEnumRedeemState(UserHqRedeemApplication.EnumRedeemState.SHCG.getCode());
		userHqRedeemApplicationMapper.updateByPrimaryKeySelective(userHqRedeem);

		jsonMessage.setMessage("操作成功！");
		return jsonMessage;
	}

}
