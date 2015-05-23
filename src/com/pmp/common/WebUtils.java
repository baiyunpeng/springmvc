package com.pmp.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pmp.pojo.User;

public class WebUtils {

	public static String getIpAddr(HttpServletRequest request) {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");
		System.out
				.println("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip="
						+ ip);

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
				System.out
						.println("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip="
								+ ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
				System.out
						.println("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip="
								+ ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
				System.out
						.println("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip="
								+ ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				System.out
						.println("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip="
								+ ip);
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				System.out
						.println("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip="
								+ ip);
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 从request 中得到username
	 * 
	 * @param request
	 * @return
	 */
	public static String getWebUserName(HttpServletRequest request) {
		if (null == request) {
			return null;
		}
		HttpSession session = request.getSession();
		if (null == session) {
			return null;
		}
		User user = (User) session.getAttribute("user");
		if (null == user) {
			return null;
		}
		return user.getUsername();
	}

	/**
	 * 从request 中得到useralias
	 * 
	 * @param request
	 * @return
	 */
	public static String getWebUserAlias(HttpServletRequest request) {
		if (null == request) {
			return null;
		}
		HttpSession session = request.getSession();
		if (null == session) {
			return null;
		}
		User user = (User) session.getAttribute("user");
		if (null == user) {
			return null;
		}
		return user.getUseralias();
	}

	/**
	 * 从request 得到Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getWebParameterMap(
			HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, String> parameters = new HashMap<String, String>(map.size());
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String[] values = map.get(key);
			parameters.put(key, values[0]);
		}
		map = null;
		return parameters;
	}

	/**
	 * 从request 得到String 数组
	 * 
	 * @param request
	 * @return
	 */
	public static String[] getWebParameterStringArray(HttpServletRequest request) {
		Map<String, String> map = getWebParameterMap(request);
		Collection<String> collections = map.values();
		String[] parameters = new String[map.size()];
		parameters = collections.toArray(parameters);
		return parameters;
	}

	/**
	 * 从request 得到List
	 * 
	 * @param request
	 * @return
	 */
	public static List<String> getWebParameterList(HttpServletRequest request) {
		String[] params = getWebParameterStringArray(request);
		List<String> parameters = new ArrayList<String>(params.length);
		return parameters;
	}

	/**
	 * 从request 得到实体类
	 * 
	 * @param request
	 * @return
	 */
	public static Object getWebParameterEntity(Object entity,
			HttpServletRequest request) {
		Map parameterMap = getWebParameterMap(request);
		return EntityUtils.fillEntity(entity, parameterMap);
	}
}
