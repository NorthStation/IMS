package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockingDAOException;

public interface IStockDAO {
	/*
	 * 根据库存商品的名称，查询库存商品的信息，支持模糊查询
	 * param proName 库存商品的名称
     *@return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockingDAOException;
	/*
	 * 根据库存商品的类型，查询库存商品的信息，支持模糊查询
	 * @return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockingDAOException;
	/*
	 * 查询库存表中的所有商品的信息
	 * @return Vector<Vector<String>> 返回所有商品信息
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingDAOException;
}
