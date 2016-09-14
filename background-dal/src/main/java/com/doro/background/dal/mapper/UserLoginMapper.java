package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
    
    List<Map<String,Object>> selectByCondition(Map<String,Object> param);
}