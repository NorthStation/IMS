package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;

/**
 * ISalesManagerBizImpl：销售管理的逻辑访问层接口
 * @author 李岳南
 *
 */
public interface ISalesManagerBiz {
	/*
	 * addSalesOrder：添加销售记录
	 * @param order 销售出库订单（包含详单信息）
	 * @return boolean 返回操作是否成功
	 */
	public boolean addSalesOrder(SalesOrder order) throws  StockAmountIsLackedException, SalesIsFailedException, SalesDaoException;

	/*
	 * updateStock：根据商品名称更新库存数量
	 * @param proName 商品名称
	 * @param number 库存数量
	 */
	public void updateStock(String proName,int number) throws SalesDaoException;

	/*
	 * searchSalesDetailOrderBySid：根据销售出库票号查询销售出库详单信息(无销售票号信息)
	 * @param sid 销售出库票号
	 * @return Vector<Vector<String>> 销售出库详单集合 
	 */
	public Vector<Vector<String>> searchSalesDetailOrderBySid(String sid) throws SalesDaoException, SearchDetailIdFailedException;
	
	/*
	 * searchAllSales：查询所有销售订单信息
	 * @return Vector<Vector<String>> 销售订单集合
	 */
	public Vector<Vector<String>> searchAllSales() throws SearchDetailIdFailedException, SalesDaoException;
	
	/*
	 * searchSalesBySid：根据销售出库票号查询销售出库订单
	 * @param sid 销售出库票号
	 * @return Vector<Vector<String>> 销售出库订单集合
	 */
	public Vector<Vector<String>> searchSalesBySid(String sid) throws SearchDetailIdFailedException, SalesDaoException;
	
	/*
	 * searchAllSalesNumber：查询所有销售出库票号
	 * @return Vector<String> 销售出库票号集合
	 */
	public Vector<String> searchAllSalesNumber() throws SalesDaoException;
	
	/*
	 * searchAllSalesReturnOrder：查询所有销售退货单信息
	 * @return Vector<Vector<String>> 销售退货单集合
	 */
	public Vector<Vector<String>> searchAllSalesReturnOrder() throws SalesDaoException, SalesReturnOrderNotFoundException;
	
	/*
	 * addSalesReturnOrder: 添加销售退货单信息
	 * @param order 销售退货单（包含销售退货详单）
	 * @return boolean 返回操作是否成功
	 */
	public boolean addSalesReturnOrder(SalesReturnOrder order) throws SalesReturnIsFailedException;
	
	/*
	 * searchSalesReturnDetailOrderBySid: 根据销售退货票号查询销售退货详单
	 * @param salesReturnId 销售退货票号
	 * @return Vector<Vector<String> 销售退货详单集合
	 */
	public Vector<Vector<String>> searchSalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnDetailNotFoundException;
	
	/*
	 * searchSalesReturnOrderBySid：根据销售退货票号查询销售退货单
	 * @param salesReturnId 销售退货票号
	 * @return Vector<Vector<String> 销售退货单集合 
	 */
	public Vector<Vector<String>> searchSalesReturnOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnOrderNotFoundException;
	
	/*
	 * seaSalesDetailOrderBySid：根据销售出库票号查询销售出库详单信息(含有销售票号信息)
	 * @param sid 销售出库票号
	 * @return Vector<Vector<String>> 销售出库详单集合 
	 */
	public Vector<Vector<String>> seaSalesDetailOrderBySid(String salesNum)throws SalesDaoException, SearchDetailIdFailedException;
}
