package com.doro.background.sina.entity.returns;

public class ReturnMsg {
	private String response_time;
	private String partner_id;
	private String _input_charset;
	private String sign;
	private String sign_type;
	private String sign_version;
	private String response_code;
	private String response_message;
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public String get_input_charset() {
		return _input_charset;
	}
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign_version() {
		return sign_version;
	}
	public void setSign_version(String sign_version) {
		this.sign_version = sign_version;
	}
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	@Override
	public String toString() {
		return "ReturnMsg [response_time=" + response_time + ", partner_id=" + partner_id + ", _input_charset="
				+ _input_charset + ", sign=" + sign + ", sign_type=" + sign_type + ", sign_version=" + sign_version
				+ ", response_code=" + response_code + ", response_message=" + response_message + "]";
	}
	
	
}
