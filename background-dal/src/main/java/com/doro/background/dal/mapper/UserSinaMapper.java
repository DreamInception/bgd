package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.UserSina;

public interface UserSinaMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserSina record);

    int insertSelective(UserSina record);

    UserSina selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserSina record);

    int updateByPrimaryKey(UserSina record);
}