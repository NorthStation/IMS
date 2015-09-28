package com.lms.zx.entity;

import java.io.Serializable;

/**
 * Supplie����Ӧ��
 * @author ������
 *
 */
public class Supplie implements Serializable{
	//���	
	private long id;
	//����	
	private String name;	
	//��ϵ��
	private String linkman;
	//�绰
	private String phone;	
	//����	
	private String email;
	//��������	
	private String bank;
	//�����˺�	
	private String account;
	//��ַ	
	private String address;
	
	//�޲ι�����
	public Supplie() {
		
	}
	
	//�вι�����
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

	//toString()����
	public String toString() {
		return this.name;
	}
	
	//equals()����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof Supplie) {
			Supplie supplie = (Supplie)obj;
			return supplie.getId() == this.id;
		}
		return false;
	}
	
	//hashCode()����
	public int hashCode() {
		return (int)this.id;
	}
	
	//getter��setter����
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
