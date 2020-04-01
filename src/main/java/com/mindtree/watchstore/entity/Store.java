package com.mindtree.watchstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long storeid;
	
	private String storename;
	
	
	@OneToOne(mappedBy = "store")
	private Watch watch;

	public long getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public Store(int storeid, String storename, Watch watch) {
		super();
		this.storeid = storeid;
		this.storename = storename;
		this.watch = watch;
	}
	public Store() {
		// TODO Auto-generated constructor stub
	}
	

	
}
