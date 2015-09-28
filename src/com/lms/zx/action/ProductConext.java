package com.lms.zx.action;


import java.util.Vector;

import com.lms.zx.biz.IProductBiz;
import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductIdExistedException;
import com.lms.zx.exception.product.ProductNotFoundException;
import com.lms.zx.factory.ProductFactory;

/**
 * 产品处理逻辑
 */
public class ProductConext {
	/**
	 * 根据供应商id获得所有商品
	 * 
	 * @param sId
	 *            供应商的id
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> getProductMsgBySid(int sId) throws ProductNotFoundException, ProductDaoException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.getProductBySid(sId);
		}

	/**
	 * 获得所有的商品信息
	 * 
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> getAllProductMsg() throws ProductDaoException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.getAllProduct();
		}

	/**
	 * 根据供应商id获得所有商品
	 * 
	 * @param setId
	 *            供应商的id
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> getProductMsgBysetSid(int setSid) throws ProductNotFoundException, ProductDaoException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.getProductBySid(setSid);
		}

	/**
	 * 根据供应商的名称获得商品的信息
	 * 
	 * @param supplieName
	 *            供应商的名称
	 * @return Vector<Vector<String>>
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> getProductMsgBySupplieName(String supplieName) throws ProductDaoException, ProductNotFoundException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.getProductBySname(supplieName);
		}

	/**
	 * 添加商品
	 * 
	 * @param name
	 *            商品名称
	 * @param genre
	 *            商品类型
	 * @param price
	 *            商品价格
	 * @param specific
	 *            规格
	 * @param unit
	 *            单位
	 * @param supplierId
	 *            供应商id
	 * @param madeIn
	 *            产地
	 * @param remark
	 *            备注
	 * @return
	 * @throws Exception
	 * @return int 返回插入商品的主键
	 * @throws ProductIdExistedException 
	 * @throws ProductDaoException 
	 */
	public int addProduct(String name, String genre, double price,
			String specific, String unit, int supplierId, String madeIn,
			String remark) throws ProductDaoException, ProductIdExistedException {
			//封装商品
			Product product = new Product();
			product.setName(name);
			product.setGenre(genre);
			product.setMadeIn(madeIn);
			product.setPrice(price);
			product.setSpecific(specific);
			product.setUnit(unit);
			product.setSupplieId(supplierId);
			product.setRemarks(remark);
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.addProduct(product);
		}

	/**
	 * 根据商品id修改商品信息
	 * 
	 * @param pid
	 *            商品id
	 * @param name
	 *            商品名称
	 * @param category
	 *            商品类型
	 * @param price
	 *            商品价格
	 * @param specific
	 *            规格
	 * @param unit
	 *            单位
	 * @param supplierId
	 *            供应商id
	 * @param madeIn
	 *            产地
	 * @param remark
	 *            备注
	 * @throws Exception
	 * @return void
	 * @throws ProductDaoException 
	 */
	public void modifyProduct(int pid, String name, String category,
			double price, String specific, String unit, int supplierId,
			String madeIn, String remark) throws ProductDaoException {
			//封装商品
			Product product = new Product();
			product.setId(pid);
			product.setName(name);
			product.setGenre(category);
			product.setMadeIn(madeIn);
			product.setPrice(price);
			product.setSpecific(specific);
			product.setUnit(unit);
			product.setSupplieId(supplierId);
			product.setRemarks(remark);
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			biz.modifyProduct(product);
		}

	/**
	 * 根据商品id删除商品
	 * 
	 * @param id
	 *            商品id
	 * @throws Exception
	 * @return void
	 * @throws ProductDaoException 
	 */
	public void deleteProduct(long id) throws ProductDaoException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			biz.deleteProductById(id);
		}

	/**
	 * 根据商品名称查询商品信息，使用模糊查询
	 * 
	 * @param productName
	 *            商品名称
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [商品编号，商品名称，类别，价格，规格，单位，供应商名称，备注，产地]
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> searchByProductName(String productName) throws ProductNotFoundException, ProductDaoException{
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.searchProductByPname(productName);
		}

	/**
	 * 根据供应商名称查询商品信息，支持模糊查询
	 * 
	 * @param supplierName
	 *            供应商名称
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [商品编号，商品名称，类别，价格，规格，单位，供应商名称，备注，产地]
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> searchByProductSupplier(String supplierName) throws ProductDaoException, ProductNotFoundException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.searchProductBySname(supplierName);
		}

	/**
	 * 根据商品类型查询商品信息，支持模糊查询
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [商品编号，商品名称，类别，价格，规格，单位，供应商名称，备注，产地]
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> searchByProductCategory(String category) throws ProductDaoException, ProductNotFoundException {
			//创建商品逻辑层对象
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//调用逻辑层方法
			return biz.searchProductByPcategory(category);
		}
}
