package com.lms.zx.biz.impl.instorage;

import java.util.Vector;

import com.lms.zx.biz.IReturnProductMsgBiz;
import com.lms.zx.dao.IReturnProductMsgDao;
import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;
import com.lms.zx.exception.instorage.productIsNotExistException;
import com.lms.zx.exception.instorage.stockIsNotException;
import com.lms.zx.factory.ReturnProductMsgFactory;



public class ReturnProductMsgBizImpl  implements IReturnProductMsgBiz{

	//根据供应商名称查找商品名称
	public Vector<String> searchProNameBySupplieName(String supplieName) throws ReturnProductMsgDaoException, productIsNotExistException {
		IReturnProductMsgDao returnProductMsgDaoImpl=ReturnProductMsgFactory.getReturnProductMsgDaoImpl();
		Vector<String> proName=returnProductMsgDaoImpl.queryStorageProductName(supplieName);
		if(proName.size()==0){
			throw new productIsNotExistException("商品不存在！");
		}
		return proName;
	}

	//根据商品名称查找库存信息
	public Vector<String> searchStrockInfoByProName(String proName) throws ReturnProductMsgDaoException, stockIsNotException {
		IReturnProductMsgDao returnProductMsgDaoImpl=ReturnProductMsgFactory.getReturnProductMsgDaoImpl();
		Vector<String> stock=returnProductMsgDaoImpl.queryStorageByProName(proName);
		if(stock.size()==0){
			throw new stockIsNotException("该商品在库存中不存在");
		}
		return stock;
	}
	
}
