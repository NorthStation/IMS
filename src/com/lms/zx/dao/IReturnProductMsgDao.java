package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;



public interface IReturnProductMsgDao {
	/**
	 * 根据供应商的名称查询商品名称
	 * 
	 * @param supplierName
	 *            供应商名称
	 * @return Vector<String> 商品名称的集合
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> queryStorageProductName(String supplierName) throws ReturnProductMsgDaoException;
	/**
	 * 根据商品名称查询库存信息，不支持模糊查询
	 * 
	 * @param proName
	 *            商品名称
	 * @return Vector<String> 库存信息 [价格，库存数量，商品规格，库存id]
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> queryStorageByProName(String proName) throws ReturnProductMsgDaoException;
}
