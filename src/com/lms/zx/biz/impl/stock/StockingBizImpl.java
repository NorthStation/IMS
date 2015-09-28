package com.lms.zx.biz.impl.stock;

import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.dao.IStockingDAO;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingNotFoundProductException;
import com.lms.zx.exception.stock.StockingUpdateFailException;
import com.lms.zx.factory.StockingFactory;

public class StockingBizImpl implements IStockingBiz {
	/*
	 * ��ÿ��������е�����
	 * @see com.lms.zx.biz.impl.IStockingBiz#getAllStorage()
	 */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException, StockingNotFoundException {
		//����dao����
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//��ȡ��������������
		Vector<Vector<String>> v=dao.queryAllStorage();
		//�ж�
		if(v==null){
			throw new StockingNotFoundException("��������");
		}else{
			return v;
		}
		
	}
	/*
	 * ͳ�ƿ���ļ�¼�����ͻ�Ʒ����
	 * @return list<Integer> ���ؼ�¼�����ͻ�Ʒ����
	 * @see com.lms.zx.biz.impl.IStockingBiz#queryCountMsg()
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException, StockingNotExistException {
		//��ȡdao����
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//��ȡ��¼�����ͻ�Ʒ����
		List<Integer> list=dao.queryCountMsg();
		//�ж�
		if(list.get(0)==null){
			throw new StockingNotExistException("����Ʒ������");
		}
		return list;
	}
	/*
	 * ���ݿ����Ʒ��id���¿����Ʒ������
	 * @param lists:�������id����Ʒ�����ļ���
	 * @see com.lms.zx.biz.impl.IStockingBiz#updateStock(java.lang.String, int)
	 */
	public void updateStock(List<int[]> lists) throws StockingDAOException, StockingUpdateFailException {
		//����dao����
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		dao.updateStockBySid(lists);
	}
	/*
	 * ��ѯ�����е�������Ʒ����
	 * @return Vector һ���������������Ʒ���Ƶ�Vector����
	 * @see com.lms.zx.biz.impl.IStockingBiz#searchAllPname()
	 */
	public Vector<String> searchAllPname() throws  StockingNotFoundProductException, StockingDAOException
			  {
		//����һ��Vector����
		Vector<String> v=new Vector<String>();
		//����dao����
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//��ȡ���ص���Ϣ
		v=dao.queryAllPname();
		//�ж�
		if(v==null){
			throw new StockingNotFoundProductException("����������Ʒ");
		}
		return v;
	}
	/*
	 * ������Ʒ���Ʋ�ѯ�����Ʒ��Ϣ
	 * @param pname:��Ʒ����
	 * @return Vector:����һ��������Ʒ��Ϣ�Ķ���
	 * @see com.lms.zx.biz.impl.IStockingBiz#searchProductByPname(java.lang.String)
	 */
	public Vector<String> searchProductByPname(String pname) throws 
			 StockingNotExistException, StockingDAOException {
		//����һ��Vector����
		Vector<String> v=new Vector<String>();
		//����dao����
		IStockingDAO dao=StockingFactory.getStockingDaoImpl();
		//��ȡ��Ʒ��Ϣ
		v=dao.queryProductByPname(pname);
		//�ж�
		if(v.size()==0){
			throw new StockingNotExistException("����Ʒ������");
		}
		//����
		return v;
	}

	
	
}
