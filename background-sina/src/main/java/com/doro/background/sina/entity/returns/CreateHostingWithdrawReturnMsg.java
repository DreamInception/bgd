package com.doro.background.sina.entity.returns;

import java.math.BigDecimal;

public class CreateHostingWithdrawReturnMsg extends ReturnMsg{
	private String outer_trade_no;
	
	private String inner_trade_no;
	
	private String withdraw_status;
	
	private BigDecimal withdraw_amount;
	
	private String card_id;

	public String getOuter_trade_no() {
		return outer_trade_no;
	}

	public void setOuter_trade_no(String outer_trade_no) {
		this.outer_trade_no = outer_trade_no;
	}

	public String getInner_trade_no() {
		return inner_trade_no;
	}

	public void setInner_trade_no(String inner_trade_no) {
		this.inner_trade_no = inner_trade_no;
	}

	public String getWithdraw_status() {
		return withdraw_status;
	}

	public void setWithdraw_status(String withdraw_status) {
		this.withdraw_status = withdraw_status;
	}

	public BigDecimal getWithdraw_amount() {
		return withdraw_amount;
	}

	public void setWithdraw_amount(BigDecimal withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	
	
	
	
}
