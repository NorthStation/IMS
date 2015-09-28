package com.lms.zx.factory;

import com.lms.zx.biz.IinStorageManagerBiz;
import com.lms.zx.biz.impl.instorage.InStorageManagerBizImpl;

import com.lms.zx.dao.IinStorageDao;
import com.lms.zx.dao.IinStorageReturnDao;
import com.lms.zx.dao.impl.instorage.InStorageDaoImpl;
import com.lms.zx.dao.impl.instorage.InStorageReturnDaoImpl;

//�򵥹���
public abstract class GetInstance {
	//���һ���������Biz����
	public static IinStorageManagerBiz getInStorageManagerBizImpl(){
		return new InStorageManagerBizImpl();
	}
	//���һ������Dao����
	public static IinStorageDao getInStorageDaoImpl(){
		return new InStorageDaoImpl();
	}
	//���һ������˻���Dao����
	public static IinStorageReturnDao getInStorageReturnDaoImpl(){
		return new InStorageReturnDaoImpl();
	}
}
