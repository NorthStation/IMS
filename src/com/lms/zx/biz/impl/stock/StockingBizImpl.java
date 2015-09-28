package com.lms.zx.biz.impl.stock;

import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.dao.IStockingDAO;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.exception.stock.StockingUpdateFailException;
import com.lms.zx.factory.StockingFactory;

public class StockingBizImpl implements IStockingBiz {
	/*
	 * 获得库存表中所有的数据
	 * @see com.lms.zx.biz.impl.IStockingBiz#getAllStorage()
	 */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException, StockingNotFoundException {
		//创建dao对象
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//获取库存表中所有数据
		Vector<Vector<String>> v=dao.queryAllStorage();
		//判断
		if(v==null){
			throw new StockingNotFoundException("库存表不存在");
		}else{
			return v;
		}
		
	}
	/*
	 * 统计库存表的记录总数和货品总数
	 * @return list<Integer> 返回记录总数和货品总数
	 * @see com.lms.zx.biz.impl.IStockingBiz#queryCountMsg()
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException, StockingNotExistException {
		//获取dao对象
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//获取记录总数和货品总数
		List<Integer> list=dao.queryCountMsg();
		//判断
		if(list.get(0)==null){
			throw new StockingNotExistException("该商品不存在");
		}
		return list;
	}
	/*
	 * 根据库存商品的id更新库存商品的数量
	 * @param lists:包含库存id和商品数量的集合
	 * @see com.lms.zx.biz.impl.IStockingBiz#updateStock(java.lang.String, int)
	 */
	public void updateStock(List<int[]> lists) throws StockingDAOException, StockingUpdateFailException {
		//创建dao对象
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		dao.updateStockBySid(lists);
	}
	/*
	 * 查询库存表中的所有商品名称
	 * @return Vector 一个包含库存所有商品名称的Vector对象
	 * @see com.lms.zx.biz.impl.IStockingBiz#searchAllPname()
	 */
	public Vector<String> searchAllPname() throws  StockingNotFoundProductException, StockingDAOException
			  {
		//创建一个Vector对象
		Vector<String> v=new Vector<String>();
		//创建dao对象
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//获取返回的信息
		v=dao.queryAllPname();
		//判断
		if(v==null){
			throw new StockingNotFoundProductException("库存表中无商品");
		}
		return v;
	}
	/*
	 * 根据商品名称查询库存商品信息
	 * @param pname:商品名称
	 * @return Vector:返回一个包含商品信息的对象
	 * @see com.lms.zx.biz.impl.IStockingBiz#searchProductByPname(java.lang.String)
	 */
	public Vector<String> searchProductByPname(String pname) throws 
			 StockingNotExistException, StockingDAOException {
		//创建一个Vector对象
		Vector<String> v=new Vector<String>();
		//创建dao对象
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//获取商品信息
		v=dao.queryProductByPname(pname);
		//判断
		if(v.size()==0){
			throw new StockingNotExistException("该商品不存在");
		}
		//返回
		return v;
	}

	
	
}
