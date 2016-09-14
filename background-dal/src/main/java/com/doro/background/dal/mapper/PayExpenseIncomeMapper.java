package com.doro.background.dal.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.doro.background.dal.entity.PayExpenseIncome;


public interface PayExpenseIncomeMapper {
    int deleteByPrimaryKey(Long expenseIncomeId);

    int insert(PayExpenseIncome record);

    int insertSelective(PayExpenseIncome record);

    PayExpenseIncome selectByPrimaryKey(Long expenseIncomeId);

    int updateByPrimaryKeySelective(PayExpenseIncome record);

    int updateByPrimaryKey(PayExpenseIncome record);
    
    List<PayExpenseIncome> selectByConditionPage(Map<String,Object> param);
    
    BigDecimal selectListByUserIdInvest(Long userId);
    
    BigDecimal selectListByUserIdRedeem(Long userId);
}