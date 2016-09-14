/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月11日 下午6:16:08
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.CmsAppActcenter;
import com.doro.background.dal.mapper.CmsAppActcenterMapper;
import com.doro.background.message.JsonMessage;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.service
 * @文件名 :ActivityImgService.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月11日 下午6:16:08
 * @版本号 :v1.0.0-16010415
 */
@Service
public class ActivityImgService {

	private static Logger logger = LoggerFactory.getLogger(ActivityImgService.class);
	@Autowired
	CmsAppActcenterMapper cmsAppActcenterMapper;

	/**
	 * 
	 * TODO 方法作用：获取活动图片列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月11日 下午6:53:48
	 */
	public List<CmsAppActcenter> selectPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<CmsAppActcenter> result = cmsAppActcenterMapper.selectPageList(param);
		logger.info("查询活动图片列表result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：根据条件查询总条数
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月12日 下午1:54:41
	 */
	public int count(Map<String, Object> param) {
		return cmsAppActcenterMapper.count(param);
	}

	/**
	 * 
	 * TODO 方法作用：添加活动图片
	 * 
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月12日 上午10:11:27
	 */
	public String insert(CmsAppActcenter bean) {
		String result = "success";
		if (bean.getAndroidKey() == null) {
			bean.setAndroidKey("");
		}
		if (bean.getIosKey() == null) {
			bean.setIosKey("");
		}
		if (cmsAppActcenterMapper.insert(bean) <= 0) {
			result = "failure";
		}
		logger.info("添加是否成功====>result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：根据id查
	 * 
	 * @Author: 子陵
	 * @Date: 2016年7月14日 上午11:06:29
	 */
	public JsonMessage selectByPrimaryKey(Long cmsAutoId) {
		JsonMessage jsonMessage = new JsonMessage();
		logger.info("传入的图片id====》cmsAutoId:{}", cmsAutoId);
		CmsAppActcenter result = cmsAppActcenterMapper.selectByPrimaryKey(cmsAutoId);
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
	 * 
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月18日 下午2:24:44
	 */
	public String updateByPrimaryKeySelective(CmsAppActcenter bean) {
		String result = "success";
		if (bean.getAndroidKey() == null) {
			bean.setAndroidKey("");
		}
		if (bean.getIosKey() == null) {
			bean.setIosKey("");
		}
		if (cmsAppActcenterMapper.updateByPrimaryKeySelective(bean) <= 0) {
			result = "failure";
		}
		logger.info("添加是否成功====>result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：根据id删除
	 * 
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月18日 下午3:18:48
	 */
	public int deleteByPrimaryKey(Long cmsAutoId) {
		logger.info("传入的图片id====》cmsAutoId:{}", cmsAutoId);
		int result = cmsAppActcenterMapper.deleteByPrimaryKey(cmsAutoId);
		logger.info("删除是否成功====>result:{}", result);
		return result;
	}
}
