package com.doro.background.dal.mapper;

import java.util.List;

import com.doro.background.dal.entity.UserWithdrawApplication;


public interface UserWithdrawApplicationMapper {
    int deleteByPrimaryKey(Long applicationId);

    int insert(UserWithdrawApplication record);

    int insertSelective(UserWithdrawApplication record);

    UserWithdrawApplication selectByPrimaryKey(Long applicationId);

    int updateByPrimaryKeySelective(UserWithdrawApplication record);

    int updateByPrimaryKey(UserWithdrawApplication record);
    
    UserWithdrawApplication selectHqRedeemReviewed();
    
    List<UserWithdrawApplication> selectUserRedeem(Long userId);
    
    List<UserWithdrawApplication> queryWithdraw(UserWithdrawApplication record);
}