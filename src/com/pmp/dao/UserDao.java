package com.pmp.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pmp.pojo.User;

@Repository
public class UserDao extends BaseDao<User, Integer> {

	public User findUser(User user) {
		return findById(1);
		/*String hql = "from User where ";
		Query query = getSession().createQuery(hql);
		query.setString("username", user.getUsername());
		List<User> resultList = query.list();
		if (null != resultList) {
			return resultList.get(0);
		}
		return null;*/
	}

}
