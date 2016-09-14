package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.HqUser;

public interface HqUserMapper {

	public List<HqUser> hqUserList();
	
	int deleteByPrimaryKey(Long hqUserId);

    int insert(HqUser record);

    int insertSelective(HqUser record);

    HqUser selectByPrimaryKey(Long hqUserId);

    int updateByPrimaryKeySelective(HqUser record);

    int updateByPrimaryKey(HqUser record);
    
    List<Map<String,Object>> selectHqBusinessList(Map<String,Object> param);
    
    int hqBusinessCount(Map<String,Object> param);
    
    List<Map<String,Object>> selectHqPageList(Map<String,Object> param);
}
