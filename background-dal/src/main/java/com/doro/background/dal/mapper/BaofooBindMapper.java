package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.BaofooBind;

public interface BaofooBindMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(BaofooBind record);

    int insertSelective(BaofooBind record);

    BaofooBind selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(BaofooBind record);

    int updateByPrimaryKey(BaofooBind record);
}