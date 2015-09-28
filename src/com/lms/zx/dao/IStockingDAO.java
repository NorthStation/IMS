package com.lms.zx.dao;

import java.util.List;
import java.util.Vector;

import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.stock.StockingDAOException;


public interface IStockingDAO {
	/*
	 * ���ݿ��id���¿����
	 * @param lists:����id�������ļ���
	 * @return int �������ݿ�����Ӱ�������
	 */
	public void updateStockBySid(List<int[]> lists) throws StockingDAOException;
	/*
	 * ͳ�ƿ����еļ�¼�����ͻ�Ʒ����
	 * @return Vector ����һ��������¼�����ͻ�Ʒ�����ļ���
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException;
	/*
	 * ��ȡ�����е���������
	 * @return Vector ����һ���������п����Ϣ��Vector����
	 */
	public Vector<Vector<String>> queryAllStorage() throws StockingDAOException; 
	/*
	 * ������Ʒ����ѯ�����Ʒ��Ϣ
	 * @return Vector ���ذ�����Ʒ��Ϣ��Vector����
	 */
	public Vector queryProductByPname(String pname) throws StockingDAOException;
	/*
	 * ��ѯ�����е�������Ʒ����
	 * @return Vector ���ذ���������������Ʒ�����Ƶ�Vector����
	 */
	public Vector<String> queryAllPname() throws StockingDAOException;
}
