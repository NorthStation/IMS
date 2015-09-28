package com.lms.zx.action;

import java.util.Vector;


import com.lms.zx.biz.IReturnProductMsgBiz;
import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;
import com.lms.zx.exception.instorage.productIsNotExistException;
import com.lms.zx.exception.instorage.stockIsNotException;
import com.lms.zx.factory.ReturnProductMsgFactory;

 

/**
 * 商品退货的信息
 */
public class ReturnProductMsgConext {
	/**
	 * 根据供应商的名称查询商品名称
	 * 
	 * @param supplierName
	 *            供应商名称
	 * @return Vector<String> 商品名称的集合
	 * @throws productIsNotExistException 
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> getStorageProductName(String supplierName) throws ReturnProductMsgDaoException, productIsNotExistException {
		Vector<String> ss=new Vector<String>();
		IReturnProductMsgBiz returnProductMsgBizImpl=ReturnProductMsgFactory.getReturnProductMsgBizImpl();
		ss=returnProductMsgBizImpl.searchProNameBySupplieName(supplierName);
		return ss;
	}

	/**
	 * 根据商品名称查询库存信息，不支持模糊查询
	 * 
	 * @param proName
	 *            商品名称
	 * @return Vector<String> 库存信息 [价格，库存数量，商品规格，库存id]
	 * @throws stockIsNotException 
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> getStorageByProName(String proName) throws ReturnProductMsgDaoException, stockIsNotException {
		IReturnProductMsgBiz returnProductMsgBizImpl=ReturnProductMsgFactory.getReturnProductMsgBizImpl();
		return returnProductMsgBizImpl.searchStrockInfoByProName(proName);
	}
}
