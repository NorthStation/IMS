package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.entity.InStorageReturnDetailOrder;
import com.lms.zx.entity.InStorageReturnOrder;

import com.lms.zx.exception.instorage.InStorageReturnDaoException;
/**
 * IinStorageReturnDao������˻����ݷ��ʲ�ӿ�
 * @author Administrator
 *
 */
public interface IinStorageReturnDao {
	/*
	 * insertReturnMsg����������˻�����
	 * @param order ����˻����������굥���ϣ�
	 */
	public void insertReturnMsg(InStorageReturnOrder order) throws  InStorageReturnDaoException;
	
	/*
	 * queryOrderMsgBySid:��������˻�Ʊ�Ų�ѯ����˻�������Ϣ
	 * @param sId ����˻�Ʊ��
	 * @return Vector<Vector<String>> ����˻�������
	 */
	public Vector<Vector<String>> queryOrderMsgBySid(String sId) throws InStorageReturnDaoException;
	
	/*
	 * queryOrderDetailMsgBySid:��������˻�Ʊ�Ų�ѯ�˻�������ϸ��Ϣ
	 * @param sId ����˻�Ʊ��
	 * @return Vector<Vector<String>> ����˻��굥����
	 */
	public Vector<Vector<String>> queryOrderDetailMsgBySid(String sId) throws InStorageReturnDaoException;
	
	/*
	 * updateStock: ���¿��
	 * @param con ���ݿ����ӣ�ͬ������
	 * @param details ����˻��굥����
	 */
	public void updateStock(Connection con,ArrayList<InStorageReturnDetailOrder> details)throws InStorageReturnDaoException;
	
	
}
