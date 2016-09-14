package com.doro.background.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doro.background.dal.entity.HqUser;
import com.doro.background.dal.mapper.HqUserMapper;
import com.doro.component.utils.common.DRConst;
import com.doro.component.utils.page.PageDealUtil;

@Service
public class HqUserService {

	private static Logger logger = LoggerFactory.getLogger(HqUserService.class);

	@Autowired
	private HqUserMapper hqUserMapper;

	/**
	 * 获取债券投资列表
	 * 
	 * @return
	 */
	public List<HqUser> getHqUserList() {
		return hqUserMapper.hqUserList();
	}

	/**
	 * 
	 * TODO 方法作用：后台管理-用户活期投资记录列表
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午2:32:42
	 */
	public List<Map<String, Object>> getUserPageList(Map<String, Object> param) {
		PageDealUtil.getLimit(param);
		if (param.containsKey("orderBy") && param.get("orderBy") == null) {
			param.put("orderBy", "order by hu.buy_time DESC");
		}
		List<Map<String, Object>> result = hqUserMapper.selectHqBusinessList(param);
		logger.info("用户活期投资列表result:{}", result);
		return result;
	}

	/**
	 * 
	 * TODO 方法作用：用户活期投资记录页数统计(12条/页)
	 * 
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午2:33:02
	 */
	public Map<String, Object> userInvestCount(Map<String, Object> param) {
		int count = hqUserMapper.hqBusinessCount(param);
		Map<String, Object> page = new HashMap<String, Object>();
		page.put(DRConst.COUNT, count);
		Map<String, Object> pageMap = PageDealUtil.getPageCount(page);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(DRConst.PAGE_COUNT, pageMap.get(DRConst.PAGE_COUNT));
		result.put(DRConst.PAGE_NUM, pageMap.get(DRConst.PAGE_NUM));
		return result;
	}
	
	/**
	 * 
	 * TODO 方法作用：后台管理-活期投资列表
	 * @param param
	 * @return
	 * @Author: 子陵
	 * @Date: 2016年7月14日 下午4:03:01
	 */
	public List<Map<String, Object>> getPageList(Map<String, Object> param) {
		List<Map<String, Object>> result = hqUserMapper.selectHqPageList(param);
		logger.info("活期投资列表result:{}", result);
		return result;
	}
}
