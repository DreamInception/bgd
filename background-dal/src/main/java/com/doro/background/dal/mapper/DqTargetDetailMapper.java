package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.DqTargetDetail;

public interface DqTargetDetailMapper {
    int deleteByPrimaryKey(Long targetId);

    int insert(DqTargetDetail record);

    int insertSelective(DqTargetDetail record);

    DqTargetDetail selectByPrimaryKey(Long targetId);

    int updateByPrimaryKeySelective(DqTargetDetail record);

    int updateByPrimaryKeyWithBLOBs(DqTargetDetail record);

    int updateByPrimaryKey(DqTargetDetail record);
}