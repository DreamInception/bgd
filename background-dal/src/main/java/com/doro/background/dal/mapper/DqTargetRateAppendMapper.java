package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.DqTargetRateAppend;

public interface DqTargetRateAppendMapper {
    int deleteByPrimaryKey(Long targetId);

    int insert(DqTargetRateAppend record);

    int insertSelective(DqTargetRateAppend record);

    DqTargetRateAppend selectByPrimaryKey(Long targetId);

    int updateByPrimaryKeySelective(DqTargetRateAppend record);

    int updateByPrimaryKey(DqTargetRateAppend record);
    
}