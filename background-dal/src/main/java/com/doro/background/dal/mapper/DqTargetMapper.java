package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.DqTarget;

public interface DqTargetMapper {
    int deleteByPrimaryKey(Long targetId);

    long insert(DqTarget record);

    int insertSelective(DqTarget record);

    DqTarget selectByPrimaryKey(Long targetId);

    int updateByPrimaryKeySelective(DqTarget record);

    int updateByPrimaryKey(DqTarget record);
    
    List<Map<String,Object>> selectPageList(Map<String,Object> param);
    
    int selectPageListCount(Map<String, Object> param);
    
    List<Map<String,Object>> selectPageAuditList(Map<String,Object> param);
    
    int selectPageAuditListCount(Map<String,Object> param);
}