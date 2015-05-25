package com.pmp.constant;

/**
 * Redis缓存
 * 
 * @author Administrator
 * 
 */
public interface RedisCacheConstant {

	/**
	 * Redis缓存超时时间 短期 1分钟
	 */
	public static final int REDIS_CACHE_TIMEOUT_MOMENT = 1 * 60;

	/**
	 * Redis缓存超时时间 正常 30分钟
	 */
	public static final int REDIS_CACHE_TIMEOUT_NORMAL = 30 * 60;

	/**
	 * Redis缓存超时时间 正常 5个小时
	 */
	public static final int REDIS_CACHE_TIMEOUT_LONG = 5 * 60 * 60;

	/**
	 * Redis缓存超时时间 永久
	 */
	public static final int REDIS_CACHE_TIMEOUT_FOREVER = -1;

	/**
	 * Redis缓存超时时间 默认秒 默认30分钟
	 */
	public static final int REDIS_CACHE_TIMEOUT_DEF = REDIS_CACHE_TIMEOUT_NORMAL;

	/**
	 * 键值生成模式 def模式 默认不转换
	 * 
	 */
	public static final String REDIS_CACHE_KEYGENERATEMODE_DEF = "NONE";

	/**
	 * 键值生成模式 MD5模式
	 * 
	 */
	public static final String REDIS_CACHE_KEYGENERATEMODE_MD5 = "MD5";

	/**
	 * 键值生成模式 Hash模式
	 * 
	 */
	public static final String REDIS_CACHE_KEYGENERATEMODE_HASH = "HASH";

	/**
	 * Redis 缓存数据类型 String类型
	 * 
	 */
	public static final String REDIS_CACHE_DATATYPE_STRING = "STRING";
	/**
	 * Redis 缓存数据类型 HASH类型
	 * 
	 */
	public static final String REDIS_CACHE_DATATYPE_HASH = "HASH";
	/**
	 * Redis 缓存数据类型 LIST类型
	 * 
	 */
	public static final String REDIS_CACHE_DATATYPE_LIST = "LIST";
	/**
	 * Redis 缓存数据类型 SET类型
	 * 
	 */
	public static final String REDIS_CACHE_DATATYPE_SET = "SET";

	/**
	 * Redis 缓存数据类型 默认 String类型
	 * 
	 */
	public static final String REDIS_CACHE_DATATYPE_DEF = REDIS_CACHE_DATATYPE_STRING;

	/**
	 * Redis 缓存 数据转换模式 DEFault 默认不转换
	 * 
	 */
	public static final String REDIS_CACHE_CONVERMODE_DEF = "NONE";

	/**
	 * Redis 缓存 数据转换模式 json 模式
	 * 
	 */
	public static final String REDIS_CACHE_CONVERMODE_JSON = "JSON";

	/**
	 * Redis 缓存 数据转换模式 XML 模式
	 * 
	 */
	public static final String REDIS_CACHE_CONVERMODE_XML = "XML";

	/**
	 * Redis 缓存 数据转换模式 SERIALIZATION 序列化 模式
	 * 
	 */
	public static final String REDIS_CACHE_CONVERMODE_SERIALIZATION = "SERIALIZATION";
}
