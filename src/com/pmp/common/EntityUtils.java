package com.pmp.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pmp.pojo.User;

/**
 * 实体类工具
 * @author Administrator
 *
 */
public class EntityUtils {

	/**
	 * Map转实体类
	 * @param entity
	 * @param request
	 * @return
	 */
	public static Object fillEntity(Object entity,Map paramsMap){
		List<String> list = ReflectUtil.getEntityPropertyCollection(entity.getClass());
		if(null == entity||null == paramsMap){
			return entity;
		}
		for(String key:list){
			if(paramsMap.containsKey(key)){
				Object value = paramsMap.get(key);
				ReflectUtil.setEntityMethod(entity,key, value);
			}
		}
		return entity;
	}
	

}
