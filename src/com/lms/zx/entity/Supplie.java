package com.lms.zx.entity;

import java.io.Serializable;

/**
 * Supplie：供应商
 * @author 李岳南
 *
 */
public class Supplie implements Serializable{
	//编号	
	private long id;
	//名称	
	private String name;	
	//联系人
	private String linkman;
	//电话
	private String phone;	
	//邮箱	
	private String email;
	//开户银行	
	private String bank;
	//开户账号	
	private String account;
	//地址	
	private String address;
	
	//无参构造器
	public Supplie() {
		
	}
	
	//有参构造器
	public Supplie(long id,String name,String linkman,String phone,String email,String bank,String account,String address) {
		this.id = id;
		this.name = name;
		this.linkman = linkman;
		this.phone = phone;
		this.email = email;
		this.bank = bank;
		this.account = account;
		this.address = address;
	}

	//toString()方法
	public String toString() {
		return this.name;
	}
	
	//equals()方法
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof Supplie) {
			Supplie supplie = (Supplie)obj;
			return supplie.getId() == this.id;
		}
		return false;
	}
	
	//hashCode()方法
	public int hashCode() {
		return (int)this.id;
	}
	
	//getter和setter方法
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
