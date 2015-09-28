package com.lms.zx.biz.impl.sales;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.dao.ISalesDao;
import com.lms.zx.dao.ISalesReturnDao;
import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;

/**
 * SalesManagerBizImpl：销售管理逻辑层实体类
 * @author 李岳南
 *
 */
public class SalesManagerBizImpl implements ISalesManagerBiz{
	//添加销售记录
	public boolean addSalesOrder(SalesOrder order) throws  StockAmountIsLackedException, SalesIsFailedException, SalesDaoException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取销售详单集合
		ArrayList<SalesDetailOrder> details = order.getDetailOrders();
		//循环判断商品库存数量是否充足
		for(int i=0;i<details.size();i++) {
			//获取销售出库商品的编号
			long proId = details.get(i).getProId();
			//获取销售出库商品的出售量
			int number = details.get(i).getAmount();
			//获取库存信息
			Stock stock = dao.queryStockByPid(proId);
			//判断库存量是否充足
			if(number > stock.getAmount() || stock.getAmount()==0) {
				throw new StockAmountIsLackedException(stock.getProName() + "的库存数量不足");
			}
		}
		try {
			//插入销售记录
			dao.insertSalesOrder(order);
		} catch (SalesDaoException e) {
			e.printStackTrace();
			throw new SalesIsFailedException("销售出库失败");
		}
		return true;
	}
	
	//更新库存
	public void updateStock(String proName,int number) throws SalesDaoException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//更新库存
		dao.updateStockByPname(proName, number);
	}
	
	//根据销售出库票号查询销售出库详单：不含有销售票号信息
	public Vector<Vector<String>> searchSalesDetailOrderBySid(String sid) throws SalesDaoException, SearchDetailIdFailedException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取详单
		Vector<Vector<String>> details = dao.querySalesDetailOrderBySid(sid);
		//判断详单是否存在
		if(details.size() == 0) {
			throw new SearchDetailIdFailedException("查询销售出库详单失败");
		}
		return details;
	}
	
	//查询所有销售出库订单信息
	public Vector<Vector<String>> searchAllSales() throws SearchDetailIdFailedException, SalesDaoException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取订单
		Vector<Vector<String>> orders = dao.queryAllSales();
		//判断订单是否存在
		if(orders.size() == 0) {
			throw new SearchDetailIdFailedException("暂无销售出库订单信息");
		}
		return orders;
	}
	
	//根据销售出库票号查询销售出库订单
	public Vector<Vector<String>> searchSalesBySid(String sid) throws SearchDetailIdFailedException, SalesDaoException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取订单
		Vector<Vector<String>> order = dao.querySalesBySid(sid);
		//判断订单是否存在
		if(order.size() == 0) {
			throw new SearchDetailIdFailedException("查询销售出库订单信息失败");
		}
		return order;
	}
	
	//查询所有销售出库票号
	public Vector<String> searchAllSalesNumber() throws SalesDaoException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取销售出库票号集合
		Vector<String> salesIds = dao.queryAllSalesNumber();
		return salesIds;
	}
	
	//查询所有销售退货单
	public Vector<Vector<String>> searchAllSalesReturnOrder() throws SalesDaoException, SalesReturnOrderNotFoundException {
		//创建销售退货数据访问层的对象
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//获取所有销售退货单
		Vector<Vector<String>> orders = dao.queryAllSalesReturnOrder();
		//判断是否存在销售退货单
		if(orders.size() == 0) {
			throw new SalesReturnOrderNotFoundException("暂无销售退货单信息");
		}
		return orders;
	}
	
	//添加销售退货单
	public boolean addSalesReturnOrder(SalesReturnOrder order) throws SalesReturnIsFailedException {
		try {
			//创建销售退货数据访问层的对象
			ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
			//插入记录
			dao.insertSalesReturnOrder(order);
		} catch (SalesDaoException e) {
			e.printStackTrace();
			throw new SalesReturnIsFailedException("销售退货操作失败");
		}
		return true;
	}
	
	//根据销售退货票号查询销售退货详单
	public Vector<Vector<String>> searchSalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnDetailNotFoundException {
		//创建销售退货数据访问层的对象
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//查询销售退货详单
		Vector<Vector<String>> detail = dao.querySalesReturnDetailOrderBySid(salesReturnId);
		//判断详单是否存在
		if(detail.size() == 0) {
			throw new SalesReturnDetailNotFoundException("获取销售退货详单失败");
		}
		return detail;
	}
	
	//根据销售退货票号查询销售退货单
	public Vector<Vector<String>> searchSalesReturnOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnOrderNotFoundException {
		//创建销售退货数据访问层的对象
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//查询销售退货单
		Vector<Vector<String>> order = dao.querySalesReturnOrderBySid(salesReturnId);
		//判断销售退货单是否存在
		if(order.size() == 0) {
			throw new SalesReturnOrderNotFoundException("获取销售退货单失败");
		}
		return order;
	}
	//根据销售出库票号查询销售详单信息：含有销售票号信息
	public Vector<Vector<String>> seaSalesDetailOrderBySid(String salesNum) throws SalesDaoException, SearchDetailIdFailedException {
		//创建销售出库数据访问层的对象
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//获取详单
		Vector<Vector<String>> details = dao.querySDetailOrderBySid(salesNum);
		//判断详单是否存在
		if(details.size() == 0) {
			throw new SearchDetailIdFailedException("查询销售出库详单失败");
		}
		return details;
	}
}
