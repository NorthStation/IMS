package com.lms.zx.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * SalesReturnOrder�������˻���
 * @author Administrator
 *
 */
public class SalesReturnOrder implements Serializable{
	//�����˻�Ʊ��   
	private String salesReturnId;
	//�˻�����
	private String time;
	//������	
	private String handle;
	//�ͻ�����	
	private String curName;
	//֧����ʽ
	private String payMent;
	//�ܽ��
	private double sum;
	//�˻��굥
	private ArrayList<SalesReturnDetailOrder> salesReturnDetailOrders;
	
	public SalesReturnOrder() {
		
	}
	
	public SalesReturnOrder(String salesReturnId,String time,String handle,String curName,String payMent,double sum,ArrayList<SalesReturnDetailOrder> salesReturnDetailOrders) {
		this.salesReturnId = salesReturnId;
		this.time = time;
		this.handle = handle;
		this.curName = curName;
		this.payMent = payMent;
		this.sum = sum;
		this.salesReturnDetailOrders = salesReturnDetailOrders;
	}
	
	//toString����
	public String toString() {
		return salesReturnId;
	}
	
	//equals����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesReturnOrder) {
			SalesReturnOrder order = (SalesReturnOrder)obj;
			return this.salesReturnId.equals(order.getSalesReturnId());
		}
		return false;
	}
	
	//hashCode����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (salesReturnId==null ? 0 : salesReturnId.hashCode());
		result = prime * result + (time==null ? 0 : time.hashCode());
		return result;
	}

	//getter��setter����
	public String getSalesReturnId() {
		return salesReturnId;
	}

	public void setSalesReturnId(String salesReturnId) {
		this.salesReturnId = salesReturnId;
	}

	public String getTime() {
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

	public String getCurName() {
		return curName;
	}

	public void setCurName(String curName) {
		this.curName = curName;
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

	public ArrayList<SalesReturnDetailOrder> getSalesReturnDetailOrders() {
		return salesReturnDetailOrders;
	}

	public void setSalesReturnDetailOrders(
			ArrayList<SalesReturnDetailOrder> salesReturnDetailOrders) {
		this.salesReturnDetailOrders = salesReturnDetailOrders;
	}

}
