package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.ActRateCouponItem;

public interface ActRateCouponItemMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(ActRateCouponItem record);

    int insertBatch(List<ActRateCouponItem> actRateCouponItems);
    
    int insertSelective(ActRateCouponItem record);

    ActRateCouponItem selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(ActRateCouponItem record);

    int updateByPrimaryKey(ActRateCouponItem record);
    
    List<Map<String,Object>> selectByActId(Long actId,Integer enumActType);
}