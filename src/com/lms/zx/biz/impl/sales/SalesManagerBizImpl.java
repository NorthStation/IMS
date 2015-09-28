package com.lms.zx.biz.impl.sales;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.dao.ISalesDao;
import com.lms.zx.dao.ISalesReturnDao;
import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.SalesReturnDetailNotFoundException;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.exception.sales.SalesReturnOrderNotFoundException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;
import com.lms.zx.exception.sales.SearchDetailIdFailedException;
import com.lms.zx.factory.SalesFactory;

/**
 * SalesManagerBizImpl�����۹����߼���ʵ����
 * @author ������
 *
 */
public class SalesManagerBizImpl implements ISalesManagerBiz{
	//������ۼ�¼
	public boolean addSalesOrder(SalesOrder order) throws  StockAmountIsLackedException, SalesIsFailedException, SalesDaoException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ�����굥����
		ArrayList<SalesDetailOrder> details = order.getDetailOrders();
		//ѭ���ж���Ʒ��������Ƿ����
		for(int i=0;i<details.size();i++) {
			//��ȡ���۳�����Ʒ�ı��
			long proId = details.get(i).getProId();
			//��ȡ���۳�����Ʒ�ĳ�����
			int number = details.get(i).getAmount();
			//��ȡ�����Ϣ
			Stock stock = dao.queryStockByPid(proId);
			//�жϿ�����Ƿ����
			if(number > stock.getAmount() || stock.getAmount()==0) {
				throw new StockAmountIsLackedException(stock.getProName() + "�Ŀ����������");
			}
		}
		try {
			//�������ۼ�¼
			dao.insertSalesOrder(order);
		} catch (SalesDaoException e) {
			e.printStackTrace();
			throw new SalesIsFailedException("���۳���ʧ��");
		}
		return true;
	}
	
	//���¿��
	public void updateStock(String proName,int number) throws SalesDaoException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//���¿��
		dao.updateStockByPname(proName, number);
	}
	
	//�������۳���Ʊ�Ų�ѯ���۳����굥������������Ʊ����Ϣ
	public Vector<Vector<String>> searchSalesDetailOrderBySid(String sid) throws SalesDaoException, SearchDetailIdFailedException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ�굥
		Vector<Vector<String>> details = dao.querySalesDetailOrderBySid(sid);
		//�ж��굥�Ƿ����
		if(details.size() == 0) {
			throw new SearchDetailIdFailedException("��ѯ���۳����굥ʧ��");
		}
		return details;
	}
	
	//��ѯ�������۳��ⶩ����Ϣ
	public Vector<Vector<String>> searchAllSales() throws SearchDetailIdFailedException, SalesDaoException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ����
		Vector<Vector<String>> orders = dao.queryAllSales();
		//�ж϶����Ƿ����
		if(orders.size() == 0) {
			throw new SearchDetailIdFailedException("�������۳��ⶩ����Ϣ");
		}
		return orders;
	}
	
	//�������۳���Ʊ�Ų�ѯ���۳��ⶩ��
	public Vector<Vector<String>> searchSalesBySid(String sid) throws SearchDetailIdFailedException, SalesDaoException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ����
		Vector<Vector<String>> order = dao.querySalesBySid(sid);
		//�ж϶����Ƿ����
		if(order.size() == 0) {
			throw new SearchDetailIdFailedException("��ѯ���۳��ⶩ����Ϣʧ��");
		}
		return order;
	}
	
	//��ѯ�������۳���Ʊ��
	public Vector<String> searchAllSalesNumber() throws SalesDaoException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ���۳���Ʊ�ż���
		Vector<String> salesIds = dao.queryAllSalesNumber();
		return salesIds;
	}
	
	//��ѯ���������˻���
	public Vector<Vector<String>> searchAllSalesReturnOrder() throws SalesDaoException, SalesReturnOrderNotFoundException {
		//���������˻����ݷ��ʲ�Ķ���
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//��ȡ���������˻���
		Vector<Vector<String>> orders = dao.queryAllSalesReturnOrder();
		//�ж��Ƿ���������˻���
		if(orders.size() == 0) {
			throw new SalesReturnOrderNotFoundException("���������˻�����Ϣ");
		}
		return orders;
	}
	
	//��������˻���
	public boolean addSalesReturnOrder(SalesReturnOrder order) throws SalesReturnIsFailedException {
		try {
			//���������˻����ݷ��ʲ�Ķ���
			ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
			//�����¼
			dao.insertSalesReturnOrder(order);
		} catch (SalesDaoException e) {
			e.printStackTrace();
			throw new SalesReturnIsFailedException("�����˻�����ʧ��");
		}
		return true;
	}
	
	//���������˻�Ʊ�Ų�ѯ�����˻��굥
	public Vector<Vector<String>> searchSalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnDetailNotFoundException {
		//���������˻����ݷ��ʲ�Ķ���
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//��ѯ�����˻��굥
		Vector<Vector<String>> detail = dao.querySalesReturnDetailOrderBySid(salesReturnId);
		//�ж��굥�Ƿ����
		if(detail.size() == 0) {
			throw new SalesReturnDetailNotFoundException("��ȡ�����˻��굥ʧ��");
		}
		return detail;
	}
	
	//���������˻�Ʊ�Ų�ѯ�����˻���
	public Vector<Vector<String>> searchSalesReturnOrderBySid(String salesReturnId) throws SalesDaoException, SalesReturnOrderNotFoundException {
		//���������˻����ݷ��ʲ�Ķ���
		ISalesReturnDao dao = SalesFactory.getSalesReturnDaoInstance();
		//��ѯ�����˻���
		Vector<Vector<String>> order = dao.querySalesReturnOrderBySid(salesReturnId);
		//�ж������˻����Ƿ����
		if(order.size() == 0) {
			throw new SalesReturnOrderNotFoundException("��ȡ�����˻���ʧ��");
		}
		return order;
	}
	//�������۳���Ʊ�Ų�ѯ�����굥��Ϣ����������Ʊ����Ϣ
	public Vector<Vector<String>> seaSalesDetailOrderBySid(String salesNum) throws SalesDaoException, SearchDetailIdFailedException {
		//�������۳������ݷ��ʲ�Ķ���
		ISalesDao dao = SalesFactory.getSalesDaoInstance();
		//��ȡ�굥
		Vector<Vector<String>> details = dao.querySDetailOrderBySid(salesNum);
		//�ж��굥�Ƿ����
		if(details.size() == 0) {
			throw new SearchDetailIdFailedException("��ѯ���۳����굥ʧ��");
		}
		return details;
	}
}
