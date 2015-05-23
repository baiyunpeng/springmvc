package com.pmp.dao.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pmp.common.HQLUtils;
import com.pmp.common.RText;
import com.pmp.entity.jdbc.HQLEntity;
import com.pmp.pojo.User;

@Repository
public class UserDao extends BaseDao<User, Integer> {

/*	public User findUser(User user) {
		Query query = findBasicHQL(user);
		User user  = query.uniqueResult()
		
		return null;
	}

	public User findUserByEmail(User user) {
		Query query = findBasicHQL(user);
		List<User> resultList = query.list();
		if (null != resultList && resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}*/

}
