package com.lms.zx.entity;

import java.io.Serializable;

/**
 * Stock：库存类
 * @author 李岳南
 *
 */
public class Stock implements Serializable{
	//库存编号	
	private int id;
	//商品编号	
	private long proId;
	//商品名称	
	private String proName;
	//规格
	private String specific;
	//价格
	private double price;
	//库存量	
	private int amount;
	//供应商名称
	private String supplieName;
	//单位	
	private String unit;
	//类型
	private String genre;
	//产地
	private String madeIn;
	//备注	
	private String remarks;
	
	public Stock() {
		
	}
	
	public Stock(int id,long proId,String proName,String specific,double price,int amount,String supplieName,
			String unit,String genre,String madeIn,String remarks) {
		this.id = id;
		this.proId = proId;
		this.proName = proName;
		this.specific = specific;
		this.price = price;
		this.amount = amount;
		this.supplieName = supplieName;
		this.unit = unit;
		this.genre = genre;
		this.madeIn = madeIn;
		this.remarks = remarks;
	}

	//toString方法
	public String toString() {
		return "库存编号：" + id + "\n商品名称:" + proName;
	}
	
	//equals方法
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof Stock) {
			Stock stock = (Stock)obj;
			return stock.getId() == this.id;
		}
		return false;
	}
	
	//getter和setter方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupplieName() {
		return supplieName;
	}

	public void setSupplieName(String supplieName) {
		this.supplieName = supplieName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
	
}
