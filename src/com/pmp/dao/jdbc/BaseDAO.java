package com.pmp.dao.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmp.common.HQLUtils;
import com.pmp.common.RText;
import com.pmp.common.ReflectUtil;
import com.pmp.entity.jdbc.HQLEntity;

public class BaseDAO<T, PK extends Serializable> {

	private SessionFactory sessionFactory;

	private Class<?> entityClass;

	public BaseDAO() {
		entityClass = ReflectUtil.getGenericParmeterType(this.getClass());
	}

	public void save(T t) {
		getSession().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		return (T) getSession().get(entityClass, id);
	}

	public void del(PK id) {
		getSession().delete(findById(id));
	}

	public void del(T t) {
		getSession().delete(t);
	}

	public List<T> findAll() {
		Criteria c = getSession().createCriteria(entityClass);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByPage(int start, int count) {
		Criteria c = getSession().createCriteria(entityClass);
		c.setFirstResult(start);
		c.setMaxResults(count);
		return c.list();
	}

	public List<T> findByHQL(String hql, Map<String, String> params) {
		Query query = getSession().createQuery(hql);
		Set<String> set = params.keySet();
		for (String key : set) {
			String value = params.get(key);
			query.setString(key, value);
		}
		return query.list();
	}

	public List<T> findBySQL(String sql, Map<String, String> params) {
		Query query = getSession().createSQLQuery(sql);
		Set<String> set = params.keySet();
		for (String key : set) {
			String value = params.get(key);
			query.setString(key, value);
		}
		return query.list();
	}

	public Query findBasicHQL(Object enity) {
		HQLEntity hqle = HQLUtils.entityToQueryHQL(enity);
		Query query = getSession().createQuery(hqle.getHql());
		Map<String, Object> parameter = hqle.getParameter();
		Set<String> set = parameter.keySet();
		for (String key : set) {
			String value = RText.toString(parameter.get(key));
			if (!RText.isEmpty(key) && !RText.isEmpty(value)) {
				query.setString(key, value);
			}
		}
		return query;
	}

	public T findUniqueResult(Object enity) {
		Query query = findBasicHQL(enity);
		return (T) query.uniqueResult();
	}

	public List<T> findListResult(Object enity) {
		Query query = findBasicHQL(enity);
		return query.list();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
