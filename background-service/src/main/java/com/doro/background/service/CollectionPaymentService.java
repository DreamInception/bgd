package com.doro.background.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.doro.background.dal.entity.PaySinaTradeBuyPay;
import com.doro.background.dal.entity.PaySinaTradeSellPay;
import com.doro.background.dal.mapper.PaySinaTradeBuyPayMapper;
import com.doro.background.dal.mapper.PaySinaTradeSellPayMapper;
import com.doro.background.sina.entity.CreateHostingCollectTrade;
import com.doro.background.sina.entity.CreateSingleHostingPayTrade;
import com.doro.background.sina.entity.QueryHostingTrade;
import com.doro.background.sina.entity.returns.CreateSingleHostingPayTradeReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingTradeReturnMsg;
import com.doro.background.sina.service.ISinaService;
import com.doro.background.sina.tools.SinaConstantFactory;
import com.doro.component.utils.common.IdFactory;
import com.doro.component.utils.common.SinaUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;




@Service
public class CollectionPaymentService {

	private static final Logger logger = LoggerFactory.getLogger(CollectionPaymentService.class);

	@Autowired
	PaySinaTradeBuyPayMapper paySinaTradeBuyPayMapper;
	@Autowired
	PaySinaTradeSellPayMapper paySinaTradeSellPayMapper;

	public List<PaySinaTradeSellPay> querySellPay(PaySinaTradeSellPay bo) {
		return paySinaTradeSellPayMapper.selectList(bo);
	}

	public List<PaySinaTradeBuyPay> queryBuyPay(PaySinaTradeBuyPay bo) {
		return paySinaTradeBuyPayMapper.selectList(bo);
	}

	@Transactional
	public Map<String, String> saveSellPay(Map<String, String> map, PaySinaTradeSellPay bo,ISinaService sinaService) {
		Date date = new Date();
		if (bo.getAmount() == null || !StringUtils.hasText(bo.getTitle())) {
			map.put("msg", "参数异常");
			return map;
		}
		Long tradeId = IdFactory.paySinaTradeSellPayId.nextId();
		String outTradeNo = SinaUtil.transationNo(true, tradeId);
		PaySinaTradeSellPay sellPay = new PaySinaTradeSellPay();
		sellPay.setAmount(bo.getAmount());
		sellPay.setCreateTime(date);
		sellPay.setEnumSinaTradeState(PaySinaTradeSellPay.EnumSinaTradeState.LOADIING.getCode());
		sellPay.setOutTradeNo(outTradeNo);
		sellPay.setPayerId(SinaConstantFactory.instance.currentSina.getPayeeIdentityId());
		sellPay.setPayerIdentityType("EMAIL");
		sellPay.setRemark("新浪赎回代收提交|");
		sellPay.setTitle(bo.getTitle());
		sellPay.setTradeId(tradeId);
		sellPay.setOpRemark("操作ip=" + SinaUtil.getIp());
		paySinaTradeSellPayMapper.insertSelective(sellPay);

		CreateHostingCollectTrade collectTrade = new CreateHostingCollectTrade();
		collectTrade.setAmount(bo.getAmount().toString());
		collectTrade.setNotifyUrl(SinaUtil.sysadminNotifyUrl);
		collectTrade.setOutTradeCode("1002");
		collectTrade.setOutTradeNo(outTradeNo);
		collectTrade.setPayerId(SinaConstantFactory.instance.currentSina.getPayeeIdentityId());
		collectTrade.setPayerIdentityType("EMAIL");
		collectTrade.setPayerIp(SinaUtil.getIp());
		collectTrade.setPayMethod(SinaUtil.getPayMethod2(bo.getAmount()));
		collectTrade.setSummary("新浪赎回代收");
		String returnMsg = sinaService.createHostingCollectTrade(collectTrade);
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(returnMsg,JsonObject.class);
		String code = jsonObject.get("response_code").toString();
		if (!"APPLY_SUCCESS".equals(code)) {
			map.put("msg", jsonObject.get("response_message").toString());
		} else {
			map.put("msg", "新浪提交成功");
		}
		return map;
	}

