package com.doro.background.sina.tools;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

public class SinakeyUtil {
	//private static Logger logger = LoggerFactory.getLogger(SinakeyUtil.class);
	
	public static String sinaKey(String pathname){
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathname);
		try {
			return IOUtils.toString(resourceAsStream,"utf-8");
		} catch (IOException e) {
			
			//logger.error("读取sinakey失败"+e);
		}
		return "";
	}
	
	
	
	
}
