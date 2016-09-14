package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.CmsAppBanner;

public interface CmsAppBannerMapper {
    int deleteByPrimaryKey(Long cmsAutoId);

    int insert(CmsAppBanner record);

    int insertSelective(CmsAppBanner record);

    CmsAppBanner selectByPrimaryKey(Long cmsAutoId);

    int updateByPrimaryKeySelective(CmsAppBanner record);

    int updateByPrimaryKey(CmsAppBanner record);
    
    List<CmsAppBanner> selectPageList(Map<String, Object> param);
    
    int count(Map<String, Object> param);
}