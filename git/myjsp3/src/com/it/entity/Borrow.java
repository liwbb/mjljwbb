package com.it.entity;

public class Borrow {
	private Integer id;
	private Object bid;
	private Object cid;
	private Object btime;
	private Object retime;
	private Object datime;
	private String state;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Object getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Object getBtime() {
		return btime;
	}

	public void setBtime(Object btime) {
		this.btime = btime;
	}

	public Object getRetime() {
		return retime;
	}

	public void setRetime(Object retime) {
		this.retime = retime;
	}

	public Object getDatime() {
		return datime;
	}

	public void setDatime(Object datime) {
		this.datime = datime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return id + "\t" + bid + "\t" + cid +  "\t" + btime +  "\t" + retime
				+  "\t" + datime +  "\t" + state +  "\t";
	}
	

	
}
