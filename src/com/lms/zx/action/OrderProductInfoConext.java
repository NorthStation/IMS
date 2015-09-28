package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.entity.InStorageDetailOrder;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.factory.GetInstance;
 

/**
 * �ɹ���� ��������ҵ��
 */
public class OrderProductInfoConext {
	/**
	 * ���ɶ���
	 * 
	 * @param Vector<String> order ������Ϣ
	 * [�������ϼƽ��������ڣ���Ʒ�����������ˣ�Ʒ��������֧����ʽ�����ս���]
	 *            
	 * @param Vector<Vector<String>> storages ������ϸ��Ϣ
	 *           
	 * @return void
	 * @throws DaoException 
	 * @throws InStorageDaoException 
	 */
	public void addOrderProductInfo(Vector<String> order,
			Vector<Vector<String>> storages) throws  InStorageDaoException {

		//���ü򵥹�������������Biz�����
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		//������ⶩ��ʵ����
		InStorageOrder inStorageOrder=new InStorageOrder();
		//��������굥����
		 ArrayList<InStorageDetailOrder> detailOrder=new  ArrayList<InStorageDetailOrder>();
		for(int j=0;j<storages.size();j++){
			//��������굥ʵ��
			InStorageDetailOrder  s=new InStorageDetailOrder();
			Vector<String> v=storages.get(j);
			s.setOrderId(order.get(0));
			s.setProId(Long.parseLong(v.get(0)));
			s.setSuppliName(v.get(1));
			s.setProName(v.get(2));
			s.setPrice(Double.parseDouble(v.get(3)));
			s.setSpecific(v.get(4));
			s.setUnit(v.get(5));
			s.setAmount(Integer.parseInt(v.get(6)));
			//s.setPrice(Double.parseDouble(v.get(7)));
			s.setRemarks(v.get(8));
			s.setMadeIn(v.get(9));
			s.setGenre(v.get(10));
			detailOrder.add(s);
		}
		
		//��װ�ɶ���
		int i=0;
		inStorageOrder.setId(order.get(i++));
		inStorageOrder.setSum(Double.parseDouble(order.get(i++)));
		inStorageOrder.setTime(order.get(i++));
		inStorageOrder.setVarNumber(Integer.parseInt(order.get(i++)));
		inStorageOrder.setHandle(order.get(i++));
		inStorageOrder.setProCount(Integer.parseInt(order.get(i++)));
		inStorageOrder.setPayMent(order.get(i++));
		inStorageOrder.setConclusion(order.get(i++));
		inStorageOrder.setDetailOrder(detailOrder);
		
		inStorageManagerBiz.addOrderProductInfo(inStorageOrder);
		
		
	}

}
