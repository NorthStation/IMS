package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.SalesReturnDetailOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesDaoException;

/**
 * ISalesReturnDao：销售退货数据访问层接口
 * @author 李岳南
 */
public interface ISalesReturnDao {
	/*
	 * insertSalesReturnOrder：插入销售退货单信息
	 * @param order 销售退货单
	 */
	public void insertSalesReturnOrder(SalesReturnOrder order) throws SalesDaoException;
	
	/*
	 * insertSalesReturnDetailOrder: 插入销售退货详单信息
	 * @param con 数据库连接对象，为了同步事务
	 * @param detail 销售退货详单
	 */
	public void insertSalesReturnDetailOrder(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException;
	
	/*
	 * updateStock: 更新库存
	 * @param con 数据库连接对象，为了同步事务
	 * @param detail 销售退货详单
	 */
	public void updateStock(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException;
	
	/*
	 * querySalesReturnDetailOrderBySid：根据销售退货票号查询销售退货详单
	 * @param salesReturnId 销售退货票号
	 * @return Vector<Vector<String>> 销售退货详单 
	 */
	public Vector<Vector<String>> querySalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException;
	
	/*
	 * querySalesReturnOrderBySid：根据销售退货票号查询销售退货单
	 * @param salesReturnId 销售退货票号
	 * @return Vector<Vecotr<String>> 销售退货单
	 */
	public Vector<Vector<String>> querySalesReturnOrderBySid(String salesReturnId) throws SalesDaoException;
	
	/*
	 * queryAllSalesReturnOrder：查询所有销售退货单信息
	 * @return Vector<Vector<String>> 销售退货单集合
	 */
	public Vector<Vector<String>> queryAllSalesReturnOrder() throws SalesDaoException;
}
