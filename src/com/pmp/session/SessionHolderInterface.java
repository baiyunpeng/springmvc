package com.pmp.session;

/**
 * session 工具类接口，为扩展分布式session保留
 * 
 * @author Administrator
 * 
 */
public interface SessionHolderInterface {
	/**
	 * 向session中插入K / V
	 * 
	 * @param key
	 *            K名称
	 * @param value
	 *            V数值
	 * */
	public void setValueToSession(String key, Object value);

	/**
	 * 从session中获取对应K的V
	 * 
	 * @param key
	 *            K名称
	 * @return value V数值
	 * */
	public Object getValueFromSession(String key);
	
	/**
	 * 在session中根据Key删除session中的值
	 * 
	 * @param key
	 *            K名称
	 *
	 * */
	public void removeValueToSession(String key);

	/**
	 * 判断是Session否包含key
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key);

	/**
	 * 使session失效 用户登出 
	 * session 会销毁，在SessionListener监听session销毁，清理权限缓存
	 */
	public void logout();
	
	
}
