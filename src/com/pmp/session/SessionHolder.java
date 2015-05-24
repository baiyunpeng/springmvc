package com.pmp.session;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * session包装类，本类的存在，是为了灵活切换集中式session与分布式session 程序中用到session的地方，请统一使用本类的方法
 * 本类可提供方法拓展，便于更好的统一规划与使用session
 * 
 * @author Administrator
 * 
 */
public class SessionHolder {
	/**
	 * session 接口
	 */
	@Autowired
	private static SessionHolderInterface sessionHolder = new LocalSessionHolder();

	/**
	 * 向session中插入K / V
	 * 
	 * @param key
	 *            K名称
	 * @param value
	 *            V数值
	 * */
	public static void setValueToSession(String key, Object value) {
		sessionHolder.setValueToSession(key, value);
	}

	/**
	 * 从session中获取对应K的V
	 * 
	 * @param key
	 *            K名称
	 * @return value V数值
	 * */
	public static Object getValueFromSession(String key) {
		return sessionHolder.getValueFromSession(key);
	}

	/**
	 * 在session中根据Key删除session中的值
	 * 
	 * @param key
	 *            K名称
	 * 
	 * */
	public static void removeValueToSession(String key) {
		sessionHolder.removeValueToSession(key);
	}

	/**
	 * 判断是Session否包含key
	 * 
	 * @param key
	 * @return
	 */
	public static boolean containsKey(String key) {
		return sessionHolder.containsKey(key);
	}

	/**
	 * session 会销毁，在SessionListener监听session销毁，清理权限缓存
	 */
	public static void logOut() {
		sessionHolder.logout();
	}
}
