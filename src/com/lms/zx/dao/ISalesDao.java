package com.lms.zx.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.sales.SalesDaoException;

/**
 * ISalesDao�����۳������ݷ��ʲ�ӿ�
 * @author Administrator
 *
 */
public interface ISalesDao {
	/*
	 * insertSalesOrder���������۳����¼
	 * @param order ���۳��ⶩ���������굥��Ϣ��
	 */
	public void insertSalesOrder(SalesOrder order) throws SalesDaoException;
	
	/*
	 * insertStock�����¿��
	 * @param con ���ݿ����ӣ�����ͬ������
	 * @param detailOrder ���۳����굥��Ϣ
	 */
	public void insertStock(Connection con, ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException;
	
	/*
	 * insertSalesDetailOrder���������۳����굥��¼
	 * @param con ���ݿ����ӣ�����ͬ������
	 * @param detailOrder ���۳����굥��Ϣ
	 */
	public void insertSalesDetailOrder(Connection con,ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException;
	
	/*
	 * updateStockByPname��ͨ����Ʒ���Ƹ��¿������
	 * @param proName ��Ʒ����
	 * @param amount ʵ�ʿ������
	 */
	public void updateStockByPname(String proName,int amount) throws SalesDaoException;
	
	/*
	 * querySalesDetailOrderBySid��ͨ�����۳���Ʊ�Ų�ѯ���۳����굥��Ϣ������������Ʊ����Ϣ
	 * @param sid ���۳���Ʊ��
	 * @return Vector<Vector<String>> ���۳����굥����
	 */
	public Vector<Vector<String>> querySalesDetailOrderBySid(String sid) throws SalesDaoException;
	
	/*
	 * queryAllSales����ѯ���е����۳��ⶩ����Ϣ
	 * @return Vector<Vector<String>> ���۳��ⶩ������
	 */
	public Vector<Vector<String>> queryAllSales() throws SalesDaoException;
	
	/*
	 * querySalesBySid���������۳��ⶩ��Ʊ�Ų�ѯ���۳��ⶩ����Ϣ
	 * @param sid ���۳��ⶩ��Ʊ��
	 * @return Vector<Vector<String>> ���۳��ⶩ������
	 */
	public Vector<Vector<String>> querySalesBySid(String sid) throws SalesDaoException;
	
	/*
	 * queryStockByPid��������Ʒ��Ų�ѯ�����Ϣ
	 * @param proId ��Ʒ���
	 * @return Stock �����Ϣ
	 */
	public Stock queryStockByPid(long proId) throws SalesDaoException;
	
	/*
	 * queryAllSalesNumber����ѯ���е����۳���Ʊ��
	 * @return Vector<String> ���۳���Ʊ�ż���
	 */
	public Vector<String> queryAllSalesNumber() throws SalesDaoException;

	/*
	 * querySDetailOrderBySid��ͨ�����۳���Ʊ�Ų�ѯ���۳����굥��Ϣ������������Ʊ����Ϣ
	 * @param sid ���۳���Ʊ��
	 * @return Vector<Vector<String>> ���۳����굥����
	 */
	public Vector<Vector<String>> querySDetailOrderBySid(String salesNum) throws SalesDaoException;
}
