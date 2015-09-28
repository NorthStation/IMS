package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.entity.SalesReturnDetailOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesReturnIsFailedException;
import com.lms.zx.factory.SalesFactory;

 

/**
 * �����˻�ҳ�������
 */
public class SalesReturnContext {
	 

	// �����˻���Ϣ�����ݿ�
	public boolean saveSalesReturnOrder(String salesReturnId, String amount,
			String date, String operator, String customerField, String payMent,
			Vector<Vector<String>> data) throws SalesReturnIsFailedException {
		//��ȡ�����˻��굥����
		ArrayList<SalesReturnDetailOrder> details = new ArrayList<SalesReturnDetailOrder>();
		//ѭ����װ�굥��Ϣ
		for(int i=0;i<data.size();i++) {
			SalesReturnDetailOrder d = new SalesReturnDetailOrder();
			//��ȡ�굥��Ϣ
			Vector<String> v = data.get(i);
			//����Vector������±�
			int index = 1;
			//��װ�굥
			d.setSalesReturnId(salesReturnId);
			d.setProId(Long.parseLong(v.get(index++)));
			d.setProName(v.get(index++));
			d.setGenre(v.get(index++));
			d.setReturnPrice(Double.parseDouble(v.get(index++)));
			d.setAmount(Integer.parseInt(v.get(index++)));
			d.setSpecific(v.get(index++));
			d.setMadeIn(v.get(index++));
			d.setRemarks(v.get(index++));
			d.setSum(Double.parseDouble(v.get(index++)));
			details.add(d);
		}
		//��װ�����˻�����Ϣ
		SalesReturnOrder order = new SalesReturnOrder();
		order.setSalesReturnId(salesReturnId);
		order.setSum(Double.parseDouble(amount));
		order.setTime(date);
		order.setHandle(operator);
		order.setCurName(customerField);
		order.setPayMent(payMent);
		order.setSalesReturnDetailOrders(details);
		//��ȡ���۹����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//���������˻���Ϣ
		biz.addSalesReturnOrder(order);
		return true;
	}

}
