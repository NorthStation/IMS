package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * �����˻���ϸ��Ϣ
 */
public class SalesReturnInfoDetailContext {
       /**
	 * �����˻����Ų�ѯ�˻���Ϣ
	 * param saleNum �����˻�����
     * @throws SalesReturnDetailNotFoundException 
     * @throws SalesDaoException 
	 */
    public Vector<Vector<String>> showDataToSalesReturnQueryDetail(
			String saleNum) throws SalesDaoException, SalesReturnDetailNotFoundException {
    	//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ�����˻��굥��Ϣ
		return biz.searchSalesReturnDetailOrderBySid(saleNum);
	}
}
