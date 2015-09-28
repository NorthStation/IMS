package com.lms.zx.entity;

import java.io.Serializable;

/**
 * Product：商品类
 * @author 李岳南
 *
 */
public class Product implements Serializable{
	//编号
	private long id;
	//名称
	private String name;
	//类型
	private String genre;
	//价格
	private double price;
	//规格
	private String specific;
	//单位
	private String unit;
	//供应商编号
	private long supplieId;
	//供应商名称
	private String supplieName;
	//备注
	private String remarks;
	//产地
	private String madeIn;

	//无参构造器
	public Product() {
		
	}
	
	//有参构造器
	public Product(long id,String name,String genre,double price,String specific,String unit,long supplieId,String supplieName,String remards,String madeIn) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.price = price;
		this.specific = specific;
		this.unit = unit;
		this.supplieId = supplieId;
		this.supplieName = supplieName;
		this.remarks = remards;
		this.madeIn = madeIn;
	}
	
	//toString方法
	public String toString() {
		return this.name;
	}
	
	//equals方法
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof Product) {
			Product product = (Product)obj;
			return product.getId() == this.id;
		}
		return false;
	}
	
	//hashCode方法
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
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
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
	
	public long getSupplieId() {
		return supplieId;
	}
	
	public void setSupplieId(long supplieId) {
		this.supplieId = supplieId;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getMadeIn() {
		return madeIn;
	}
	
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public String getSupplieName() {
		return supplieName;
	}

	public void setSupplieName(String supplieName) {
		this.supplieName = supplieName;
	}
	
}
