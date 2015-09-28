package com.lms.zx.biz.impl.supplie;

import java.util.Vector;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.dao.ISupplieDao;
import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;
import com.lms.zx.factory.SupplieFactory;

public class SupplieBizImpl implements ISupplieBiz{
	//添加供应商
	public int addSupplier(Supplie supplie) throws SupplieDaoException, SupplierIsExistedException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//通过名称查询供应商
		Vector<String> s = dao.querySupplierByName(supplie.getName());
		//判断供应商是否已存在
		if(s.size() != 0) {
			throw new SupplierIsExistedException("该供应商已存在");
		}
		//调用数据访问层的方法
		dao.insertSupplier(supplie);
		//调用数据访问层的方法
		Vector<String> p = dao.querySupplierByName(supplie.getName());
		int id = Integer.parseInt(p.get(0));
		return id;
	}

	//删除供应商
	public boolean deleteSupplierById(long id) throws SupplieDaoException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法，并返回底层数据库受影响的记录数
		int number = dao.deleteSupplierById(id);
		return number != 0;
	}
	
	//修改供应商信息
	public boolean modifySupplier(Supplie supplier) throws SupplieDaoException {
		System.out.println("---------------------------------------updateBiz");
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法，并返回底层数据库受影响的记录数
		int number = dao.updateSupplier(supplier);
		return number != 0;
	}
	
	//查询所有的供应商信息
	public Vector<Vector<String>> searchAllSupplier() throws SupplieDaoException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法
		Vector<Vector<String>> suppliers = dao.queryAllSupplier();
		return suppliers;
	}
	
	//根据编号查询供应商信息
	public Vector<String> searchSupplierById(long id) throws SupplieDaoException, SupplierNotFoundException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法
		Vector<String> s = dao.querySupplierById(id);
		//判断是否存在该供应商信息
		if(s.size() == 0) {
			throw new SupplierNotFoundException("供应商不存在");
		}
		return s;
	}
	
	//根据名称查询供应商信息
	public Vector<String> searchSupplierByName(String name) throws SupplieDaoException, SupplierNotFoundException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法
		Vector<String> s = dao.querySupplierByName(name);
		//判断是否存在该供应商信息
		if(s.size() == 0) {
			throw new SupplierNotFoundException("供应商不存在");
		}
		return s;
	}
	
	//根据名称查询供应商信息:模糊查询
	public Vector<Vector<String>> searchSuppliersByName(String name) throws SupplieDaoException, SupplierNotFoundException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法
		Vector<Vector<String>> s = dao.querySuppliersByName(name);
		//判断是否存在该供应商信息
		if(s.size() == 0) {
			throw new SupplierNotFoundException("供应商不存在");
		}
		return s;
	}
	
	//查询所有的供应商名称
	public Vector<String> searchSupplierNames() throws SupplieDaoException {
		//创建供应商数据层对象
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//调用数据访问层的插入方法
		Vector<String> s = dao.querySupplierNames();
		return s;
	}
}
