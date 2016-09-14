package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.ActTargetRateAppend;

public interface ActTargetRateAppendMapper {
	
	List<Map<String, Object>> selectPageList(Map<String, Object> param);
	
	int selectPageListCount(Map<String, Object> param);
	
	int insert(ActTargetRateAppend actTargetRateAppend);
	
	void update(ActTargetRateAppend actTargetRateAppend);
	
	void updateOnsale(Map<String, Object> param);
	
	List<Map<String, Object>> selectByValid();
	
	ActTargetRateAppend selectByPrimaryKey(Long actAutoId);
}
