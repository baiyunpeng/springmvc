package com.pmp.dao.redis;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.pmp.common.RText;


public  class RedisBaseDAO<T> {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	private Class<T> entityClass;

	public RedisBaseDAO() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			entityClass = (Class<T>) types[0];
		}
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * 数据验证
	 * @param key
	 * @return
	 */
	public boolean validate(String key) {
		if (RText.isEmpty(key)) {
			return true;
		}
		return false;
	}

	/**
	 * 数据验证
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean validate(String key, Object value) {
		if (RText.isEmpty(key)) {
			return true;
		}

		if (RText.isEmpty(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 数据验证
	 * @param key
	 * @param value
	 * @param sec
	 * @return
	 */
	public boolean validate(String key, Object value, int sec) {
		if (RText.isEmpty(key)) {
			return true;
		}

		if (RText.isEmpty(value)) {
			return true;
		}

		if (sec <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 数据验证
	 * @param key
	 * @param sec
	 * @return
	 */
	public boolean validate(String key, int sec) {
		if (RText.isEmpty(key)) {
			return true;
		}

		if (sec <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取String数据
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		if (validate(key)) {
			return null;
		}
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 获取List数据
	 * @param key
	 * @return
	 */
	public List<String> getList(String key) {
		if (validate(key)) {
			return null;
		}
		return stringRedisTemplate.opsForList().range(key, 0, -1);
	}

	/**
	 * 获取Map 数据
	 * @param key
	 * @return
	 */
	public Map<String, String> getMap(String key) {
		if (validate(key)) {
			return null;
		}
		Map map = stringRedisTemplate.opsForHash().entries(key);
		return RText.toString(map);
	}

	/**
	 * 锟矫碉拷Set锟斤拷锟斤拷
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> getSet(String key) {
		if (validate(key)) {
			return null;
		}

		return stringRedisTemplate.opsForSet().members(key);

	}

	/**
	 * 添加数据
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value) {
		if (validate(key, value)) {
			return;
		}
		if (value instanceof String) {
			setString(key, RText.toString(value));
		} else if (value instanceof List) {
			setList(key, (List) value);
		} else if (value instanceof Set) {
			setSet(key, (Set) value);
		} else if (value instanceof Map) {
			setMap(key, (Map) value);
		} else {
			setJson(key, value);
		}

	}

	/**
	 * 添加数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void set(String key, Object value, int sec) {
		if (validate(key, value)) {
			return;
		}
		if (value instanceof String) {
			setString(key, RText.toString(value), sec);
		} else if (value instanceof List) {
			setList(key, (List) value, sec);
		} else if (value instanceof Set) {
			setSet(key, (Set) value, sec);
		} else if (value instanceof Map) {
			setMap(key, (Map) value, sec);
		} else {
			setJson(key, value, sec);
		}
	}

	/**
	 * 添加String类型数据
	 * 
	 * @param key
	 * @param value
	 */
	public void setString(String key, String value) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 添加String类型数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void setString(String key, String value, int sec) {
		if (validate(key, value, sec)) {
			return;
		}
		stringRedisTemplate.opsForValue().set(key, value);
		if (sec > 0) {
			stringRedisTemplate.expire(key, sec, TimeUnit.SECONDS);
		}

	}

	/**
	 * 添加Map类型数据
	 * 
	 * @param key
	 * @param value
	 */
	public void setMap(String key, Map<String, String> value) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForHash().putAll(key, value);
	}

	/**
	 * 添加Map类型数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void setMap(String key, Map<String, String> value, int sec) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForHash().putAll(key, value);
		if (sec > 0) {
			stringRedisTemplate.expire(key, sec, TimeUnit.SECONDS);
		}

	}

	/**
	 * 添加List类型数据
	 * 
	 * @param key
	 * @param value
	 */
	public void setList(String key, List<String> value) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForList().rightPushAll(key, value);
	}

	/**
	 * 添加List类型数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void setList(String key, List<String> value, int sec) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForList().rightPushAll(key, value);
		if (sec > 0) {
			stringRedisTemplate.expire(key, sec, TimeUnit.SECONDS);
		}

	}

	/**
	 * 
	 * 添加Set类型数据
	 * 
	 * @param key
	 * @param value
	 */
	public void setSet(String key, Set<String> value) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForSet().difference(key, value);
	}

	/**
	 * 添加Set类型数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void setSet(String key, Set<String> value, int sec) {
		if (validate(key, value)) {
			return;
		}
		stringRedisTemplate.opsForSet().difference(key, value);
		if (sec > 0) {
			stringRedisTemplate.expire(key, sec, TimeUnit.SECONDS);
		}
	}

	/**
	 * 添加json类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public void setJson(String key, Object value) {
		setString(key, RText.toJson(value));
	}

	/**
	 * 添加json类型的数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void setJson(String key, Object value, int sec) {
		setString(key, RText.toJson(value), sec);
	}

	/**
	 * 编辑数据
	 * 
	 * @param key
	 * @param value
	 */
	public void edit(String key, String value) {
		set(key, value);
	}

	/**
	 * 编辑数据
	 * 
	 * @param key
	 * @param value
	 * @param sec
	 */
	public void edit(String key, String value, int sec) {
		set(key, value, sec);
	}

	/**
	 * 删除元素
	 * 
	 * @param key
	 */
	public void remove(String key) {
		if (validate(key)) {
			return;
		}
		stringRedisTemplate.delete(key);
	}

	/**
	 * 删除元素
	 * 
	 * @param keys
	 */
	public void remove(String... keys) {
		if (null == keys || keys.length <= 0) {
			return;
		}
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 检出Key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean keyExists(String key) {
		boolean tag = false;
		if (validate(key)) {
			return tag;
		}
		return stringRedisTemplate.hasKey(key);
	}

	/**
	 * 检查key 过期时间
	 * 
	 * @param key
	 * @return
	 */
	public long checkExpirationDate(String key) {
		long tag = -1;
		if (validate(key)) {
			return tag;
		}
		return stringRedisTemplate.getExpire(key);
	}

	/**
	 * 得到数据类型
	 * 
	 * @param key
	 * @return
	 */
	public String getDataType(String key) {
		if (validate(key)) {
			return null;
		}
		DataType type = stringRedisTemplate.type(key);
		return type.toString();
	}

}
