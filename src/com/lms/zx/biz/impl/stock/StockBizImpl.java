package com.lms.zx.biz.impl.stock;

import java.util.Vector;

import com.lms.zx.biz.IStockBiz;
import com.lms.zx.dao.IStockDAO;
import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.StockFactory;

public class StockBizImpl implements IStockBiz{
	/*
	 * 查询库存表中的所有商品的信息
	 * @return Vector<Vector<String>> 返回所有的商品的信息
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingNotFoundProductException, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建一个dao对象
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryAll();
		if(v.isEmpty()){
			throw new StockingNotFoundProductException("库存表中无商品");
		}
		return v;
	}
	/*
	 * 根据库存商品的类型，查询库存商品的信息，支持模糊查询
	 * @param genre 库存商品的类型
	 *@return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建一个dao对象
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryByGenre(genre);
		if(v.isEmpty()){
			throw new StockNotFoundProduct("没有找到该商品");
		}
		return v;
	}
	/*
	 * 根据库存商品的名称，查询库存商品的信息，支持模糊查询
	 * @param proName 库存商品的名称
     *@return Vector<Vector<String>> 返回商品信息
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建一个dao对象
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryByProductName(proName);
		if(v.isEmpty()){
			throw new StockNotFoundProduct("没有找到该商品");
		}
		return v;
	}
	
}
