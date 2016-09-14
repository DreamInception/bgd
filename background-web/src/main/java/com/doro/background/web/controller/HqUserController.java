package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doro.background.dal.entity.HqUser;
import com.doro.background.service.HqUserService;
import com.doro.component.utils.common.DRConst;

@Controller
@RequestMapping("/hqUser")
public class HqUserController {

	@Autowired
	private HqUserService hqUserService;
	
	/**
	 * 债券投资列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hqUserList.do", method = RequestMethod.GET)
	public String bondlist(Model model){
		List<HqUser> hqUsers = hqUserService.getHqUserList();
		model.addAttribute("hqUsers", hqUsers);
		return "bond_pool/hq_User_List";
	}
	
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping(value = "/addHqUser.do", method = RequestMethod.GET)
	public String addHqUser(){
		return "bond_pool/add_hq_user";	
	}
	
	/**
	 * 
	 * TODO 方法作用：后台管理-用户活期投资列表
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午4:21:01
	 */
	@RequestMapping("/getUserPageList.do")
	public String getUserPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_NUM, 1);
		Map<String, Object> pageMap = hqUserService.userInvestCount(param);
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));
		List<Map<String, Object>> resultList = hqUserService.getUserPageList(param);
		model.addAttribute("resultList", resultList);
		return "bond_pool/user_invest_list";
	}
	
	/**
	 * 
	 * TODO 方法作用：后台管理-活期投资统计
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午4:06:41
	 */
	@RequestMapping("/investRecordPageList.do")
	public String investRecordPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<Map<String, Object>> resultList = hqUserService.getPageList(param);
		model.addAttribute("resultList", resultList);
		return "bond_pool/invest_record_list";
	}
}
