package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.doro.background.dal.entity.CmsAppActcenter;
import com.doro.background.message.JsonMessage;
import com.doro.background.service.ActivityImgService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.PushFileUtil;
import com.doro.component.utils.page.PageDealUtil;

/**
 * 
 * @包名 :com.doro.background.web.controller
 * @文件名 :ActivityController.java TODO 类作用：活动图片管理
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月11日 下午6:10:11
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/activity-img")
public class ActivityImgController {

	@Autowired
	ActivityImgService activityImgService;

	/**
	 * 
	 * TODO 方法作用：活动图片列表
	 * 
	 * @param page
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月11日 下午6:10:23
	 */
	@RequestMapping("/selectPageList.do")
	public String selectPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<CmsAppActcenter> resultList = activityImgService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = activityImgService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "activity_manage/activity_img_list";
	}

	/**
	 * 
	 * TODO 方法作用：分页局部刷新
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月12日 上午11:55:30
	 */
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<CmsAppActcenter> resultList = activityImgService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = activityImgService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "activity_manage/activity_img_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param file
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月12日 上午10:07:56
	 */
	@RequestMapping("/insert.do")
	public String insert(@RequestParam(value = "file") MultipartFile file, CmsAppActcenter bean, Model model) {
		bean.setPicSrc(PushFileUtil.pushActivityPic(file));
		if (activityImgService.insert(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<CmsAppActcenter> resultList = activityImgService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = activityImgService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "activity_manage/activity_img_list";
	}

	/**
	 * 
	 * TODO 方法作用：根据主键查询
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 上午11:00:23
	 */
	@RequestMapping("/selectByPrimaryKey.do")
	@ResponseBody
	public JsonMessage selectByPrimaryKey(Long cmsAutoId) {
		return activityImgService.selectByPrimaryKey(cmsAutoId);
	}

	/**
	 * 
	 * TODO 方法作用：修改
	 * 
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月18日 下午2:22:52
	 */
	@RequestMapping("/edit.do")
	public String edit(@RequestParam(value = "file") MultipartFile file, CmsAppActcenter bean, Model model) {
		bean.setPicSrc(PushFileUtil.pushActivityPic(file));
		if (activityImgService.updateByPrimaryKeySelective(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<CmsAppActcenter> resultList = activityImgService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = activityImgService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "activity_manage/activity_img_list";
	}

	/**
	 * 
	 * TODO 方法作用：根据id删除
	 * 
	 * @param cmsAutoId
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月18日 下午3:47:52
	 */
	@RequestMapping("/deleteByPrimaryKey.do")
	public String deleteByPrimaryKey(Long cmsAutoId, Model model) {
		activityImgService.deleteByPrimaryKey(cmsAutoId);
		Map<String, Object> param = new HashMap<>();
		List<CmsAppActcenter> resultList = activityImgService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = activityImgService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "activity_manage/activity_img_list";
	}
}
