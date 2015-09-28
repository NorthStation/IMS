package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.factory.GetInstance;

 
/**
 * ������Ϣ��ѯ
 */
public class StorageInfoInquiryContext {
	/**
	 * �������Ʊ�Ų�ѯ������Ϣ��֧��ģ����ѯ
	 *@param orderId ��ⶩ��Ʊ��
	 *@return 
	 *@return Vector<Vector<String>>
	 * @throws ReturnOrderIsMotExistException 
	 */
	public Vector<Vector<String>> queryOrderMsg(String orderId) throws ReturnOrderIsMotExistException {
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		return inStorageManagerBiz.searchOrderMsgByOid(orderId);
	}
	/**
	 * �������Ʊ�Ų�ѯ������ϸ�� 
	 *@param orderId  ���Ʊ��
	 *@return 
	 *@return Vector<Vector<String>>
	 */
	public Vector<Vector<String>> queryOrderDetailMsg(String orderId) {
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		return inStorageManagerBiz.searchOrderDetailMsgByOid(orderId);
	}
	
}
