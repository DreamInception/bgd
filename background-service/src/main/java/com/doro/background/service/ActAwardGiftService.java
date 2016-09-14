package com.doro.background.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.doro.background.dal.entity.ActAwardGift;
import com.doro.background.dal.mapper.ActAwardGiftMapper;
import com.doro.background.dal.mapper.ActMoneyCouponItemMapper;
import com.doro.background.dal.mapper.ActRateCouponItemMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActAwardGiftModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.JsonUtil;
import com.doro.component.utils.common.WebUtil;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class ActAwardGiftService {

	@Autowired
	private ActAwardGiftMapper actAwardGiftMapper;
	@Autowired
	private ActMoneyCouponItemMapper actMoneyCouponItemMapper;
	@Autowired
	private ActRateCouponItemMapper actRateCouponItemMapper;
	/**
	 * 查询邀请送列表
	 * @param pageNum
	 * @param actRegGiftModel
	 * @param model
	 * @param page
	 * @return
	 */
	public String getActAwardGiftList(int pageNum, ActAwardGiftModel actAwardGiftModel, Model model, int page) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(actAwardGiftModel)) {
				params.put("actAutoId", actAwardGiftModel.getActAutoId());
				params.put("actName", actAwardGiftModel.getActName());
			}
			params.put(DRConst.PAGE_KEY_PAGE, pageNum);
			params.put(DRConst.COUNT, actAwardGiftMapper.selectPageListCount(params));
			PageDealUtil.getLimit(params);
			pageReslut.setResultList(actAwardGiftMapper.selectPageList(params));
			pageReslut.setResulPages(PageDealUtil.getPageCount(params));
			pageReslut.setParams(params);
			model.addAttribute("resultList", pageReslut.getResultList());
			model.addAttribute("page", pageReslut.getResulPages());
			model.addAttribute("params", pageReslut.getParams());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page == 0 ? "activity_manage/award_activity/award_activity_manage_list" : "activity_manage/award_activity/award_activity_manage_refresh";
	}

	/**
	 * 添加活动
	 * @param actRegGiftModel
	 * @param model
	 * @return
	 */
	public Object addActRegGift(ActAwardGiftModel actAwardGiftModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actAwardGiftModel)||DRUtil.isEmptyObject(actAwardGiftModel.getActName())||DRUtil.isEmptyObject(actAwardGiftModel.getBeginDate())||DRUtil.isEmptyObject(actAwardGiftModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		}else if(actAwardGiftModel.getEndDate().getTime()-DRDateUtil.getNow().getTime()<0){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于当前日期");
		}else if(actAwardGiftModel.getBeginDate().getTime()>actAwardGiftModel.getEndDate().getTime()){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于开始日期");
		}else{
			ActAwardGift actAwardGift = new ActAwardGift();
			actAwardGift.setActName(actAwardGiftModel.getActName());
			actAwardGift.setBeginDate(actAwardGiftModel.getBeginDate());
			actAwardGift.setEndDate(actAwardGiftModel.getEndDate());
			actAwardGift.setIsOnsale(false);
			actAwardGiftMapper.insert(actAwardGift);
			return getActAwardGiftList(1, actAwardGiftModel, model, 1);
		}
		WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
		return null;
	}
	
	/**
	 * 上下架
	 * @param actRegGiftModel
	 * @param model
	 * @return
	 */
	public JsonMessage onsale(ActAwardGiftModel actAwardGiftModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actAwardGiftModel)||DRUtil.isEmptyObject(actAwardGiftModel.getActAutoId())||DRUtil.isEmptyObject(actAwardGiftModel.getIsOnsale())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		}else{
			ActAwardGift actAwardGift = new ActAwardGift();
			actAwardGift.setActAutoId(actAwardGiftModel.getActAutoId());
			actAwardGift.setIsOnsale(actAwardGiftModel.getIsOnsale());
			actAwardGiftMapper.updateByPrimaryKeySelective(actAwardGift);
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("上下架成功");
			jsonMessage.setData(actAwardGift.getActAutoId());
		}
		return jsonMessage;
	}
	
	/**
	 * 查看详情体验金券
	 * @param actAutoId
	 * @param model
	 * @return
	 */
	public Object getActRegGiftAndActMoneyCouponItem(Long actAutoId,Model model){
		ActAwardGift actAwardGift = actAwardGiftMapper.selectByPrimaryKey(actAutoId);
		List<Map<String,Object>> list = actMoneyCouponItemMapper.selectByActId(actAutoId,100);
		model.addAttribute("actAwardGift", actAwardGift);
		model.addAttribute("resultList", list);
		return null;
	}
	
	/**
	 * 查看详情加息券
	 * @param actAutoId
	 * @param model
	 * @return
	 */
	public Object getActRegGiftAndActRateCouponItem(Long actAutoId,Model model){
		ActAwardGift actAwardGift = actAwardGiftMapper.selectByPrimaryKey(actAutoId);
		List<Map<String,Object>> list = actRateCouponItemMapper.selectByActId(actAutoId,100);
		model.addAttribute("actAwardGift", actAwardGift);
		model.addAttribute("resultList", list);
		return null;
	}
}
