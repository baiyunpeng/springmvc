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
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.pmp.common.DateUtil;
import com.pmp.common.RText;

/**
 * 用户表
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 姓名
	 */
	private String useralias;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 出生日期
	 */
	private String birthdate;
	/**
	 * 身份证号
	 */
	private String cardid;
	/**
	 * 家庭地址
	 */
	private String address;
	/**
	 * 备注呀
	 */
	private String remark;
	/**
	 * 用户状态 0:正常;1:冻结;2:禁用;
	 */
	private Integer status = 0;
	/**
	 * 最后修改时间
	 */
	private String lastdate;

	/**
	 * 多对多关联权限表
	 */
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUseralias() {
		return useralias;
	}

	public void setUseralias(String useralias) {
		this.useralias = useralias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = RText.encodeMD5(password);
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
