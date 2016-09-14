package com.doro.background.sina.service.impl;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.doro.background.sina.entity.BindingBankCard;
import com.doro.background.sina.entity.BindingBankCardAdvance;
import com.doro.background.sina.entity.BindingVerify;
import com.doro.background.sina.entity.CreateActivateMember;
import com.doro.background.sina.entity.CreateHostingCollectTrade;
import com.doro.background.sina.entity.CreateHostingDeposit;
import com.doro.background.sina.entity.CreateHostingWithdraw;
import com.doro.background.sina.entity.CreateSingleHostingPayTrade;
import com.doro.background.sina.entity.QueryBalance;
import com.doro.background.sina.entity.QueryHostingDeposit;
import com.doro.background.sina.entity.QueryHostingTrade;
import com.doro.background.sina.entity.QueryHostingWithdraw;
import com.doro.background.sina.entity.QueryIsSetPayPassword;
import com.doro.background.sina.entity.QueryMiddleAccount;
import com.doro.background.sina.entity.SetPayPassword;
import com.doro.background.sina.entity.SetRealName;
import com.doro.background.sina.entity.ShowMemberInfosSina;
import com.doro.background.sina.entity.returns.BindingBankCardAdvanceReturnMsg;
import com.doro.background.sina.entity.returns.BindingBankCardReturnMsg;
import com.doro.background.sina.entity.returns.CreateHostingDepositReturnMsg;
import com.doro.background.sina.entity.returns.CreateHostingWithdrawReturnMsg;
import com.doro.background.sina.entity.returns.CreateSingleHostingPayTradeReturnMsg;
import com.doro.background.sina.entity.returns.QueryBalanceReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingDepositReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingTradeReturnMsg;
import com.doro.background.sina.entity.returns.QueryHostingWithdrawReturnMsg;
import com.doro.background.sina.entity.returns.QueryIsSetPayPasswordReturnMsg;
import com.doro.background.sina.entity.returns.QueryMiddleAccountReturnMsg;
import com.doro.background.sina.entity.returns.QueryTradeReturnMsg;
import com.doro.background.sina.entity.returns.ReturnMsg;
import com.doro.background.sina.entity.returns.SetPayPasswordReturnMsg;
import com.doro.background.sina.entity.returns.ShowMemberInfosSinaReturnMsg;
import com.doro.background.sina.service.ISinaService;
import com.doro.background.sina.tools.Base64;
import com.doro.background.sina.tools.CallServiceUtil;
import com.doro.background.sina.tools.CommonUtils;
import com.doro.background.sina.tools.DateUtil;
import com.doro.background.sina.tools.GsonUtil;
import com.doro.background.sina.tools.RSA;
import com.doro.background.sina.tools.SignUtil;
import com.doro.background.sina.tools.SinaConstant;
import com.doro.background.sina.tools.SinaConstantFactory;
import com.doro.background.sina.tools.Tools;




@Service
public class SinaService implements ISinaService {

	Logger logger = LoggerFactory.getLogger(SinaService.class);
	
	private static SinaConstant sina = SinaConstantFactory.instance.currentSina;
	
