package com.lms.zx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//入库单类
public class InStorageOrder implements Serializable{
	private String id;//订单票号
	private int varNumber;//品种数量
	private  int proCount;//品种总数
	private double sum;//总金额
	private String payMent;//支付方式
	private String time;//订购日期
	private String handle;//经手人
	private String conclusion;//验收结论
	private  ArrayList<InStorageDetailOrder> detailOrder;//订单详单
	
	public InStorageOrder() {
		
	}

	public InStorageOrder(String id, int varNumber, int proCount, double sum,
			String payMent, String time, String handle, String conclusion,
			ArrayList<InStorageDetailOrder> detailOrder) {
		this.id = id;
		this.varNumber = varNumber;
		this.proCount = proCount;
		this.sum = sum;
		this.payMent = payMent;
		this.time = time;
		this.handle = handle;
		this.conclusion = conclusion;
		this.detailOrder = detailOrder;
	}
	
	public String toString(){
		return varNumber+""+proCount+""+sum+""+payMent+""+time+""+handle+""+conclusion;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	public boolean equals(Object obj){
		if(obj == null) 
			return false;
		if(obj==this)
			return true;
		if(obj instanceof InStorageOrder ){
			InStorageOrder  other=(InStorageOrder )obj;
			return this.id.equals(other.getId());
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVarNumber() {
		return varNumber;
	}

	public void setVarNumber(int varNumber) {
		this.varNumber = varNumber;
	}

	public int getProCount() {
		return proCount;
	}

	public void setProCount(int proCount) {
		this.proCount = proCount;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getPayMent() {
		return payMent;
	}

	public void setPayMent(String payMent) {
		this.payMent = payMent;
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

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public ArrayList<InStorageDetailOrder> getDetailOrder() {
		return detailOrder;
	}

	public void setDetailOrder(ArrayList<InStorageDetailOrder> detailOrder) {
		this.detailOrder = detailOrder;
	}

}
