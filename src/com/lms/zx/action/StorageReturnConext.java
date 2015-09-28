package com.lms.zx.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.entity.InStorageReturnDetailOrder;
import com.lms.zx.entity.InStorageReturnOrder;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.factory.GetInstance;

 
/**����˻�*/
public class StorageReturnConext {
  /**
   * ��������˻���Ϣ
   *@param List<String>s ����˻���Ϣ
   * [�˻�Ʊ�ţ��˻����ڣ������ˣ��ܽ����ʽ]
   *@param sDetail  ����˻���ϸ��Ϣ
   *@return void
 * @throws InStorageReturnDaoException 
   */
  public void createRetrunMsg(List<String> s,Vector<Vector<String>> sDetail) throws InStorageReturnDaoException{
	//���ü򵥹�������������Biz�����
		IinStorageManagerBiz inStorageManagerBiz=GetInstance.getInStorageManagerBizImpl();
		//��������˻���ʵ����
		InStorageReturnOrder returnOrder=new InStorageReturnOrder();
		//��������˻��굥����
		 ArrayList<InStorageReturnDetailOrder> detailOrder=new  ArrayList<InStorageReturnDetailOrder>();
		
		 System.out.println(s.toString());
		 //[RTH20131006214211426, 2013-10-06, admin, 2.0, ��ʦ��, �ֽ�]
		for(int j=0;j<sDetail.size();j++){
			System.out.println("�굥"+sDetail.get(j).toString());
			//�굥[0, 1, 1]��Ʒ���,�˻����ۣ��˻�����
			//��������˻��굥ʵ��
			InStorageReturnDetailOrder  order=new InStorageReturnDetailOrder();
			Vector<String> v=sDetail.get(j);
			for(int k=0;k<v.size();k++) {
				System.out.println(v.get(k));
			}
			order.setOrderReturnId(s.get(0));
			order.setProId(Long.parseLong(v.get(0)));
			order.setReturnPrice(Double.parseDouble(v.get(1)));
			order.setAmount(Integer.parseInt(v.get(2)));
			detailOrder.add(order);
		}
		
		//��װ�ɶ���
		int i=0;
		returnOrder.setId(s.get(i++));
		returnOrder.setTime(s.get(i++));
		returnOrder.setHandle(s.get(i++));
		returnOrder.setSum(Double.parseDouble(s.get(i++)));
		returnOrder.setSupplieName(s.get(i++));
		returnOrder.setPayMent(s.get(i++));
		
		returnOrder.setInReturnOrder(detailOrder);
			inStorageManagerBiz.addReturnMsg(returnOrder);
			
	
  }
}
