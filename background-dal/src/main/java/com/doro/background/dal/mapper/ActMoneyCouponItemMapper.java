package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.ActMoneyCouponItem;

public interface ActMoneyCouponItemMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(ActMoneyCouponItem record);

    int insertBatch(List<ActMoneyCouponItem> actMoneyCouponItems);
    
    int insertSelective(ActMoneyCouponItem record);

    ActMoneyCouponItem selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(ActMoneyCouponItem record);

    int updateByPrimaryKey(ActMoneyCouponItem record);
    
    List<Map<String,Object>> selectByActId(Long actId,Integer enumActType);
}