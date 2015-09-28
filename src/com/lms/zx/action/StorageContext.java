 package com.lms.zx.action;


import java.util.Vector;

import com.lms.zx.biz.IStockBiz;
import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.StockFactory;

 
 

/** 库存管理 */
public class StorageContext {
     /**
     * 根据库存商品的名称，查询库存商品的信息，支持模糊查询
     *@param proName 库存商品的名称
     *@return Vector<Vector<String>>
     * @throws StockNotFoundProduct 
     * @throws StockDAOException 
     * @throws StockingDAOException 
     */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		//创建一个Vector对象
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建biz对象
		IStockBiz biz= StockFactory.getStockBizImpl();
		//调用biz的查询方法	
		v=biz.queryByProductName(proName);
		//返回
		return v;
		}
	
	
	/**
	 * 根据库存商品的类型，查询库存商品的信息，支持模糊查询
	 *@param genre  库存商品的类型
	 *@return Vector<Vector<String>>
	 * @throws StockNotFoundProduct 
	 * @throws StockDAOException 
	 * @throws StockingDAOException 
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		//创建一个Vector对象
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建一个biz对象
		IStockBiz biz= StockFactory.getStockBizImpl();
		//调用biz的方法
		v=biz.queryByGenre(genre);
		//返回
		return v;
	}
	
	/**
	 * 查询库存表中的所有商品的信息
	 *@return 
	 *@return Vector<Vector<String>>
	 * @throws StockingNotFoundProductException 
	 * @throws StockDAOException 
	 * @throws StockingDAOException 
	 */
	public Vector<Vector<String>> queryAll( ) throws StockDAOException, StockingNotFoundProductException, StockingDAOException {
		//创建一个Vector对象
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//创建一个Biz对象
		IStockBiz biz= StockFactory.getStockBizImpl();
		//调用biz的方法
		v=biz.queryAll();
		//返回
		return v;
	}
	 

}
