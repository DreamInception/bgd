/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月13日 上午11:06:17
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.doro.background.dal.entity.CmsSysPic;
import com.doro.background.message.JsonMessage;
import com.doro.background.service.SysPictureService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.PushFileUtil;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.web.controller
 * @文件名 :SysPictureController.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月13日 上午11:06:17
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/sys-img")
public class SysPictureController {
	@Autowired
	SysPictureService sysPictureService;

	/**
	 * 
	 * TODO 方法作用：系统图片列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月13日 上午11:28:07
	 */
	@RequestMapping("/selectPageList.do")
	public String selectPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<CmsSysPic> resultList = sysPictureService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = sysPictureService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "img_manage/sys_img_list";
	}
	
	/**
	 * 
	 * TODO 方法作用：局部刷新
	 * @param pageNum
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午5:52:55
	 */
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<CmsSysPic> resultList = sysPictureService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = sysPictureService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "img_manage/sys_img_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：添加图片
	 * 
	 * @param file
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月13日 下午2:13:10
	 */
	@RequestMapping("/insert.do")
	public String insert(@RequestParam(value = "file") MultipartFile file, CmsSysPic bean) {
		bean.setPicUrl(PushFileUtil.pushOtherPic(file, UUID.randomUUID().toString()));
		sysPictureService.insert(bean);
		return "redirect:/sys-img/selectPageList.do";
	}
	
	/**
	 * 
	 * TODO 方法作用：根据id查
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午5:53:21
	 */
	@RequestMapping("/selectByPrimaryKey.do")
	@ResponseBody
	public JsonMessage selectByPrimaryKey(Long cmsAutoId) {
		return sysPictureService.selectByPrimaryKey(cmsAutoId);
	}
	
	/**
	 * 
	 * TODO 方法作用：修改
	 * @param file
	 * @param bean
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午5:54:44
	 */
	@RequestMapping("/edit.do")
	public String edit(@RequestParam(value = "file") MultipartFile file, CmsSysPic bean, Model model) {
		bean.setPicUrl(PushFileUtil.pushActivityPic(file));
		if (sysPictureService.updateByPrimaryKeySelective(bean).equals("success")) {
			Map<String, Object> param = new HashMap<>();
			List<CmsSysPic> resultList = sysPictureService.selectPageList(param);
			model.addAttribute("resultList", resultList);
			// 返回总页数
			int count = sysPictureService.count(param);
			Map<String, Object> page = new HashMap<>();
			page.put(DRConst.COUNT, count);
			page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
			Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
			model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
			model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		}
		return "img_manage/sys_img_list";
	}
	
	/**
	 * 
	 * TODO 方法作用：删除
	 * @param cmsAutoId
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午5:55:42
	 */
	@RequestMapping("/deleteByPrimaryKey.do")
	public String deleteByPrimaryKey(Long cmsAutoId, Model model) {
		sysPictureService.deleteByPrimaryKey(cmsAutoId);
		Map<String, Object> param = new HashMap<>();
		List<CmsSysPic> resultList = sysPictureService.selectPageList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = sysPictureService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get(DRConst.PAGE_NUM));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "img_manage/sys_img_list";
	}
}
