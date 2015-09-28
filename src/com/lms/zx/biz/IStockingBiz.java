package com.lms.zx.biz;

import java.util.List;
import java.util.Vector;

import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.exception.stock.StockingUpdateFailException;


public interface IStockingBiz {
	/*
	 * ���ݿ����Ʒ��id���¿����Ʒ������
	 * @param lists���������id�Ϳ�������ļ���
	 */
	public void updateStock(List<int[]> lists) throws StockingDAOException, StockingUpdateFailException;
	/*
	 * ��ÿ������������
	 * @return Vector �������п����Ϣ��Vector����
	 * �׳�DAOException��StockingNotFoundException�쳣
	 */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException, StockingNotFoundException;
	/*
	 * ͳ�ƿ���ļ�¼�����ͻ�Ʒ����
	 * @return Vector ������¼�����ͻ�Ʒ�����ļ���
	 * �׳�DAOException��StockingNotExistException�쳣
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException, StockingNotExistException;
	/*
	 * ��ѯ�����е�������Ʒ����
	 * @return  Vector ����������Ʒ���Ƶ�Vector����
	 * �׳�DAOException��StockingBizException�쳣
	 */
	public Vector<String> searchAllPname()throws StockingDAOException,StockingNotFoundProductException;
	/*
	 * ������Ʒ����ѯ�����Ʒ��Ϣ
	 * @param pname ��Ʒ��
	 * @return Vector ������Ʒ��Ϣ��һ��Vector����
	 * �׳�DAOException��StockingNotExistException�쳣
	 */
	public Vector searchProductByPname(String pname) throws StockingDAOException,StockingNotExistException;
}
