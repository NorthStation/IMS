package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.SalesReturnDetailOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesDaoException;

/**
 * ISalesReturnDao�������˻����ݷ��ʲ�ӿ�
 * @author ������
 */
public interface ISalesReturnDao {
	/*
	 * insertSalesReturnOrder�����������˻�����Ϣ
	 * @param order �����˻���
	 */
	public void insertSalesReturnOrder(SalesReturnOrder order) throws SalesDaoException;
	
	/*
	 * insertSalesReturnDetailOrder: ���������˻��굥��Ϣ
	 * @param con ���ݿ����Ӷ���Ϊ��ͬ������
	 * @param detail �����˻��굥
	 */
	public void insertSalesReturnDetailOrder(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException;
	
	/*
	 * updateStock: ���¿��
	 * @param con ���ݿ����Ӷ���Ϊ��ͬ������
	 * @param detail �����˻��굥
	 */
	public void updateStock(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException;
	
	/*
	 * querySalesReturnDetailOrderBySid�����������˻�Ʊ�Ų�ѯ�����˻��굥
	 * @param salesReturnId �����˻�Ʊ��
	 * @return Vector<Vector<String>> �����˻��굥 
	 */
	public Vector<Vector<String>> querySalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException;
	
	/*
	 * querySalesReturnOrderBySid�����������˻�Ʊ�Ų�ѯ�����˻���
	 * @param salesReturnId �����˻�Ʊ��
	 * @return Vector<Vecotr<String>> �����˻���
	 */
	public Vector<Vector<String>> querySalesReturnOrderBySid(String salesReturnId) throws SalesDaoException;
	
	/*
	 * queryAllSalesReturnOrder����ѯ���������˻�����Ϣ
	 * @return Vector<Vector<String>> �����˻�������
	 */
	public Vector<Vector<String>> queryAllSalesReturnOrder() throws SalesDaoException;
}
