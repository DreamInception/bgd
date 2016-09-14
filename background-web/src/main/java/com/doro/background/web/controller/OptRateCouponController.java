/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月21日 下午5:08:42
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doro.background.dal.entity.OptRateCoupon;
import com.doro.background.message.JsonMessage;
import com.doro.background.service.OptRateCouponService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.web.controller
 * @文件名 :OptMoneyCoupnController.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月21日 下午5:08:42
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/opt-rate-coupon")
public class OptRateCouponController {
	@Autowired
	OptRateCouponService optRateCouponService;

	/**
	 * 
	 * TODO 方法作用：查询赠送体验金列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月21日 下午5:11:13
	 */
	@RequestMapping("/selectPageList.do")
	public String selectPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = optRateCouponService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "operation_manage/operation_rate_list";
	}

	/**
	 * 
	 * TODO 方法作用：局部刷新
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月8日 下午5:07:05
	 */
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = optRateCouponService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "operation_manage/operation_rate_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：赠送体验金审核列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午3:47:29
	 */
	@RequestMapping("/selectReviewList.do")
	public String selectReviewList(Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put("enumSendgiftState", OptRateCoupon.EnumSendgiftState.REVIEWING.getCode());
		List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = optRateCouponService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "operation_manage/opt_review_rate_list";
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param file
	 * @param bean
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月22日 上午10:39:51
	 */
	@RequestMapping("/insert.do")
	public String insert(OptRateCoupon bean, Model model) {
		if (optRateCouponService.insert(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = optRateCouponService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "operation_manage/operation_rate_list";
	}

	/**
	 * 
	 * TODO 方法作用：根据手机查询用户信息
	 * 
	 * @param userMobile
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月25日 上午11:43:32
	 */
	@RequestMapping(value = "/selectByUserMobile.do", method = RequestMethod.POST)
	@ResponseBody
	public JsonMessage selectByUserMobile(String userMobile) {
		return optRateCouponService.selectByUserMobile(userMobile);
	}

	/**
	 * 
	 * TODO 方法作用：修改
	 * 
	 * @param file
	 * @param bean
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午3:12:15
	 */
	@RequestMapping("/edit.do")
	public String edit(OptRateCoupon bean, Model model) {
		if (optRateCouponService.updateByPrimaryKeySelective(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = optRateCouponService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "operation_manage/operation_rate_list";
	}

	/**
	 * 
	 * TODO 方法作用：通过审核
	 * 
	 * @param bean
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午4:04:56
	 */
	@RequestMapping("/pass.do")
	@Transactional
	public String pass(OptRateCoupon bean, Model model) {
		// 此处从session里获取userid赋值
		bean.setAuditAdminid(Long.parseLong("2016070518019111845"));
		bean.setEnumSendgiftState(OptRateCoupon.EnumSendgiftState.SUCCESS.getCode());
		if (optRateCouponService.updateByPrimaryKeySelective(bean).equals("success")) {
			OptRateCoupon recod = optRateCouponService.selectByPrimaryKey(bean.getAutoId());
			optRateCouponService.addMoneyCoupon(recod);

			Map<String, Object> param = new HashMap<>();
			param.put("enumSendgiftState", OptRateCoupon.EnumSendgiftState.REVIEWING.getCode());
			List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = optRateCouponService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "operation_manage/opt_review_rate_list";
	}

	/**
	 * 
	 * TODO 方法作用：驳回请求
	 * 
	 * @param bean
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月26日 下午5:22:02
	 */
	@RequestMapping("/denie.do")
	public String denie(OptRateCoupon bean, Model model) {
		// 此处从session里获取userid赋值
		bean.setAuditAdminid(Long.parseLong("2016070518019111845"));
		bean.setEnumSendgiftState(OptRateCoupon.EnumSendgiftState.INCOME.getCode());
		if (optRateCouponService.updateByPrimaryKeySelective(bean).equals("success")) {

			Map<String, Object> param = new HashMap<>();
			param.put("enumSendgiftState", OptRateCoupon.EnumSendgiftState.REVIEWING.getCode());
			List<Map<String, Object>> resultList = optRateCouponService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = optRateCouponService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "operation_manage/opt_review_rate_list";
	}
}