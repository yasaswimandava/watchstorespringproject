package com.mindtree.watchstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="watchid")
public class Watch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long watchid;
	
	private String watchname;
	
	private double watchprice;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Store store;

	public Watch() {
	}

	public Watch(long watchid, String watchname, double watchprice, Store store) {
		this.watchid = watchid;
		this.watchname = watchname;
		this.watchprice = watchprice;
		this.store = store;
	}

	public long getWatchid() {
		return watchid;
	}

	public void setWatchid(long watchid) {
		this.watchid = watchid;
	}

	public String getWatchname() {
		return watchname;
	}

	public void setWatchname(String watchname) {
		this.watchname = watchname;
	}

	public double getWatchprice() {
		return watchprice;
	}

	public void setWatchprice(double watchprice) {
		this.watchprice = watchprice;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}


	
	
	

}
