package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.entity.SalesReturnDetailOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.factory.SalesFactory;

 

/**
 * 销售退货页面控制器
 */
public class SalesReturnContext {
	 

	// 保存退货信息到数据库
	public boolean saveSalesReturnOrder(String salesReturnId, String amount,
			String date, String operator, String customerField, String payMent,
			Vector<Vector<String>> data) throws SalesReturnIsFailedException {
		//获取销售退货详单集合
		ArrayList<SalesReturnDetailOrder> details = new ArrayList<SalesReturnDetailOrder>();
		//循环封装详单信息
		for(int i=0;i<data.size();i++) {
			SalesReturnDetailOrder d = new SalesReturnDetailOrder();
			//获取详单信息
			Vector<String> v = data.get(i);
			//遍历Vector对象的下标
			int index = 1;
			//封装详单
			d.setSalesReturnId(salesReturnId);
			d.setProId(Long.parseLong(v.get(index++)));
			d.setProName(v.get(index++));
			d.setGenre(v.get(index++));
			d.setReturnPrice(Double.parseDouble(v.get(index++)));
			d.setAmount(Integer.parseInt(v.get(index++)));
			d.setSpecific(v.get(index++));
			d.setMadeIn(v.get(index++));
			d.setRemarks(v.get(index++));
			d.setSum(Double.parseDouble(v.get(index++)));
			details.add(d);
		}
		//封装销售退货单信息
		SalesReturnOrder order = new SalesReturnOrder();
		order.setSalesReturnId(salesReturnId);
		order.setSum(Double.parseDouble(amount));
		order.setTime(date);
		order.setHandle(operator);
		order.setCurName(customerField);
		order.setPayMent(payMent);
		order.setSalesReturnDetailOrders(details);
		//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//保存销售退货信息
		biz.addSalesReturnOrder(order);
		return true;
	}

}
