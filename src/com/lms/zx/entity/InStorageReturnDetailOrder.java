package com.lms.zx.entity;

import java.io.Serializable;

//����˻��굥
public class InStorageReturnDetailOrder implements Serializable{
	private String orderReturnId;//����˻�Ʊ��
	private long proId;//��Ʒ���
	private  int amount;//�˻�����
	private double returnPrice;//�˻��۸�
	private String supplieName;//��Ӧ������
	private String proName;//��Ʒ����
	private String unit;//��λ
	private String specific;//���
	private double inPrice;//���۸�
	public InStorageReturnDetailOrder() {
		
	}
	public InStorageReturnDetailOrder(String orderReturnId, long proId,
			int amount, double returnPrice, String supplieName,  String proName,String unit,
			String specific, double inPrice) {
		this.orderReturnId = orderReturnId;
		this.proId = proId;
		this.amount = amount;
		this.returnPrice = returnPrice;
		this.supplieName = supplieName;
		this.proName=proName;
		this.unit = unit;
		this.specific = specific;
		this.inPrice = inPrice;
	}
	
	public String toString(){
		return proId+""+amount+""+returnPrice+""+supplieName+""+proName+""+unit+""+specific+""+inPrice;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderReturnId == null) ? 0 : orderReturnId.hashCode());
		result = prime * result + (int) (proId ^ (proId >>> 32));
		return result;
	}
	
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(obj==this)
			return true;
		if(obj instanceof InStorageReturnDetailOrder){
			InStorageReturnDetailOrder other=(InStorageReturnDetailOrder)obj;
			return this.orderReturnId.equals(other.getOrderReturnId());
		}
		return false;
	}
	
	public String getOrderReturnId() {
		return orderReturnId;
	}
	public void setOrderReturnId(String orderReturnId) {
		this.orderReturnId = orderReturnId;
	}
	public long getProId() {
		return proId;
	}
	public void setProId(long proId) {
		this.proId = proId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(double returnPrice) {
		this.returnPrice = returnPrice;
	}
	public String getSupplieName() {
		return supplieName;
	}
	public void setSupplieName(String supplieName) {
		this.supplieName = supplieName;
	}
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSpecific() {
		return specific;
	}
	public void setSpecific(String specific) {
		this.specific = specific;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}

}
