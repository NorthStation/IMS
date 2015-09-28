package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.sales.SalesDaoException;

/**
 * ISalesDao：销售出库数据访问层接口
 * @author Administrator
 *
 */
public interface ISalesDao {
	/*
	 * insertSalesOrder：插入销售出库记录
	 * @param order 销售出库订单（包含详单信息）
	 */
	public void insertSalesOrder(SalesOrder order) throws SalesDaoException;
	
	/*
	 * insertStock：更新库存
	 * @param con 数据库连接，便于同步事务
	 * @param detailOrder 销售出库详单信息
	 */
	public void insertStock(Connection con, ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException;
	
	/*
	 * insertSalesDetailOrder：插入销售出库详单记录
	 * @param con 数据库连接，便于同步事务
	 * @param detailOrder 销售出库详单信息
	 */
	public void insertSalesDetailOrder(Connection con,ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException;
	
	/*
	 * updateStockByPname：通过商品名称更新库存数量
	 * @param proName 商品名称
	 * @param amount 实际库存数量
	 */
	public void updateStockByPname(String proName,int amount) throws SalesDaoException;
	
	/*
	 * querySalesDetailOrderBySid：通过销售出库票号查询销售出库详单信息：不含有销售票号信息
	 * @param sid 销售出库票号
	 * @return Vector<Vector<String>> 销售出库详单集合
	 */
	public Vector<Vector<String>> querySalesDetailOrderBySid(String sid) throws SalesDaoException;
	
	/*
	 * queryAllSales：查询所有的销售出库订单信息
	 * @return Vector<Vector<String>> 销售出库订单集合
	 */
	public Vector<Vector<String>> queryAllSales() throws SalesDaoException;
	
	/*
	 * querySalesBySid：根据销售出库订单票号查询销售出库订单信息
	 * @param sid 销售出库订单票号
	 * @return Vector<Vector<String>> 销售出库订单集合
	 */
	public Vector<Vector<String>> querySalesBySid(String sid) throws SalesDaoException;
	
	/*
	 * queryStockByPid：根据商品编号查询库存信息
	 * @param proId 商品编号
	 * @return Stock 库存信息
	 */
	public Stock queryStockByPid(long proId) throws SalesDaoException;
	
	/*
	 * queryAllSalesNumber：查询所有的销售出库票号
	 * @return Vector<String> 销售出库票号集合
	 */
	public Vector<String> queryAllSalesNumber() throws SalesDaoException;

	/*
	 * querySDetailOrderBySid：通过销售出库票号查询销售出库详单信息：不含有销售票号信息
	 * @param sid 销售出库票号
	 * @return Vector<Vector<String>> 销售出库详单集合
	 */
	public Vector<Vector<String>> querySDetailOrderBySid(String salesNum) throws SalesDaoException;
}