	@Transactional
	public Map<String, String> saveBuyPay(Map<String, String> map, PaySinaTradeBuyPay bo,ISinaService sinaService) {
		Date date = new Date();
		if (bo.getAmount() == null || !StringUtils.hasText(bo.getTitle())) {
			map.put("msg", "参数异常");
			return map;
		}
		Long tradeId = IdFactory.paySinaTradeBuyPayId.nextId();
		String outTradeNo = SinaUtil.transationNo(false, tradeId);
		PaySinaTradeBuyPay buyPay = new PaySinaTradeBuyPay();
		buyPay.setAmount(bo.getAmount());
		buyPay.setCreateTime(date);
		buyPay.setEnumSinaTradeState(PaySinaTradeSellPay.EnumSinaTradeState.LOADIING.getCode());
		buyPay.setOutTradeNo(outTradeNo);
		buyPay.setPayeeIdentityId(SinaConstantFactory.instance.currentSina.getPayeeIdentityId());
		buyPay.setPayeeIdentityType("EMAIL");
		buyPay.setRemark("新浪投资代付提交|");
		buyPay.setTitle(bo.getTitle());
		buyPay.setTradeId(tradeId);
		buyPay.setOpRemark("操作ip=" + SinaUtil.getIp());
		paySinaTradeBuyPayMapper.insertSelective(buyPay);

		CreateSingleHostingPayTrade payTrade = new CreateSingleHostingPayTrade();
		payTrade.setAccountType("BASIC");
		payTrade.setAmount(bo.getAmount().toString());
		payTrade.setNotifyUrl(SinaUtil.sysadminNotifyUrl);
		payTrade.setOutTradeCode("2001");
		payTrade.setOutTradeNo(outTradeNo);
		payTrade.setPayeeIdentityId(SinaConstantFactory.instance.currentSina.getPayeeIdentityId());
		payTrade.setPayeeIdentityType("EMAIL");
		payTrade.setSummary("用户投资代付");
		CreateSingleHostingPayTradeReturnMsg returnMsg = sinaService.createSingleHostingPayTrade(payTrade);
		if (!"APPLY_SUCCESS".equals(returnMsg.getResponse_code())) {
			map.put("msg", returnMsg.getResponse_message());
		} else {
			map.put("msg", "新浪提交成功");
		}
		return map;
	}

	@Transactional
	public void sellPayAndBuyPayTask(ISinaService sinaService) {
		PaySinaTradeSellPay paySinaTradeSellPay = paySinaTradeSellPayMapper.selectOne();
		if (paySinaTradeSellPay != null) {
			String outTradeNo = paySinaTradeSellPay.getOutTradeNo();
			QueryHostingTrade queryHostingTrade = new QueryHostingTrade();
			queryHostingTrade.setOutTradeNo(outTradeNo);
			QueryHostingTradeReturnMsg returnMsg = sinaService.queryHostingTrade(queryHostingTrade);
			if (!"APPLY_SUCCESS".equals(returnMsg.getResponse_code())) {
				logger.info("新浪查询失败,新浪返回的错误信息" + returnMsg.getResponse_message());
				return;
			} else {
				String state = returnMsg.getTradeList().split("\\|")[0].split("\\^")[3];
				if ("TRADE_FINISHED".equals(state)) {
					paySinaTradeSellPay.setEnumSinaTradeState(PaySinaTradeSellPay.EnumSinaTradeState.SUCCESS.getCode());
					paySinaTradeSellPay.setRemark(paySinaTradeSellPay.getRemark()+"主动查询成功state="+state);
				} else if ("TRADE_CLOSED".equals(state) || "TRADE_FAILED".equals(state)) {
					paySinaTradeSellPay.setRemark(paySinaTradeSellPay.getRemark()+"主动查询失败state="+state);
					paySinaTradeSellPay.setEnumSinaTradeState(PaySinaTradeSellPay.EnumSinaTradeState.FAIL.getCode());
				}
				paySinaTradeSellPayMapper.updateByPrimaryKeySelective(paySinaTradeSellPay);
				return;
			}
		} else {
			PaySinaTradeBuyPay paySinaTradeBuyPay = paySinaTradeBuyPayMapper.selectOne();
			if (paySinaTradeBuyPay == null) {
				logger.info("没有需要处理的数据--后台管理员代收代付");
				return;
			} else {
				String outTradeNo = paySinaTradeBuyPay.getOutTradeNo();
				QueryHostingTrade queryHostingTrade = new QueryHostingTrade();
				queryHostingTrade.setOutTradeNo(outTradeNo);
				QueryHostingTradeReturnMsg returnMsg = sinaService.queryHostingTrade(queryHostingTrade);
				if (!"APPLY_SUCCESS".equals(returnMsg.getResponse_code())) {
					logger.info("新浪查询失败,新浪返回的错误信息" + returnMsg.getResponse_message());
					return;
				} else {
					String state = returnMsg.getTradeList().split("\\|")[0].split("\\^")[3];
					if ("TRADE_FINISHED".equals(state)) {
						paySinaTradeBuyPay.setRemark(paySinaTradeBuyPay.getRemark()+"主动查询成功state="+state);
						paySinaTradeBuyPay.setEnumSinaTradeState(PaySinaTradeBuyPay.EnumSinaTradeState.SUCCESS.getCode());
					}else if("TRADE_CLOSED".equals(state) || "TRADE_FAILED".equals(state)){
						paySinaTradeBuyPay.setRemark(paySinaTradeBuyPay.getRemark()+"主动查询失败state="+state);
						paySinaTradeBuyPay.setEnumSinaTradeState(PaySinaTradeBuyPay.EnumSinaTradeState.FAIL.getCode());
					}
					paySinaTradeBuyPayMapper.updateByPrimaryKeySelective(paySinaTradeBuyPay);
					return;
				}
			}
		}
	}
}
