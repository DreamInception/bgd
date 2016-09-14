package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.OptMoneyCoupon;

public interface OptMoneyCouponMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(OptMoneyCoupon record);

    int insertSelective(OptMoneyCoupon record);

    OptMoneyCoupon selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(OptMoneyCoupon record);

    int updateByPrimaryKey(OptMoneyCoupon record);
    
    List<Map<String,Object>> selectPageList(Map<String,Object> param);
    
    int count(Map<String,Object> param);
}