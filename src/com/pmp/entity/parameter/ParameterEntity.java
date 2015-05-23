package com.pmp.entity.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pmp.common.CollectionConverUtils;
import com.pmp.common.RText;
/**
 * web 参数对象
 * @author Administrator
 *
 */
public class ParameterEntity {
	/**
	 * 参数列表
	 */
	private Map<String, String> parameter;

	
	/**
	 * 参数转为List对象
	 * @return
	 */
	public List<String> getParameterList() {
		List<String> list = new ArrayList<String>(parameter.size());
		if (null != parameter && parameter.size() >= 1) {
			list = CollectionConverUtils.MapToList(getParameter());
		}
		return list;
	}
	
	
	
	/**
	 * 参数转为数组对象
	 * @return
	 */
	public String[] getParameterArray() {
		String[] array = new String[parameter.size()];
		if (null != parameter && parameter.size() >= 1) {
			array = RText.toString(CollectionConverUtils.mapToArray(getParameter()));
		}
		return array;
	}
	
	
	public Map<String, String> getParameter() {
		return parameter;
	}

	public void setParameter(Map<String, String> parameter) {
		this.parameter = parameter;
	}

	

}
