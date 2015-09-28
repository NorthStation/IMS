package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockingDAOException;

public interface IStockDAO {
	/*
	 * ���ݿ����Ʒ�����ƣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * param proName �����Ʒ������
     *@return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockingDAOException;
	/*
	 * ���ݿ����Ʒ�����ͣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
	 * @return Vector<Vector<String>> ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockingDAOException;
	/*
	 * ��ѯ�����е�������Ʒ����Ϣ
	 * @return Vector<Vector<String>> ����������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingDAOException;
}
