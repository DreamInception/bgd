package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.BaofooOutgo;

public interface BaofooOutgoMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(BaofooOutgo record);

    int insertSelective(BaofooOutgo record);

    BaofooOutgo selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(BaofooOutgo record);

    int updateByPrimaryKey(BaofooOutgo record);
}