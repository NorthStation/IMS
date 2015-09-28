package com.lms.zx.entity;

import java.io.Serializable;

/**
 * SalesDetailOrder：销售出库详单类
 * @author 李岳南
 *
 */
public class SalesDetailOrder implements Serializable{
	//销售单号	
	private String salesId;
	//商品编号	
	private long proId;
	//商品名称	
	private String proName;
	//商品类型
	private String genre;
	//出售价格	
	private double salesPrice;
	//出售数量	
	private int amount;
	//规格	
	private String specific;
	//产地	
	private String madeIn;
	//备注
	private String remarks;
	//单位	
	private String unit;
	
	public SalesDetailOrder() {
		
	}
	
	public SalesDetailOrder(String salesId,long proId,String proName,String genre,
			double salesPrice,int amount,String specific,String madeIn,String remarks,String unit) {
		this.salesId = salesId;
		this.proId = proId;
		this.proName = proName;
		this.genre = genre;
		this.salesPrice = salesPrice;
		this.amount = amount;
		this.specific = specific;
		this.madeIn = madeIn;
		this.remarks = remarks;
		this.unit = unit;
	}
	
	//toString方法
	public String toString() {
		return "销售出库单号：" + this.salesId + "商品名称" + this.proName;
	}
	
	//equals方法
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesDetailOrder) {
			SalesDetailOrder detailOrder = (SalesDetailOrder)obj;
			return this.salesId.equals(detailOrder.getSalesId());
		}
		return false;
	}
	
	//hashCode方法
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (int) (proId ^ (proId >>> 32));
		result = prime * result + ((salesId == null) ? 0 : salesId.hashCode());
		return result;
	}

	//getter和setter方法
	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public long getProId() {
		return proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
