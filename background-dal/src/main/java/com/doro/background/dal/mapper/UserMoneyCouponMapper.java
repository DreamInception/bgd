package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.UserMoneyCoupon;

public interface UserMoneyCouponMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(UserMoneyCoupon record);

    int insertSelective(UserMoneyCoupon record);

    UserMoneyCoupon selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(UserMoneyCoupon record);

    int updateByPrimaryKey(UserMoneyCoupon record);
}