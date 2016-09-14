package com.doro.background.sina.entity.returns;

public class QueryHostingDepositReturnMsg extends ReturnMsg{
	
	private String deposit_list;
	private String page_no;
	private String page_size;
	private String total_item;
	public String getDeposit_list() {
		return deposit_list;
	}
	public void setDeposit_list(String deposit_list) {
		this.deposit_list = deposit_list;
	}
	public String getPage_no() {
		return page_no;
	}
	public void setPage_no(String page_no) {
		this.page_no = page_no;
	}
	public String getPage_size() {
		return page_size;
	}
	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}
	public String getTotal_item() {
		return total_item;
	}
	public void setTotal_item(String total_item) {
		this.total_item = total_item;
	}
	
	

}
