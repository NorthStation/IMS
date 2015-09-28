package com.lms.zx.factory;

import com.lms.zx.biz.IStockBiz;
import com.lms.zx.biz.impl.stock.StockBizImpl;
import com.lms.zx.dao.IStockDAO;
import com.lms.zx.dao.impl.stock.StockDAOImpl;

public abstract class StockFactory {
	public static IStockBiz getStockBizImpl(){
		return new StockBizImpl();
		
	}
	public static IStockDAO getStockDAOImpl(){
		return new StockDAOImpl();
	}
}
