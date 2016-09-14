package com.doro.background.sina.tools;

public class SinaConstantFactory {
	
	private  SinaConstant sinaConstantProd;
	
	private  SinaConstant sinaConstantTest;
	
	public static SinaConstantFactory instance = new SinaConstantFactory();
	
	private boolean isDebug = true;
	
	public SinaConstantFactory(){
		sinaConstantProd = new SinaConstant();
		sinaConstantProd.setHy_url("https://gate.pay.sina.com.cn/mgs/gateway.do");
		sinaConstantProd.setMD5_KEY("6RipsfX5JhvEwZxe3NrmbcUkDauztjAy");
		sinaConstantProd.setPartnerId("200013838392");
		sinaConstantProd.setPayeeIdentityId("service@51vest.com");
		sinaConstantProd.setRsa_public("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEOGQ+DGFYlKgPlJmJ7zqtMer1QsFQmwR01gh4gFaRNlqdDgZJbYzNO0r8fmynPU5ZZH28TL8zGGJtYwKw9npK54gLeRkuZ2DeSMGfM0nffLuy1krURf+D/uLlC7KhiG07StRojEdlxIPNAlhRgAImt+DN/8rxSEfXUWv6JOCvsQIDAQAB");
		sinaConstantProd.setSd_url("https://gate.pay.sina.com.cn/mas/gateway.do");
		
		sinaConstantTest = new SinaConstant();
		sinaConstantTest.setHy_url("https://testgate.pay.sina.com.cn/mgs/gateway.do");
		sinaConstantTest.setMD5_KEY("1234567890qwertyuiopasdfghjklzxc");
		sinaConstantTest.setPartnerId("200004595271");
		sinaConstantTest.setPayeeIdentityId("ceshishanghuhao");
		sinaConstantTest.setRsa_public("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBpueNweMbYdb+CMl8dUNv5g5THYLD9Z33cAMA4GNjmPYsbcNQLyO5QSlLNjpbCwopt7b5lFP8TGLUus4x0Ed6S4Wd9KmNw6NLbszNEmppP9HXlT9sT4/ShL0CpVF4ofFS8O/gXwCTJjYZJ0HvK3GBTSP2C9WlipTpWQ+9QJugewIDAQAB");
		sinaConstantTest.setSd_url("https://testgate.pay.sina.com.cn/mas/gateway.do");
		
		setCurrentSina(isDebug?sinaConstantTest:sinaConstantProd);
	}
	
	public  SinaConstant currentSina;



	


	public SinaConstant getCurrentSina() {
		return currentSina;
	}


	private void setCurrentSina(SinaConstant currentSina) {
		this.currentSina = currentSina;
	}
	
	
}
