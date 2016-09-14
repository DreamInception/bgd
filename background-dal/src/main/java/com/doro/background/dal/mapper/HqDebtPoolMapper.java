package com.doro.background.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.HqDebtPool;

public interface HqDebtPoolMapper {
	int deleteByPrimaryKey(Long poolAutoId);

	int insert(HqDebtPool record);

	int insertSelective(HqDebtPool record);

	HqDebtPool selectByPrimaryKey(Long poolAutoId);

	int updateByPrimaryKeySelective(HqDebtPool record);

	int updateByPrimaryKey(HqDebtPool record);

	HqDebtPool queryDebtPollDesc(BigDecimal currentAmount,Long userId);

	List<HqDebtPool> queryDebtPollAse(BigDecimal currentAmount,Long userId);

	HqDebtPool queryDebtPollForUpdate(Long poolAtuoId);

	int updateCurrentAmount(HqDebtPool record);
	
	int count(Map<String,Object> param);
	
	List<Map<String,Object>> selectPageList(Map<String,Object> param);
	
	Map<String,Object> countDistinct();
}
