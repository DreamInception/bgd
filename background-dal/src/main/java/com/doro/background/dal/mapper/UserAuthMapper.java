package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.UserAuth;

public interface UserAuthMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(UserAuth record);

	int insertSelective(UserAuth record);

	UserAuth selectByPrimaryKey(Long userId);

	int updateByPrimaryKeySelective(UserAuth record);

	int updateByPrimaryKey(UserAuth record);

	List<Map<String,Object>> selectByCondition(Map<String, Object> param);
}