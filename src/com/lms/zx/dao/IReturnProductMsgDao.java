package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;



public interface IReturnProductMsgDao {
	/**
	 * ���ݹ�Ӧ�̵����Ʋ�ѯ��Ʒ����
	 * 
	 * @param supplierName
	 *            ��Ӧ������
	 * @return Vector<String> ��Ʒ���Ƶļ���
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> queryStorageProductName(String supplierName) throws ReturnProductMsgDaoException;
	/**
	 * ������Ʒ���Ʋ�ѯ�����Ϣ����֧��ģ����ѯ
	 * 
	 * @param proName
	 *            ��Ʒ����
	 * @return Vector<String> �����Ϣ [�۸񣬿����������Ʒ��񣬿��id]
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> queryStorageByProName(String proName) throws ReturnProductMsgDaoException;
}
