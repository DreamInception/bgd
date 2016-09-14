package com.doro.background.dal.mapper;

import java.math.BigDecimal;

import com.doro.background.dal.entity.UserAcct;

public interface UserAcctMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserAcct record);

    int insertSelective(UserAcct record);

    UserAcct selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserAcct record);

    int updateByPrimaryKey(UserAcct record);
    
    UserAcct selectByUserIdForUpdate(Long userId);
    
    int updateAcctFrozen(BigDecimal amount, Long userId);
}