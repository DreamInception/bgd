package com.doro.background.sina.entity.returns;

public class BindingBankCardAdvanceReturnMsg extends ReturnMsg{
	
	private String card_id;
	private String is_verified;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getIs_verified() {
		return is_verified;
	}
	public void setIs_verified(String is_verified) {
		this.is_verified = is_verified;
	}
	
	
}
