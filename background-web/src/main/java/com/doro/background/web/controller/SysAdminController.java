package com.doro.background.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.message.JsonMessage;
import com.doro.background.model.SysAdminModel;
import com.doro.background.service.SysAdminService;

/**
 * @包名 :com.doro.background.web.controller
 * @ClassName: SysAdminController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2016年7月11日 上午10:54:39
 *
 */
@Controller
public class SysAdminController {

	@Autowired
	private SysAdminService sysAdminService;

	/**
	 * 进入登陆页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * 进入主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/base.do", method = RequestMethod.GET)
	public String basePage() {
		return "common/base";
	}

	/**
	 * 注册用户
	 * 
	 * @param sysAdminModel
	 * @return
	 */
	@RequestMapping(value = "/register.do", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Object register(SysAdminModel sysAdminModel) {
		JsonMessage jsonMessage = sysAdminService.register(sysAdminModel);
		return jsonMessage;
	}

	/**
	 * 用户登陆
	 * 
	 * @param sysAdminModel
	 * @return
	 */
	@RequestMapping(value = "/sysAdminLogin.do", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Object sysAdminLogin(SysAdminModel sysAdminModel) {
		JsonMessage jsonMessage = sysAdminService.sysAdminLogin(sysAdminModel);
		return jsonMessage;
	}
	
	/**
	 * 用户退出
	 */
	@RequestMapping(value = "/sysAdminLogout.do", method = RequestMethod.GET)
	public Object sysAdminLogout() {
		return sysAdminService.sysAdminLogout();
	}
}
