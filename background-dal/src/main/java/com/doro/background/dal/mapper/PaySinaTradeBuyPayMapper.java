package com.doro.background.dal.mapper;

import java.util.List;

import com.doro.background.dal.entity.PaySinaTradeBuyPay;


public interface PaySinaTradeBuyPayMapper {
    int deleteByPrimaryKey(Long tradeId);

    int insert(PaySinaTradeBuyPay record);

    int insertSelective(PaySinaTradeBuyPay record);

    PaySinaTradeBuyPay selectByPrimaryKey(Long tradeId);

    int updateByPrimaryKeySelective(PaySinaTradeBuyPay record);

    int updateByPrimaryKey(PaySinaTradeBuyPay record);
    
    List<PaySinaTradeBuyPay> selectList(PaySinaTradeBuyPay record);
    
    PaySinaTradeBuyPay selectOne();
}