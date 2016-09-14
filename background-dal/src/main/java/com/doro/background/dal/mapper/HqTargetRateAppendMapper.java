package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.HqTargetRateAppend;

public interface HqTargetRateAppendMapper {
    int deleteByPrimaryKey(Long targetId);

    int insert(HqTargetRateAppend record);

    int insertSelective(HqTargetRateAppend record);

    HqTargetRateAppend selectByPrimaryKey(Long targetId);

    int updateByPrimaryKeySelective(HqTargetRateAppend record);

    int updateByPrimaryKey(HqTargetRateAppend record);
    
    int countActivity(Long actAutoId);
}