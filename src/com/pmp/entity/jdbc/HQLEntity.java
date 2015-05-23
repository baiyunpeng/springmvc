package com.pmp.entity.jdbc;

import java.util.Map;

public class HQLEntity {
	private String hql;
	private Map<String, Object> parameter;

	public HQLEntity() {

	}

	public HQLEntity(String hql, Map<String, Object> parameter) {
		this.hql = hql;
		this.parameter = parameter;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public Map<String, Object> getParameter() {
		return parameter;
	}

	public void setParameter(Map<String, Object> parameter) {
		this.parameter = parameter;
	}

}
