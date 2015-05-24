package com.pmp.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pmp.constant.SessionConstant;
import com.pmp.pojo.User;
import com.pmp.session.SessionHolder;

public class WebUtils {

	public static String getIpAddr(HttpServletRequest request) {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				
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
	 * 得到username
	 * 
	 * @param request
	 * @return
	 */
	public static String getWebUserName(HttpServletRequest request) {
		String username = null;
		User user = (User) SessionHolder
				.getValueFromSession(SessionConstant.GLOBAL_SESSION_USER);
		if (null != user) {
			username = user.getUsername();
		} else if (null != request) {
			username = request.getParameter("username");
			if(RText.isEmpty(username)){
				username = RText.toString(request.getAttribute("username"));
			}
		}
		return username;
	}

	/**
	 * 得到useralias
	 * 
	 * @param request
	 * @return
	 */
	public static String getWebUserAlias(HttpServletRequest request) {
		String useralias = null;
		User user = (User) SessionHolder
				.getValueFromSession(SessionConstant.GLOBAL_SESSION_USER);
		if (null != user) {
			useralias = user.getUseralias();
		} else if (null != request) {
			useralias = request.getParameter("useralias");
			if(RText.isEmpty(useralias)){
				useralias = RText.toString(request.getAttribute("useralias"));
			}
		}
		return useralias;
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

	/**
	 * 判断表单是否提交成功
	 * 
	 * @return
	 */
	public static boolean isSubmitSuccess(HttpServletRequest request) {

		// 根据token得到表单提交状态
		String submitStatus = RText.toString(request
				.getAttribute(SessionConstant.GLOBAL_SESSION_SUBMIT));
		// 提交成功
		if (SessionConstant.GLOBAL_SESSION_SUBMIT_SUCCESS.equals(submitStatus)) {
			return true;
			// 提交失败
		} else if (SessionConstant.GLOBAL_SESSION_SUBMIT_FAILURE
				.equals(submitStatus)) {
			return false;
		}
		return true;
	}
}
