package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.factory.GetInstance;

 
/**
 * ����˻���ѯ
 */
public class InStoreBackToolsQueryContext {
	/**
	 * ������ⶩ����ѯ��Ϣ
	 *@param sId  ��ⶩ��
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
   * ����ѡ�����ⶩ����ѯ��������
   *@param sId
   *@return 
   *@return Vector<Vector<String>>
 * @throws InStorageReturnDaoException 
   */
  public Vector<Vector<String>> queryReturnDetailMsg(String sId) throws InStorageReturnDaoException{
	  //��������
	  IinStorageManagerBiz inStorageManagerBizImpl=GetInstance.getInStorageManagerBizImpl();
	  	
	  return inStorageManagerBizImpl.searchOrderDetailReturnBySid(sId);
  }
}
