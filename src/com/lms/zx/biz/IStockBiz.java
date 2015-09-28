package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockNotFoundProduct;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;

public interface IStockBiz {
	/*
	 * ���ݿ����Ʒ�����ƣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * @param proName �����Ʒ������
     *@return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockNotFoundProduct, StockingDAOException;
	/*
	 * ���ݿ����Ʒ�����ͣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * @param genre �����Ʒ������
	 *@return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockNotFoundProduct, StockingDAOException;
	/*
	 * ��ѯ�����е�������Ʒ����Ϣ
	 * @return Vector<Vector<String>> �������е���Ʒ����Ϣ
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingNotFoundProductException, StockingDAOException;
}
