package com.doro.background.dal.mapper;

import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.UserHqRedeemApplication;

public interface UserHqRedeemApplicationMapper {
    int deleteByPrimaryKey(Long applicationId);

    int insert(UserHqRedeemApplication record);

    int insertSelective(UserHqRedeemApplication record);

    UserHqRedeemApplication selectByPrimaryKey(Long applicationId);

    int updateByPrimaryKeySelective(UserHqRedeemApplication record);

    int updateByPrimaryKey(UserHqRedeemApplication record);
    
    List<Map<String,Object>> selectPageList(Map<String,Object> param);
    
    int count(Map<String,Object> param);
    
    UserHqRedeemApplication selectByPrimaryKeyForUpdate(Long applicationId);
}