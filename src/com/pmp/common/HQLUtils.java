package com.pmp.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pmp.entity.jdbc.HQLEntity;
import com.pmp.pojo.User;

/**
 * HQL工具类
 * @author Administrator
 *
 */
public class HQLUtils {

	/**
	 * 实体类转查询HQL
	 * @param entity
	 * @return
	 */
	public static HQLEntity entityToQueryHQL(Object entity){
		Map<String,Object> parameter = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder("FROM ").append(entity.getClass().getSimpleName()).append(" WHERE 1=1 ");
		String entityName = entity.getClass().getSimpleName();
		List<String> methodList = ReflectUtil.getEntityPropertyCollection(entity.getClass());
		for(String methodName:methodList){
			String key = methodName;
			String  value = RText.toString(ReflectUtil.getEntityMethod(entity, methodName),"");
			if(!RText.isEmpty(value)){
				hql.append(" AND ").append(key).append("=").append(":").append(key);
				parameter.put(key, value);
			}
		}
		HQLEntity hqle = new HQLEntity(hql.toString(),parameter);
		return hqle;
	}
}
