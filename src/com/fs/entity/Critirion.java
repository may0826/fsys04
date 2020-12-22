package com.fs.entity;

public class Critirion {
	private Integer pn;
	
	private Integer sn;
	
	private Integer start;
	
	private String[] where;
	
	public Critirion(){
		
	}
	
	public Critirion(Integer pn, Integer sn){
		this.pn = pn;
		this.sn = sn;
	}

	public Integer getStart(){
		return (pn - 1) * this.sn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String[] getWhere() {
		return where;
	}

	public void setWhere(String[] where) {
		this.where = where;
	}
	
	
}
