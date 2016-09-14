package com.doro.background.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.dal.entity.UserHqRedeemApplication;
import com.doro.background.dal.entity.UserWithdrawApplication;
import com.doro.background.message.JsonMessage;
import com.doro.background.service.UserWithdrawApplicationService;

/**
 * 
 * @包名 :com.doro.background.web.controller
 * @文件名 :UserWithdrawApplicationController.java TODO 类作用：赎回相关操作
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年8月4日 下午3:21:51
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/userWithdraw")
public class UserWithdrawApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(UserWithdrawApplicationController.class);
	@Autowired
	UserWithdrawApplicationService userWithdrawApplicationService;

	/**
	 * 
	 * TODO 方法作用：赎回列表
	 * 
	 * @param bo
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 上午11:44:52
	 */
	@RequestMapping(value = "/queryWithdraw", method = RequestMethod.GET)
	public String index(UserHqRedeemApplication bo, Model model) {
		Map<String, Object> param = new HashMap<>();
		List<Map<String, Object>> user = userWithdrawApplicationService.queryWithdraw(param);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (Map<String, Object> temp : user) {
			temp.put("applicationId", temp.get("applicationId").toString());
			resultList.add(temp);
		}
		logger.info("查询的赎回列表结果=====》resultList:{}", resultList);
		model.addAttribute("resultList", resultList);
		return "/settle_administration/user_withdraw_list";
	}

	/**
	 * 
	 * TODO 方法作用：局部刷新
	 * 
	 * @param bo
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 下午2:29:52
	 */
	@RequestMapping(value = "/queryWithdrawRefresh", method = RequestMethod.POST)
	public String indexRefresh(UserWithdrawApplication bo,Model model) {
		Map<String, Object> param = new HashMap<>();
		List<Map<String, Object>> user = userWithdrawApplicationService.queryWithdraw(param);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (Map<String, Object> temp : user) {
			temp.put("applicationId", temp.get("applicationId").toString());
			resultList.add(temp);
		}
		model.addAttribute("resultList", resultList);
		logger.info("查询的赎回列表结果=====》resultList:{}", resultList);
		return "/settle_administration/user_withdraw_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：赎回审核通过
	 * @param applicationId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月4日 下午4:15:50
	 */
	@ResponseBody
	@RequestMapping(value = "/loan/{applicationId}", method = RequestMethod.POST)
	public JsonMessage loan(@PathVariable("applicationId") Long applicationId) {
		return userWithdrawApplicationService.loan(applicationId);

	}

}
