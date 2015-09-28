package com.lms.zx.factory;

import com.lms.zx.biz.IProductBiz;
import com.lms.zx.biz.impl.product.ProductBizImpl;
import com.lms.zx.dao.IProductDao;
import com.lms.zx.dao.impl.product.ProductDaoImpl;

/**
 * ProductFactory����Ʒ����
 * @author Administrator
 *
 */
public abstract class ProductFactory {
	//������Ʒ���ݷ��ʲ�Ķ���
	public static IProductDao getProductDaoInstance() {
		return new ProductDaoImpl();
	}
	
	//������Ʒ�߼���Ķ���
	public static IProductBiz getProductBizInstance() {
		return new ProductBizImpl();
	}
}
