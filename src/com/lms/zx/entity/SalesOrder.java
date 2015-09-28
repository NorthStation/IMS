package com.lms.zx.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * SalesOrder�����۳��ⶩ����
 * @author Administrator
 *
 */
public class SalesOrder implements Serializable{
	//���۵���
	private String id;
	//������	
	private String handle;
	//����ʱ��
	private String time;	
	//�ͻ�����
	private String cusName;
	//֧����ʽ
	private String payMent;
	//�ܽ��	
	private double sum;
	//��ע
	private String remarks;
	//���۳����굥	
	private ArrayList<SalesDetailOrder> detailOrders;
	
	public SalesOrder() {
		
	}
	
	public SalesOrder(String id,String handle,String time,String cusName,String payMent,
			double sum,String remarks,ArrayList<SalesDetailOrder> detailOrders) {
		this.id = id;
		this.handle = handle;
		this.time = time;
		this.cusName = cusName;
		this.payMent = payMent;
		this.sum = sum;
		this.remarks = remarks;
		this.detailOrders = detailOrders;
	}

	//toString
	public String toString() {
		return "���۳��ⵥ��: " + id + "\n�����ˣ�" + handle;
	}
	
	//equals����
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesOrder) {
			SalesOrder order = (SalesOrder)obj;
			return this.id.equals(order.getId());
		}
		return false;
	}
	
	//hashCode����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	
	//getter��setter����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ArrayList<SalesDetailOrder> getDetailOrders() {
		return detailOrders;
	}

	public void setDetailOrders(ArrayList<SalesDetailOrder> detailOrders) {
		this.detailOrders = detailOrders;
	}

}
