package com.doro.background.sina.entity.returns;

public class QueryHostingTradeReturnMsg extends ReturnMsg{
	private String tradeList;
	private String pageNo;
	private String pageSize;
	private String totalItem;
	public String getTradeList() {
		return tradeList;
	}
	public void setTradeList(String tradeList) {
		this.tradeList = tradeList;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}
	
	
}
