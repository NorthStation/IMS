package com.lms.zx.biz;

import java.util.List;
import java.util.Vector;

import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.exception.stock.StockingUpdateFailException;


public interface IStockingBiz {
	/*
	 * 根据库存商品的id更新库存商品的数量
	 * @param lists：包含库存id和库存数量的集合
	 */
	public void updateStock(List<int[]> lists) throws StockingDAOException, StockingUpdateFailException;
	/*
	 * 获得库存表的所有数据
	 * @return Vector 包含所有库存信息的Vector对象
	 * 抛出DAOException和StockingNotFoundException异常
	 */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException, StockingNotFoundException;
	/*
	 * 统计库存表的记录总数和货品总数
	 * @return Vector 包含记录总数和货品总数的集合
	 * 抛出DAOException和StockingNotExistException异常
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException, StockingNotExistException;
	/*
	 * 查询库存表中的所有商品名称
	 * @return  Vector 包含所有商品名称的Vector对象
	 * 抛出DAOException和StockingBizException异常
	 */
	public Vector<String> searchAllPname()throws StockingDAOException,StockingNotFoundProductException;
	/*
	 * 根据商品名查询库存商品信息
	 * @param pname 商品名
	 * @return Vector 包含商品信息的一个Vector对象
	 * 抛出DAOException和StockingNotExistException异常
	 */
	public Vector searchProductByPname(String pname) throws StockingDAOException,StockingNotExistException;
}
