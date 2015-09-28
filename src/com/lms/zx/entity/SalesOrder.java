package com.lms.zx.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * SalesOrder：销售出库订单类
 * @author Administrator
 *
 */
public class SalesOrder implements Serializable{
	//销售单号
	private String id;
	//经手人	
	private String handle;
	//销售时间
	private String time;	
	//客户名称
	private String cusName;
	//支付方式
	private String payMent;
	//总金额	
	private double sum;
	//备注
	private String remarks;
	//销售出库详单	
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
		return "销售出库单号: " + id + "\n经手人：" + handle;
	}
	
	//equals方法
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof SalesOrder) {
			SalesOrder order = (SalesOrder)obj;
			return this.id.equals(order.getId());
		}
		return false;
	}
	
	//hashCode方法
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	
	//getter和setter方法
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
