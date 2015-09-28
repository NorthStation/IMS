package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;
 

/**
 * 销售退货页面控制器
 */
public class SalesReturnInfoContext {
	 
	 
	/**
	 * 根据订单编号查询商品信息显示到表格中
	 * 
	 * @param salesNum
	 *            订单编号
	 * @return
	 * @throws SalesDaoException 
	 * @throws SearchDetailIdFailedException 
	 */
	public Vector<Vector<String>> showDataToTable(String salesNum) throws SearchDetailIdFailedException, SalesDaoException {
		//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取销售出库详单信息
		return biz.seaSalesDetailOrderBySid(salesNum);
	}
	/**
	 * 查找数据显示到下拉框
	 * @throws SalesDaoException 
	 * 
	 */
	public Vector<String> showDataToJCM() throws SalesDaoException {
		//获取销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//获取销售出库票号
		return biz.searchAllSalesNumber();
	}
}
