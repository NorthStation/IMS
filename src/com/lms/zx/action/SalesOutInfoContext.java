package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductNotFoundException;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.SalesFactory;
import com.lms.zx.factory.StockingFactory;

 
/**
 *���۳�����Ϣ���
 *<h1>ע��</h1>:�����۳���Ľ��棬¼����Ϣʱ����Ҫʵ��findProductName����
 */
public class SalesOutInfoContext {
 	/**
	 * ������Ʒ���Ʋ�ѯ��Ʒ��Ϣ
	 * @param proName  ��Ʒ����
	 * @return
 	 * @throws StockingNotExistException 
 	 * @throws StockingDAOException 
 	 * @throws ProductDaoException 
 	 * @throws ProductNotFoundException 
	 */
	public Vector<String> findProduct(String proName) throws StockingDAOException, StockingNotExistException {
		//�����������߼������
		IStockingBiz biz = StockingFactory.getStockingBizImpl();
		//��ȡ��Ʒ��Ϣ
		return biz.searchProductByPname(proName);
	}
	/**
	 * ��ѯ�����Ʒ����
	 * @return 
	 * @throws StockingNotFoundProductException 
	 * @throws StockingDAOException 
	 */
   public  Vector<String> findProductName() throws StockingDAOException, StockingNotFoundProductException{
	 //�����������߼������
	   IStockingBiz biz = StockingFactory.getStockingBizImpl();
	 //��ȡ��Ʒ���Ƽ���
	 return biz.searchAllPname();
   }
   /**
    * ���¿�������Ʒ��Ϣ
    * @param proName
    * @param num
 * @throws SalesDaoException 
 * @throws NumberFormatException 
    */
	public void update(String proName, String num) throws NumberFormatException, SalesDaoException {
        //�������۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//���¿��
		biz.updateStock(proName, Integer.parseInt(num));
	}
}
