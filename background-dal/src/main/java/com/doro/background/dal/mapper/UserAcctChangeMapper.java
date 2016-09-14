package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.UserAcctChange;

public interface UserAcctChangeMapper {
    int deleteByPrimaryKey(Long mapAutoId);

    int insert(UserAcctChange record);

    int insertSelective(UserAcctChange record);

    UserAcctChange selectByPrimaryKey(Long mapAutoId);

    int updateByPrimaryKeySelective(UserAcctChange record);

    int updateByPrimaryKey(UserAcctChange record);
}