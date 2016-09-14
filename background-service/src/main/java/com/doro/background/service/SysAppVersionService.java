/*************************************************************************
 * @system name：  :上海景源金服服务端
 * @Author: 子陵 604969793@qq.com
 * @Date: 2016年7月14日 下午4:43:29
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package com.doro.background.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.SysAppVersion;
import com.doro.background.dal.mapper.SysAppVersionMapper;

/**
 * @包名 :com.doro.background.service
 * @文件名 :SysAppVersionService.java TODO 类作用：
 * @系统名称 : 上海景源金服服务端
 * @Author: 子陵
 * @Date: 2016年7月14日 下午4:43:29
 * @版本号 :v1.0.0-16010415
 */
@Service
public class SysAppVersionService {
	private static Logger logger = LoggerFactory.getLogger(SysAppVersionService.class);
	@Autowired
	SysAppVersionMapper sysAppVersionMapper;

	/**
	 * 
	 * TODO 方法作用：获取app版本列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午4:45:57
	 */
	public List<Map<String, Object>> getVersionList(Map<String, Object> param) {
		List<Map<String, Object>> resultList = sysAppVersionMapper.selectVersionList(param);
		logger.info("查询到的版本列表==>resultList:{}", resultList);
		return resultList;
	}

	/**
	 * 
	 * TODO 方法作用：添加
	 * @param record
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 上午11:36:44
	 */
	public int insert(SysAppVersion record){
		return sysAppVersionMapper.insert(record);
	}
	
	/**
	 * 
	 * TODO 方法作用：更新状态
	 * @param record
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 下午4:47:14
	 */
	public int update(SysAppVersion record){
		return sysAppVersionMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 
	 * TODO 方法作用：统计符合条件的记录条数
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年8月10日 上午11:11:54
	 */
	public int count(Map<String, Object> param) {
		return sysAppVersionMapper.count(param);
	}
}
