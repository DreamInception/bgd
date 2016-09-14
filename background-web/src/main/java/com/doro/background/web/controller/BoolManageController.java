package com.doro.background.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.message.JsonMessage;
import com.doro.background.model.HqDebtModel;
import com.doro.background.model.HqDebtPoolModel;
import com.doro.background.model.HqTargetModel;
import com.doro.background.service.HqDebtPoolService;
import com.doro.background.service.HqDebtService;
import com.doro.background.service.HqTargetService;
import com.doro.component.utils.common.JsonUtil;
import com.doro.component.utils.common.WebUtil;
import com.doro.component.utils.page.PageReslut;

@Controller
@RequestMapping("/bool-manage")
public class BoolManageController {

	@Autowired
	private HqTargetService hqTargetService;
	
	@Autowired
	private HqDebtService hqDebtService;
	
	@Autowired
	private HqDebtPoolService hqDebtPoolService;

	/**
	* @Title: targetManageList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/targetManageList.do",  method = { RequestMethod.GET, RequestMethod.POST })
	public String targetManageList(HqTargetModel hqTargetModel,Model model) {
		return toTargetManageList(1,hqTargetModel,model,0);
	}
	
	/**
	 * 
	 * @param hqTargetModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectTargetManageList.do",  method = { RequestMethod.GET, RequestMethod.POST })
	public String selectTargetManageList(HqTargetModel hqTargetModel,Model model) {
		return toTargetManageList(1,hqTargetModel,model,0);
	}
	
	/**
	 * 
	 * @param hqTargetModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectTargetManageListRefresh.do",  method = { RequestMethod.GET, RequestMethod.POST })
	public String selectTargetManageListRefresh(int pageNum,HqTargetModel hqTargetModel,Model model) {
		return toTargetManageList(pageNum,hqTargetModel,model,1);
	}

	
	/**
	 * 
	* @Title: getActAutoIdItems 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/getActAutoIdItems.do", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object getActAutoIdItems(){
		return hqTargetService.getActTargetRateAppendByValid();	
	}
	
	/**
	 * 
	* @Title: selectHqTarget 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param targetId
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/selectHqTarget.do", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object selectHqTarget(Long targetId){
		return hqTargetService.getHqTarget(targetId);
	}
	
	/**
	 * 
	* @Title: addTarget 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param hqTargetModel
	* @param @param model
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addTarget.do",method = { RequestMethod.GET, RequestMethod.POST })
	public Object addTarget(HqTargetModel hqTargetModel, Model model) {
		JsonMessage jsonMessage = hqTargetService.addHqTarget(hqTargetModel);
		if (jsonMessage.isFlag()) {
			return toTargetManageList(1,hqTargetModel,model,0);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	@RequestMapping(value = "/targetState.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object targetState(HqTargetModel hqTargetModel,Model model){
		JsonMessage jsonMessage = hqTargetService.updateEnumTargetState(hqTargetModel);
		if (jsonMessage.isFlag()) {
			return toTargetManageList(1,hqTargetModel,model,0);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	
	
	
	
	/**
	 * 
	* @Title: hqDebtEditorList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/hqDebtEditorList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String hqDebtEditorList(HqDebtModel hqDebtModel,Model model) {
		return tohqDebtEditorList(hqDebtModel,model);
	}
	
	
	@RequestMapping(value = "/addHqDebt.do",method = { RequestMethod.GET, RequestMethod.POST })
	public Object addHqDebt(HqDebtModel hqDebtModel,Model model) {
		JsonMessage jsonMessage = hqDebtService.addHqDebt(hqDebtModel);
		if (jsonMessage.isFlag()) {
			return tohqDebtEditorList(hqDebtModel,model);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	@RequestMapping(value = "/enumDebtState.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object enumDebtState(HqDebtModel hqDebtModel,Model model){
		try {
			JsonMessage jsonMessage = hqDebtService.enumDebtState(hqDebtModel,1);
			if (jsonMessage.isFlag()) {
				return tohqDebtEditorList(hqDebtModel,model);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/modifyHqDebt.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object modifyHqDebt(HqDebtModel hqDebtModel,Model model){
		JsonMessage jsonMessage = hqDebtService.modifyHqDebt(hqDebtModel);
		if (jsonMessage.isFlag()) {
			return tohqDebtEditorList(hqDebtModel,model);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	/**
	 * 
	* @Title: hqDebtEditorList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/hqDebtAuditList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String hqDebtAuditList(HqDebtModel hqDebtModel ,Model model) {
		return tohqDebtAuditList(hqDebtModel,model);
	}
	
	@RequestMapping(value = "/reject.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String reject(HqDebtModel hqDebtModel ,Model model) {
		try {
			JsonMessage jsonMessage = hqDebtService.enumDebtState(hqDebtModel,2);
			if (jsonMessage.isFlag()) {
				return tohqDebtAuditList(hqDebtModel,model);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/adopt.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String adopt(HqDebtModel hqDebtModel ,Model model) {
		try {
			JsonMessage jsonMessage = hqDebtService.enumDebtState(hqDebtModel,3);
			if (jsonMessage.isFlag()) {
				return tohqDebtAuditList(hqDebtModel,model);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/hqDebtPoolList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String hqDebtPoolList(HqDebtPoolModel hqDebtPoolModel ,Model model) {
		return toHqDebtPoolList(1,hqDebtPoolModel,model,0);
	}
	
	@RequestMapping(value = "/hqDebtPoolListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String hqDebtPoolListRefresh(Integer pageNum,HqDebtPoolModel hqDebtPoolModel ,Model model) {
		return toHqDebtPoolList(pageNum,hqDebtPoolModel,model,1);
	}
	
	@RequestMapping(value = "/selectHqdebtPoolList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String selectHqdebtPoolList(HqDebtPoolModel hqDebtPoolModel ,Model model) {
		return toHqDebtPoolList(1,hqDebtPoolModel,model,1);
	}
	
	
	
	
	private String toHqDebtPoolList(int pageNum,HqDebtPoolModel hqDebtPoolModel,Model model,int page){
		String pages="";
		PageReslut pageReslut = null;
		if(page == 0){
			pageReslut = hqDebtPoolService.getHqDebtPoolList();
			pages = "hq_debt_pool_list";
			model.addAttribute("resultMap",pageReslut.getParams());
		}else{
			pageReslut = hqDebtPoolService.getHqDebtPoolListRefresh(pageNum, hqDebtPoolModel);
			pages = "hq_debt_pool_refresh";
			model.addAttribute("params",pageReslut.getParams());
		}
		model.addAttribute("resultList",pageReslut.getResultList());
		model.addAttribute("page",pageReslut.getResulPages());	
		return "bool_manage/"+pages;	
	}
	
	private String toTargetManageList(int pageNum,HqTargetModel hqTargetModel,Model model,int page){
		PageReslut pageReslut = hqTargetService.getHqTargetList(pageNum,hqTargetModel);
		model.addAttribute("resultList",pageReslut.getResultList());
		model.addAttribute("page",pageReslut.getResulPages());
		model.addAttribute("params",pageReslut.getParams());
		if(page==0){
			return "bool_manage/target_manage_list";
		}else{
			return "bool_manage/target_manage_refresh";
		}
	}
	
	private String tohqDebtEditorList(HqDebtModel hqDebtModel,Model model){
		PageReslut pageReslut = hqDebtService.getHqDebtList(hqDebtModel,0);
		model.addAttribute("resultList",pageReslut.getResultList());
		model.addAttribute("page",pageReslut.getResulPages());
		model.addAttribute("params",pageReslut.getParams());
		return "bool_manage/hq_debt_editor_list";
	}
	
	private String tohqDebtAuditList(HqDebtModel hqDebtModel,Model model){
		PageReslut pageReslut = hqDebtService.getHqDebtList(hqDebtModel,1);
		model.addAttribute("resultList",pageReslut.getResultList());
		model.addAttribute("page",pageReslut.getResulPages());
		model.addAttribute("params",pageReslut.getParams());
		return "bool_manage/hq_debt_audit_list";
	}
}
