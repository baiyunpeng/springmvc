package com.pmp.filter.shiro;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmp.pojo.User;
import com.pmp.service.jdbc.UserService;

public class ShiroFilter implements Filter{

	@Autowired
	private UserService userService;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub 
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    Principal principal = httpRequest.getUserPrincipal();

	    if (principal != null) {
	      Subject subjects = SecurityUtils.getSubject();
	      User user = new User();
	      user.setUsername(principal.getName());
	      user = userService.findUser(user);
	      if (user.getUsername().equals(principal.getName())) {
	        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user .getPassword());
	        subjects = SecurityUtils.getSubject();
	        subjects.login(token);
	        subjects.getSession();
	      } else {
	        // 如果用户为空，则subjects信息登出
	        if (subjects != null) {
	          subjects.logout();
	        }
	      }
	    }
	    chain.doFilter(httpRequest, httpResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
