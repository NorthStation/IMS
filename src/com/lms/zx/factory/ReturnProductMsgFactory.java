package com.lms.zx.factory;

import com.lms.zx.biz.IReturnProductMsgBiz;
import com.lms.zx.biz.impl.instorage.ReturnProductMsgBizImpl;
import com.lms.zx.dao.IReturnProductMsgDao;
import com.lms.zx.dao.impl.instorage.ReturnProductMsgDaoImpl;



public abstract class ReturnProductMsgFactory {

	public static IReturnProductMsgDao getReturnProductMsgDaoImpl() {
		
		return new ReturnProductMsgDaoImpl();
	}

	public static IReturnProductMsgBiz getReturnProductMsgBizImpl() {
		return new ReturnProductMsgBizImpl();
	}

}
