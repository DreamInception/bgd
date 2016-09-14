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

import com.doro.background.dal.entity.OptRateCoupon;
import com.doro.background.dal.entity.UserRateCoupon;
import com.doro.background.dal.mapper.OptRateCouponMapper;
import com.doro.background.dal.mapper.UserAuthMapper;
import com.doro.background.dal.mapper.UserRateCouponMapper;
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
public class OptRateCouponService {
	private static Logger logger = LoggerFactory.getLogger(OptRateCouponService.class);
	@Autowired
	OptRateCouponMapper optRateCouponMapper;
	@Autowired
	UserAuthMapper userAuthMapper;
	@Autowired
	UserRateCouponMapper userRateCouponMapper;

	/**
	 * 
	 * TODO 方法作用：查询赠送加息券列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月21日 下午5:04:21
	 */
	public List<Map<String, Object>> selectPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<Map<String, Object>> result = optRateCouponMapper.selectPageList(param);
		logger.info("查询加息券列表result:{}", result);
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
		return optRateCouponMapper.count(param);
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
	public String insert(OptRateCoupon bean) {
		String result = "success";
		bean.setAuditAdminid((long) 0);
		bean.setCreateTime(DRDateUtil.getNow());
		bean.setEnumSendgiftState(OptRateCoupon.EnumSendgiftState.INCOME.getCode());
		BigDecimal dayRate = bean.getYearRate().divide(new BigDecimal(360), 6, BigDecimal.ROUND_FLOOR);
		bean.setDayRate(dayRate);
		if (optRateCouponMapper.insert(bean) <= 0) {
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
	public String updateByPrimaryKeySelective(OptRateCoupon bean) {
		String result = "success";
		if (optRateCouponMapper.updateByPrimaryKeySelective(bean) <= 0) {
			result = "failure";
		}
		logger.info("修改是否成功====>result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：审核通过添加用户加息券
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午4:10:16
	 */
	public int addMoneyCoupon(OptRateCoupon bean) {
		UserRateCoupon userBean = new UserRateCoupon();
		userBean.setUserId(bean.getUserId());
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
		return userRateCouponMapper.insert(userBean);
	}

	/**
	 * 
	 * TODO 方法作用：根据主键查询
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午4:48:08
	 */
	public OptRateCoupon selectByPrimaryKey(Long autoId) {
		return optRateCouponMapper.selectByPrimaryKey(autoId);
	}
}
