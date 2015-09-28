package com.lms.zx.factory;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.biz.impl.sales.SalesManagerBizImpl;
import com.lms.zx.dao.ISalesDao;
import com.lms.zx.dao.ISalesReturnDao;
import com.lms.zx.dao.impl.sales.SalesDaoImpl;
import com.lms.zx.dao.impl.sales.SalesReturnDaoImpl;

/**
 * SalesFactory：销售管理工厂
 * @author 李岳南
 *
 */
public abstract class SalesFactory {
	//返回销售出库模块的数据访问层对象
	public static ISalesDao getSalesDaoInstance() {
		return new SalesDaoImpl();
	}
	
	//返回销售出库退货模块的数据访问层对象
	public static ISalesReturnDao getSalesReturnDaoInstance() {
		return new SalesReturnDaoImpl();
	}
	
	//返回销售管理逻辑层的对象
	public static ISalesManagerBiz getSalesManagerBizInstance() {
		return new SalesManagerBizImpl();
	}
}
