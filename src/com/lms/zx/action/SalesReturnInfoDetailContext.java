package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * 销售退货详细信息
 */
public class SalesReturnInfoDetailContext {
       /**
	 * 根据退货单号查询退货信息
	 * param saleNum 销售退货单号
     * @throws SalesReturnDetailNotFoundException 
     * @throws SalesDaoException 
	 */
    public Vector<Vector<String>> showDataToSalesReturnQueryDetail(
			String saleNum) throws SalesDaoException, SalesReturnDetailNotFoundException {
    	//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取销售退货详单信息
		return biz.searchSalesReturnDetailOrderBySid(saleNum);
	}
}
