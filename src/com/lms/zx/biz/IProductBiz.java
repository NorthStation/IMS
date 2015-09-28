package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductIdExistedException;
import com.lms.zx.exception.product.ProductNotFoundException;

/**
 * IProductBiz：商品逻辑接口
 * @author Administrator
 *
 */
public interface IProductBiz {
	/*
	 * addProduct：添加商品信息
	 * @param product 商品信息
	 * @return int 商品的主键值
	 */
	public int addProduct(Product product) throws ProductDaoException, ProductIdExistedException;
	
	/*
	 * deleteProductById：根据商品编号删除商品信息
	 * @param id 商品编号
	 */
	public void deleteProductById(long id) throws ProductDaoException;
	
	/*
	 * modifyProduct：修改商品信息
	 * @param product 已修改的商品信息
	 */
	public void modifyProduct(Product product) throws ProductDaoException;
	
	/*
	 * getAllProduct：查询所有商品信息
	 */
	public Vector<Vector<String>> getAllProduct() throws ProductDaoException;
	
	/*
	 * getProductBySid：根据供应商编号查询商品信息
	 * @param sid 供应商编号
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> getProductBySid(long sid) throws ProductNotFoundException, ProductDaoException;
	
	/*
	 * getProductBySname：根据供应商名称查询商品信息
	 * @param sname 供应商名称
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> getProductBySname(String sname) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductBySname：根据供应商名称查询商品信息，模糊查询
	 * @param sname 供应商名称
	 * @return Vector<Vecotr<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductByPcategory：根据商品类型查询商品信息，模糊查询
	 * @param category 商品类型
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductByPname：根据商品名称查询商品信息，模糊查询
	 * @param pname 商品名称
	 * @return Vector<Vector<String>> 商品信息集合
	 */
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductNotFoundException, ProductDaoException;
}
