package com.lms.zx.entity;

import java.io.Serializable;

/**
 * Product����Ʒ��
 * @author ������
 *
 */
public class Product implements Serializable{
	//���
	private long id;
	//����
	private String name;
	//����
	private String genre;
	//�۸�
	private double price;
	//���
	private String specific;
	//��λ
	private String unit;
	//��Ӧ�̱��
	private long supplieId;
	//��Ӧ������
	private String supplieName;
	//��ע
	private String remarks;
	//����
	private String madeIn;

	//�޲ι�����
	public Product() {
		
	}
	
	//�вι�����
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
	
	//toString����
	public String toString() {
		return this.name;
	}
	
	//equals����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof Product) {
			Product product = (Product)obj;
			return product.getId() == this.id;
		}
		return false;
	}
	
	//hashCode����
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
