package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;
 

/**
 * �����˻�ҳ�������
 */
public class SalesReturnInfoContext {
	 
	 
	/**
	 * ���ݶ�����Ų�ѯ��Ʒ��Ϣ��ʾ�������
	 * 
	 * @param salesNum
	 *            �������
	 * @return
	 * @throws SalesDaoException 
	 * @throws SearchDetailIdFailedException 
	 */
	public Vector<Vector<String>> showDataToTable(String salesNum) throws SearchDetailIdFailedException, SalesDaoException {
		//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���۳����굥��Ϣ
		return biz.seaSalesDetailOrderBySid(salesNum);
	}
	/**
	 * ����������ʾ��������
	 * @throws SalesDaoException 
	 * 
	 */
	public Vector<String> showDataToJCM() throws SalesDaoException {
		//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���۳���Ʊ��
		return biz.searchAllSalesNumber();
	}
}
