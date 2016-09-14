package com.doro.background.sina.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtil {
	public static String date2string(String pattern){
		if(!StringUtils.hasText(pattern)){
			return null;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
