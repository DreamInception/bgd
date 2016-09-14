package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.CmsAppActcenter;

public interface CmsAppActcenterMapper {
    int deleteByPrimaryKey(Long cmsAutoId);

    int insert(CmsAppActcenter record);

    int insertSelective(CmsAppActcenter record);

    CmsAppActcenter selectByPrimaryKey(Long cmsAutoId);

    int updateByPrimaryKeySelective(CmsAppActcenter record);

    int updateByPrimaryKey(CmsAppActcenter record);
    
    List<CmsAppActcenter> selectPageList(Map<String, Object> param);
    
    int count(Map<String, Object> param);
}