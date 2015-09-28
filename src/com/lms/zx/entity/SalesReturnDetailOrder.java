package com.lms.zx.entity;

import java.io.Serializable;

/**
 * SalesReturnDetailOrder�����۳����˻��굥
 * @author ������
 *
 */
public class SalesReturnDetailOrder implements Serializable{
	//�����˻�Ʊ�� 
	private String salesReturnId;
	//��Ʒ���
	private long proId;
	//��Ʒ����
	private String proName;
	//���� 
	private String genre;
	//�˻��۸�	
	private double returnPrice;
	//�˻�����	
	private int amount;
	//��λ
	private String unit;
	//����	
	private String madeIn;
	//��ע	
	private String remarks;
	//�ܽ��	
	private double sum;
	//���	
	private String specific;
	
	public SalesReturnDetailOrder() {
		
	}
	
	public SalesReturnDetailOrder(String salesReturnId, long proId,
			String proName, String genre, double returnPrice, int amount,
			String unit, String madeIn, String remarks, double sum,
			String specific) {
		this.salesReturnId = salesReturnId;
		this.proId = proId;
		this.proName = proName;
		this.genre = genre;
		this.returnPrice = returnPrice;
		this.amount = amount;
		this.unit = unit;
		this.madeIn = madeIn;
		this.remarks = remarks;
		this.sum = sum;
		this.specific = specific;
	}
	
	//toString����
	public String toString() {
		return "�����˻�Ʊ�ţ�" + this.salesReturnId + "\n��Ʒ" + this.proName;
	}
	
	//equals����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesReturnDetailOrder) {
			SalesReturnDetailOrder detail = (SalesReturnDetailOrder)obj;
			return this.salesReturnId.equals(detail.getSalesReturnId());
		}
		return false;
	}
	
	//hashCode����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (proId ^ (proId >>> 32));
		result = prime * result
				+ ((salesReturnId == null) ? 0 : salesReturnId.hashCode());
		return result;
	}
	
	//getter��setter����
	public String getSalesReturnId() {
		return salesReturnId;
	}

	public void setSalesReturnId(String salesReturnId) {
		this.salesReturnId = salesReturnId;
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

	public double getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(double returnPrice) {
		this.returnPrice = returnPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}
	
	
}
