package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.InStorageDetailOrder;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.exception.instorage.InStorageDaoException;

/**
 * IinStorageDao：入库数据访问层接口
 * @author 陈琼
 *
 */
public interface IinStorageDao {
	/*
	 * addProductInfo：插入入库单记录
	 * @param order 入库单（包含详单）
	 */
	public void addProductInfo(InStorageOrder order) throws InStorageDaoException;
	
	/*
	 * queryOrderMsgByOid：根据入库票号查询入库单信息，模糊查询
	 * @param orderId 入库票号
	 * @return Vector<Vector<String>> 入库单集合
	 */
	public Vector<Vector<String>> queryOrderMsgByOid(String orderId);
	
	/*
	 * queryOrderDetailMsgByOid：根据入库票号查询入库详单信息
	 * @param orderId 入库票号
	 * @return Vector<Vector<String>> 入库详单集合
	 */
	public Vector<Vector<String>> queryOrderDetailMsgByOid(String orderId);
	
	/*
	 * addProductToStock：更新库存
	 * @param con 数据库连接，同步事务
	 * @param details 详单集合
	 */
	public void addProductToStock(Connection con,ArrayList<InStorageDetailOrder> details) throws InStorageDaoException;
}
