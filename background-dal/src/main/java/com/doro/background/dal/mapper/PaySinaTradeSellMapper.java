package com.doro.background.dal.mapper;

import com.doro.background.dal.entity.PaySinaTradeSell;

public interface PaySinaTradeSellMapper {
    int deleteByPrimaryKey(Long tradeId);

    int insert(PaySinaTradeSell record);

    int insertSelective(PaySinaTradeSell record);

    PaySinaTradeSell selectByPrimaryKey(Long tradeId);

    int updateByPrimaryKeySelective(PaySinaTradeSell record);

    int updateByPrimaryKey(PaySinaTradeSell record);
    
    PaySinaTradeSell selectByOutTradeNo(String outTradeNo);
}