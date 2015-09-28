package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductNotFoundException;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.SalesFactory;
import com.lms.zx.factory.StockingFactory;

 
/**
 *销售出库信息面板
 *<h1>注意</h1>:在销售出库的界面，录入信息时，需要实现findProductName方法
 */
public class SalesOutInfoContext {
 	/**
	 * 根据商品名称查询商品信息
	 * @param proName  商品名称
	 * @return
 	 * @throws StockingNotExistException 
 	 * @throws StockingDAOException 
 	 * @throws ProductDaoException 
 	 * @throws ProductNotFoundException 
	 */
	public Vector<String> findProduct(String proName) throws StockingDAOException, StockingNotExistException {
		//创建库存类的逻辑层对象
		IStockingBiz biz = StockingFactory.getStockingBizImpl();
		//获取商品信息
		return biz.searchProductByPname(proName);
	}
	/**
	 * 查询库存商品名称
	 * @return 
	 * @throws StockingNotFoundProductException 
	 * @throws StockingDAOException 
	 */
   public  Vector<String> findProductName() throws StockingDAOException, StockingNotFoundProductException{
	 //创建库存类的逻辑层对象
	   IStockingBiz biz = StockingFactory.getStockingBizImpl();
	 //获取商品名称集合
	 return biz.searchAllPname();
   }
   /**
    * 更新库存表中商品信息
    * @param proName
    * @param num
 * @throws SalesDaoException 
 * @throws NumberFormatException 
    */
	public void update(String proName, String num) throws NumberFormatException, SalesDaoException {
        //创建销售管理逻辑层对象
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//更新库存
		biz.updateStock(proName, Integer.parseInt(num));
	}
}
