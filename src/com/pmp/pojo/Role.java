package com.pmp.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 角色表
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 权限名称
	 */
	private String role;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * 最后修改时间
	 */
	private String lastdate;
	
	/**
	 * 得到关联用户
	 */
	@ManyToMany(mappedBy="roles",cascade=CascadeType.REFRESH)
	private List<User> users;
	
	/**
	 * 多对多关联权限表
	 */
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "t_role_permission", joinColumns = @JoinColumn(name = "roleid"), inverseJoinColumns = @JoinColumn(name = "permissionid"))
	private List<Permission> permissions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
