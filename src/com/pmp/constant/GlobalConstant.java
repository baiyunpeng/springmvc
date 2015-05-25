package com.pmp.constant;

/**
 * 全局常量类，全局常量定义在此,前缀Global_
 * 
 * @author Administrator
 * 
 */
public class GlobalConstant {

	/**
	 * 基础Controller包命名空间
	 */
	public static String BaseControllerNameSpace = "com.pmp.controller";

	/**
	 * 得到返回页面模式 URL模式 对URL进行解析，切面自动设置url路径为返回对应的jsp 如果页面路径和url路径一致使用此项
	 */
	public static String Global_Return_Parameter_Type_Url = "URL";
	/**
	 * 得到返回页面模式 CLASS模式 对Class 包名进行解析，切面自动设置包路径为返回对应的jsp 如果页面路径和包路径一致使用此项
	 */
	public static String Global_Return_Parameter_Type_Class = "CLASS";
	/**
	 * 得到返回页面模式 Annotation模式 对Annotation 名进行解析，切面自动设置包路径为返回对应的jsp
	 * 如果页面路径和注解定义的路径一致使用此项
	 */
	public static String Global_Return_Parameter_Type_Annotation = "ANNOTATION";

	/**
	 * 默认页面返回模式
	 */
	public static String Global_Return_Parameter_Type_Def = Global_Return_Parameter_Type_Class;

	/**
	 * 得到返回页面模式
	 */
	public static String Global_Return_Parameter_Type = Global_Return_Parameter_Type_Class;

}
