package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;

/**
 * ISupplieBiz：供应商逻辑层接口
 * @author Administrator
 *
 */
public interface ISupplieBiz {
	/*
	 * addSupplier：添加供应商
	 * @param supplie 供应商的具体信息
	 * @return int 返回供应商的主键值
	 */
	public int addSupplier(Supplie supplie) throws SupplieDaoException, SupplierIsExistedException;
	
	/*
	 * deleteSupplierById：根据编号删除供应商信息
	 * @param id 供应商编号
	 * @return boolean 返回操作是否成功
	 */
	public boolean deleteSupplierById(long id) throws SupplieDaoException;
	
	/*
	 * modifySupplier：修改供应商信息
	 * @param supplier 已修改的供应商信息
	 * @return boolean 返回操作是否成功
	 */
	public boolean modifySupplier(Supplie supplier) throws SupplieDaoException;
	
	/*
	 * searchAllSupplier：查询所有的供应商信息
	 * @return Vector<Vector<String>> 供应商信息
	 */
	public Vector<Vector<String>> searchAllSupplier() throws SupplieDaoException;
	
	/*
	 * searchSupplierById：根据编号查询供应商信息
	 * @param id 供应商编号
	 * @return Vector<String> 供应商信息
	 */
	public Vector<String> searchSupplierById(long id) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSupplierByName：根据名称查询供应商信息
	 * @param name 供应商名称
	 * @return Vector<String> 供应商信息
	 */
	public Vector<String> searchSupplierByName(String name) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSuppliersByName：根据名称查询供应商信息:模糊查询
	 * @param name 供应商名称
	 * @return Vector<String> 供应商信息
	 */
	public Vector<Vector<String>> searchSuppliersByName(String name) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSupplierNames:查询所有的供应商名称
	 * @return Vector<String> 所有的供应商名称
	 */
	public Vector<String> searchSupplierNames() throws SupplieDaoException;
}
