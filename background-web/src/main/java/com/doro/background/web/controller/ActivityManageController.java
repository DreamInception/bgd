package com.doro.background.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActAwardGiftModel;
import com.doro.background.model.ActMoneyCouponItemModel;
import com.doro.background.model.ActRateCouponItemModel;
import com.doro.background.model.ActRegGiftModel;
import com.doro.background.model.ActTargetRateAppendModel;
import com.doro.background.service.ActAwardGiftService;
import com.doro.background.service.ActMoneyCouponItemService;
import com.doro.background.service.ActRateCouponItemService;
import com.doro.background.service.ActRegGiftService;
import com.doro.background.service.ActTargetRateService;
import com.doro.component.utils.common.JsonUtil;
import com.doro.component.utils.common.WebUtil;
import com.doro.component.utils.page.PageReslut;

/**
 * 
 * @ClassName: ActivityManageController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2016年7月11日 上午10:59:37
 *
 */
@Controller
@RequestMapping("/activity-manage")
public class ActivityManageController {

	@Autowired
	private ActTargetRateService actTargetRateService;
	@Autowired
	private ActRegGiftService actRegGiftService;
	@Autowired
	private ActMoneyCouponItemService actMoneyCouponItemService;
	@Autowired
	private ActRateCouponItemService actRateCouponItemService;
	@Autowired
	private ActAwardGiftService actAwardGiftService;
	
	
	@RequestMapping(value = "/activityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String activityManageList(Model model) {
		return toListPage(1,null,model,0);
	}
	@RequestMapping(value = "/selectActivityManageListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String activityManageListRefresh(Integer pageNum,ActTargetRateAppendModel actTargetRateAppendModel,Model model) {
		return toListPage(pageNum,actTargetRateAppendModel,model,1);
	}
	
	
	@RequestMapping(value = "/selectActivityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectActivityManageList(ActTargetRateAppendModel actTargetRateAppendModel,Model model) {
		return toListPage(1,actTargetRateAppendModel,model,1);
	}
	
	@RequestMapping(value = "/addActivity.do", method = RequestMethod.POST)
	public Object addActivity(ActTargetRateAppendModel actTargetRateAppendModel, Model model) {
		JsonMessage jsonMessage = actTargetRateService.addActTargetRateAppend(actTargetRateAppendModel);
		if (jsonMessage.isFlag()) {
			return toListPage(1,actTargetRateAppendModel,model,0);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	
	@RequestMapping(value = "/onSale.do", method = { RequestMethod.GET, RequestMethod.POST})
	public Object onSale(ActTargetRateAppendModel actTargetRateAppendModel,Model model){
		JsonMessage jsonMessage = actTargetRateService.updateOnsale(actTargetRateAppendModel);
		if (jsonMessage.isFlag()) {
			return toListPage(1,actTargetRateAppendModel,model,0);
		} else {
			WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
			return null;
		}
	}
	
	@RequestMapping(value = "/regActivityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object regActivityManageList(Model model){
		return actRegGiftService.getActRegGiftList(1, null, model, 0);
	}
	
	@RequestMapping(value = "/selectRegActivityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selectRegActivityManageList(ActRegGiftModel actRegGiftModel,Model model){
		return actRegGiftService.getActRegGiftList(1, actRegGiftModel, model, 1);
	}

	@RequestMapping(value = "/selectRegActivityManageListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selectRegActivityManageListRefresh(Integer pageNum,ActRegGiftModel actRegGiftModel,Model model){
		return actRegGiftService.getActRegGiftList(pageNum, actRegGiftModel, model, 1);
	}
	
	
	@RequestMapping(value = "/addRegActivity.do", method = RequestMethod.POST)
	public Object addRegActivity(ActRegGiftModel actRegGiftModel, Model model) {
		return actRegGiftService.addActRegGift(actRegGiftModel, model);
	}
	
	@RequestMapping(value = "/modifyRegActivity.do", method = RequestMethod.POST)
	public Object modifyRegActivity(ActRegGiftModel actRegGiftModel, Model model) {
		return actRegGiftService.modifyActRegGift(actRegGiftModel, model);
	}
	
	@ResponseBody
	@RequestMapping(value = "/regOnsale.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object regOnsale(ActRegGiftModel actRegGiftModel, Model model) {
		return  actRegGiftService.onsale(actRegGiftModel, model);
	}
	
	@RequestMapping(value = "/selectCouponItems.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selectCouponItems(ActRegGiftModel actRegGiftModel, Model model) {
		return  actRegGiftService.getCouponItems(actRegGiftModel.getActAutoId(), model);
	}
	
	@ResponseBody
	@RequestMapping(value = "/awardOnsale.do", method = RequestMethod.POST)
	public Object awardOnsale(ActAwardGiftModel actAwardGiftModel, Model model) {
		return actAwardGiftService.onsale(actAwardGiftModel, model);
	}
	
	
	@RequestMapping(value = "/addActMoneyCouponItems.do", method = RequestMethod.POST)
	public Object addActMoneyCouponItems(@RequestBody List<ActRegGiftModel> actRegGifts, Model model) {
		System.out.println(actRegGifts);
		WebUtil.printWriter(JsonUtil.entity2Json(actRegGifts));
		return "";
	}
	
	@RequestMapping(value = "/addActMoneyCouponItem.do", method = RequestMethod.POST)
	@ResponseBody
	public Object addActMoneyCouponItem(ActMoneyCouponItemModel actMoneyCouponItemModel, Model model) {
		return actMoneyCouponItemService.addActMoneyCouponItem(actMoneyCouponItemModel, model);
	}
	
	@RequestMapping(value = "/addActRateCouponItem.do", method = RequestMethod.POST)
	@ResponseBody
	public Object addActRateCouponItem(ActRateCouponItemModel actRateCouponItemModel, Model model) {
		return actRateCouponItemService.addActRateCouponItem(actRateCouponItemModel, model);
	}
	
	@RequestMapping(value = "/awardActivityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object awardActivityManageList(Model model){
		return actAwardGiftService.getActAwardGiftList(1, null, model, 0);
	}
	
	@RequestMapping(value = "/selectAwardActivityManageList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selectAwardActivityManageList(ActAwardGiftModel actAwardGiftModel,Model model){
		return actAwardGiftService.getActAwardGiftList(1, actAwardGiftModel, model, 1);
	}
	
	@RequestMapping(value = "/selectAwardActivityManageListRefresh.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selectAwardActivityManageListRefresh(Integer pageNum,ActAwardGiftModel actAwardGiftModel,Model model){
		return actAwardGiftService.getActAwardGiftList(pageNum, actAwardGiftModel, model, 1);
	}
	
	@RequestMapping(value = "/addAwardActivity.do", method = RequestMethod.POST)
	public Object addAwardActivity(ActAwardGiftModel actAwardGiftModel, Model model) {
		return actAwardGiftService.addActRegGift(actAwardGiftModel, model);
	}
	/**
	 * 
	* @Title: toListPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String toListPage(Integer pageNum,ActTargetRateAppendModel actTargetRateAppendModel,Model model,int page){
		PageReslut pageReslut = actTargetRateService.getActTargetRateAppendList(pageNum,actTargetRateAppendModel);
		model.addAttribute("resultList", pageReslut.getResultList());
		model.addAttribute("page", pageReslut.getResulPages());
		model.addAttribute("params", pageReslut.getParams());
		if(page==0){
			return "activity_manage/activity_manage_list";
		}else{
			return "activity_manage/activity_manage_refresh";
		}
	}
}
