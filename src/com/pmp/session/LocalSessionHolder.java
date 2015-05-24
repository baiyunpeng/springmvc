package com.pmp.session;

import java.util.Collection;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class LocalSessionHolder implements SessionHolderInterface {

	public void setValueToSession(String key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute(key, value);
	}

	public Object getValueFromSession(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		return session.getAttribute(key);
	}
	
	public void removeValueToSession(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.removeAttribute(key);
	}

	public boolean containsKey(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Collection<Object> sessionCollections = session.getAttributeKeys();
		return sessionCollections.contains(key);
	}

	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated() || subject.getSession() != null) {
			subject.logout();
		}
	}



}
