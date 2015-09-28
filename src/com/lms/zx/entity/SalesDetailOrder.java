package com.lms.zx.entity;

import java.io.Serializable;

/**
 * SalesDetailOrder�����۳����굥��
 * @author ������
 *
 */
public class SalesDetailOrder implements Serializable{
	//���۵���	
	private String salesId;
	//��Ʒ���	
	private long proId;
	//��Ʒ����	
	private String proName;
	//��Ʒ����
	private String genre;
	//���ۼ۸�	
	private double salesPrice;
	//��������	
	private int amount;
	//���	
	private String specific;
	//����	
	private String madeIn;
	//��ע
	private String remarks;
	//��λ	
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
	
	//toString����
	public String toString() {
		return "���۳��ⵥ�ţ�" + this.salesId + "��Ʒ����" + this.proName;
	}
	
	//equals����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesDetailOrder) {
			SalesDetailOrder detailOrder = (SalesDetailOrder)obj;
			return this.salesId.equals(detailOrder.getSalesId());
		}
		return false;
	}
	
	//hashCode����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (int) (proId ^ (proId >>> 32));
		result = prime * result + ((salesId == null) ? 0 : salesId.hashCode());
		return result;
	}

	//getter��setter����
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
