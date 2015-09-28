package com.lms.zx.factory;

import com.lms.zx.biz.ISalesManagerBiz;
import com.lms.zx.biz.impl.sales.SalesManagerBizImpl;
import com.lms.zx.dao.ISalesDao;
import com.lms.zx.dao.ISalesReturnDao;
import com.lms.zx.dao.impl.sales.SalesDaoImpl;
import com.lms.zx.dao.impl.sales.SalesReturnDaoImpl;

/**
 * SalesFactory�����۹�����
 * @author ������
 *
 */
public abstract class SalesFactory {
	//�������۳���ģ������ݷ��ʲ����
	public static ISalesDao getSalesDaoInstance() {
		return new SalesDaoImpl();
	}
	
	//�������۳����˻�ģ������ݷ��ʲ����
	public static ISalesReturnDao getSalesReturnDaoInstance() {
		return new SalesReturnDaoImpl();
	}
	
	//�������۹����߼���Ķ���
	public static ISalesManagerBiz getSalesManagerBizInstance() {
		return new SalesManagerBizImpl();
	}
}
