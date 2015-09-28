package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.InStorageDetailOrder;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.exception.instorage.InStorageDaoException;

/**
 * IinStorageDao��������ݷ��ʲ�ӿ�
 * @author ����
 *
 */
public interface IinStorageDao {
	/*
	 * addProductInfo��������ⵥ��¼
	 * @param order ��ⵥ�������굥��
	 */
	public void addProductInfo(InStorageOrder order) throws InStorageDaoException;
	
	/*
	 * queryOrderMsgByOid���������Ʊ�Ų�ѯ��ⵥ��Ϣ��ģ����ѯ
	 * @param orderId ���Ʊ��
	 * @return Vector<Vector<String>> ��ⵥ����
	 */
	public Vector<Vector<String>> queryOrderMsgByOid(String orderId);
	
	/*
	 * queryOrderDetailMsgByOid���������Ʊ�Ų�ѯ����굥��Ϣ
	 * @param orderId ���Ʊ��
	 * @return Vector<Vector<String>> ����굥����
	 */
	public Vector<Vector<String>> queryOrderDetailMsgByOid(String orderId);
	
	/*
	 * addProductToStock�����¿��
	 * @param con ���ݿ����ӣ�ͬ������
	 * @param details �굥����
	 */
	public void addProductToStock(Connection con,ArrayList<InStorageDetailOrder> details) throws InStorageDaoException;
}
