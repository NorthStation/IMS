package com.lms.zx.factory;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.biz.impl.supplie.SupplieBizImpl;
import com.lms.zx.dao.ISupplieDao;
import com.lms.zx.dao.impl.supplie.SupplieDaoImpl;

/**
 * SupplieFactory：供应商工厂
 * @author Administrator
 *
 */
public abstract class SupplieFactory {
	//返回供应商逻辑层对象
	public static ISupplieBiz getSupplieBizInstance() {
		return new SupplieBizImpl();
	}
	
	//返回供应商数据访问层对象
	public static ISupplieDao getSupplieDaoInstance() {
		return new SupplieDaoImpl();
	}
}
