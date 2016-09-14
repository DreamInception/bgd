package com.doro.background.sina.entity.returns;

public class QueryHostingWithdrawReturnMsg extends ReturnMsg{
	
	private String withdraw_list;
	private String page_no;
	private String page_size;
	private String total_item;
	public String getWithdraw_list() {
		return withdraw_list;
	}
	public void setWithdraw_list(String withdraw_list) {
		this.withdraw_list = withdraw_list;
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
