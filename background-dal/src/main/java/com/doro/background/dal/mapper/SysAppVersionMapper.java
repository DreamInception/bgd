package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.SysAppVersion;

public interface SysAppVersionMapper {
    int deleteByPrimaryKey(Long appVersionId);

    int insert(SysAppVersion record);

    int insertSelective(SysAppVersion record);

    SysAppVersion selectByPrimaryKey(Long appVersionId);

    int updateByPrimaryKeySelective(SysAppVersion record);

    int updateByPrimaryKey(SysAppVersion record);
    
    List<Map<String,Object>> selectVersionList(Map<String,Object> param);
    
    int count(Map<String,Object> param);
}