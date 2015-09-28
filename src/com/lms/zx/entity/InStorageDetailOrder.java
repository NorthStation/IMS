package com.lms.zx.entity;

import java.io.Serializable;

//入库订单详单类
public class InStorageDetailOrder implements Serializable{
	private String orderId;//订单票号
	private long proId;//商品编号
	private String suppliName;//供应商名称
	private String proName;//商品名称
	private double price;//单价
	private String specific;//规格
	private String unit;//单位
	private int amount;//入库数量
	private String madeIn;//产地
	private String genre;//商品类型
	private String remarks;//备注
	
	public InStorageDetailOrder() {
		
	}
	
	public InStorageDetailOrder(String orderId, long proId, String suppliName,
			String proName, double price, String specific, String unit,
			int amount, String madeIn, String genre, String remarks) {
		this.orderId = orderId;
		this.proId = proId;
		this.suppliName = suppliName;
		this.proName = proName;
		this.price = price;
		this.specific = specific;
		this.unit = unit;
		this.amount = amount;
		this.madeIn = madeIn;
		this.genre = genre;
		this.remarks = remarks;
	}
	
	public String toString(){
		return proId+""+suppliName+""+proName+""+price+""+specific+""+unit+""+amount+""+madeIn+""+genre+""+remarks;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + (int) (proId ^ (proId >>> 32));
		return result;
	}
	
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(obj==this)
			return true;
		if(obj instanceof InStorageDetailOrder){
			InStorageDetailOrder other=(InStorageDetailOrder)obj;
			return this.orderId.equals(other.getOrderId());
		}
		return false;
	}
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public long getProId() {
		return proId;
	}
	public void setProId(long proId) {
		this.proId = proId;
	}
	public String getSuppliName() {
		return suppliName;
	}
	public void setSuppliName(String suppliName) {
		this.suppliName = suppliName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSpecific() {
		return specific;
	}
	public void setSpecific(String specific) {
		this.specific = specific;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
