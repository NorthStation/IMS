package com.lms.zx.biz.impl.instorage;

import java.util.List;
import java.util.Vector;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.entity.InStorageReturnOrder;
import com.lms.zx.dao.IinStorageDao;
import com.lms.zx.dao.IinStorageReturnDao;
import com.lms.zx.exception.instorage.ReturnOrderIsMotExistException;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.factory.GetInstance;

//������Biz��
public class InStorageManagerBizImpl implements IinStorageManagerBiz {
	//������ⶩ��
	public void addOrderProductInfo(InStorageOrder order) throws InStorageDaoException {
		//ͨ���򵥹�����ȡDao���������
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		inStorageDao.addProductInfo(order);
		}

	//��ѯ��ⶩ����Ϣ֧��ģ����ѯ
	public Vector<Vector<String>> searchOrderMsgByOid(String orderId) throws ReturnOrderIsMotExistException {
		//ͨ���򵥹�����ȡDao���������
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		Vector<Vector<String>> data=inStorageDao.queryOrderMsgByOid(orderId);
		if(data.size()==0){
			throw new ReturnOrderIsMotExistException("�ö��������ڣ�");
		}	
		return data;
	}

	//��ѯ��ⶩ����ϸ��Ϣ
	public Vector<Vector<String>> searchOrderDetailMsgByOid(String orderId) {
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		return inStorageDao.queryOrderDetailMsgByOid(orderId);
	}

	//��������˻�����
	public void addReturnMsg(InStorageReturnOrder order) throws InStorageReturnDaoException {
		//ͨ���򵥹�����ȡDao���������
		IinStorageReturnDao inStorageReturnDao=GetInstance.getInStorageReturnDaoImpl();
		inStorageReturnDao.insertReturnMsg(order);
	}

	//��������˻�������ѯ������Ϣ
	public Vector<Vector<String>>  searchOrderReturnBySid(String sId) throws ReturnOrderIsMotExistException, InStorageReturnDaoException{
		//ͨ���򵥹�����ȡDao���������
		IinStorageReturnDao inStorageReturnDaoImpl=GetInstance.getInStorageReturnDaoImpl();
		Vector<Vector<String>> data=inStorageReturnDaoImpl.queryOrderMsgBySid(sId);
		if(data.size()==0){
			throw new ReturnOrderIsMotExistException("�ö��������ڣ�");
		}
		return data;
	}
	//��������˻�������ѯ��ϸ������Ϣ
	public Vector<Vector<String>>  searchOrderDetailReturnBySid(String sId) throws InStorageReturnDaoException{
		IinStorageReturnDao inStorageReturnDaoImpl=GetInstance.getInStorageReturnDaoImpl();
		return inStorageReturnDaoImpl.queryOrderDetailMsgBySid(sId);
	}

	


}
