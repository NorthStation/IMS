package com.lms.zx.biz;


import java.util.Vector;


import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.entity.InStorageReturnOrder;

import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;

//入库管理
public interface IinStorageManagerBiz {
	
	/*
	 * addProductInfo：插入入库单记录
	 * @param order 入库单（包含详单）
	 */
	public void addOrderProductInfo(InStorageOrder order) throws  InStorageDaoException;

	/*
	 * searchOrderMsgByOid：根据入库票号查询入库单信息，模糊查询
	 * @param orderId 入库票号
	 * @return Vector<Vector<String>> 入库单集合
	 */
	public Vector<Vector<String>> searchOrderMsgByOid(String orderId) throws ReturnOrderIsMotExistException;
	/*
	 * searchOrderDetailMsgByOid：根据入库票号查询入库详单信息
	 * @param orderId 入库票号
	 * @return Vector<Vector<String>> 入库详单集合
	 */
	
	public Vector<Vector<String>> searchOrderDetailMsgByOid(String orderId);
	/*
	 * insertReturnMsg：生成入库退货订单
	 * @param order 入库退货单（包含详单集合）
	 */
	
	public void addReturnMsg(InStorageReturnOrder order) throws  InStorageReturnDaoException;
	
	/*
	 * searchOrderReturnBySid：根据入库退货票号查询入库退货单信息，模糊查询
	 * @param sId 入库票号
	 * @return Vector<Vector<String>> 入库单集合
	 */
	public Vector<Vector<String>>  searchOrderReturnBySid(String sId) throws ReturnOrderIsMotExistException, InStorageReturnDaoException;
	/*
	 * searchOrderDetailReturnBySid:根据入库退货票号查询退货订单详细信息
	 * @param sId 入库退货票号
	 * @return Vector<Vector<String>> 入库退货详单集合
	 */
	
	public Vector<Vector<String>>  searchOrderDetailReturnBySid(String sId) throws InStorageReturnDaoException;
}
