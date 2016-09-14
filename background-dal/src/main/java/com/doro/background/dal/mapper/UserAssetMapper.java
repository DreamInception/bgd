package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.UserAsset;

public interface UserAssetMapper {
    int deleteByPrimaryKey(Long userAssetId);

    int insert(UserAsset record);

    int insertSelective(UserAsset record);

    UserAsset selectByPrimaryKey(Long userAssetId);

    int updateByPrimaryKeySelective(UserAsset record);

    int updateByPrimaryKey(UserAsset record);
    
    UserAsset selectHqByUserIdForUpdate(Long userId);
}