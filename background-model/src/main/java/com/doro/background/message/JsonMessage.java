package com.doro.background.message;

/**
 * 通用的数据返回
* @ClassName: JsonMessage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年7月11日 下午4:40:08 
*
 */
public class JsonMessage {
	private boolean flag;
	private String message;
    private Object data;
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonMessage() {
	}

	public JsonMessage(String msg) {
		this.setMessage(msg);
	}

	public JsonMessage(boolean flag, String msg) {
		this.setFlag(flag);
		this.setMessage(msg);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
