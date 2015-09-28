package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;

/**
 * ISalesManagerBizImpl�����۹�����߼����ʲ�ӿ�
 * @author ������
 *
 */
public interface ISalesManagerBiz {
	/*
	 * addSalesOrder��������ۼ�¼
	 * @param order ���۳��ⶩ���������굥��Ϣ��
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean addSalesOrder(SalesOrder order) throws  StockAmountIsLackedException, SalesIsFailedException, SalesDaoException;

	/*
	 * updateStock��������Ʒ���Ƹ��¿������
	 * @param proName ��Ʒ����
	 * @param number �������
	 */
	public void updateStock(String proName,int number) throws SalesDaoException;

	/*
	 * searchSalesDetailOrderBySid���������۳���Ʊ�Ų�ѯ���۳����굥��Ϣ(������Ʊ����Ϣ)
	 * @param sid ���۳���Ʊ��
	 * @return Vector<Vector<String>> ���۳����굥���� 
	 */
	public Vector<Vector<String>> searchSalesDetailOrderBySid(String sid) throws SalesDaoException, SearchDetailIdFailedException;
	
	/*
	 * searchAllSales����ѯ�������۶�����Ϣ
	 * @return Vector<Vector<String>> ���۶�������
	 */
	public Vector<Vector<String>> searchAllSales() throws SearchDetailIdFailedException, SalesDaoException;
	
	/*
	 * searchSalesBySid���������۳���Ʊ�Ų�ѯ���۳��ⶩ��
	 * @param sid ���۳���Ʊ��
	 * @return Vector<Vector<String>> ���۳��ⶩ������
	 */
	public Vector<Vector<String>> searchSalesBySid(String sid) throws SearchDetailIdFailedException, SalesDaoException;
	
	/*
	 * searchAllSalesNumber����ѯ�������۳���Ʊ��
	 * @return Vector<String> ���۳���Ʊ�ż���
	 */
	public Vector<String> searchAllSalesNumber() throws SalesDaoException;
	
	/*
	 * searchAllSalesReturnOrder����ѯ���������˻�����Ϣ
	 * @return Vector<Vector<String>> �����˻�������
	 */
	public Vector<Vector<String>> searchAllSalesReturnOrder() throws SalesDaoException, SalesReturnOrderNotFoundException;
	
	/*
	 * addSalesReturnOrder: ��������˻�����Ϣ
	 * @param order �����˻��������������˻��굥��
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean addSalesReturnOrder(SalesReturnOrder order) throws SalesReturnIsFailedException;
	
	/*
	 * searchSalesReturnDetailOrderBySid: ���������˻�Ʊ�Ų�ѯ�����˻��굥
	 * @param salesReturnId �����˻�Ʊ��
	 * @return Vector<Vector<String> �����˻��굥����
	 */
	public Vector<Vector<String>> searchSalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnDetailNotFoundException;
	
	/*
	 * searchSalesReturnOrderBySid�����������˻�Ʊ�Ų�ѯ�����˻���
	 * @param salesReturnId �����˻�Ʊ��
	 * @return Vector<Vector<String> �����˻������� 
	 */
	public Vector<Vector<String>> searchSalesReturnOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnOrderNotFoundException;
	
	/*
	 * seaSalesDetailOrderBySid���������۳���Ʊ�Ų�ѯ���۳����굥��Ϣ(��������Ʊ����Ϣ)
	 * @param sid ���۳���Ʊ��
	 * @return Vector<Vector<String>> ���۳����굥���� 
	 */
	public Vector<Vector<String>> seaSalesDetailOrderBySid(String salesNum)throws SalesDaoException, SearchDetailIdFailedException;
}
