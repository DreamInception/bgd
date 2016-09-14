package com.doro.background.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.doro.background.dal.entity.ActRegGift;
import com.doro.background.dal.mapper.ActMoneyCouponItemMapper;
import com.doro.background.dal.mapper.ActRateCouponItemMapper;
import com.doro.background.dal.mapper.ActRegGiftMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActRegGiftModel;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.common.DRUtil;
import com.doro.component.utils.common.JsonUtil;
import com.doro.component.utils.common.WebUtil;
import com.doro.component.utils.page.PageDealUtil;
import com.doro.component.utils.page.PageReslut;

@Service
public class ActRegGiftService {

	@Autowired
	private ActRegGiftMapper actRegGiftMapper;
	@Autowired
	private ActMoneyCouponItemMapper actMoneyCouponItemMapper;
	@Autowired
	private ActRateCouponItemMapper actRateCouponItemMapper;

	/**
	 * 进入活动列表
	 * 
	 * @param pageNum
	 * @param actRegGiftModel
	 * @param model
	 * @param page
	 * @return
	 */
	public String getActRegGiftList(Integer pageNum, ActRegGiftModel actRegGiftModel, Model model, int page) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageReslut pageReslut = new PageReslut();
		try {
			// 校验传入的参数
			if (!DRUtil.isEmptyObject(actRegGiftModel)) {
				params.put("actAutoId", actRegGiftModel.getActAutoId());
				params.put("actName", actRegGiftModel.getActName());
			}
			params.put(DRConst.PAGE_KEY_PAGE, pageNum == null ? 1 : pageNum);
			params.put(DRConst.COUNT, actRegGiftMapper.selectPageListCount(params));
			PageDealUtil.getLimit(params);
			pageReslut.setResultList(actRegGiftMapper.selectPageList(params));
			pageReslut.setResulPages(PageDealUtil.getPageCount(params));
			pageReslut.setParams(params);
			model.addAttribute("resultList", pageReslut.getResultList());
			model.addAttribute("page", pageReslut.getResulPages());
			model.addAttribute("params", pageReslut.getParams());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page == 0 ? "activity_manage/reg_activity/reg_activity_manage_list"
				: "activity_manage/reg_activity/reg_activity_manage_refresh";
	}

