package com.pmp.cache;

/**
 * 缓存接口
 * @author Administrator
 *
 */
public interface cache {
	
	/**
	 * 添加缓存
	 * @param chcheKey
	 * @param value
	 */
	public void put(String chcheKey,Object value);
	
	
	/**
	 * 获取缓存
	 * @param chcheKey
	 * @param value
	 */
	public Object get(String chcheKey);
	
	
	/**
	 * 删除缓存
	 * @param chcheKey
	 * @param value
	 */
	public void remove(String chcheKey);
}
