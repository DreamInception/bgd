/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月14日 下午4:46:46
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.doro.background.dal.entity.SysAppVersion;
import com.doro.background.service.SysAppVersionService;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.common.DRDateUtil;
import com.doro.component.utils.common.PushFileUtil;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.web.controller
 * @文件名 :SysAppVersionController.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月14日 下午4:46:46
 * @版本号 :v1.0.0-16010415
 */
@Controller
@RequestMapping("/app-version")
public class SysAppVersionController {

	@Autowired
	SysAppVersionService sysAppVersionService;

	/**
	 * 
	 * TODO 方法作用：版本列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午4:49:09
	 */
	@RequestMapping("/versionPageList.do")
	public String versionPageList(Model model) {
		Map<String, Object> param = new HashMap<>();
		List<Map<String, Object>> resultList = sysAppVersionService.getVersionList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = sysAppVersionService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "version_manage/version_list";
	}

	/**
	 * 
	 * TODO 方法作用：局部刷新
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 上午11:03:29
	 */
	@RequestMapping("/refresh.do")
	public String refresh(Integer pageNum, Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put(DRConst.PAGE_KEY_PAGE, pageNum);
		List<Map<String, Object>> resultList = sysAppVersionService.getVersionList(param);
		model.addAttribute("resultList", resultList);
		// 返回总页数
		int count = sysAppVersionService.count(param);
		Map<String, Object> page = new HashMap<>();
		page.put(DRConst.COUNT, count);
		page.put(DRConst.PAGE_NUM, param.get("pageNum"));
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		model.addAttribute(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));// 当前页码
		model.addAttribute(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));// 总页数
		return "version_manage/version_refresh";
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param file
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 上午11:34:14
	 */
	@RequestMapping("/insert.do")
	public String insert(@RequestParam(value = "file") MultipartFile file, SysAppVersion bean) {
		bean.setPicUrl(PushFileUtil.pushBannerPic(file));
		if (bean.getPicUrl() != null) {
			String versionStr = bean.getAppVersionStr();
			versionStr = versionStr.replace(".", "");
			bean.setAppVersionInt(Integer.parseInt(versionStr));
			bean.setEnumAppVersionState(SysAppVersion.EnumAppVersionState.EDIT.getCode());
			bean.setCreateTime(DRDateUtil.getNow(DRDateUtil.YYYYMMDDHHMMSS));
			sysAppVersionService.insert(bean);
		}
		return "forward:/app-version/versionPageList.do";
	}

	/**
	 * 
	 * TODO 方法作用：修改审核状态
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 下午4:43:19
	 */
	@RequestMapping("/setState.do")
	public String setState(SysAppVersion record){
		String url = "";
		sysAppVersionService.update(record);
		if(record.getEnumAppVersionState() == 100){
			url = "forward:/app-version/versionPageList.do";
		}else if(record.getEnumAppVersionState() == 200){
			url = "forward:/app-version/reviewList.do";
		}
		return url;
	}
	/**
	 * 
	 * TODO 方法作用：审核列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午5:29:37
	 */
	@RequestMapping("/reviewList.do")
	public String reviewList(Model model) {
		Map<String, Object> param = new HashMap<>();
		param.put("enumAppVersionState", SysAppVersion.EnumAppVersionState.REVIEWING.getCode());
		List<Map<String, Object>> resultList = sysAppVersionService.getVersionList(param);
		model.addAttribute("resultList", resultList);
		return "version_manage/version_review_list";
	}
}
