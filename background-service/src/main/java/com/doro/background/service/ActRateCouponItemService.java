package com.doro.background.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.doro.background.dal.entity.ActRateCouponItem;
import com.doro.background.dal.mapper.ActRateCouponItemMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActRateCouponItemModel;
import com.doro.component.utils.common.DRUtil;

@Service
public class ActRateCouponItemService {

	@Autowired
	private ActRateCouponItemMapper actRateCouponItemMapper;

	/**
	 * 添加加息券活动
	 * @param actRateCouponItemModel
	 * @param model
	 * @return
	 */
	public JsonMessage addActRateCouponItem(ActRateCouponItemModel actRateCouponItemModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actRateCouponItemModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getActId())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("活动ID不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getYearRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息年利率不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getDayRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息天利率不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getDayCount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息天数不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getValidDayCount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("有效天数不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getMinAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("最低投资金额不可为空");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getMinDays())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("最低投资天数不可为空");
		} else {
			ActRateCouponItem actRateCouponItem = new ActRateCouponItem();
			actRateCouponItem.setEnumActType(actRateCouponItemModel.getEnumActType());
			actRateCouponItem.setActId(actRateCouponItemModel.getActId());
			actRateCouponItem.setYearRate(actRateCouponItemModel.getYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			actRateCouponItem.setDayRate(actRateCouponItemModel.getDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			actRateCouponItem.setDayCount(actRateCouponItemModel.getDayCount());
			actRateCouponItem.setValidDayCount(actRateCouponItemModel.getValidDayCount());
			actRateCouponItem.setMinDays(actRateCouponItemModel.getMinDays());
			actRateCouponItem.setMinAmount(actRateCouponItemModel.getMinAmount());
			actRateCouponItemMapper.insert(actRateCouponItem);
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("添加成功");
		}
		return jsonMessage;
	}

	/**
	 * 删除加息券活动
	 * @param actRateCouponItemModel
	 * @param model
	 * @return
	 */
	public Object delActRateCouponItem(ActRateCouponItemModel actRateCouponItemModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actRateCouponItemModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (DRUtil.isEmptyObject(actRateCouponItemModel.getAutoId())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("活动ID不可为空");
		}else{
			actRateCouponItemMapper.deleteByPrimaryKey(actRateCouponItemModel.getAutoId());
		}
		return null;
	}
}
