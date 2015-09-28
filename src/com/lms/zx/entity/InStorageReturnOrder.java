package com.lms.zx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//����˻���
public class InStorageReturnOrder implements Serializable{
	private String id;//�˻�Ʊ��
	private String time;//����
	private String handle;//������
	private String payMent;//֧����ʽ
	private double sum;//�ܽ�
	private String supplieName;//��Ӧ������
	private  ArrayList<InStorageReturnDetailOrder> inReturnOrder;//����˻��굥
	public InStorageReturnOrder() {
		
	}
	public InStorageReturnOrder(String id, String time, String handle,
			String payMent, double sum, String supplieName, ArrayList<InStorageReturnDetailOrder> inReturnOrder) {
		this.id = id;
		this.time = time;
		this.handle = handle;
		this.payMent = payMent;
		this.sum = sum;
		this.supplieName=supplieName;
		this.inReturnOrder = inReturnOrder;
	}
	
	public String toString(){
		return id+ time+""+handle+""+payMent+""+sum;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(obj==this)
			return true;
		if(obj instanceof InStorageReturnOrder){
			InStorageReturnOrder other=(InStorageReturnOrder)obj;
			return this.id.equals(other.getId());
		}
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public 	String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getPayMent() {
		return payMent;
	}
	public void setPayMent(String payMent) {
		this.payMent = payMent;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	public String getSupplieName() {
		return supplieName;
	}
	public void setSupplieName(String supplieName) {
		this.supplieName = supplieName;
	}
	public  ArrayList<InStorageReturnDetailOrder>  getInReturnOrder() {
		return inReturnOrder;
	}
	public void setInReturnOrder( ArrayList<InStorageReturnDetailOrder>  inReturnOrder) {
		this.inReturnOrder = inReturnOrder;
	}

}
