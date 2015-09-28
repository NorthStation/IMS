 package com.lms.zx.action;


import java.util.Vector;

import com.lms.zx.biz.IStockBiz;
import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.StockFactory;

 
 

/** ������ */
public class StorageContext {
     /**
     * ���ݿ����Ʒ�����ƣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
     *@param proName �����Ʒ������
     *@return Vector<Vector<String>>
     * @throws StockNotFoundProduct 
     * @throws StockDAOException 
     * @throws StockingDAOException 
     */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		//����һ��Vector����
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����biz����
		IStockBiz biz= StockFactory.getStockBizImpl();
		//����biz�Ĳ�ѯ����	
		v=biz.queryByProductName(proName);
		//����
		return v;
		}
	
	
	/**
	 * ���ݿ����Ʒ�����ͣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 *@param genre  �����Ʒ������
	 *@return Vector<Vector<String>>
	 * @throws StockNotFoundProduct 
	 * @throws StockDAOException 
	 * @throws StockingDAOException 
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		//����һ��Vector����
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����һ��biz����
		IStockBiz biz= StockFactory.getStockBizImpl();
		//����biz�ķ���
		v=biz.queryByGenre(genre);
		//����
		return v;
	}
	
	/**
	 * ��ѯ�����е�������Ʒ����Ϣ
	 *@return 
	 *@return Vector<Vector<String>>
	 * @throws StockingNotFoundProductException 
	 * @throws StockDAOException 
	 * @throws StockingDAOException 
	 */
	public Vector<Vector<String>> queryAll( ) throws StockDAOException, StockingNotFoundProductException, StockingDAOException {
		//����һ��Vector����
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����һ��Biz����
		IStockBiz biz= StockFactory.getStockBizImpl();
		//����biz�ķ���
		v=biz.queryAll();
		//����
		return v;
	}
	 

}
