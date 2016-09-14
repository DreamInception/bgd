package com.doro.background.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.message.JsonMessage;
import com.doro.background.model.DqTargetModel;
import com.doro.background.service.DqTargetService;
import com.doro.component.utils.common.JsonUtil;
import com.doro.component.utils.common.WebUtil;
import com.doro.component.utils.page.PageReslut;


@Controller
@RequestMapping("/regular-manage")
public class RegularManageController {

	@Autowired
	private DqTargetService dqTargetService;
	
	@RequestMapping(value = "/dqTargetList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String dqTargetList(Model model){
		return toDqTargetListPage(1,null,model,0,0);
	}
	
	@RequestMapping(value = "/dqTargetAuditList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String dqTargetAuditList(Model model){
		return toDqTargetListPage(1,null,model,0,1);
	}
	
	@RequestMapping(value = "/addDqTarget.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object addDqTarget(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.addDqTarget(dqTargetModel);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,0);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/modifyDqTarget.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object modifyDqTarget(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateDqTarget(dqTargetModel);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,0);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/dqTargetListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String hqDebtPoolListRefresh(Integer pageNum,DqTargetModel dqTargetModel,Model model) {
		return toDqTargetListPage(pageNum,dqTargetModel,model,1,0);
	}
	
	@RequestMapping(value = "/dqTargetAuditListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String dqTargetAuditListRefresh(Integer pageNum,DqTargetModel dqTargetModel,Model model) {
		return toDqTargetListPage(pageNum,dqTargetModel,model,1,1);
	}
	
	@RequestMapping(value = "/getTargetIconItems.do", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object getTargetIconItems(){
		return dqTargetService.getCmsSysPicByPicCode();	
	}
	
	@RequestMapping(value = "/getActAutoIdItems.do", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object getActAutoIdItems(){
		return dqTargetService.getActTargetRateAppendByValid();	
	}
	
	@RequestMapping(value = "/selectDqTargetList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String selectRegularManageList(DqTargetModel dqTargetModel,Model model) {
		return toDqTargetListPage(1,dqTargetModel,model,0,0);
	}
	
	@RequestMapping(value = "/selectDqTargetAuditList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String selectDqTargetAuditList(DqTargetModel dqTargetModel,Model model) {
		return toDqTargetListPage(1,dqTargetModel,model,0,1);
	}
	
	@RequestMapping(value = "/selectDqTarget.do", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object selectDqTarget(Long targetId,Model model) {
		return dqTargetService.getDqTarget(targetId);
	}
	
	@RequestMapping(value = "/enumDqtargetState.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object enumDebtState(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel, 1);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,0);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/reject.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object reject(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel, 2);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,1);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/adopt.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object adopt(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel, 3);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,1);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/fullScale.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object fullScale(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel,6);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,0);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/preShelve.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object preShelve(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel, 4);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,1);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/shelve.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object shelve(DqTargetModel dqTargetModel,Model model){
		try {
			JsonMessage jsonMessage = dqTargetService.updateEnumDqtargetState(dqTargetModel, 5);
			if (jsonMessage.isFlag()) {
				return toDqTargetListPage(1,dqTargetModel,model,0,1);
			} else {
				WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String toDqTargetListPage(Integer pageNum,DqTargetModel dqTargetModel,Model model,int page,int audit){
		PageReslut pageReslut = dqTargetService.getDqTargetList(pageNum, dqTargetModel,audit);
		model.addAttribute("resultList", pageReslut.getResultList());
		model.addAttribute("page", pageReslut.getResulPages());
		model.addAttribute("params", pageReslut.getParams());
		if(audit==0){
			return page==0?"regular_manage/regular_manage_list":"regular_manage/regular_manage_refresh";
		}else{
			return page==0?"regular_manage/regular_audit_manage_list":"regular_manage/regular_audit_manage_refresh";
		}
		
	}
}
