package com.pmp.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.validation.support.BindingAwareModelMap;

/**
 * 集合之间的转换
 * 
 * @author Administrator
 * 
 */
public class CollectionConverUtils {

	/**
	 * Map转数组
	 * 
	 * @param map
	 * @return
	 */
	public static Object[] mapToArray(Map map) {
		Collection collections = map.values();
		Object[] parameters = new Object[map.size()];
		parameters = collections.toArray(parameters);

		return parameters;
	}

	/**
	 * List 转数组
	 * @param oList
	 * @return
	 */
	public static Object[] List2Array(List oList) {
		Object[] oArray = oList.toArray(new Object[] {});
		return oArray;
	}
	/**
	 * Set 转数组
	 * @param oList
	 * @return
	 */
	public static Object[] Set2Array(Set oSet) {
		Object[] oArray = oSet.toArray(new Object[] {});
		return oArray;
	}

	/**
	 * Set 转List
	 * @param oList
	 * @return
	 */
	public static <T extends Object> List<T> Set2List(Set<T> oSet) {
		List<T> tList = new ArrayList<T>(oSet);
		return tList;
	}

	
	/**
	 * 数组转 转List
	 * @param tArray
	 * @return
	 */
	public static <T extends Object> List<T> Array2List(T[] tArray) {
		List<T> tList = Arrays.asList(tArray);
		return tList;
	}

	/**
	 * List 转 Set
	 * @param tList
	 * @return
	 */
	public static <T extends Object> Set<T> List2Set(List<T> tList) {
		Set<T> tSet = new HashSet<T>(tList);
		return tSet;
	}

	/**
	 * 数组转Set
	 * @param tArray
	 * @return
	 */
	public static <T extends Object> Set<T> Array2Set(T[] tArray) {
		Set<T> tSet = new HashSet<T>(Arrays.asList(tArray));
		return tSet;
	}

	/**
	 * Map 转 List
	 * @param map
	 * @return
	 */
	public static List MapToList(Map map) {
		Collection collections = map.values();
		List parameters = new ArrayList(map.size());
		for (Object obj : collections) {
			parameters.add(obj);
		}
		return parameters;
	}
	
	public static BindingAwareModelMap mapToBindingAwareModelMap(BindingAwareModelMap bindingAwareModelMap,Map paramMap){
		if(null ==bindingAwareModelMap){
			bindingAwareModelMap = new BindingAwareModelMap();
		}
		Set<String> set = paramMap.keySet();
		for(String key:set){
			Object value = paramMap.get(key);
			bindingAwareModelMap.put(key, value);
		}
		return bindingAwareModelMap;
		
	}

}
