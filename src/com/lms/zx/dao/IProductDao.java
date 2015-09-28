package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;

public interface IProductDao {
	/*
	 * insertProduct：插入商品记录
	 * @param product 商品信息
	 */
	public void insertProduct(Product product) throws ProductDaoException;
	
	/*
	 * deleteProductById：根据编号删除商品记录
	 * @param id 商品编号
	 */
	public void deleteProductById(long id) throws ProductDaoException;
	
	/*
	 * updateProduct：更新商品记录
	 * @param product 已修改的商品信息
	 */
	public void updateProduct(Product product) throws ProductDaoException;
	
	/*
	 * queryAllProduct：查询所有的商品信息
	 * @return Vector<Product> 商品信息集合
	 */
	public Vector<Vector<String>> queryAllProduct() throws ProductDaoException;
	
	/*
	 * queryProductBySid：根据供应商编号查询商品信息
	 * @param sid 供应商编号
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> queryProductBySid(long sid) throws ProductDaoException;
	
	/*
	 * queryProductBySname:根据供应商名称查询商品信息
	 * @param sname 供应商名称
	 * @return Vector<Vector<String>> 商品信息集合 
	 */
	public Vector<Vector<String>> queryProductBySname(String sname) throws ProductDaoException;
	
	/*
	 * searchProductBySname：根据供应商名称查询商品信息，模糊查询
	 * @param sname 供应商名称
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException;
	
	/*
	 * searchProductByPcategory：根据商品类型查询商品信息，模糊查询
	 * @param category 商品类型
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException;
	
	/*
	 * searchProductByPname：根据商品名称查询商品信息，模糊查询
	 * @param pname 商品名称
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductDaoException;
}
