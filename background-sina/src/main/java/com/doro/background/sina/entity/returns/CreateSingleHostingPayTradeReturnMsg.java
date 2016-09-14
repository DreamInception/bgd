package com.doro.background.sina.entity.returns;

public class CreateSingleHostingPayTradeReturnMsg extends ReturnMsg{
	private String out_trade_no;
	private String trade_status;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	
}
