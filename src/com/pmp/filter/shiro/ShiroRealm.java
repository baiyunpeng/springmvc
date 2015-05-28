package com.pmp.filter.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmp.pojo.Role;
import com.pmp.pojo.User;
import com.pmp.service.jdbc.UserService;

/**
 * shiro 安全规则配置
 * @author Administrator
 *
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 根据用户配置用户与权限
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection方法参数不能为空。");
		}
		String name = (String) getAvailablePrincipal(principals);
		List<String> roles = new ArrayList<String>();
		User user = new User();
		user.setUsername(name);
		user = userService.findUser(user);
		if (user.getUsername().equals(name)) {
			if (user.getRoles() != null) {
				for(Role role:user.getRoles()){
					roles.add(role.getRole());
				}
			}
		} else {
			throw new AuthorizationException();
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 增加角色
		info.addRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = new User();
		user.setUsername(token.getUsername());
		user = userService.findUser(user);
		if (user == null) {
			throw new AuthorizationException();
		}
		SimpleAuthenticationInfo info = null;
		if (user.getUsername().equals(token.getUsername())) {
			info = new SimpleAuthenticationInfo(user.getUsername(),
					user.getPassword(), getName());
		}
		return info;
	}

}
