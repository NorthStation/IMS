package com.lms.zx.dao;

import java.util.List;
import java.util.Vector;

import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.stock.StockingDAOException;


public interface IStockingDAO {
	/*
	 * 根据库存id更新库存量
	 * @param lists:包含id和数量的集合
	 * @return int 返回数据库中受影响的行数
	 */
	public void updateStockBySid(List<int[]> lists) throws StockingDAOException;
	/*
	 * 统计库存表中的记录总数和货品总数
	 * @return Vector 返回一个包含记录总数和货品总数的集合
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException;
	/*
	 * 获取库存表中的所有数据
	 * @return Vector 返回一个包含所有库存信息的Vector对象
	 */
	public Vector<Vector<String>> queryAllStorage() throws StockingDAOException; 
	/*
	 * 根据商品名查询库存商品信息
	 * @return Vector 返回包含商品信息的Vector对象
	 */
	public Vector queryProductByPname(String pname) throws StockingDAOException;
	/*
	 * 查询库存表中的所有商品名称
	 * @return Vector 返回包含库存表中所有商品的名称的Vector对象
	 */
	public Vector<String> queryAllPname() throws StockingDAOException;
}
