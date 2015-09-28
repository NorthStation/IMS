package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;

/**
 * ISupplieDao:供应商数据访问层接口
 * @author Administrator
 *
 */
public interface ISupplieDao {
	/*
	 * insertSupplier：插入供应商记录
	 * @param supplie 供应商信息
	 */
	public void insertSupplier(Supplie supplie) throws SupplieDaoException;
	
	/*
	 * deleteSupplierById:删除供应商信息
	 * @param id 供应商编号
	 * @return int 返回底层数据库受影响的记录数
	 */
	public int deleteSupplierById(long id) throws SupplieDaoException;
	
	/*
	 * updateSuppllie：修改供应商信息
	 * @param supplie 修改信息
	 * @return int 返回底层数据库受影响的记录数
	 */
	public int updateSupplier(Supplie supplie) throws SupplieDaoException;
	
	/*
	 * queryAllSupplier：查询所有的供应商信息
	 * @return Vector<Vector<String>> 返回所有的供应商信息
	 */
	public Vector<Vector<String>> queryAllSupplier() throws SupplieDaoException ;
	
	/*
	 * querySupplierById：通过编号查询供应商信息
	 * @param id 供应商编号
	 * @return Vector<String> 返回供应商信息
	 */
	public Vector<String> querySupplierById(long id) throws SupplieDaoException;
	
	/*
	 * querySupplierByName：通过名称查询供应商信息
	 * @param name 供应商名称
	 * @return Vector<String> 供应商信息
	 */
	public Vector<String> querySupplierByName(String name) throws SupplieDaoException;
	
	/*
	 * querySuppliesByName：通过名称查询供应商信息:模糊查询
	 * @param name 供应商名称
	 * @return Vector<Vector<String>> 供应商信息
	 */
	public Vector<Vector<String>> querySuppliersByName(String name) throws SupplieDaoException;
	
	/*
	 * querySupplierNames：查询所有供应商的名称
	 * @return Vector<String> 所有供应商名称
	 */
	public Vector<String> querySupplierNames() throws SupplieDaoException;
}
