package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.entity.InStorageDetailOrder;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.factory.GetInstance;
 

/**
 * 采购入库 订单生成业务
 */
public class OrderProductInfoConext {
	/**
	 * 生成订单
	 * 
	 * @param Vector<String> order 订单信息
	 * [主键，合计金额，订单日期，货品总数，经手人，品种数量，支付方式，验收结论]
	 *            
	 * @param Vector<Vector<String>> storages 订单详细信息
	 *           
	 * @return void
	 * @throws DaoException 
	 * @throws InStorageDaoException 
	 */
	public void addOrderProductInfo(Vector<String> order,
			Vector<Vector<String>> storages) throws  InStorageDaoException {

		//利用简单工厂创建入库管理Biz层对象
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		//创建入库订单实体类
		InStorageOrder inStorageOrder=new InStorageOrder();
		//创建入库详单集合
		 ArrayList<InStorageDetailOrder> detailOrder=new  ArrayList<InStorageDetailOrder>();
		for(int j=0;j<storages.size();j++){
			//创建入库详单实体
			InStorageDetailOrder  s=new InStorageDetailOrder();
			Vector<String> v=storages.get(j);
			s.setOrderId(order.get(0));
			s.setProId(Long.parseLong(v.get(0)));
			s.setSuppliName(v.get(1));
			s.setProName(v.get(2));
			s.setPrice(Double.parseDouble(v.get(3)));
			s.setSpecific(v.get(4));
			s.setUnit(v.get(5));
			s.setAmount(Integer.parseInt(v.get(6)));
			//s.setPrice(Double.parseDouble(v.get(7)));
			s.setRemarks(v.get(8));
			s.setMadeIn(v.get(9));
			s.setGenre(v.get(10));
			detailOrder.add(s);
		}
		
		//封装成对象
		int i=0;
		inStorageOrder.setId(order.get(i++));
		inStorageOrder.setSum(Double.parseDouble(order.get(i++)));
		inStorageOrder.setTime(order.get(i++));
		inStorageOrder.setVarNumber(Integer.parseInt(order.get(i++)));
		inStorageOrder.setHandle(order.get(i++));
		inStorageOrder.setProCount(Integer.parseInt(order.get(i++)));
		inStorageOrder.setPayMent(order.get(i++));
		inStorageOrder.setConclusion(order.get(i++));
		inStorageOrder.setDetailOrder(detailOrder);
		
		inStorageManagerBiz.addOrderProductInfo(inStorageOrder);
		
		
	}

}
