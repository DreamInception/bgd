package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.dal.entity.PaySinaTradeBuyPay;
import com.doro.background.dal.entity.PaySinaTradeSellPay;
import com.doro.background.service.CollectionPaymentService;
import com.doro.background.sina.entity.QueryBalance;
import com.doro.background.sina.entity.QueryMiddleAccount;
import com.doro.background.sina.entity.returns.QueryBalanceReturnMsg;
import com.doro.background.sina.entity.returns.QueryMiddleAccountReturnMsg;
import com.doro.background.sina.service.impl.SinaService;
import com.doro.background.sina.tools.SinaConstantFactory;

@Controller
@RequestMapping("/collectionPayment")
public class CollectionPaymentController {
	private static final Logger logger = LoggerFactory.getLogger(CollectionPaymentController.class);
	@Autowired
	CollectionPaymentService collectionPaymentService;
	@Autowired
	SinaService sinaService;

	@RequestMapping("/sellPay") // 代收
	public String indexSellPay(PaySinaTradeSellPay bo, Model model) {
		List<PaySinaTradeSellPay> pays = collectionPaymentService.querySellPay(bo);
		for (PaySinaTradeSellPay paySinaTradeSellPay : pays) {
			paySinaTradeSellPay.setState(
					PaySinaTradeSellPay.EnumSinaTradeState.getDescs(paySinaTradeSellPay.getEnumSinaTradeState()));
		}
		model.addAttribute("bo", bo);
		model.addAttribute("pays", pays);
		return "/collection_payment/sell_pay_list";
	}
	
	@RequestMapping("/sellPayRefresh") // 代收
	public String indexSellPayRefresh(PaySinaTradeSellPay bo, Model model) {
		List<PaySinaTradeSellPay> pays = collectionPaymentService.querySellPay(bo);
		for (PaySinaTradeSellPay paySinaTradeSellPay : pays) {
			paySinaTradeSellPay.setState(
					PaySinaTradeSellPay.EnumSinaTradeState.getDescs(paySinaTradeSellPay.getEnumSinaTradeState()));
		}
		model.addAttribute("bo", bo);
		model.addAttribute("pays", pays);
		return "/collection_payment/sell_pay_refresh";
	}
	
	@ResponseBody
	@RequestMapping("/toSellPayAdd")
	public Map<String, Object> toSellPayAdd(Model model) {
		Map<String, Object> map = new HashMap<>();
		// 查询账户余额
		QueryBalance queryBalance = new QueryBalance();
		queryBalance.setIdentityId(SinaConstantFactory.instance.currentSina.getPartnerId());
		queryBalance.setIdentityType("MEMBER_ID");
		queryBalance.setAccountType("BASIC");
		QueryBalanceReturnMsg returnMsg = sinaService.queryBalance(queryBalance);
		if (!returnMsg.getResponse_code().equals("APPLY_SUCCESS")) {
			map.put("error", returnMsg.getResponse_message());
		} else {
			map.put("balance", returnMsg.getAvailable_balance());
		}
		// 查询中间账户余额
		QueryMiddleAccount queryMiddleAccount = new QueryMiddleAccount();
		queryMiddleAccount.setOutTradeCode("1002");
		QueryMiddleAccountReturnMsg returnMsg2 = sinaService.queryMiddleAccountReturnMsg(queryMiddleAccount);
		if (!returnMsg2.getResponse_code().equals("APPLY_SUCCESS")) {
			model.addAttribute("error", returnMsg.getResponse_message());
			map.put("error", returnMsg.getAvailable_balance());
		} else {
			String account_list = returnMsg2.getAccount_list();
			String amount = account_list.split("\\|")[0].split("\\^")[2];
			map.put("amount", amount);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/saveSellPay")
	public Map<String, String> saveSellPay(PaySinaTradeSellPay bo) {
		Map<String, String> map = new HashMap<>();
		try {
			map = collectionPaymentService.saveSellPay(map, bo,sinaService);
		} catch (Exception e) {
			map.put("msg", "系统错误");
			logger.error("系统错误", e);
		}
		return map;
	}

	@RequestMapping("/buyPay") // 代付
	public String indexBuyPay(PaySinaTradeBuyPay bo, Model model) {
		List<PaySinaTradeBuyPay> pays = collectionPaymentService.queryBuyPay(bo);
		for (PaySinaTradeBuyPay paySinaTradeBuyPay : pays) {
			paySinaTradeBuyPay.setState(
					PaySinaTradeBuyPay.EnumSinaTradeState.getDescs(paySinaTradeBuyPay.getEnumSinaTradeState()));
		}
		model.addAttribute("bo", bo);
		model.addAttribute("pays", pays);
		return "/collection_payment/buy_pay_list";
	}
	@RequestMapping("/buyPayRefresh") // 代付
	public String buyPayRefresh(PaySinaTradeBuyPay bo, Model model) {
		List<PaySinaTradeBuyPay> pays = collectionPaymentService.queryBuyPay(bo);
		for (PaySinaTradeBuyPay paySinaTradeBuyPay : pays) {
			paySinaTradeBuyPay.setState(
					PaySinaTradeBuyPay.EnumSinaTradeState.getDescs(paySinaTradeBuyPay.getEnumSinaTradeState()));
		}
		model.addAttribute("bo", bo);
		model.addAttribute("pays", pays);
		return "/collection_payment/buy_pay_refresh";
	}
	
	@ResponseBody
	@RequestMapping("/toBuyPayAdd")
	public Map<String, Object> toBuyPayAdd(Model model) {
		Map<String, Object> map = new HashMap<>();
		// 查询账户余额
		QueryBalance queryBalance = new QueryBalance();
		queryBalance.setIdentityId(SinaConstantFactory.instance.currentSina.getPartnerId());
		queryBalance.setIdentityType("MEMBER_ID");
		queryBalance.setAccountType("BASIC");
		QueryBalanceReturnMsg returnMsg = sinaService.queryBalance(queryBalance);
		if (!returnMsg.getResponse_code().equals("APPLY_SUCCESS")) {
			map.put("error", returnMsg.getResponse_message());
		} else {
			map.put("balance", returnMsg.getAvailable_balance());
		}
		// 查询中间账户余额
		QueryMiddleAccount queryMiddleAccount = new QueryMiddleAccount();
		queryMiddleAccount.setOutTradeCode("2001");
		QueryMiddleAccountReturnMsg returnMsg2 = sinaService.queryMiddleAccountReturnMsg(queryMiddleAccount);
		if (!returnMsg2.getResponse_code().equals("APPLY_SUCCESS")) {
			map.put("error", returnMsg.getResponse_message());
		} else {
			String account_list = returnMsg2.getAccount_list();
			String amount = account_list.split("\\|")[0].split("\\^")[2];
			map.put("amount", amount);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping("/saveBuyPay")
	public Map<String, String> saveBuyPay(PaySinaTradeBuyPay bo) {
		Map<String, String> map = new HashMap<>();
		try {
			map = collectionPaymentService.saveBuyPay(map, bo,sinaService);
		} catch (Exception e) {
			map.put("msg", "系统错误");
			logger.error("系统错误", e);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping("/sellPayAndBuyPayTask")
	public void sellPayAndBuyPayTask(){
		collectionPaymentService.sellPayAndBuyPayTask(sinaService);
	}

}
