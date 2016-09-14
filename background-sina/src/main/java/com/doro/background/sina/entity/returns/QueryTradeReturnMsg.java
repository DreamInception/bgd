package com.doro.background.sina.entity.returns;

import java.math.BigDecimal;

public class QueryTradeReturnMsg extends ReturnMsg{
	private String outer_trade_no;
	
	private String inner_trade_no;
	
	private String trade_status;
	
	private BigDecimal trade_amount;
	
	private String gmt_create;
	
	private String gmt_payment;
	
	private String gmt_close;
	
	private String pay_method;
	
	@Override
	public String toString() {
		return "CreateHostingCollectTradeReturnMsg [outer_trade_no=" + outer_trade_no + ", inner_trade_no="
				+ inner_trade_no + ", trade_status=" + trade_status + ", trade_amount=" + trade_amount + ", gmt_create="
				+ gmt_create + ", gmt_payment=" + gmt_payment + ", gmt_close=" + gmt_close + ", pay_method="
				+ pay_method + ", auth_finish_amount=" + auth_finish_amount + "]";
	}

	private BigDecimal auth_finish_amount;

	
	
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

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public BigDecimal getTrade_amount() {
		return trade_amount;
	}

	public void setTrade_amount(BigDecimal trade_amount) {
		this.trade_amount = trade_amount;
	}

	public String getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getGmt_close() {
		return gmt_close;
	}

	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public BigDecimal getAuth_finish_amount() {
		return auth_finish_amount;
	}

	public void setAuth_finish_amount(BigDecimal auth_finish_amount) {
		this.auth_finish_amount = auth_finish_amount;
	}
	
	
	
	
}
