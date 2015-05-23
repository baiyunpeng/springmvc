package com.pmp.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;

import com.pmp.entity.jdbc.TestEntity;
import com.pmp.entity.reflect.Entity;
import com.pmp.pojo.User;

public class ReflectUtil {
	/**
	 * 得到泛型的类型
	 * 
	 * @param clazz
	 * @return
	 */
	public static Class getGenericParmeterType(Class clazz) {
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types = pt.getActualTypeArguments();
		return (Class<?>) types[0];
	}

	public static Field getEntityField(Class clazz, String filedName) {
		Field[] fs = clazz.getDeclaredFields();
		Field fd = null;
		for (Field field : fs) {
			String name = field.getName();
			if (name.equals(filedName)) {
				fd = field;
				break;
			}
		}
		return fd;
	}

	/**
	 * 得到实体类所有属性
	 */
	public static List<String> getEntityPropertyCollection(Class clazz) {
		Field[] fs = clazz.getDeclaredFields();
		List<String> propertys = new ArrayList<String>(fs.length);
		for (Field field : fs) {
			propertys.add(field.getName());
		}
		return propertys;
	}

	public static Class[] getEntityPropertyType(Class clazz,String... propertys) {
		String[] propertyTypes = propertys;
		Class[] propertyClassTypes = new Class[propertyTypes.length];
		for (int i = 0; i < propertyTypes.length; i++) {
			Field field = getEntityField(clazz, propertyTypes[i]);
			propertyClassTypes[i] = field.getType();
		}

		return propertyClassTypes;
	}

	/**
	 * 得到所有名称和属性类型列表
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 */
	public static Map<String, String> getEntityPropertyOrTypeCollection(
			Class clazz) {

		Field[] fs = clazz.getDeclaredFields();
		Map<String, String> propertysType = new HashMap<String, String>(
				fs.length);
		for (Field field : fs) {
			String fieldType = field.getType().getName();
			String fieldName = field.getName();
			propertysType.put(fieldName, fieldType);
		}
		return propertysType;
	}

	/**
	 * 执行一个方法得到一个值
	 */
	public static Object getMethodValue(Object entity, String methodName) {
		Object value = null;
		try {
			Method method = entity.getClass().getMethod(methodName);
			value = method.invoke(entity);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 执行一个方法得并向一个属性中赋值
	 */
	public static Object setMethodValue(Object entity, String methodName,
			Class[] fieldTypes, Object[] values) {
		try {
			Method method = entity.getClass().getMethod(methodName, fieldTypes);
			method.invoke(entity, values);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * 判断一个对象是否包含一个属性
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 */
	public static boolean containAttribute(Class clazz, String methodName) {
		List<String> propertyList = getEntityPropertyCollection(clazz);
		boolean flag = false;
		if (propertyList.contains(methodName)) {
			flag = true;
		}
		propertyList = null;
		return flag;
	}

	/**
	 * 根据属性生成方法名称
	 * 
	 * @param entity
	 * @param property
	 * @param prefix
	 * @return
	 */
	public static String generateMethod(Object entity, String property,
			String prefix) {
		if (!containAttribute(entity.getClass(), property)) {
			return null;
		}
		Map<String, String> propertyTypeList = getEntityPropertyOrTypeCollection(entity
				.getClass());

		if (!propertyTypeList.containsKey(property)) {
			return null;
		}
		String fieldType = propertyTypeList.get(property);
		Entity ent = new Entity();
		ent.setFieldName(property);
		ent.setFieldType(fieldType);
		return createMethodName(ent, prefix);
	}

	/**
	 * Object 类型转换
	 * 
	 * @param obj
	 * @param type
	 * @return
	 */
	public static Object converObjectToType(Object obj, Class type) {
		return ConvertUtils.convert(obj, type);
	}

	public static Object[] converObjectToTypes(Class[] types, Object[] values) {
		int size = Math.min(types.length, values.length);
		for (int i = 0; i < size; i++) {
			values[i] = converObjectToType(values[i], types[i]);
		}
		return values;
	}

	public static Object[] converParameterType(Class[] fieldTypes,
			Object[] values) {
		return converObjectToTypes(fieldTypes, values);
	}

	/**
	 * 生成Get方法名称
	 * 
	 * @return
	 */
	public static String generateGetMethod(Object entity, String property) {
		return generateMethod(entity, property, "get");
	}

	/**
	 * 生成Set方法名称
	 * 
	 * @return
	 */
	public static String generateSetMethod(Object entity, String property) {
		return generateMethod(entity, property, "set");
	}

	/**
	 * 创建一个方法
	 * 
	 * @param entity
	 * @param prefix
	 * @return
	 */
	public static String createMethodName(Entity entity, String prefix) {
		String property = entity.getFieldName();
		String type = entity.getFieldType();
		String method = "";
		if ("get".equals(prefix)) {
			if ("java.lang.Boolean".equals(type)) {
				method = "is" + RText.toUpperCaseFirstOne(property);
			} else if ("boolean".equals(type)) {
				return "is" + RText.toUpperCaseFirstOne(property);
			} else {
				method = prefix + property;
			}
		} else if ("set".equals(prefix)) {
			method = prefix + RText.toUpperCaseFirstOne(property);
		} else {
			method = prefix + property;
		}
		return method;

	}

	/**
	 * 执行一个属性的Get方法
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 */
	public static Object getEntityMethod(Object entity, String methodName) {
		String getMethod = generateGetMethod(entity, methodName);
		return getMethodValue(entity, getMethod);
	}

	/**
	 * 执行一个Set方法 将一个值填入实体类中
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 */
	public static Object setEntityMethod(Object entity, String methodName,
			Object value) {
		String getMethod = generateSetMethod(entity, methodName);
		Class[] fieldTypes = getEntityPropertyType(entity.getClass(),
				methodName);
		Object[] values = { value };
		values = converParameterType(fieldTypes, values);
		return setMethodValue(entity, getMethod, fieldTypes, values);
	}
}
