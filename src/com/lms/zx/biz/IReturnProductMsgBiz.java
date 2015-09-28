package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;
import com.lms.zx.exception.instorage.productIsNotExistException;
import com.lms.zx.exception.instorage.stockIsNotException;



public interface  IReturnProductMsgBiz {
	/**
	 * ���ݹ�Ӧ�̵����Ʋ�ѯ��Ʒ����
	 * @throws ReturnProductMsgDaoException 
	 * @throws productIsNotExistException 
	 */
	public Vector<String> searchProNameBySupplieName(String supplieName) throws ReturnProductMsgDaoException, productIsNotExistException;
	
	/**
	 * ������Ʒ���Ʋ�ѯ�����Ϣ
	 * @throws ReturnProductMsgDaoException 
	 * @throws stockIsNotException 
	 */
	public  Vector<String> searchStrockInfoByProName(String proName) throws ReturnProductMsgDaoException, stockIsNotException;
}
