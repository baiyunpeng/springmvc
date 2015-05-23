package com.pmp.common;

import java.util.ArrayList;
import java.util.Collection;
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
	 * 数组转List
	 * 
	 * @param array
	 * @return
	 */
	public static List arrayToList(Object[] array) {
		List parameters = new ArrayList(array.length);
		for (Object obj : array) {
			parameters.add(obj);
		}
		return parameters;
	}

	/**
	 * List转数组
	 * 
	 * @param array
	 * @return
	 */
	public static Object[] listToArray(List list) {
		Object[] array = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
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
