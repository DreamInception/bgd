package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.CmsSysPic;

public interface CmsSysPicMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(CmsSysPic record);

    int insertSelective(CmsSysPic record);

    CmsSysPic selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(CmsSysPic record);

    int updateByPrimaryKey(CmsSysPic record);
    
    List<CmsSysPic> selectPageList(Map<String, Object> param);
    
    int count(Map<String, Object> param);
    
    List<Map<String, Object>> selectByPicCode(String picCode);
    
    CmsSysPic selectByPicUrl(String picUrl);
}