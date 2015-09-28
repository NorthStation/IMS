package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * �����˻���ѯ
 */
public class SalesReturnQueryContext {
    /**
     * �����˻�Ʊ�Ų�ѯ�˻���Ʒ��Ϣ
     * @param salesReturnNum �˻�Ʊ��
     * @return
     * @throws SalesReturnOrderNotFoundException 
     * @throws SalesDaoException 
     */
	 public Vector<Vector<String>> findSalesReturn(String salesReturnNum) throws SalesDaoException, SalesReturnOrderNotFoundException {
		//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		return biz.searchSalesReturnOrderBySid(salesReturnNum);
	}
	 /**
	     * ��ѯ�˻���Ʒ��Ϣ
	     * @return
	 * @throws SalesReturnOrderNotFoundException 
	 * @throws SalesDaoException 
	     */
	public Vector<Vector<String>> findSalesReturn() throws SalesDaoException, SalesReturnOrderNotFoundException {
		//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���е������˻���
		return biz.searchAllSalesReturnOrder();
	}

}
