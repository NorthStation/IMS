package com.lms.zx.factory;

import com.lms.zx.biz.IProductBiz;
import com.lms.zx.biz.impl.product.ProductBizImpl;
import com.lms.zx.dao.IProductDao;
import com.lms.zx.dao.impl.product.ProductDaoImpl;

/**
 * ProductFactory：商品工厂
 * @author Administrator
 *
 */
public abstract class ProductFactory {
	//返回商品数据访问层的对象
	public static IProductDao getProductDaoInstance() {
		return new ProductDaoImpl();
	}
	
	//返回商品逻辑层的对象
	public static IProductBiz getProductBizInstance() {
		return new ProductBizImpl();
	}
}
