 package com.fs.entity;

import java.util.Date;
import java.util.List;

public class Product {
	private Integer pid;
	private String pname;
	private Integer uid;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	private Integer ptid;

	
	private Float pprice;
	private Date ptime;
	private String des;
	private String imga;

	private String tname;
	
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	private Integer loves;
	
	private Ptype type;
	private User user;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPtid() {
		return ptid;
	}
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Float getPprice() {
		return pprice;
	}
	public void setPprice(Float pprice) {
		this.pprice = pprice;
	}
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImga() {
		return imga;
	}
	public void setImga(String imga) {
		this.imga = imga;
	}

	public Integer getLoves() {
		return loves;
	}
	public void setLoves(Integer loves) {
		this.loves = loves;
	}
	public Ptype getType() {
		return type;
	}
	public void setType(Ptype type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
