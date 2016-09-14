package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.doro.background.dal.entity.CmsAppBanner;
import com.doro.background.message.JsonMessage;
import com.doro.background.service.BannerService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.PushFileUtil;
import com.doro.component.utils.page.PageDealUtil;

/**
 * 
 * @包名 :com.doro.background.web.controller
 * @文件名 :BannerController.java TODO 类作用：首页banner管理
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月8日 下午2:23:06
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

	Logger logger = LoggerFactory.getLogger(BannerController.class);

	@Autowired
	BannerService bannerService;

	/**
	 * 
	 * TODO 方法作用：banner列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月8日 下午3:16:09
	 */
	@RequestMapping("/bannerList.do")
	public String bannerList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<CmsAppBanner> resultList = bannerService.getBannerList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = bannerService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "banner_manage/banner_list";
	}

	/**
	 * 
	 * TODO 方法作用：局部刷新
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:51:19
	 */
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<CmsAppBanner> resultList = bannerService.getBannerList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = bannerService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "banner_manage/banner_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param file
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月11日 下午2:15:15
	 */
	@RequestMapping("/insert.do")
	public String insert(@RequestParam(value = "file") MultipartFile file, CmsAppBanner bean) {
		bean.setPicSrc(PushFileUtil.pushBannerPic(file));
		bannerService.insert(bean);
		return "forward:/banner/bannerList.do";
	}

	/**
	 * 
	 * TODO 方法作用：根据主键查询
	 * 
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午1:54:21
	 */
	@RequestMapping("/selectByPrimaryKey.do")
	@ResponseBody
	public JsonMessage selectByPrimaryKey(Long cmsAutoId) {
		return bannerService.selectByPrimaryKey(cmsAutoId);
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
	 * @Date: 2016年7月20日 下午1:57:48
	 */
	@RequestMapping("/edit.do")
	public String edit(@RequestParam(value = "file") MultipartFile file, CmsAppBanner bean, Model model) {
		bean.setPicSrc(PushFileUtil.pushActivityPic(file));
		if (bannerService.updateByPrimaryKeySelective(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<CmsAppBanner> resultList = bannerService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = bannerService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "banner_manage/banner_list";
	}

	/**
	 * 
	 * TODO 方法作用：删除
	 * 
	 * @param cmsAutoId
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:34:04
	 */
	@RequestMapping("/deleteByPrimaryKey.do")
	public String deleteByPrimaryKey(Long cmsAutoId, Model model) {
		bannerService.deleteByPrimaryKey(cmsAutoId);
		Map<String, Object> param = new HashMap<>();
		List<CmsAppBanner> resultList = bannerService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = bannerService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "banner_manage/banner_list";
	}
}