	/**
	 * 添加活动
	 * 
	 * @param actRegGiftModel
	 * @param model
	 * @return
	 */
	public Object addActRegGift(ActRegGiftModel actRegGiftModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actRegGiftModel) || DRUtil.isEmptyObject(actRegGiftModel.getActName())
				|| DRUtil.isEmptyObject(actRegGiftModel.getBeginDate())
				|| DRUtil.isEmptyObject(actRegGiftModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (actRegGiftModel.getEndDate().getTime() - DRDateUtil.getNow().getTime() < 0) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于当前日期");
		} else if (actRegGiftModel.getEndDate().getTime() - actRegGiftModel.getBeginDate().getTime() < 0) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于开始日期");
		} else {
			Map<String, Object> map = actRegGiftMapper.selectActRegGiftLast();
			if (!DRUtil.isEmptyObject(map) && actRegGiftModel.getBeginDate().getTime()
					- DRDateUtil.parseDate(DRUtil.toStr(map.get("endDate")), DRDateUtil.YYYYMMDD3).getTime() <= 0) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("同一时间段不可以添加两个活动");
			} else {
				ActRegGift actRegGift = new ActRegGift();
				actRegGift.setActName(actRegGiftModel.getActName());
				actRegGift.setBeginDate(actRegGiftModel.getBeginDate());
				actRegGift.setEndDate(actRegGiftModel.getEndDate());
				actRegGift.setIsOnsale(false);
				actRegGiftMapper.insert(actRegGift);
				return getActRegGiftList(1, actRegGiftModel, model, 1);
			}
		}
		WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
		return null;
	}

	/**
	 * 修改活动
	 * 
	 * @param actRegGiftModel
	 * @param model
	 * @return
	 */
	public Object modifyActRegGift(ActRegGiftModel actRegGiftModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		ActRegGift actRegGift = new ActRegGift();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actRegGiftModel) || DRUtil.isEmptyObject(actRegGiftModel.getActAutoId())
				|| DRUtil.isEmptyObject(actRegGiftModel.getActName())
				|| DRUtil.isEmptyObject(actRegGiftModel.getBeginDate())
				|| DRUtil.isEmptyObject(actRegGiftModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (actRegGiftModel.getEndDate().getTime() - DRDateUtil.getNow().getTime() < 0) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于当前日期");
		} else if (actRegGiftModel.getEndDate().getTime() - actRegGiftModel.getBeginDate().getTime() < 0) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("截止日期不能小于开始日期");
		} else {
			actRegGift.setActAutoId(actRegGiftModel.getActAutoId() - 1);
			Map<String, Object> map = actRegGiftMapper.selectActRegGiftByActAutoId(actRegGift);
			actRegGift.setActAutoId(actRegGiftModel.getActAutoId() + 1);
			Map<String, Object> map2 = actRegGiftMapper.selectActRegGiftByActAutoId(actRegGift);
			if (!DRUtil
					.isEmptyObject(
							map)
					&& actRegGiftModel.getBeginDate().getTime()
							- DRDateUtil
									.parseDate(
											DRUtil.toStr(
													map.get("endDate")),
											DRDateUtil.YYYYMMDD3)
									.getTime() <= 0
					|| !DRUtil.isEmptyObject(map2) && actRegGiftModel.getEndDate().getTime() - DRDateUtil
							.parseDate(DRUtil.toStr(map2.get("beginDate")), DRDateUtil.YYYYMMDD3).getTime() > 0) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("同一时间段不可以有两个活动");
			} else {
				actRegGift.setActAutoId(actRegGiftModel.getActAutoId());
				actRegGift.setActName(actRegGiftModel.getActName());
				actRegGift.setBeginDate(actRegGiftModel.getBeginDate());
				actRegGift.setEndDate(actRegGiftModel.getEndDate());
				actRegGiftMapper.updateByPrimaryKeySelective(actRegGift);
				return getActRegGiftList(1, actRegGiftModel, model, 1);
			}
		}
		WebUtil.printWriter(JsonUtil.entity2Json(jsonMessage));
		return null;
	}

	/**
	 * 上下架
	 * 
	 * @param actRegGiftModel
	 * @param model
	 * @return
	 */
	public JsonMessage onsale(ActRegGiftModel actRegGiftModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actRegGiftModel) || DRUtil.isEmptyObject(actRegGiftModel.getActAutoId())
				|| DRUtil.isEmptyObject(actRegGiftModel.getIsOnsale())
				|| DRUtil.isEmptyObject(actRegGiftModel.getEndDate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
			return jsonMessage;
		}
		ActRegGift actRegGift = new ActRegGift();
		actRegGift.setActAutoId(actRegGiftModel.getActAutoId());
		Map<String, Object> nums = actRegGiftMapper.selectActRegGiftByActAutoId(actRegGift);
		if (!DRUtil.isEmptyMap(nums) && DRUtil.toInt(nums.get("countAmci")) == 0
				&& DRUtil.toInt(nums.get("countArci")) == 0 && actRegGiftModel.getIsOnsale()) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("请添加卡券,才可以上架");
			return jsonMessage;
		}
		actRegGift.setIsOnsale(true);
		Map<String, Object> maps = actRegGiftMapper.selectActRegGiftByActAutoId(actRegGift);
		if (!DRUtil.isEmptyMap(maps) && actRegGiftModel.getIsOnsale()) {
			long time = actRegGiftModel.getBeginDate().getTime()
					- DRDateUtil.parseDate(maps.get("endDate").toString(), DRDateUtil.YYYYMMDD3).getTime();
			if (time <= 0) {
				jsonMessage.setFlag(false);
				jsonMessage.setMessage("同一时间段不可以上架两个活动");
				return jsonMessage;
			}
		}
		actRegGift.setIsOnsale(actRegGiftModel.getIsOnsale());
		actRegGiftMapper.updateByPrimaryKeySelective(actRegGift);
		jsonMessage.setFlag(true);
		jsonMessage.setMessage("上下架成功");
		jsonMessage.setData(actRegGift.getActAutoId());
		return jsonMessage;
	}

	/**
	 * 
	 * 
	 * @param actAutoId
	 * @param model
	 * @return
	 */
	public Object getCouponItems(Long actAutoId, Model model) {
		ActRegGift actRegGift = actRegGiftMapper.selectByPrimaryKey(actAutoId);
		List<Map<String, Object>> list1 = actMoneyCouponItemMapper.selectByActId(actAutoId, 0);
		List<Map<String, Object>> list2 = actRateCouponItemMapper.selectByActId(actAutoId, 0);
		model.addAttribute("actRegGift", actRegGift);
		model.addAttribute("resultMoneyList", list1);
		model.addAttribute("resultRateList", list2);
		return "activity_manage/reg_activity/reg_select_activity_table_refresh";
	}

	/**
	 * 查看详情加息券
	 * 
	 * @param actAutoId
	 * @param model
	 * @return
	 */
	public Object getActRegGiftAndActRateCouponItem(Long actAutoId, Model model) {
		ActRegGift actRegGift = actRegGiftMapper.selectByPrimaryKey(actAutoId);
		List<Map<String, Object>> list = actRateCouponItemMapper.selectByActId(actAutoId, 0);
		model.addAttribute("actRegGift", actRegGift);
		model.addAttribute("resultList", list);
		return null;
	}
}
