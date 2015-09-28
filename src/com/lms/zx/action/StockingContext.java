package com.lms.zx.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingUpdateFailException;
import com.lms.zx.factory.StockingFactory;

 

/**库存盘点*/
public class StockingContext {
	   
	/**
	 * 根据库存商品的id更新库存商品的数量
	 *@param lists  第一个参数为 库存商品的数量，第二个参数为库存商品的id 
	 *@return void
	 * @throws DAOException 
	 * @throws StockingUpdateFailException 
	 */
	public void saveBatchDatas(List<int[]> lists) throws StockingDAOException,StockingUpdateFailException{
		//创建biz对象
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//调用biz的updateStock方法
		biz.updateStock(lists);
	}
	
	/** 获得库存表的所有数据
	 * @throws DAOException 
	 * @throws StockingNotFoundException */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException,  StockingNotFoundException{
		//创建biz对象
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//调用biz的getAllStorage方法，并接收返回值
		Vector<Vector<String>> v=biz.getAllStorage();
		//返回
		return v;
   }
   /**
    * 统计库存表的记录总数和货品总数
    * @return List<Integer> 返回记录总数，货品总数
 * @throws DAOException 
 * @throws StockingNotExistException 
    */
	public List<Integer> getCountMsg() throws StockingDAOException, StockingNotExistException{
		//利用工厂创建biz对象
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//创建一个Arraylist对象
		List<Integer> s=new ArrayList<Integer>();
		//调用biz的queryCountMsg方法，并接收返回值
		s=biz.queryCountMsg();
		//返回
		return s;
	}
     
}
