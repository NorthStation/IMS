package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * 销售出库页面控制器
 */
public class SalesOrderContext {
	 
	/**
	 * 保存销售信息
	 *@param salesNum 销售单号
	 *@param amount   总金额 
	 *@param customerName 客户名称
	 *@param salesTime 销售时间
	 *@param handle    经手人
	 *@param payMent   支付方式
	 *@param remark    备注
	 *@param data      销售详细信息
	 *@return 
	 *@return boolean
	 * @throws SalesDaoException 
	 * @throws SalesIsFailedException 
	 * @throws StockAmountIsLackedException 
	 */
	public boolean saveSalesOrder(String salesNum, String amount,
			String customerName, String salesTime, String handle,
			String payMent, String remark,Vector<Vector<String>> data) throws StockAmountIsLackedException, SalesIsFailedException, SalesDaoException {
		//获取销售出库详单集合
		ArrayList<SalesDetailOrder> details = new ArrayList<SalesDetailOrder>();
		for(int i=0;i<data.size();i++) {
			//获取集合中的元素
			Vector<String> v = data.get(i);
			//封装销售出库详单
			SalesDetailOrder d = new SalesDetailOrder();
			//遍历Vector对象的下标
			int index = 0;
			d.setProId(Long.parseLong(v.get(index++)));
			d.setProName(v.get(index++));
			d.setGenre(v.get(index++));
			d.setSalesPrice(Double.parseDouble(v.get(index++)));
			d.setAmount(Integer.parseInt(v.get(index++)));
			d.setSpecific(v.get(index++));
			d.setMadeIn(v.get(index++));
			d.setRemarks(v.get(index++));
			d.setSalesId(salesNum);
			details.add(d);
		}
		//封装销售出库单
		SalesOrder order = new SalesOrder();
		order.setId(salesNum);
		order.setSum(Double.parseDouble(amount));
		order.setCusName(customerName);
		order.setTime(salesTime);
		order.setHandle(handle);
		order.setPayMent(payMent);
		order.setRemarks(remark);
		order.setDetailOrders(details);
		//获取销售管理的逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//保存销售信息
		return biz.addSalesOrder(order);
	}

}
