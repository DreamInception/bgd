package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.HqTarget;

public interface HqTargetMapper {
	
	List<Map<String, Object>> selectPageList(Map<String, Object> param);
	
	int selectPageListCount(Map<String, Object> param);
	
	int insert(HqTarget hqTarget);
	
	void updateEnumTargetState(Map<String, Object> param);
	
	HqTarget selectByPrimaryKey(Long targetId);
}
