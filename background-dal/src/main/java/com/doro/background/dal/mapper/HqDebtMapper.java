package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.HqDebt;

public interface HqDebtMapper {

	List<Map<String, Object>> selectPageList(Map<String, Object> param);

	int selectPageListCount(Map<String, Object> param);
	
	List<Map<String, Object>> selectPageAuditList(Map<String, Object> param);

	int selectPageAuditListCount(Map<String, Object> param);
	
	int insert(HqDebt hqDebt);
	
	int updateByPrimaryKeySelective(HqDebt hqDebt);
	
	HqDebt selectByPrimaryKey(long key);
}
