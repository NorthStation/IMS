package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.factory.GetInstance;

 
/**
 * 入库存信息查询
 */
public class StorageInfoInquiryContext {
	/**
	 * 根据入库票号查询订单信息，支持模糊查询
	 *@param orderId 入库订单票号
	 *@return 
	 *@return Vector<Vector<String>>
	 * @throws ReturnOrderIsMotExistException 
	 */
	public Vector<Vector<String>> queryOrderMsg(String orderId) throws ReturnOrderIsMotExistException {
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		return inStorageManagerBiz.searchOrderMsgByOid(orderId);
	}
	/**
	 * 根据入库票号查询订单详细表 
	 *@param orderId  入库票号
	 *@return 
	 *@return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> queryOrderDetailMsg(String orderId) {
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		return inStorageManagerBiz.searchOrderDetailMsgByOid(orderId);
	}
	
}
