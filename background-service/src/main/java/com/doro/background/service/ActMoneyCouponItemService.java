package com.doro.background.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.doro.background.dal.entity.ActMoneyCouponItem;
import com.doro.background.dal.mapper.ActMoneyCouponItemMapper;
import com.doro.background.message.JsonMessage;
import com.doro.background.model.ActMoneyCouponItemModel;
import com.doro.component.utils.common.DRUtil;

@Service
public class ActMoneyCouponItemService {

	@Autowired
	private ActMoneyCouponItemMapper actMoneyCouponItemMapper;

	/**
	 * 添加体验金活动
	 * @param actMoneyCouponItemModel
	 * @param model
	 * @return
	 */
	public JsonMessage addActMoneyCouponItem(ActMoneyCouponItemModel actMoneyCouponItemModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actMoneyCouponItemModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getActId())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("活动ID不可为空");
		} else if(DRUtil.isEmptyObject(actMoneyCouponItemModel.getEnumActType())){
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("活动类型不可为空");
		}else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getActAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("体验金金额不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getYearRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息年利率不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getDayRate())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息天利率不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getDayCount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("加息天数不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getValidDayCount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("有效天数不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getMinAmount())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("最低投资金额不可为空");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getMinDays())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("最低投资天数不可为空");
		} else {
			ActMoneyCouponItem actMoneyCouponItem = new ActMoneyCouponItem();
			actMoneyCouponItem.setEnumActType(actMoneyCouponItemModel.getEnumActType());
			actMoneyCouponItem.setActAmount(actMoneyCouponItemModel.getActAmount());
			actMoneyCouponItem.setActId(actMoneyCouponItemModel.getActId());
			actMoneyCouponItem.setYearRate(actMoneyCouponItemModel.getYearRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			actMoneyCouponItem.setDayRate(actMoneyCouponItemModel.getDayRate().setScale(6,BigDecimal.ROUND_DOWN).divide(new BigDecimal(100)).setScale(6,BigDecimal.ROUND_DOWN));
			actMoneyCouponItem.setDayCount(actMoneyCouponItemModel.getDayCount());
			actMoneyCouponItem.setValidDayCount(actMoneyCouponItemModel.getValidDayCount());
			actMoneyCouponItem.setMinDays(actMoneyCouponItemModel.getMinDays());
			actMoneyCouponItem.setMinAmount(actMoneyCouponItemModel.getMinAmount());
			actMoneyCouponItemMapper.insert(actMoneyCouponItem);
			jsonMessage.setFlag(true);
			jsonMessage.setMessage("添加成功");
		}
		return jsonMessage;
	}

	/**
	 * 删除体验金活动
	 * @param actMoneyCouponItemModel
	 * @param model
	 * @return
	 */
	public Object delActMoneyCouponItem(ActMoneyCouponItemModel actMoneyCouponItemModel, Model model) {
		JsonMessage jsonMessage = new JsonMessage();
		// 校验传入的参数
		if (DRUtil.isEmptyObject(actMoneyCouponItemModel)) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("非法参数");
		} else if (DRUtil.isEmptyObject(actMoneyCouponItemModel.getAutoId())) {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("体验金活动ID不可为空");
		} else {
			actMoneyCouponItemMapper.deleteByPrimaryKey(actMoneyCouponItemModel.getAutoId());
		}
		return null;
	}
}
