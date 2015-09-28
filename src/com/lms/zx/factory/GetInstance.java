package com.lms.zx.factory;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.biz.impl.instorage.InStorageManagerBizImpl;

import com.lms.zx.dao.IinStorageDao;
import com.lms.zx.dao.IinStorageReturnDao;
import com.lms.zx.dao.impl.instorage.InStorageDaoImpl;
import com.lms.zx.dao.impl.instorage.InStorageReturnDaoImpl;

//简单工厂
public abstract class GetInstance {
	//获得一个入库管理的Biz对象
	public static IinStorageManagerBiz getInStorageManagerBizImpl(){
		return new InStorageManagerBizImpl();
	}
	//获得一个入库的Dao对象
	public static IinStorageDao getInStorageDaoImpl(){
		return new InStorageDaoImpl();
	}
	//获得一个入库退货的Dao对象
	public static IinStorageReturnDao getInStorageReturnDaoImpl(){
		return new InStorageReturnDaoImpl();
	}
}
