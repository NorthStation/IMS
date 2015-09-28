package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;
import com.lms.zx.exception.instorage.productIsNotExistException;
import com.lms.zx.exception.instorage.stockIsNotException;



public interface  IReturnProductMsgBiz {
	/**
	 * 根据供应商的名称查询商品名称
	 * @throws ReturnProductMsgDaoException 
	 * @throws productIsNotExistException 
	 */
	public Vector<String> searchProNameBySupplieName(String supplieName) throws ReturnProductMsgDaoException, productIsNotExistException;
	
	/**
	 * 根据商品名称查询库存信息
	 * @throws ReturnProductMsgDaoException 
	 * @throws stockIsNotException 
	 */
	public  Vector<String> searchStrockInfoByProName(String proName) throws ReturnProductMsgDaoException, stockIsNotException;
}
