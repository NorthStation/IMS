package com.lms.zx.action;

import java.util.Vector;


import com.lms.zx.biz.IReturnProductMsgBiz;
import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;
import com.lms.zx.exception.instorage.productIsNotExistException;
import com.lms.zx.exception.instorage.stockIsNotException;
import com.lms.zx.factory.ReturnProductMsgFactory;

 

/**
 * ��Ʒ�˻�����Ϣ
 */
public class ReturnProductMsgConext {
	/**
	 * ���ݹ�Ӧ�̵����Ʋ�ѯ��Ʒ����
	 * 
	 * @param supplierName
	 *            ��Ӧ������
	 * @return Vector<String> ��Ʒ���Ƶļ���
	 * @throws productIsNotExistException 
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> getStorageProductName(String supplierName) throws ReturnProductMsgDaoException, productIsNotExistException {
		Vector<String> ss=new Vector<String>();
		IReturnProductMsgBiz returnProductMsgBizImpl=ReturnProductMsgFactory.getReturnProductMsgBizImpl();
		ss=returnProductMsgBizImpl.searchProNameBySupplieName(supplierName);
		return ss;
	}

	/**
	 * ������Ʒ���Ʋ�ѯ�����Ϣ����֧��ģ����ѯ
	 * 
	 * @param proName
	 *            ��Ʒ����
	 * @return Vector<String> �����Ϣ [�۸񣬿����������Ʒ��񣬿��id]
	 * @throws stockIsNotException 
	 * @throws ReturnProductMsgDaoException 
	 */
	public Vector<String> getStorageByProName(String proName) throws ReturnProductMsgDaoException, stockIsNotException {
		IReturnProductMsgBiz returnProductMsgBizImpl=ReturnProductMsgFactory.getReturnProductMsgBizImpl();
		return returnProductMsgBizImpl.searchStrockInfoByProName(proName);
	}
}
