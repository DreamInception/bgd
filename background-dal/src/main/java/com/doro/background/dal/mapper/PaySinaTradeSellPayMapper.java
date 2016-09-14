package com.doro.background.dal.mapper;

import java.util.List;

import com.doro.background.dal.entity.PaySinaTradeSellPay;


public interface PaySinaTradeSellPayMapper {
    int deleteByPrimaryKey(Long tradeId);

    int insert(PaySinaTradeSellPay record);

    int insertSelective(PaySinaTradeSellPay record);

    PaySinaTradeSellPay selectByPrimaryKey(Long tradeId);

    int updateByPrimaryKeySelective(PaySinaTradeSellPay record);

    int updateByPrimaryKey(PaySinaTradeSellPay record);
    
    List<PaySinaTradeSellPay> selectList(PaySinaTradeSellPay record);
    
    PaySinaTradeSellPay selectOne();
}