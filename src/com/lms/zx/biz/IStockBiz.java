package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;

public interface IStockBiz {
	/*
	 * 根据库存商品的名称，查询库存商品的信息，支持模糊查询
	 * @param proName 库存商品的名称
     *@return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException;
	/*
	 * 根据库存商品的类型，查询库存商品的信息，支持模糊查询
	 * @param genre 库存商品的类型
	 *@return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException;
	/*
	 * 查询库存表中的所有商品的信息
	 * @return Vector<Vector<String>> 返回所有的商品的信息
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingNotFoundProductException, StockingDAOException;
}
