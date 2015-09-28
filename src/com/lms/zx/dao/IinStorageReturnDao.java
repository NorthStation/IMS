package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.entity.InStorageReturnDetailOrder;
import com.lms.zx.entity.InStorageReturnOrder;

import com.lms.zx.exception.instorage.InStorageReturnDaoException;
/**
 * IinStorageReturnDao：入库退货数据访问层接口
 * @author Administrator
 *
 */
public interface IinStorageReturnDao {
	/*
	 * insertReturnMsg：生成入库退货订单
	 * @param order 入库退货单（包含详单集合）
	 */
	public void insertReturnMsg(InStorageReturnOrder order) throws  InStorageReturnDaoException;
	
	/*
	 * queryOrderMsgBySid:根据入库退货票号查询入库退货订单信息
	 * @param sId 入库退货票号
	 * @return Vector<Vector<String>> 入库退货单集合
	 */
	public Vector<Vector<String>> queryOrderMsgBySid(String sId) throws InStorageReturnDaoException;
	
	/*
	 * queryOrderDetailMsgBySid:根据入库退货票号查询退货订单详细信息
	 * @param sId 入库退货票号
	 * @return Vector<Vector<String>> 入库退货详单集合
	 */
	public Vector<Vector<String>> queryOrderDetailMsgBySid(String sId) throws InStorageReturnDaoException;
	
	/*
	 * updateStock: 更新库存
	 * @param con 数据库连接，同步事务
	 * @param details 入库退货详单集合
	 */
	public void updateStock(Connection con,ArrayList<InStorageReturnDetailOrder> details)throws InStorageReturnDaoException;
	
	
}
