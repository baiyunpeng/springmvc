package com.pmp.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.pmp.constant.GlobalConstant;

public class RText {

	private static final String[] templateStr = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRETUVWXYZ"
			.split("");

	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		} else {
			String str = obj.toString();
			if ("".equals(str)) {
				return true;
			}
		}
		return false;
	}

	public static String[] split(String str, String split) {
		return StringUtils.split(str, split);
	}

	/**
	 * 首字母转大写
	 * 
	 * @return
	 */
	public static String toUpperCaseFirstOne(String name) {
		StringBuilder sb = new StringBuilder(name);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

	/**
	 * toString 方法重载 转换成String类型
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (isEmpty(obj)) {
			return "";
		}
		if (obj instanceof String) {
			String str = obj.toString();
			return str;
		}
		return "";
	}

	/**
	 * toString 方法重载 转换成String类型
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj, String def) {
		if (isEmpty(obj)) {
			return "";
		}
		if (obj instanceof String) {
			String str = obj.toString();
			return str;
		}
		return def;
	}

	/**
	 * toString 方法重载 转换成String数组
	 * 
	 * @param obj
	 * @return
	 */
	public static String[] toString(Object[] array) {
		if (isEmpty(array)) {
			return null;
		}
		if (array instanceof String[]) {
			return (String[]) array;
		} else if (array instanceof Object[]) {
			String[] strArray = new String[array.length];
			for (int i = 0; i < array.length; i++) {
				strArray[i] = toString(array[i]);
			}
			return strArray;
		}
		return null;
	}

	/**
	 * toString 方法重载 转换成Map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> toString(Map<Object, Object> map) {
		if (isEmpty(map)) {
			return null;
		}
		Map<String, String> stirngMap = new HashMap<String, String>();
		Set<Object> keys = map.keySet();
		for (Object key : keys) {
			String value = toString(map.get(key));
			stirngMap.put(toString(key), value);
		}
		keys = null;
		return stirngMap;
	}

	/**
	 * 根据数组下标获取值 Object[] array = {1,3,5} toObjectForArray(array,0) = 1
	 * 
	 * toObjectForArray(array,1) = 3
	 * 
	 * toObjectForArray(array,3) = null
	 * 
	 * @param T
	 * @return T
	 */
	public static <T> T toObjectForArray(T[] args, int index) {
		if (null == args) {
			return null;
		}
		int length = args.length;
		if (index <= length) {
			return args[index];
		} else {
			return null;
		}
	}

	/**
	 * 根据数组下标获取值 Object[] array = {1,3,5} toObjectForArray(array,0,0) = 1
	 * 
	 * toObjectForArray(array,1,0) = 3
	 * 
	 * toObjectForArray(array,3,0) = 0
	 * 
	 * @param obj
	 * 
	 * @param def
	 * 
	 * @return
	 */
	public static <T> T toObjectForArray(T[] args, int index, T def) {
		T t = toObjectForArray(args, index);
		if (null == t) {
			return def;
		} else {
			return t;
		}
	}

	/**
	 * 根据数组下标获取值 String[] array = {"A","B","C"} toStringForArray(array,0) = "A"
	 * 
	 * toStringForArray(array,1) = "B"
	 * 
	 * toStringForArray(array,3) = ""
	 * 
	 * @param obj
	 * 
	 * 
	 * @return
	 */
	public static String toStringForArray(Object[] args, int index) {
		Object obj = toObjectForArray(args, index);
		String str = toString(obj);
		if (!isEmpty(str)) {
			return str;
		}
		return "";
	}

	/**
	 * 根据数组下标获取值 String[] array = {"A","B","C"} toStringForArray(array,0,"def")
	 * = "A"
	 * 
	 * toStringForArray(array,1,"def") = "B"
	 * 
	 * toStringForArray(array,3,"def") = "def"
	 * 
	 * @param obj
	 * 
	 * @param def
	 * 
	 * @return
	 */
	public static String toStringForArray(Object[] args, int index, String def) {
		Object obj = toObjectForArray(args, index);
		String str = toString(obj);
		if (!isEmpty(str)) {
			return str;
		}
		return def;
	}

	/**
	 * 字符串转Integer 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Integer toInteger(String str) {
		Integer number = null;
		if (isEmpty(str)) {
			return number;
		}
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return number;
	}

	/**
	 * 字符串转Integer 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Integer toInteger(String str, Integer def) {
		Integer number = def;
		if (isEmpty(str)) {
			return number;
		}
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return number;
	}

	/**
	 * 字符串转Long 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Long toLong(String str) {
		Long number = null;
		if (isEmpty(str)) {
			return number;
		}
		try {
			number = Long.parseLong(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return number;
	}

	/**
	 * 字符串转Long 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Long toLong(String str, Long def) {
		Long number = def;
		if (isEmpty(str)) {
			return number;
		}
		try {
			number = Long.parseLong(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return number;
	}

	/**
	 * 字符串转boolean 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Boolean toBoolean(String str) {
		Boolean bool = null;
		if (isEmpty(str)) {
			return bool;
		}
		try {
			bool = Boolean.parseBoolean(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * 字符串转boolean 类型
	 * 
	 * @param str
	 * @return
	 */
	public static Boolean toBoolean(String str, Boolean def) {
		Boolean bool = def;
		if (isEmpty(str)) {
			return bool;
		}
		try {
			bool = Boolean.parseBoolean(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * 转 json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * 根据json转成实体类
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}

	/**
	 * 根据json转成实体类
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T extends Object> T fromJsonForGener(String json,
			Class<T> clazz) {
		Object obj = fromJson(json, clazz);
		if (null != obj) {
			return (T) obj;
		}
		return null;
	}

	/**
	 * base64 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeBase64(String str) {
		Base64 base64 = new Base64();
		try {
			str = base64.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * base64 解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeBase64(String str) {
		str = new String(Base64.decodeBase64(str));
		return str;
	}

	/**
	 * 哈希加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeHex(String str) {
		try {
			str = Hex.encodeHexString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;

	}

	/**
	 * 哈希解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeHex(String str) {
		Hex hex = new Hex();
		try {
			str = new String((byte[]) hex.decode(str));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return str;

	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeMD5(String str) {
		try {
			str = DigestUtils.md5Hex(toString(str).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * SHA加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeSHA(String str) {
		try {
			str = DigestUtils.sha512Hex(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 得到UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 随机得到一串数组
	 * 
	 * @return
	 */
	public static int getRandomNumber() {
		Random random = new Random((long) (Math.random() * 1000000));
		return random.nextInt();
	}

	/**
	 * 随机得到一串数组
	 * 
	 * @param n
	 *            小于多少
	 * @return
	 */
	public static int getRandomNumber(int n) {
		Random random = new Random((long) (Math.random() * 1000000));
		return random.nextInt(n);
	}

	/**
	 * 随机得到一个字符串
	 * 
	 * @return
	 */
	public static String getRandomStr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < templateStr.length; i++) {
			sb.append(toStringForArray(templateStr,
					getRandomNumber(templateStr.length), ""));
		}
		return sb.toString();
	}

	/**
	 * 根据类路径和方法得到controller 命名空间
	 * 
	 * @param className
	 * @param methodName
	 */
	public static String getControllerNameSpace(String className,
			String methodName) {
		if (!className.startsWith(GlobalConstant.BaseControllerNameSpace)) {
			return "";
		}
		String space = className.substring(
				GlobalConstant.BaseControllerNameSpace.length(),
				className.lastIndexOf(".") + 1);
		StringBuilder nameSpace = new StringBuilder();
		String spacePath = nameSpace.append(space).append(methodName)
				.toString().replace(".", "/");
		return spacePath;
	}

}
