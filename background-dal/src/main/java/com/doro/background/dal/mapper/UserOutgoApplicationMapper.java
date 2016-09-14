package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.UserOutgoApplication;

public interface UserOutgoApplicationMapper {
    int deleteByPrimaryKey(Long applicationId);

    int insert(UserOutgoApplication record);

    int insertSelective(UserOutgoApplication record);

    UserOutgoApplication selectByPrimaryKey(Long applicationId);

    int updateByPrimaryKeySelective(UserOutgoApplication record);

    int updateByPrimaryKey(UserOutgoApplication record);
    
    int count(Map<String, Object> map);
    
    List<UserOutgoApplication> selectPage(Map<String, Object> map);
}