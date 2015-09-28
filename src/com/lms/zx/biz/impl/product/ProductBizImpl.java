package com.lms.zx.biz.impl.product;

import java.util.Vector;

import com.lms.zx.biz.IProductBiz;
import com.lms.zx.dao.IProductDao;
import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductIdExistedException;
import com.lms.zx.exception.product.ProductNotFoundException;
import com.lms.zx.factory.ProductFactory;

public class ProductBizImpl implements IProductBiz{
	//添加商品，并返回商品的主键值
	public int addProduct(Product product) throws ProductDaoException, ProductIdExistedException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.searchProductByPname(product.getName());
		//判断商品信息是否已存在
		if(products.size() != 0) {
			throw new ProductIdExistedException("该商品已存在");
		}
		dao.insertProduct(product);
		//根据商品名称查询商品信息，求主键值
		Vector<Vector<String>> p = dao.searchProductByPname(product.getName());
		int id = Integer.parseInt(p.get(0).get(0));
		return id;
	}
	
	//删除商品
	public void deleteProductById(long id) throws ProductDaoException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		dao.deleteProductById(id);
	}
	
	//修改商品信息
	public void modifyProduct(Product product) throws ProductDaoException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		dao.updateProduct(product);
	}
	
	//查询所有的商品
	public Vector<Vector<String>> getAllProduct() throws ProductDaoException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.queryAllProduct();
		return products;
	}
	
	//根据供应商编号查询商品信息
	public Vector<Vector<String>> getProductBySid(long sid) throws ProductNotFoundException, ProductDaoException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.queryProductBySid(sid);
		//判断是否有商品
		if(products.size() == 0) {
			throw new ProductNotFoundException("暂无该供应商的商品信息");
		}
		return products;
	}
	
	//根据供应商名称查询商品信息
	public Vector<Vector<String>> getProductBySname(String sname) throws ProductDaoException, ProductNotFoundException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.queryProductBySname(sname);
		//判断是否有商品
		if(products.size() == 0) {
			throw new ProductNotFoundException("暂无该供应商的商品信息");
		}
		return products;
	}
	
	//根据商品类型查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException, ProductNotFoundException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.searchProductByPcategory(category);
		//判断是否有商品
		if(products.size() == 0) {
			throw new ProductNotFoundException("暂无该类型的商品信息");
		}
		return products;
	}
	
	//根据商品名称查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductNotFoundException, ProductDaoException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.searchProductByPname(pname);
		//判断是否有商品
		if(products.size() == 0) {
			throw new ProductNotFoundException("暂无包含该商品名称的商品信息");
		}
		return products;
	}
	
	//根据供应商名称查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException, ProductNotFoundException {
		//创建商品数据访问层的对象
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//调用数据访问层的方法
		Vector<Vector<String>> products = dao.searchProductBySname(sname);
		//判断是否有商品
		if(products.size() == 0) {
			throw new ProductNotFoundException("暂无包含该供应商名称的商品信息");
		}
		return products;
	}
}
