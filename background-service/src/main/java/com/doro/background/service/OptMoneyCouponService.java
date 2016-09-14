/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月21日 下午5:00:08
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.OptMoneyCoupon;
import com.doro.background.dal.entity.UserMoneyCoupon;
import com.doro.background.dal.mapper.OptMoneyCouponMapper;
import com.doro.background.dal.mapper.UserAuthMapper;
import com.doro.background.dal.mapper.UserMoneyCouponMapper;
import com.doro.background.message.JsonMessage;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.service
 * @文件名 :OptMoneyCoupnService.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月21日 下午5:00:08
 * @版本号 :v1.0.0-16010415
 */
@Service
public class OptMoneyCouponService {
	private static Logger logger = LoggerFactory.getLogger(OptMoneyCouponService.class);
	@Autowired
	OptMoneyCouponMapper optMoneyCouponMapper;
	@Autowired
	UserMoneyCouponMapper userMoneyCouponMapper;
	@Autowired
	UserAuthMapper userAuthMapper;

	/**
	 * 
	 * TODO 方法作用：查询赠送体验金券列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月21日 下午5:04:21
	 */
	public List<Map<String, Object>> selectPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<Map<String, Object>> result = optMoneyCouponMapper.selectPageList(param);
		logger.info("查询活动图片列表result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：统计条数
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月21日 下午5:07:16
	 */
	public int count(Map<String, Object> param) {
		return optMoneyCouponMapper.count(param);
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月22日 上午10:42:25
	 */
	public String insert(OptMoneyCoupon bean) {
		String result = "success";
		bean.setAuditAdminid((long) 0);
		bean.setCreateTime(DRDateUtil.getNow());
		bean.setEnumSendgiftState(OptMoneyCoupon.EnumSendgiftState.INCOME.getCode());
		BigDecimal dayRate = bean.getYearRate().divide(new BigDecimal(360), 6, BigDecimal.ROUND_FLOOR);
		bean.setDayRate(dayRate);
		if (optMoneyCouponMapper.insert(bean) <= 0) {
			result = "failure";
		}
		logger.info("添加是否成功====>result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：根据用户手机查询用户信息
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月25日 上午11:29:25
	 */
	public JsonMessage selectByUserMobile(String userMobile) {
		JsonMessage jsonMessage = new JsonMessage();
		Map<String, Object> param = new HashMap<>();
		param.put("userMobile", userMobile);
		List<Map<String,Object>> userList = userAuthMapper.selectByCondition(param);
		if (userList.size() > 0) {
			jsonMessage.setFlag(true);
			Map<String, Object> user = userList.get(0);
			user.put("userId", user.get("userId").toString());
			jsonMessage.setData(user);
			jsonMessage.setMessage("查询成功！");
		} else {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("未查询到用户！");
		}
		return jsonMessage;
	}

	/**
	 * 
	 * TODO 方法作用：修改
	 * 
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午3:09:28
	 */
	public String updateByPrimaryKeySelective(OptMoneyCoupon bean) {
		String result = "success";
		if (optMoneyCouponMapper.updateByPrimaryKeySelective(bean) <= 0) {
			result = "failure";
		}
		logger.info("修改是否成功====>result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：审核通过添加用户体验金券
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午4:10:16
	 */
	public int addMoneyCoupon(OptMoneyCoupon bean) {
		UserMoneyCoupon userBean = new UserMoneyCoupon();
		userBean.setUserId(bean.getUserId());
		userBean.setAmount(bean.getAmount());
		userBean.setYearRate(bean.getYearRate());
		userBean.setDayRate(bean.getDayRate());
		userBean.setDayCount(bean.getDayCount());
		userBean.setClosingDate(bean.getEndDate());
		userBean.setMinAmount(bean.getMinAmount());
		userBean.setMinDays(bean.getMinDays());
		userBean.setIsUsed(false);
		userBean.setUseTime(DRDateUtil.parseDate(DRDateUtil.getNowStr(DRDateUtil.YYYYMMDDHHMMSS), DRDateUtil.YYYYMMDDHHMMSS));
		userBean.setTitleTip("运营送");
		userBean.setRemark(bean.getRemark());
		userBean.setCreateTime(
				DRDateUtil.parseDate(DRDateUtil.getNowStr(DRDateUtil.YYYYMMDDHHMMSS), DRDateUtil.YYYYMMDDHHMMSS));
		return userMoneyCouponMapper.insert(userBean);
	}

	/**
	 * 
	 * TODO 方法作用：根据主键查询
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午4:48:08
	 */
	public OptMoneyCoupon selectByPrimaryKey(Long autoId) {
		return optMoneyCouponMapper.selectByPrimaryKey(autoId);
	}
}
