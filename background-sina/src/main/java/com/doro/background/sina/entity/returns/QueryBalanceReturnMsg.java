package com.doro.background.sina.entity.returns;

public class QueryBalanceReturnMsg extends ReturnMsg{
	private String balance;
	private String available_balance;
	private String bonus;
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAvailable_balance() {
		return available_balance;
	}
	public void setAvailable_balance(String available_balance) {
		this.available_balance = available_balance;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	

}
