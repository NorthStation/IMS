package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * 销售退货查询
 */
public class SalesReturnQueryContext {
    /**
     * 根据退货票号查询退货商品信息
     * @param salesReturnNum 退货票号
     * @return
     * @throws SalesReturnOrderNotFoundException 
     * @throws SalesDaoException 
     */
	 public Vector<Vector<String>> findSalesReturn(String salesReturnNum) throws SalesDaoException, SalesReturnOrderNotFoundException {
		//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		return biz.searchSalesReturnOrderBySid(salesReturnNum);
	}
	 /**
	     * 查询退货商品信息
	     * @return
	 * @throws SalesReturnOrderNotFoundException 
	 * @throws SalesDaoException 
	     */
	public Vector<Vector<String>> findSalesReturn() throws SalesDaoException, SalesReturnOrderNotFoundException {
		//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取所有的销售退货单
		return biz.searchAllSalesReturnOrder();
	}

}
