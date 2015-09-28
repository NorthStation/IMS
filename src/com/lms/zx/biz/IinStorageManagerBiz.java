package com.lms.zx.biz;


import java.util.Vector;


import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.entity.InStorageReturnOrder;

import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;

//������
public interface IinStorageManagerBiz {
	
	/*
	 * addProductInfo��������ⵥ��¼
	 * @param order ��ⵥ�������굥��
	 */
	public void addOrderProductInfo(InStorageOrder order) throws  InStorageDaoException;

	/*
	 * searchOrderMsgByOid���������Ʊ�Ų�ѯ��ⵥ��Ϣ��ģ����ѯ
	 * @param orderId ���Ʊ��
	 * @return Vector<Vector<String>> ��ⵥ����
	 */
	public Vector<Vector<String>> searchOrderMsgByOid(String orderId) throws ReturnOrderIsMotExistException;
	/*
	 * searchOrderDetailMsgByOid���������Ʊ�Ų�ѯ����굥��Ϣ
	 * @param orderId ���Ʊ��
	 * @return Vector<Vector<String>> ����굥����
	 */
	
	public Vector<Vector<String>> searchOrderDetailMsgByOid(String orderId);
	/*
	 * insertReturnMsg����������˻�����
	 * @param order ����˻����������굥���ϣ�
	 */
	
	public void addReturnMsg(InStorageReturnOrder order) throws  InStorageReturnDaoException;
	
	/*
	 * searchOrderReturnBySid����������˻�Ʊ�Ų�ѯ����˻�����Ϣ��ģ����ѯ
	 * @param sId ���Ʊ��
	 * @return Vector<Vector<String>> ��ⵥ����
	 */
	public Vector<Vector<String>>  searchOrderReturnBySid(String sId) throws ReturnOrderIsMotExistException, InStorageReturnDaoException;
	/*
	 * searchOrderDetailReturnBySid:��������˻�Ʊ�Ų�ѯ�˻�������ϸ��Ϣ
	 * @param sId ����˻�Ʊ��
	 * @return Vector<Vector<String>> ����˻��굥����
	 */
	
	public Vector<Vector<String>>  searchOrderDetailReturnBySid(String sId) throws InStorageReturnDaoException;
}
