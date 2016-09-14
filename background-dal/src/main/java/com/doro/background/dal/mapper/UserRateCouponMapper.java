package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.UserRateCoupon;

public interface UserRateCouponMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(UserRateCoupon record);

    int insertSelective(UserRateCoupon record);

    UserRateCoupon selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(UserRateCoupon record);

    int updateByPrimaryKey(UserRateCoupon record);
}