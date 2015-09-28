package com.lms.zx.action;

import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.exception.sales.SalesIsFailedException;
import com.lms.zx.exception.sales.StockAmountIsLackedException;
import com.lms.zx.factory.SalesFactory;
 
/**
 * ���۳���ҳ�������
 */
public class SalesOrderContext {
	 
	/**
	 * ����������Ϣ
	 *@param salesNum ���۵���
	 *@param amount   �ܽ�� 
	 *@param customerName �ͻ�����
	 *@param salesTime ����ʱ��
	 *@param handle    ������
	 *@param payMent   ֧����ʽ
	 *@param remark    ��ע
	 *@param data      ������ϸ��Ϣ
	 *@return 
	 *@return boolean
	 * @throws SalesDaoException 
	 * @throws SalesIsFailedException 
	 * @throws StockAmountIsLackedException 
	 */
	public boolean saveSalesOrder(String salesNum, String amount,
			String customerName, String salesTime, String handle,
			String payMent, String remark,Vector<Vector<String>> data) throws StockAmountIsLackedException, SalesIsFailedException, SalesDaoException {
		//��ȡ���۳����굥����
		ArrayList<SalesDetailOrder> details = new ArrayList<SalesDetailOrder>();
		for(int i=0;i<data.size();i++) {
			//��ȡ�����е�Ԫ��
			Vector<String> v = data.get(i);
			//��װ���۳����굥
			SalesDetailOrder d = new SalesDetailOrder();
			//����Vector������±�
			int index = 0;
			d.setProId(Long.parseLong(v.get(index++)));
			d.setProName(v.get(index++));
			d.setGenre(v.get(index++));
			d.setSalesPrice(Double.parseDouble(v.get(index++)));
			d.setAmount(Integer.parseInt(v.get(index++)));
			d.setSpecific(v.get(index++));
			d.setMadeIn(v.get(index++));
			d.setRemarks(v.get(index++));
			d.setSalesId(salesNum);
			details.add(d);
		}
		//��װ���۳��ⵥ
		SalesOrder order = new SalesOrder();
		order.setId(salesNum);
		order.setSum(Double.parseDouble(amount));
		order.setCusName(customerName);
		order.setTime(salesTime);
		order.setHandle(handle);
		order.setPayMent(payMent);
		order.setRemarks(remark);
		order.setDetailOrders(details);
		//��ȡ���۹�����߼������
		ISalesManagerBiz biz = SalesFactory.getSalesManagerBizInstance();
		//����������Ϣ
		return biz.addSalesOrder(order);
	}

}
