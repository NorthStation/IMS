package com.lms.zx.factory;

import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.biz.impl.stock.StockingBizImpl;
import com.lms.zx.dao.IStockingDAO;
import com.lms.zx.dao.impl.stock.StockingDAOImpl;


public abstract class StockingFactory {
	public static IStockingBiz getStockingBizImpl(){
		return new StockingBizImpl();
	}
	public static IStockingDAO getStockingDaoImpl(){
		return new StockingDAOImpl();
	}
}
