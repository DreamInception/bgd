package com.doro.background.sina.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommonUtils {

	public static String getRequestNo() {
		UUID uuid = UUID.randomUUID();
		return String.valueOf(uuid).replaceAll("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getRequestNo());
	}

	public static Map<String, String> getBasicMap() {
		Map<String, String> basicMap = new HashMap<String, String>();
		basicMap.put("version", "1.0");
		basicMap.put("partner_id", SinaConstantFactory.instance.currentSina.getPartnerId());
		basicMap.put("_input_charset", "UTF-8");
		return basicMap;
	}
}
