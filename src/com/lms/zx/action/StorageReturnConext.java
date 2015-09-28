package com.lms.zx.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.entity.InStorageReturnDetailOrder;
import com.lms.zx.entity.InStorageReturnOrder;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.factory.GetInstance;

 
/**入库退货*/
public class StorageReturnConext {
  /**
   * 生成入库退货信息
   *@param List<String>s 入库退货信息
   * [退货票号，退货日期，经手人，总金额，付款方式]
   *@param sDetail  入库退货详细信息
   *@return void
 * @throws InStorageReturnDaoException 
   */
  public void createRetrunMsg(List<String> s,Vector<Vector<String>> sDetail) throws InStorageReturnDaoException{
	//利用简单工厂创建入库管理Biz层对象
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		//创建入库退货单实体类
		InStorageReturnOrder returnOrder=new InStorageReturnOrder();
		//创建入库退货详单集合
		 ArrayList<InStorageReturnDetailOrder> detailOrder=new  ArrayList<InStorageReturnDetailOrder>();
		
		 System.out.println(s.toString());
		 //[RTH20131006214211426, 2013-10-06, admin, 2.0, 康师傅, 现金]
		for(int j=0;j<sDetail.size();j++){
			System.out.println("详单"+sDetail.get(j).toString());
			//详单[0, 1, 1]商品编号,退货单价，退货数量
			//创建入库退货详单实体
			InStorageReturnDetailOrder  order=new InStorageReturnDetailOrder();
			Vector<String> v=sDetail.get(j);
			for(int k=0;k<v.size();k++) {
				System.out.println(v.get(k));
			}
			order.setOrderReturnId(s.get(0));
			order.setProId(Long.parseLong(v.get(0)));
			order.setReturnPrice(Double.parseDouble(v.get(1)));
			order.setAmount(Integer.parseInt(v.get(2)));
			detailOrder.add(order);
		}
		
		//封装成对象
		int i=0;
		returnOrder.setId(s.get(i++));
		returnOrder.setTime(s.get(i++));
		returnOrder.setHandle(s.get(i++));
		returnOrder.setSum(Double.parseDouble(s.get(i++)));
		returnOrder.setSupplieName(s.get(i++));
		returnOrder.setPayMent(s.get(i++));
		
		returnOrder.setInReturnOrder(detailOrder);
			inStorageManagerBiz.addReturnMsg(returnOrder);
			
	
  }
}
