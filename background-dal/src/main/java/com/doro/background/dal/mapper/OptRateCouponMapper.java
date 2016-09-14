package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.OptRateCoupon;

public interface OptRateCouponMapper {
	int deleteByPrimaryKey(Long autoId);

	int insert(OptRateCoupon record);

	int insertSelective(OptRateCoupon record);

	OptRateCoupon selectByPrimaryKey(Long autoId);

	int updateByPrimaryKeySelective(OptRateCoupon record);

	int updateByPrimaryKey(OptRateCoupon record);

	List<Map<String, Object>> selectPageList(Map<String, Object> param);

	int count(Map<String, Object> param);
}