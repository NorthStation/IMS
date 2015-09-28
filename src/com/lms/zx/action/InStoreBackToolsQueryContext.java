package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.factory.GetInstance;

 
/**
 * 入库退货查询
 */
public class InStoreBackToolsQueryContext {
	/**
	 * 根据入库订单查询信息
	 *@param sId  入库订单
	 *@return 
	 *@return Vector<Vector<String>>
	 * @throws ReturnOrderIsMotExistException 
	 * @throws InStorageReturnDaoException 
	 */
  public Vector<Vector<String>> queryReturnMsg(String sId) throws ReturnOrderIsMotExistException, InStorageReturnDaoException{
	 IinStorageManagerBiz inStorageManagerBizImpl=GetInstance.getInStorageManagerBizImpl();
	 Vector<Vector<String>> data=new Vector<Vector<String>>();
	 data=inStorageManagerBizImpl.searchOrderReturnBySid(sId);
	 
	return data;
  }
  /**
   * 根据选择的入库订单查询订单详情
   *@param sId
   *@return 
   *@return Vector<Vector<String>>
 * @throws InStorageReturnDaoException 
   */
  public Vector<Vector<String>> queryReturnDetailMsg(String sId) throws InStorageReturnDaoException{
	  //创建对象
	  IinStorageManagerBiz inStorageManagerBizImpl=GetInstance.getInStorageManagerBizImpl();
	  	
	  return inStorageManagerBizImpl.searchOrderDetailReturnBySid(sId);
  }
}
