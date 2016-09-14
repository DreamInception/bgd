package com.doro.background.dal.mapper;

import java.util.List;

import com.doro.background.dal.entity.PayBank;


public interface PayBankMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(PayBank record);

    int insertSelective(PayBank record);

    PayBank selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(PayBank record);

    int updateByPrimaryKey(PayBank record);
    
    List<PayBank> selectBankList();
    
    PayBank selectBankName(String bankCode);
}