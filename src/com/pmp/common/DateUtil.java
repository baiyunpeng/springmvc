package com.pmp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author Administrator
 * 
 */
public class DateUtil {
	/**
	 * 
	 */
	public static final String DatePatttern = "yyyy-MM-dd";
	public static final String DateTimePatttern = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期转字符串
	 * @param date 日期
	 * @param datePatttern 转换格式 
	 * @return
	 */
	public static String dateFormat(Date date,String datePatttern) {
		SimpleDateFormat formatter = new SimpleDateFormat(datePatttern);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 字符串转日期
	 * @param dateString 日期字符串
	 * @param datePatttern 转换格式
	 * @return
	 */
	public static Date dateFormat(String dateString,String datePatttern) {
		SimpleDateFormat formatter = new SimpleDateFormat(DatePatttern);
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转字符串
	 * 格式 ：YYYY-MM-dd
	 * @param date 日期
	 * @return
	 */
	public static String toDate(Date date) {
		return dateFormat(date,DatePatttern);
	}
	
	/**
	 * 字符串转日期
	 * 格式 ：YYYY-MM-dd
	 * @param date 日期
	 * @return
	 */
	public static Date toDate(String date) {
		return dateFormat(date,DatePatttern);
	}
	
	
	/**
	 * 日期转字符串
	 * 格式 ：YYYY-MM-dd HH:mm:ss
	 * @param date 日期
	 * @return
	 */
	public static String toDateTime(Date date) {
		return dateFormat(date,DateTimePatttern);
	}
	
	/**
	 * 字符串转日期和时间
	 * 格式 ：YYYY-MM-dd HH:mm:ss
	 * @param date 日期
	 * @return
	 */
	public static Date toDateTime(String date) {
		return dateFormat(date,DateTimePatttern);
	}
	
	/**
	 * 得到今天的日期
	 * 格式 YYYY-MM-dd
	 * @return
	 */
	public static String getNowDate(){
		return toDate(new Date());
	}
	
	/**
	 * 得到今天的日期和时间
	 * 格式 YYYY-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDateTime(){
		return toDateTime(new Date());
	}
}
