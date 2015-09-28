package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;

 

/**
 * 销售出库查询页面控制器
 * @author logan
 *
 */
public class SalesQueryContext {
 
   /**
    * 根据销售单号查询
    * @param saleNum
    * @return
 * @throws SalesDaoException 
 * @throws SearchDetailIdFailedException 
    */
	public Vector<Vector<String>> findSales(String saleNum) throws SearchDetailIdFailedException, SalesDaoException {
		//创建销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取销售出库单
		return biz.searchSalesBySid(saleNum);
	}
    /**
     * 查询所有销售信息
     * @return
     * @throws SalesDaoException 
     * @throws SearchDetailIdFailedException 
     */
	public Vector<Vector<String>> findSalesAll() throws SearchDetailIdFailedException, SalesDaoException {
		//创建销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取所有的销售出库单
		return biz.searchAllSales();
	}
	/**
	 * 删除订单信息
	 * @param proName
	 * @return
	 */
	public boolean deleteSalesOrder(String proName) {
		return false;
	}
	/**
	 * 根据订单号查询订单商品信息
	 * @throws SearchDetailIdFailedException 
	 * @throws SalesDaoException 
	 */
	public Vector<Vector<String>> showDataToSalesQueryDetail(String saleNum) throws SalesDaoException, SearchDetailIdFailedException {
		//创建销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取销售出库详单信息集合
		return biz.searchSalesDetailOrderBySid(saleNum);
	}

}
