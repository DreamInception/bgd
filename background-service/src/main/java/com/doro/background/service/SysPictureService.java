/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月13日 上午10:31:36
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.CmsSysPic;
import com.doro.background.dal.mapper.CmsSysPicMapper;
import com.doro.background.message.JsonMessage;
import com.doro.component.utils.page.PageDealUtil;

/**
 * @包名 :com.doro.background.service
 * @文件名 :SysPictureService.java TODO 类作用：系统图片管理
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月13日 上午10:31:36
 * @版本号 :v1.0.0-16010415
 */
@Service
public class SysPictureService {

	private static Logger logger = LoggerFactory.getLogger(SysPictureService.class);

	@Autowired
	CmsSysPicMapper cmsSysPicMapper;

	/**
	 * 
	 * TODO 方法作用：系统图片列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月13日 上午10:36:23
	 */
	public List<CmsSysPic> selectPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		List<CmsSysPic> result = cmsSysPicMapper.selectPageList(param);
		logger.info("查询系统图片列表result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：统计符合条件的记录条数
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月13日 上午10:36:35
	 */
	public int count(Map<String, Object> param) {
		return cmsSysPicMapper.count(param);
	}
	
	/**
	 * 
	 * TODO 方法作用：添加图片
	 * @param bean
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月13日 下午2:12:21
	 */
	public String insert(CmsSysPic bean) {
		String result = "success";
		if (cmsSysPicMapper.insert(bean) <= 0) {
			result = "failure";
		}
		logger.info("添加是否成功====>result:{}", result);
		return result;
	}
	
	/**
	 * 
	 * TODO 方法作用：根据id查
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午5:59:41
	 */
	public JsonMessage selectByPrimaryKey(Long autoId) {
		JsonMessage jsonMessage = new JsonMessage();
		logger.info("传入的图片id====》autoId:{}", autoId);
		CmsSysPic result = cmsSysPicMapper.selectByPrimaryKey(autoId);
		if (result != null) {
			System.out.println(result.getAutoId());
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
	 * @Date: 2016年7月20日 下午6:01:53
	 */
	public String updateByPrimaryKeySelective(CmsSysPic bean) {
		String result = "success";
		if (cmsSysPicMapper.updateByPrimaryKeySelective(bean) <= 0) {
			result = "failure";
		}
		logger.info("修改是否成功====>result:{}", result);
		return result;
	}
	
	/**
	 * 
	 * TODO 方法作用：删除
	 * @param cmsAutoId
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月20日 下午6:04:04
	 */
	public int deleteByPrimaryKey(Long cmsAutoId) {
		logger.info("传入的图片id====》cmsAutoId:{}", cmsAutoId);
		int result = cmsSysPicMapper.deleteByPrimaryKey(cmsAutoId);
		logger.info("删除是否成功====>result:{}", result);
		return result;
	}
}
