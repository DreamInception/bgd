package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.ActAwardGift;

public interface ActAwardGiftMapper {
    int deleteByPrimaryKey(Long actAutoId);

    int insert(ActAwardGift record);

    int insertSelective(ActAwardGift record);

    ActAwardGift selectByPrimaryKey(Long actAutoId);

    int updateByPrimaryKeySelective(ActAwardGift record);

    int updateByPrimaryKey(ActAwardGift record);
    
    List<Map<String, Object>> selectPageList(Map<String, Object> param);

	int selectPageListCount(Map<String, Object> param);
}