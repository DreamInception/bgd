package com.doro.background.web.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.dal.entity.UserOutgoApplication;
import com.doro.background.service.UserOutgoApplicationService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.page.PageDealUtil;


@Controller
@RequestMapping("/withdraw")
public class UserOutgoApplicationController {
	Logger logger = LoggerFactory.getLogger(UserOutgoApplicationController.class);
	@Autowired
	UserOutgoApplicationService userOutgoApplicationService;
	@RequestMapping("/selectPageList.do")
	public String selectPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<UserOutgoApplication> resultList = userOutgoApplicationService.selectListPage(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = userOutgoApplicationService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "user_withdraw/withdraw_list";
	}
	
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<UserOutgoApplication> resultList = userOutgoApplicationService.selectListPage(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = userOutgoApplicationService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "user_withdraw/withdraw_refresh";
	}
	
	//后台放款
	@ResponseBody
	@RequestMapping("/fopay/{applicationId}.do")
	public Map<String, Object> fopay(@PathVariable("applicationId")String applicationId){
		Map<String, Object> map = new HashMap<>();
		if(applicationId == null){
			map.put("msg", "参数异常");
			return map;
		}
		try {
			map = userOutgoApplicationService.fopay(Long.valueOf(applicationId), map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "系统异常");
		}
		return map;
		
	}
	//资金退回
	@ResponseBody
	@RequestMapping("/assetBack/{applicationId}.do")
	public Map<String, Object> assetBack(@PathVariable("applicationId")String applicationId){
		Map<String, Object> map = new HashMap<>();
		if(applicationId == null){
			map.put("msg", "参数异常");
			return map;
		}
		try {
			map = userOutgoApplicationService.assetBack(Long.valueOf(applicationId), map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "系统异常");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/alertMsg/{applicationId}.do")
	public Map<String, Object> alertMsg(@PathVariable("applicationId")String applicationId){
		Map<String, Object> map = new HashMap<>();
		if(applicationId == null){
			map.put("msg", "参数异常");
			return map;
		}
		try {
			map = userOutgoApplicationService.alertMsg(Long.valueOf(applicationId), map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "系统异常");
		}
		return map;
	}
}









