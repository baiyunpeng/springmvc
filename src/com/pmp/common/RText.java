package com.pmp.common;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

public class RText {

	private static final String[] templateStr = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRETUVWXYZ"
			.split("");

	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str)) {
			return true;
		}
		return false;
	}

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
	
	
	/**
	 * 首字母转大写
	 * @return
	 */
	public static String toUpperCaseFirstOne(String name) {
		StringBuilder sb = new StringBuilder(name);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return  sb.toString();
    }

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
	
	
	public static String toString(Object obj,String def) {
		if (isEmpty(obj)) {
			return "";
		}
		if (obj instanceof String) {
			String str = obj.toString();
			return str;
		}
		return def;
	}

	public static String[] toString(Object[] array) {
		if (isEmpty(array)) {
			return null;
		}
		if (array instanceof String[]) {
			return (String[]) array;
		}else if(array instanceof Object[]){
			String[] strArray = new String[array.length];
			for(int i=0;i<array.length;i++){
				strArray[i] = toString(array[i]);
			}
			return strArray;
		}
		return null;
	}

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

	public static <T> T toObjectForArray(T[] args, int index, T def) {
		T t = toObjectForArray(args, index);
		if (null == t) {
			return def;
		} else {
			return t;
		}
	}

	public static String toStringtForArray(Object[] args, int index) {
		Object obj = toObjectForArray(args, index);
		String str = toString(obj);
		if (!isEmpty(str)) {
			return str;
		}
		return "";
	}

	public static String toStringtForArray(Object[] args, int index, String def) {
		Object obj = toObjectForArray(args, index);
		String str = toString(obj);
		if (!isEmpty(str)) {
			return str;
		}
		return def;
	}

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

	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static Object fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}

	public static <T extends Object> T fromJsonForGener(String json,
			Class<T> clazz) {
		Object obj = fromJson(json, clazz);
		if (null != obj) {
			return (T) obj;
		}
		return null;
	}

	public static String encodeBase64(String str) {
		Base64 base64 = new Base64();
		try {
			str = base64.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String decodeBase64(String str) {
		str = new String(Base64.decodeBase64(str));
		return str;
	}

	public static String encodeHex(String str) {
		try {
			str = Hex.encodeHexString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;

	}

	public static String decodeHex(String str) {
		Hex hex = new Hex();
		try {
			str = new String((byte[]) hex.decode(str));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return str;

	}

	public static String encodeMD5(String str) {
		try {
			str = DigestUtils.md5Hex(toString(str).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	

	public static String encodeSHA(String str) {
		try {
			str = DigestUtils.shaHex(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static int getRandomNumber() {
		Random random = new Random((long) (Math.random() * 1000000));
		return random.nextInt();
	}

	public static int getRandomNumber(int n) {
		Random random = new Random((long) (Math.random() * 1000000));
		return random.nextInt(n);
	}

	public static String getRandomStr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < templateStr.length; i++) {
			sb.append(toStringtForArray(templateStr,
					getRandomNumber(templateStr.length), ""));
		}
		return sb.toString();
	}

	public static Object[] List2Array(List oList) {
		Object[] oArray = oList.toArray(new Object[] {});
		return oArray;
	}

	public static Object[] Set2Array(Set oSet) {
		Object[] oArray = oSet.toArray(new Object[] {});
		return oArray;
	}

	public static <T extends Object> List<T> Set2List(Set<T> oSet) {
		List<T> tList = new ArrayList<T>(oSet);
		return tList;
	}

	public static <T extends Object> List<T> Array2List(T[] tArray) {
		List<T> tList = Arrays.asList(tArray);
		return tList;
	}

	public static <T extends Object> Set<T> List2Set(List<T> tList) {
		Set<T> tSet = new HashSet<T>(tList);
		return tSet;
	}

	public static <T extends Object> Set<T> Array2Set(T[] tArray) {
		Set<T> tSet = new HashSet<T>(Arrays.asList(tArray));
		return tSet;
	}

}