	public ReturnMsg createActivateMember(CreateActivateMember createActivateMember) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		basicMap.put("request_time", DateUtil.date2string("yyyyMMddHHmmss"));
		basicMap.put("service", "create_activate_member");
		if (StringUtils.hasText(createActivateMember.getIdentityId())) {
			basicMap.put("identity_id", createActivateMember.getIdentityId());
		}
		if (StringUtils.hasText(createActivateMember.getMemberType())) {
			basicMap.put("member_type", createActivateMember.getMemberType());
		}
		if (StringUtils.hasText(createActivateMember.getExtendParam())) {
			basicMap.put("extend_param", createActivateMember.getExtendParam());
		}
		basicMap.put("identity_type", createActivateMember.getIdentityType());
		ReturnMsg returnMsg = null;
		try {
			String param = Tools.createLinkString(basicMap, false);
			SignUtil.sign(param, basicMap);
			param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param),
					basicMap.get("_input_charset").toString());
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, ReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用create_activate_member接口失败", e);
		}
		return returnMsg;
	}

	public ReturnMsg setRealName(SetRealName setRealName) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "set_real_name");
		basicMap.put("cert_type", "IC");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(setRealName.getCertNo())) {
			basicMap.put("cert_no", setRealName.getCertNo());
		}
		basicMap.put("cert_type", setRealName.getCertType());
		if (StringUtils.hasText(setRealName.getExtendParam())) {
			basicMap.put("extend_param", setRealName.getExtendParam());
		}
		if (StringUtils.hasText(setRealName.getIdentityId())) {
			basicMap.put("identity_id", setRealName.getIdentityId());
		}
		basicMap.put("identity_type", setRealName.getIdentityType());
		if (StringUtils.hasText(setRealName.getNeedConfirm())) {
			basicMap.put("need_confirm", setRealName.getNeedConfirm());
		}
		if (StringUtils.hasText(setRealName.getRealName())) {
			basicMap.put("real_name", setRealName.getRealName());
		}
		byte[] real_name_byte = null;
		byte[] cert_no_byte = null;
		try {
			real_name_byte = RSA.encryptByPublicKey(basicMap.get("real_name").getBytes("utf-8"), sina.getRsa_public());
			cert_no_byte = RSA.encryptByPublicKey(basicMap.get("cert_no").getBytes(), sina.getRsa_public());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String base64_real_name_encrypt = Base64.encode(real_name_byte);
		String base64_cert_no_encrypt = Base64.encode(cert_no_byte);

		basicMap.put("real_name", base64_real_name_encrypt);
		basicMap.put("cert_no", base64_cert_no_encrypt);
		String content = Tools.createLinkString(basicMap, false);
		ReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, ReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用set_real_name接口失败", e);
		}
		return returnMsg;
	}

	public ReturnMsg bindingVerify(BindingVerify bindingVerify) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "binding_verify");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(bindingVerify.getExtendParam())) {
			basicMap.put("extend_param", bindingVerify.getExtendParam());
		}
		if (StringUtils.hasText(bindingVerify.getIdentityId())) {
			basicMap.put("identity_id", bindingVerify.getIdentityId());
		}
		if (StringUtils.hasText(bindingVerify.getVerifyEntity())) {
			basicMap.put("verify_entity", bindingVerify.getVerifyEntity());
		}
		basicMap.put("identity_type", bindingVerify.getIdentityType());
		basicMap.put("verify_type", bindingVerify.getVerifyType());
		byte[] verify_entity_byte = null;
		try {
			verify_entity_byte = RSA.encryptByPublicKey(basicMap.get("verify_entity").getBytes("utf-8"), sina.getRsa_public());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String base64_verify_entity_encrypt = Base64.encode(verify_entity_byte);
		basicMap.put("verify_entity", base64_verify_entity_encrypt);
		String content = Tools.createLinkString(basicMap, false);
		ReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, ReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用binding_verify接口失败", e);
		}
		return returnMsg;
	}

	public BindingBankCardReturnMsg bindingBankCard(BindingBankCard bandingBankCard) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "binding_bank_card");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(bandingBankCard.getAccountName())) {
			basicMap.put("account_name", bandingBankCard.getAccountName());
		}
		if (StringUtils.hasText(bandingBankCard.getIdentityId())) {
			basicMap.put("identity_id", bandingBankCard.getIdentityId());
		}
		if (StringUtils.hasText(bandingBankCard.getBankAccountNo())) {
			basicMap.put("bank_account_no", bandingBankCard.getBankAccountNo());
		}
		if (StringUtils.hasText(bandingBankCard.getBankBranch())) {
			basicMap.put("bank_branch", bandingBankCard.getBankBranch());
		}
		if (StringUtils.hasText(bandingBankCard.getBankCode())) {
			basicMap.put("bank_code", bandingBankCard.getBankCode());
		}
		if (StringUtils.hasText(bandingBankCard.getCardAttribute())) {
			basicMap.put("card_attribute", bandingBankCard.getCardAttribute());
		}
		if (StringUtils.hasText(bandingBankCard.getCardType())) {
			basicMap.put("card_type", bandingBankCard.getCardType());
		}
		if (StringUtils.hasText(bandingBankCard.getCertNo())) {
			basicMap.put("cert_no", bandingBankCard.getCertNo());
		}
		if (StringUtils.hasText(bandingBankCard.getCertType())) {
			basicMap.put("cert_type", bandingBankCard.getCertType());
		}
		if (StringUtils.hasText(bandingBankCard.getCity())) {
			basicMap.put("city", bandingBankCard.getCity());
		}
		if (StringUtils.hasText(bandingBankCard.getExtendParam())) {
			basicMap.put("extend_param", bandingBankCard.getExtendParam());
		}
		if (StringUtils.hasText(bandingBankCard.getVerificationValue())) {
			basicMap.put("verification_value", bandingBankCard.getVerificationValue());
		}
		if (StringUtils.hasText(bandingBankCard.getVerifyMode())) {
			basicMap.put("verify_mode", bandingBankCard.getVerifyMode());
		}
		if (StringUtils.hasText(bandingBankCard.getIdentityType())) {
			basicMap.put("identity_type", bandingBankCard.getIdentityType());
		}
		if (StringUtils.hasText(bandingBankCard.getPhoneNo())) {
			basicMap.put("phone_no", bandingBankCard.getPhoneNo());
		}
		if (StringUtils.hasText(bandingBankCard.getProvince())) {
			basicMap.put("province", bandingBankCard.getProvince());
		}
		if (StringUtils.hasText(bandingBankCard.getRequestNo())) {
			basicMap.put("request_no", bandingBankCard.getRequestNo());
		}
		if (StringUtils.hasText(bandingBankCard.getValidityPeriod())) {
			basicMap.put("validity_period", bandingBankCard.getValidityPeriod());
		}
		byte[] bank_account_no_byte = null;
		byte[] account_name_byte = null;
		byte[] cert_no_byte = null;
		byte[] phone_no_byte = null;
		byte[] validity_period_byte = null;
		byte[] verification_value_byte = null;
		try {
			bank_account_no_byte = RSA.encryptByPublicKey(basicMap.get("bank_account_no").getBytes("utf-8"),
					sina.getRsa_public());
			if (StringUtils.hasText(basicMap.get("account_name"))) {
				account_name_byte = RSA.encryptByPublicKey(basicMap.get("account_name").getBytes("utf-8"), sina.getRsa_public());
			}
			if (StringUtils.hasText(basicMap.get("cert_no"))) {
				cert_no_byte = RSA.encryptByPublicKey(basicMap.get("cert_no").getBytes("utf-8"), sina.getRsa_public());
			}
			phone_no_byte = RSA.encryptByPublicKey(basicMap.get("phone_no").getBytes("utf-8"), sina.getRsa_public());
			if (StringUtils.hasText(basicMap.get("validity_period"))) {
				validity_period_byte = RSA.encryptByPublicKey(basicMap.get("validity_period").getBytes("utf-8"),
						sina.getRsa_public());
			}
			if (StringUtils.hasText(basicMap.get("verification_value"))) {
				verification_value_byte = RSA.encryptByPublicKey(basicMap.get("verification_value").getBytes("utf-8"),
						sina.getRsa_public());
			}
			String base64_bank_account_no_encrypt = Base64.encode(bank_account_no_byte);
			if (validity_period_byte != null) {
				String base64_account_name_encrypt = Base64.encode(account_name_byte);
				basicMap.put("account_name", base64_account_name_encrypt);
			}
			if (validity_period_byte != null) {
				String base64_cert_no_encrypt = Base64.encode(cert_no_byte);
				basicMap.put("cert_no", base64_cert_no_encrypt);
			}
			String base64_phone_no_encrypt = Base64.encode(phone_no_byte);
			String base64_validity_period_encrypt = null;
			if (validity_period_byte != null) {
				base64_validity_period_encrypt = Base64.encode(validity_period_byte);
				basicMap.put("validity_period", base64_validity_period_encrypt);
			}
			String base64_verification_value_encrypt = null;
			if (verification_value_byte != null) {
				base64_verification_value_encrypt = Base64.encode(verification_value_byte);
				basicMap.put("verification_value", base64_verification_value_encrypt);
			}
			basicMap.put("bank_account_no", base64_bank_account_no_encrypt);

			basicMap.put("phone_no", base64_phone_no_encrypt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String content = Tools.createLinkString(basicMap, false);
		BindingBankCardReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, BindingBankCardReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用binding_verify接口失败", e);
		}
		return returnMsg;
	}

	public BindingBankCardAdvanceReturnMsg bindingBankCardAdvance(BindingBankCardAdvance bankCardAdvance) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "binding_bank_card_advance");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(bankCardAdvance.getTicket())) {
			basicMap.put("ticket", bankCardAdvance.getTicket());
		}
		if (StringUtils.hasText(bankCardAdvance.getValidCode())) {
			basicMap.put("valid_code", bankCardAdvance.getValidCode());
		}
		if (StringUtils.hasText(bankCardAdvance.getExtendParam())) {
			basicMap.put("extend_param", bankCardAdvance.getExtendParam());
		}

		String content = Tools.createLinkString(basicMap, false);
		BindingBankCardAdvanceReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content,basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, BindingBankCardAdvanceReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用binding_verify接口失败", e);
		}
		return returnMsg;
	}

	public String createHostionDeposit(CreateHostingDeposit createHostingDeposit) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "create_hosting_deposit");
		basicMap.put("request_time", time);
		String ex = "channel_black_list^online_bank";
		createHostingDeposit.setExtendParam(ex);
		if (StringUtils.hasText(createHostingDeposit.getIdentityId())) {
			basicMap.put("identity_id", createHostingDeposit.getIdentityId());
		}
		if (createHostingDeposit.getAmount() != null) {
			basicMap.put("amount", createHostingDeposit.getAmount().toString());
		}
		if (StringUtils.hasText(createHostingDeposit.getAccountType())) {
			basicMap.put("account_type", createHostingDeposit.getAccountType());
		}
		if (StringUtils.hasText(createHostingDeposit.getExtendParam())) {
			basicMap.put("extend_param", createHostingDeposit.getExtendParam());
		}
		if (StringUtils.hasText(createHostingDeposit.getIdentityType())) {
			basicMap.put("identity_type", createHostingDeposit.getIdentityType());
		}
		if (StringUtils.hasText(createHostingDeposit.getOutTradeNo())) {
			basicMap.put("out_trade_no", createHostingDeposit.getOutTradeNo());
		}
		if (StringUtils.hasText(createHostingDeposit.getPayerIp())) {
			basicMap.put("payer_ip", createHostingDeposit.getPayerIp());
		}
		if (StringUtils.hasText(createHostingDeposit.getPayMethod())) {
			basicMap.put("pay_method", createHostingDeposit.getPayMethod());
		}
		if (StringUtils.hasText(createHostingDeposit.getSummary())) {
			basicMap.put("summary", createHostingDeposit.getSummary());
		}
		if (StringUtils.hasText(createHostingDeposit.getUserFee())) {
			basicMap.put("user_fee", createHostingDeposit.getUserFee());
		}
		if (StringUtils.hasText(createHostingDeposit.getNotifyUrl())) {
			basicMap.put("notify_url", createHostingDeposit.getNotifyUrl());
		}
		if (StringUtils.hasText(createHostingDeposit.getReturnUrl())) {
			basicMap.put("return_url", createHostingDeposit.getReturnUrl());
		}
		String content = Tools.createLinkString(basicMap, false);
		String result = "";
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			logger.error("调用create_hostion_deposit接口失败", e);
		}
		return result;
	}

	public String createHostionWithdraw(CreateHostingWithdraw createHostingWithdraw) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "create_hosting_withdraw");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(createHostingWithdraw.getIdentityId())) {
			basicMap.put("identity_id", createHostingWithdraw.getIdentityId());
		}
		if (createHostingWithdraw.getAmount() != null) {
			basicMap.put("amount", createHostingWithdraw.getAmount().toString());
		}
		if (StringUtils.hasText(createHostingWithdraw.getAccountType())) {
			basicMap.put("account_type", createHostingWithdraw.getAccountType());
		}
		if (StringUtils.hasText(createHostingWithdraw.getExtendParam())) {
			basicMap.put("extend_param", createHostingWithdraw.getExtendParam());
		}
		if (StringUtils.hasText(createHostingWithdraw.getIdentityType())) {
			basicMap.put("identity_type", createHostingWithdraw.getIdentityType());
		}
		if (StringUtils.hasText(createHostingWithdraw.getOutTradeNo())) {
			basicMap.put("out_trade_no", createHostingWithdraw.getOutTradeNo());
		}
		if (StringUtils.hasText(createHostingWithdraw.getSummary())) {
			basicMap.put("summary", createHostingWithdraw.getSummary());
		}
		if (StringUtils.hasText(createHostingWithdraw.getUserFee())) {
			basicMap.put("user_fee", createHostingWithdraw.getUserFee());
		}
		if (StringUtils.hasText(createHostingWithdraw.getWithdrawMode())) {
			basicMap.put("withdraw_mode", createHostingWithdraw.getWithdrawMode());
		}
		if (StringUtils.hasText(createHostingWithdraw.getNotifyUrl())) {
			basicMap.put("notify_url", createHostingWithdraw.getNotifyUrl());
		}
		if (StringUtils.hasText(createHostingWithdraw.getReturnUrl())) {
			basicMap.put("return_url", createHostingWithdraw.getReturnUrl());
		}
		if (StringUtils.hasText(createHostingWithdraw.getCardId())) {
			basicMap.put("card_id", createHostingWithdraw.getCardId());
		}
		if (StringUtils.hasText(createHostingWithdraw.getPaytoType())) {
			basicMap.put("payto_type", createHostingWithdraw.getPaytoType());
		}
		String content = Tools.createLinkString(basicMap, false);
		String result = "";
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			logger.error("create_hosting_withdraw签名失败", e);
		}
		return result;
	}

	public CreateSingleHostingPayTradeReturnMsg createSingleHostingPayTrade(CreateSingleHostingPayTrade createSingleHostingPayTrade) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "create_single_hosting_pay_trade");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(createSingleHostingPayTrade.getPayeeIdentityId())) {
			basicMap.put("payee_identity_id", createSingleHostingPayTrade.getPayeeIdentityId());
		}
		if (createSingleHostingPayTrade.getAmount() != null) {
			basicMap.put("amount", new BigDecimal(createSingleHostingPayTrade.getAmount()).setScale(2, BigDecimal.ROUND_DOWN).toString()  );
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getAccountType())) {
			basicMap.put("account_type", createSingleHostingPayTrade.getAccountType());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getExtendParam())) {
			basicMap.put("extend_param", createSingleHostingPayTrade.getExtendParam());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getPayeeIdentityType())) {
			basicMap.put("payee_identity_type", createSingleHostingPayTrade.getPayeeIdentityType());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getOutTradeNo())) {
			basicMap.put("out_trade_no", createSingleHostingPayTrade.getOutTradeNo());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getSummary())) {
			basicMap.put("summary", createSingleHostingPayTrade.getSummary());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getNotifyUrl())) {
			basicMap.put("notify_url", createSingleHostingPayTrade.getNotifyUrl());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getReturnUrl())) {
			basicMap.put("return_url", createSingleHostingPayTrade.getReturnUrl());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getOutTradeCode())) {
			basicMap.put("out_trade_code", createSingleHostingPayTrade.getOutTradeCode());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getGoodsId())) {
			basicMap.put("goods_id", createSingleHostingPayTrade.getGoodsId());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getOutTradeCode())) {
			basicMap.put("out_trade_code", createSingleHostingPayTrade.getOutTradeCode());
		}
		if (StringUtils.hasText(createSingleHostingPayTrade.getSplitList())) {
			basicMap.put("split_list", createSingleHostingPayTrade.getSplitList());
		}
		String content = Tools.createLinkString(basicMap, false);
		CreateSingleHostingPayTradeReturnMsg returnMsg = null;
		String result = "";
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, CreateSingleHostingPayTradeReturnMsg.class);
		} catch (Exception e) {
			logger.error("create_hosting_withdraw签名失败", e);
		}

		return returnMsg;
	}

	public String createHostingCollectTrade(CreateHostingCollectTrade collectTrade) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "create_hosting_collect_trade");
		basicMap.put("request_time", time);
		String ex = "channel_black_list^online_bank";
		collectTrade.setExtendParam(ex);
		if (StringUtils.hasText(collectTrade.getCanRepayOnFailed())) {
			basicMap.put("can_repay_on_failed", collectTrade.getCanRepayOnFailed());
		}
		if (StringUtils.hasText(collectTrade.getCollectTradeType())) {
			basicMap.put("collect_trade_type", collectTrade.getCollectTradeType());
		}
		if (StringUtils.hasText(collectTrade.getExtendParam())) {
			basicMap.put("extend_param", collectTrade.getExtendParam());
		}
		if (StringUtils.hasText(collectTrade.getGoodsId())) {
			basicMap.put("goods_id", collectTrade.getGoodsId());
		}
		if (StringUtils.hasText(collectTrade.getOutTradeCode())) {
			basicMap.put("out_trade_code", collectTrade.getOutTradeCode());
		}
		if (StringUtils.hasText(collectTrade.getOutTradeNo())) {
			basicMap.put("out_trade_no", collectTrade.getOutTradeNo());
		}
		if (StringUtils.hasText(collectTrade.getPayerId())) {
			basicMap.put("payer_id", collectTrade.getPayerId());
		}
		if (StringUtils.hasText(collectTrade.getPayerIdentityType())) {
			basicMap.put("payer_identity_type", collectTrade.getPayerIdentityType());
		}
		if (StringUtils.hasText(collectTrade.getPayerIp())) {
			basicMap.put("payer_ip", collectTrade.getPayerIp());
		}
		if (StringUtils.hasText(collectTrade.getPayMethod())) {
			basicMap.put("pay_method", collectTrade.getPayMethod());
		}
		if (StringUtils.hasText(collectTrade.getSummary())) {
			basicMap.put("summary", collectTrade.getSummary());
		}
		if (StringUtils.hasText(collectTrade.getTradeCloseTime())) {
			basicMap.put("trade_close_time", collectTrade.getTradeCloseTime());
		}
		if (StringUtils.hasText(collectTrade.getReturnUrl())) {
			basicMap.put("return_url", collectTrade.getReturnUrl());
		}
		if (StringUtils.hasText(collectTrade.getNotifyUrl())) {
			basicMap.put("notify_url", collectTrade.getNotifyUrl());
		}
		String content = Tools.createLinkString(basicMap, false);
		String result = "";
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			logger.error("create_hosting_collect_trade失败", e);
		}

		return result;
	}

	public SetPayPasswordReturnMsg setPayPassword(SetPayPassword setPayPassword) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "set_pay_password");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(setPayPassword.getExtendParam())) {
			basicMap.put("extend_param", setPayPassword.getExtendParam());
		}
		if (StringUtils.hasText(setPayPassword.getIdentityId())) {
			basicMap.put("identity_id", setPayPassword.getIdentityId());
		}
		if (StringUtils.hasText(setPayPassword.getIdentityType())) {
			basicMap.put("identity_type", setPayPassword.getIdentityType());
		}
		if (StringUtils.hasText(setPayPassword.getReturnUrl())) {
			basicMap.put("return_url", setPayPassword.getReturnUrl());
		}
		String content = Tools.createLinkString(basicMap, false);
		SetPayPasswordReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, SetPayPasswordReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用set_pay_password接口失败", e);
		}
		return returnMsg;
	}

	public ShowMemberInfosSinaReturnMsg showMemberInfosSina(ShowMemberInfosSina showMemberInfosSina) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "show_member_infos_sina");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(showMemberInfosSina.getExtendParam())) {
			basicMap.put("extend_param", showMemberInfosSina.getExtendParam());
		}
		if (StringUtils.hasText(showMemberInfosSina.getIdentityId())) {
			basicMap.put("identity_id", showMemberInfosSina.getIdentityId());
		}
		if (StringUtils.hasText(showMemberInfosSina.getIdentityType())) {
			basicMap.put("identity_type", showMemberInfosSina.getIdentityType());
		}

		if (StringUtils.hasText(showMemberInfosSina.getDefaultPage())) {
			basicMap.put("default_page", showMemberInfosSina.getDefaultPage());
		}
		if (StringUtils.hasText(showMemberInfosSina.getHidePage())) {
			basicMap.put("hide_pages", showMemberInfosSina.getHidePage());
		}
		if (StringUtils.hasText(showMemberInfosSina.getRespMethod())) {
			basicMap.put("resp_method", showMemberInfosSina.getRespMethod());
		}
		if (StringUtils.hasText(showMemberInfosSina.getSingleCustom())) {
			basicMap.put("single_custom", showMemberInfosSina.getSingleCustom());
		}
		if (StringUtils.hasText(showMemberInfosSina.getTempletCustom())) {
			basicMap.put("templet_custom", showMemberInfosSina.getTempletCustom());
		}
		String content = Tools.createLinkString(basicMap, false);
		ShowMemberInfosSinaReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content,basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, ShowMemberInfosSinaReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用show_member_infos_sina接口失败", e);
		}
		return returnMsg;
	}

	public QueryIsSetPayPasswordReturnMsg queryIsSetPayPassword(QueryIsSetPayPassword queryIsSetPayPassword) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_is_set_pay_password");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryIsSetPayPassword.getExtendParam())) {
			basicMap.put("extend_param", queryIsSetPayPassword.getExtendParam());
		}
		if (StringUtils.hasText(queryIsSetPayPassword.getIdentityId())) {
			basicMap.put("identity_id", queryIsSetPayPassword.getIdentityId());
		}
		if (StringUtils.hasText(queryIsSetPayPassword.getIdentityType())) {
			basicMap.put("identity_type", queryIsSetPayPassword.getIdentityType());
		}
		String content = Tools.createLinkString(basicMap, false);
		QueryIsSetPayPasswordReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content,basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryIsSetPayPasswordReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_is_set_pay_password接口失败", e);
		}
		return returnMsg;
	}

	public boolean DenotifyUrlDecrypt(CreateHostingDepositReturnMsg msg) {
		System.out.println(msg.getSign());
		Map<String, String> map = new HashMap<String, String>();
		map.put("deposit_amount", msg.getDeposit_amount());
		map.put("deposit_status", msg.getDeposit_status());
		map.put("inner_trade_no", msg.getInner_trade_no());
		map.put("out_trade_no", msg.getOut_trade_no());
		map.put("partner_id", msg.getPartner_id());
		map.put("pay_method", msg.getPay_method());
		map.put("response_code", msg.getResponse_code());
		map.put("reponse_message", msg.getResponse_message());
		map.put("response_time", msg.getResponse_time());
		map.put("input_charset_", msg.get_input_charset());
		Tools.createLinkString(map, false);
		try {
//			if (SignUtil.Check_sign(like_result.toString(), msg.getSign(), msg.getSign_type(), rsa_sign_public,
//					"UTF-8")) {
//				return true;
//			}
		} catch (Exception e) {
			logger.error("充值异步回调参数验证失败", e);
		}
		return false;
	}

	public QueryHostingDepositReturnMsg queryHostingDeposit(QueryHostingDeposit queryHostingDeposit) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_hosting_deposit");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryHostingDeposit.getAccountType())) {
			basicMap.put("account_type", queryHostingDeposit.getAccountType());
		}
		if (StringUtils.hasText(queryHostingDeposit.getEndTime())) {
			basicMap.put("end_time", queryHostingDeposit.getEndTime());
		}
		if (StringUtils.hasText(queryHostingDeposit.getExtendParam())) {
			basicMap.put("extend_param", queryHostingDeposit.getExtendParam());
		}

		if (StringUtils.hasText(queryHostingDeposit.getIdentityId())) {
			basicMap.put("identity_id", queryHostingDeposit.getIdentityId());
		}
		if (StringUtils.hasText(queryHostingDeposit.getIdentityType())) {
			basicMap.put("identity_type", queryHostingDeposit.getIdentityType());
		}
		if (StringUtils.hasText(queryHostingDeposit.getOutTradeNo())) {
			basicMap.put("out_trade_no", queryHostingDeposit.getOutTradeNo());
		}
		if (StringUtils.hasText(queryHostingDeposit.getPageNo())) {
			basicMap.put("page_no", queryHostingDeposit.getPageNo());
		}
		if (StringUtils.hasText(queryHostingDeposit.getPageSize())) {
			basicMap.put("page_size", queryHostingDeposit.getPageSize());
		}
		if (StringUtils.hasText(queryHostingDeposit.getStartTime())) {
			basicMap.put("start_time", queryHostingDeposit.getStartTime());
		}
		String content = Tools.createLinkString(basicMap, false);
		QueryHostingDepositReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryHostingDepositReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_hosting_deposit接口失败", e);
		}
		return returnMsg;
	}

	public boolean withdrawnotifyUrlDecrypt(CreateHostingWithdrawReturnMsg msg) {
		System.out.println(msg.getSign());
		Map<String, String> map = new HashMap<String, String>();
		map.put("input_charset_", msg.get_input_charset());
		if (!StringUtils.hasText(msg.getCard_id())) {
			map.put("card_id", msg.getCard_id());
		}
		map.put("inner_trade_no", msg.getInner_trade_no());
		map.put("outer_trade_no", msg.getOuter_trade_no());
		map.put("partner_id", msg.getPartner_id());
		map.put("pay_method", msg.getResponse_code());
		map.put("reponse_message", msg.getResponse_message());
		map.put("response_time", msg.getResponse_time());
		map.put("response_code", msg.getResponse_code());
		map.put("withdraw_status", msg.getWithdraw_status());
		Tools.createLinkString(map, false);
		try {
//			if (SignUtil.Check_sign(like_result.toString(), msg.getSign(), msg.getSign_type(), rsa_sign_public,
//					"UTF-8")) {
//				return true;
//			}
		} catch (Exception e) {
			logger.error("充值异步回调参数验证失败", e);
		}
		return false;
	}

	public QueryHostingWithdrawReturnMsg queryHostingWithdraw(QueryHostingWithdraw queryHostingWithdraw) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_hosting_withdraw");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryHostingWithdraw.getAccountType())) {
			basicMap.put("account_type", queryHostingWithdraw.getAccountType());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getEndTime())) {
			basicMap.put("end_time", queryHostingWithdraw.getEndTime());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getExtendParam())) {
			basicMap.put("extend_param", queryHostingWithdraw.getExtendParam());
		}

		if (StringUtils.hasText(queryHostingWithdraw.getIdentityId())) {
			basicMap.put("identity_id", queryHostingWithdraw.getIdentityId());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getIdentityType())) {
			basicMap.put("identity_type", queryHostingWithdraw.getIdentityType());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getOutTradeNo())) {
			basicMap.put("out_trade_no", queryHostingWithdraw.getOutTradeNo());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getPageNo())) {
			basicMap.put("page_no", queryHostingWithdraw.getPageNo());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getPageSize())) {
			basicMap.put("page_size", queryHostingWithdraw.getPageSize());
		}
		if (StringUtils.hasText(queryHostingWithdraw.getStartTime())) {
			basicMap.put("start_time", queryHostingWithdraw.getStartTime());
		}
		String content = Tools.createLinkString(basicMap, false);
		QueryHostingWithdrawReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result+"query_hosting_withdraw");
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryHostingWithdrawReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_hosting_withdraw接口失败", e);
		}
		return returnMsg;
	}

	public boolean collectTradenotifyUrlDecrypt(QueryTradeReturnMsg msg) {
		System.out.println(msg.getSign());
		Map<String, String> map = new HashMap<String, String>();
		map.put("input_charset_", msg.get_input_charset());
		map.put("outer_trade_no", msg.getOuter_trade_no());
		map.put("inner_trade_no", msg.getInner_trade_no());
		map.put("trade_status", msg.getTrade_status());
		map.put("trade_amount", String.valueOf(msg.getTrade_amount()));
		map.put("gmt_create", msg.getGmt_create());
		if (StringUtils.hasText(msg.getGmt_payment())) {
			map.put("gmt_payment", msg.getGmt_payment());
		}
		if (StringUtils.hasText(msg.getGmt_close())) {
			map.put("gmt_close", msg.getGmt_close());
		}
		map.put("partner_id", msg.getPartner_id());
		if (StringUtils.hasText(msg.getPay_method())) {
			map.put("pay_method", msg.getPay_method());
		}
		map.put("reponse_message", msg.getResponse_message());
		if (msg.getAuth_finish_amount()!=null) {
			map.put("auth_finish_amount", String.valueOf(msg.getAuth_finish_amount()));
		}
		map.put("response_time", msg.getResponse_time());
		map.put("response_code", msg.getResponse_code());
		Tools.createLinkString(map, false);
		try {
//			if (SignUtil.Check_sign(like_result.toString(), msg.getSign(), msg.getSign_type(), rsa_sign_public,
//					"UTF-8")) {
//				return true;
//			}
		} catch (Exception e) {
			logger.error("充值异步回调参数验证失败", e);
		}
		return true;
	}

	public QueryHostingTradeReturnMsg queryHostingTrade(QueryHostingTrade queryHostingTrade) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_hosting_trade");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryHostingTrade.getEndTime())) {
			basicMap.put("end_time", queryHostingTrade.getEndTime());
		}
		if (StringUtils.hasText(queryHostingTrade.getExtendParam())) {
			basicMap.put("extend_param", queryHostingTrade.getExtendParam());
		}

		if (StringUtils.hasText(queryHostingTrade.getIdentityId())) {
			basicMap.put("identity_id", queryHostingTrade.getIdentityId());
		}
		if (StringUtils.hasText(queryHostingTrade.getIdentityType())) {
			basicMap.put("identity_type", queryHostingTrade.getIdentityType());
		}
		if (StringUtils.hasText(queryHostingTrade.getOutTradeNo())) {
			basicMap.put("out_trade_no", queryHostingTrade.getOutTradeNo());
		}
		if (StringUtils.hasText(queryHostingTrade.getPageNo())) {
			basicMap.put("page_no", queryHostingTrade.getPageNo());
		}
		if (StringUtils.hasText(queryHostingTrade.getPageSize())) {
			basicMap.put("page_size", queryHostingTrade.getPageSize());
		}
		if (StringUtils.hasText(queryHostingTrade.getStartTime())) {
			basicMap.put("start_time", queryHostingTrade.getStartTime());
		}
		String content = Tools.createLinkString(basicMap, false);
		QueryHostingTradeReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content, basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getSd_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryHostingTradeReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_hosting_trade接口失败", e);
		}
		return returnMsg;
	}

	public QueryBalanceReturnMsg queryBalance(QueryBalance queryBalance) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_balance");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryBalance.getAccountType())) {
			basicMap.put("account_type", queryBalance.getAccountType());
		}
		if (StringUtils.hasText(queryBalance.getExtendParam())) {
			basicMap.put("extend_param", queryBalance.getExtendParam());
		}

		if (StringUtils.hasText(queryBalance.getIdentityId())) {
			basicMap.put("identity_id", queryBalance.getIdentityId());
		}
		if (StringUtils.hasText(queryBalance.getIdentityType())) {
			basicMap.put("identity_type", queryBalance.getIdentityType());
		}
		
		
		String content = Tools.createLinkString(basicMap, false);
		QueryBalanceReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content,basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryBalanceReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_hosting_trade接口失败", e);
		}
		return returnMsg;
	}

	public QueryMiddleAccountReturnMsg queryMiddleAccountReturnMsg(QueryMiddleAccount queryMiddleAccount) {
		Map<String, String> basicMap = CommonUtils.getBasicMap();
		String time = DateUtil.date2string("yyyyMMddHHmmss");
		basicMap.put("service", "query_middle_account");
		basicMap.put("request_time", time);
		if (StringUtils.hasText(queryMiddleAccount.getOutTradeCode())) {
			basicMap.put("out_trade_code", queryMiddleAccount.getOutTradeCode());
		}
		if (StringUtils.hasText(queryMiddleAccount.getExtendParam())) {
			basicMap.put("extend_param", queryMiddleAccount.getExtendParam());
		}
		String content = Tools.createLinkString(basicMap, false);
		QueryMiddleAccountReturnMsg returnMsg = null;
		try {
			SignUtil.sign(content,basicMap);
			String param = Tools.createLinkString(basicMap, true);
			String result = URLDecoder.decode(CallServiceUtil.sendPost(sina.getHy_url(), param), "UTF-8");
			System.out.println(result);
			returnMsg = GsonUtil.fromJsonUnderScoreStyle(result, QueryMiddleAccountReturnMsg.class);
		} catch (Exception e) {
			logger.error("调用query_middle_account接口失败", e);
		}
		return returnMsg;
	}

}
