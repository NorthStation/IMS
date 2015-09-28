package com.lms.zx.biz.impl.stock;

import java.util.Vector;

import com.lms.zx.biz.IStockBiz;
import com.lms.zx.dao.IStockDAO;
import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.factory.StockFactory;

public class StockBizImpl implements IStockBiz{
	/*
	 * ��ѯ�����е�������Ʒ����Ϣ
	 * @return Vector<Vector<String>> �������е���Ʒ����Ϣ
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingNotFoundProductException, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����һ��dao����
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryAll();
		if(v.isEmpty()){
			throw new StockingNotFoundProductException("����������Ʒ");
		}
		return v;
	}
	/*
	 * ���ݿ����Ʒ�����ͣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * @param genre �����Ʒ������
	 *@return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����һ��dao����
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryByGenre(genre);
		if(v.isEmpty()){
			throw new StockNotFoundProduct("û���ҵ�����Ʒ");
		}
		return v;
	}
	/*
	 * ���ݿ����Ʒ�����ƣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * @param proName �����Ʒ������
     *@return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		//����һ��dao����
		IStockDAO dao=StockFactory.getStockDAOImpl();
		v=dao.queryByProductName(proName);
		if(v.isEmpty()){
			throw new StockNotFoundProduct("û���ҵ�����Ʒ");
		}
		return v;
	}
	
}
