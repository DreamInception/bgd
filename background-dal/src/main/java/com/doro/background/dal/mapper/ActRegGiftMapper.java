package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.ActRegGift;

public interface ActRegGiftMapper {
	int deleteByPrimaryKey(Long actAutoId);

	int insert(ActRegGift record);

	int insertSelective(ActRegGift record);

	ActRegGift selectByPrimaryKey(Long actAutoId);

	int updateByPrimaryKeySelective(ActRegGift record);

	int updateByPrimaryKey(ActRegGift record);

	List<Map<String, Object>> selectPageList(Map<String, Object> param);

	int selectPageListCount(Map<String, Object> param);
	
	Map<String, Object> selectActRegGiftByActAutoId(ActRegGift record);
	
	Map<String, Object> selectActRegGiftLast();
}