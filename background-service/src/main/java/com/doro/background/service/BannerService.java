/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月8日 下午3:48:38
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.CmsAppBanner;
import com.doro.background.dal.mapper.CmsAppBannerMapper;
import com.doro.background.message.JsonMessage;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.service
 * @文件名 :BannerService.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月8日 下午3:48:38
 * @版本号 :v1.0.0-16010415
 */
@Service
public class BannerService {
	private static Logger logger = LoggerFactory.getLogger(BannerService.class);

	@Autowired
	CmsAppBannerMapper cmsAppBannerMapper;

	/**
	 * 
	 * TODO 方法作用：后台管理banner列表
	 * 
	 * @param model
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月8日 下午3:59:11
	 */
	public List<CmsAppBanner> getBannerList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<CmsAppBanner> result = cmsAppBannerMapper.selectPageList(param);
		logger.info("banner列表:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * 
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月11日 下午2:13:02
	 */
	public String insert(CmsAppBanner bean) {
		String result = "success";
		if (bean.getAndroidKey() == null) {
			bean.setAndroidKey("");
		}
		if (bean.getIosKey() == null) {
			bean.setIosKey("");
		}
		if (cmsAppBannerMapper.insert(bean) <= 0) {
			result = "failure";
		}
		logger.info("添加是否成功====>result:{}", result);
		return result;
	}

	/**
	 * TODO 方法作用：根据id查
	 * 
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午1:54:41
	 */
	public JsonMessage selectByPrimaryKey(Long cmsAutoId) {
		JsonMessage jsonMessage = new JsonMessage();
		logger.info("传入的图片id====》cmsAutoId:{}", cmsAutoId);
		CmsAppBanner result = cmsAppBannerMapper.selectByPrimaryKey(cmsAutoId);
		if (result != null) {
			jsonMessage.setFlag(true);
			jsonMessage.setData(result);
		} else {
			jsonMessage.setFlag(false);
			jsonMessage.setMessage("未查询到数据！");
		}
		return jsonMessage;
	}
	
	/**
	 * 
	 * TODO 方法作用：编辑
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:01:14
	 */
	public String updateByPrimaryKeySelective(CmsAppBanner bean) {
		String result = "success";
		if (cmsAppBannerMapper.updateByPrimaryKeySelective(bean) <= 0) {
			result = "failure";
		}
		logger.info("修改是否成功====>result:{}", result);
		return result;
	}
	
	/**
	 * 
	 * TODO 方法作用：获取banner列表
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:07:30
	 */
	public List<CmsAppBanner> selectPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<CmsAppBanner> result = cmsAppBannerMapper.selectPageList(param);
		logger.info("查询banner列表result:{}", result);
		return result;
	}
	
	/**
	 * 
	 * TODO 方法作用：根据条件查询总条数
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:23:07
	 */
	public int count(Map<String, Object> param) {
		return cmsAppBannerMapper.count(param);
	}
	
	/**
	 * 
	 * TODO 方法作用：根据id删除
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午2:32:39
	 */
	public int deleteByPrimaryKey(Long cmsAutoId) {
		logger.info("传入的图片id====》cmsAutoId:{}", cmsAutoId);
		int result = cmsAppBannerMapper.deleteByPrimaryKey(cmsAutoId);
		logger.info("删除是否成功====>result:{}", result);
		return result;
	}
}
