package com.lms.zx.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IStockingBiz;
import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.exception.stock.StockingNotExistException;
import com.lms.zx.exception.stock.StockingNotFoundException;
import com.lms.zx.exception.stock.StockingUpdateFailException;
import com.lms.zx.factory.StockingFactory;

 

/**����̵�*/
public class StockingContext {
	   
	/**
	 * ���ݿ����Ʒ��id���¿����Ʒ������
	 *@param lists  ��һ������Ϊ �����Ʒ���������ڶ�������Ϊ�����Ʒ��id 
	 *@return void
	 * @throws DAOException 
	 * @throws StockingUpdateFailException 
	 */
	public void saveBatchDatas(List<int[]> lists) throws StockingDAOException,StockingUpdateFailException{
		//����biz����
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//����biz��updateStock����
		biz.updateStock(lists);
	}
	
	/** ��ÿ������������
	 * @throws DAOException 
	 * @throws StockingNotFoundException */
	public Vector<Vector<String>> getAllStorage() throws StockingDAOException,  StockingNotFoundException{
		//����biz����
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//����biz��getAllStorage�����������շ���ֵ
		Vector<Vector<String>> v=biz.getAllStorage();
		//����
		return v;
   }
   /**
    * ͳ�ƿ���ļ�¼�����ͻ�Ʒ����
    * @return List<Integer> ���ؼ�¼��������Ʒ����
 * @throws DAOException 
 * @throws StockingNotExistException 
    */
	public List<Integer> getCountMsg() throws StockingDAOException, StockingNotExistException{
		//���ù�������biz����
		IStockingBiz biz=StockingFactory.getStockingBizImpl();
		//����һ��Arraylist����
		List<Integer> s=new ArrayList<Integer>();
		//����biz��queryCountMsg�����������շ���ֵ
		s=biz.queryCountMsg();
		//����
		return s;
	}
     
}
