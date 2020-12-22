package com.fs.entity;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class User {
	@JsonIgnore
	private Integer uid;
	
	private String phone;
	@JsonIgnore
	private String pcode;
	
	private String uname;
	
	@JsonIgnore
	private Date regtime;
	@JsonIgnore
	private Integer sex;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
	
}
