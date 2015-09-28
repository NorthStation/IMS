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

//入库管理Biz层
public class InStorageManagerBizImpl implements IinStorageManagerBiz {
	//生成入库订单
	public void addOrderProductInfo(InStorageOrder order) throws InStorageDaoException {
		//通过简单工厂获取Dao层的入库对象
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		inStorageDao.addProductInfo(order);
		}

	//查询入库订单信息支持模糊查询
	public Vector<Vector<String>> searchOrderMsgByOid(String orderId) throws ReturnOrderIsMotExistException {
		//通过简单工厂获取Dao层的入库对象
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		Vector<Vector<String>> data=inStorageDao.queryOrderMsgByOid(orderId);
		if(data.size()==0){
			throw new ReturnOrderIsMotExistException("该订单不存在！");
		}	
		return data;
	}

	//查询入库订单详细信息
	public Vector<Vector<String>> searchOrderDetailMsgByOid(String orderId) {
		IinStorageDao inStorageDao=GetInstance.getInStorageDaoImpl();
		return inStorageDao.queryOrderDetailMsgByOid(orderId);
	}

	//生成入库退货订单
	public void addReturnMsg(InStorageReturnOrder order) throws InStorageReturnDaoException {
		//通过简单工厂获取Dao层的入库对象
		IinStorageReturnDao inStorageReturnDao=GetInstance.getInStorageReturnDaoImpl();
		inStorageReturnDao.insertReturnMsg(order);
	}

	//根据入库退货订单查询订单信息
	public Vector<Vector<String>>  searchOrderReturnBySid(String sId) throws ReturnOrderIsMotExistException, InStorageReturnDaoException{
		//通过简单工厂获取Dao层的入库对象
		IinStorageReturnDao inStorageReturnDaoImpl=GetInstance.getInStorageReturnDaoImpl();
		Vector<Vector<String>> data=inStorageReturnDaoImpl.queryOrderMsgBySid(sId);
		if(data.size()==0){
			throw new ReturnOrderIsMotExistException("该订单不存在！");
		}
		return data;
	}
	//根据入库退货订单查询详细订单信息
	public Vector<Vector<String>>  searchOrderDetailReturnBySid(String sId) throws InStorageReturnDaoException{
		IinStorageReturnDao inStorageReturnDaoImpl=GetInstance.getInStorageReturnDaoImpl();
		return inStorageReturnDaoImpl.queryOrderDetailMsgBySid(sId);
	}

	


}
