package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;

 

/**
 * ���۳����ѯҳ�������
 * @author logan
 *
 */
public class SalesQueryContext {
 
   /**
    * �������۵��Ų�ѯ
    * @param saleNum
    * @return
 * @throws SalesDaoException 
 * @throws SearchDetailIdFailedException 
    */
	public Vector<Vector<String>> findSales(String saleNum) throws SearchDetailIdFailedException, SalesDaoException {
		//�������۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���۳��ⵥ
		return biz.searchSalesBySid(saleNum);
	}
    /**
     * ��ѯ����������Ϣ
     * @return
     * @throws SalesDaoException 
     * @throws SearchDetailIdFailedException 
     */
	public Vector<Vector<String>> findSalesAll() throws SearchDetailIdFailedException, SalesDaoException {
		//�������۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���е����۳��ⵥ
		return biz.searchAllSales();
	}
	/**
	 * ɾ��������Ϣ
	 * @param proName
	 * @return
	 */
	public boolean deleteSalesOrder(String proName) {
		return false;
	}
	/**
	 * ���ݶ����Ų�ѯ������Ʒ��Ϣ
	 * @throws SearchDetailIdFailedException 
	 * @throws SalesDaoException 
	 */
	public Vector<Vector<String>> showDataToSalesQueryDetail(String saleNum) throws SalesDaoException, SearchDetailIdFailedException {
		//�������۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//��ȡ���۳����굥��Ϣ����
		return biz.searchSalesDetailOrderBySid(saleNum);
	}

}
