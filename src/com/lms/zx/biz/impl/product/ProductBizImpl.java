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
	//�����Ʒ����������Ʒ������ֵ
	public int addProduct(Product product) throws ProductDaoException, ProductIdExistedException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.searchProductByPname(product.getName());
		//�ж���Ʒ��Ϣ�Ƿ��Ѵ���
		if(products.size() != 0) {
			throw new ProductIdExistedException("����Ʒ�Ѵ���");
		}
		dao.insertProduct(product);
		//������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��������ֵ
		Vector<Vector<String>> p = dao.searchProductByPname(product.getName());
		int id = Integer.parseInt(p.get(0).get(0));
		return id;
	}
	
	//ɾ����Ʒ
	public void deleteProductById(long id) throws ProductDaoException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		dao.deleteProductById(id);
	}
	
	//�޸���Ʒ��Ϣ
	public void modifyProduct(Product product) throws ProductDaoException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		dao.updateProduct(product);
	}
	
	//��ѯ���е���Ʒ
	public Vector<Vector<String>> getAllProduct() throws ProductDaoException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.queryAllProduct();
		return products;
	}
	
	//���ݹ�Ӧ�̱�Ų�ѯ��Ʒ��Ϣ
	public Vector<Vector<String>> getProductBySid(long sid) throws ProductNotFoundException, ProductDaoException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.queryProductBySid(sid);
		//�ж��Ƿ�����Ʒ
		if(products.size() == 0) {
			throw new ProductNotFoundException("���޸ù�Ӧ�̵���Ʒ��Ϣ");
		}
		return products;
	}
	
	//���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ
	public Vector<Vector<String>> getProductBySname(String sname) throws ProductDaoException, ProductNotFoundException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.queryProductBySname(sname);
		//�ж��Ƿ�����Ʒ
		if(products.size() == 0) {
			throw new ProductNotFoundException("���޸ù�Ӧ�̵���Ʒ��Ϣ");
		}
		return products;
	}
	
	//������Ʒ���Ͳ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException, ProductNotFoundException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.searchProductByPcategory(category);
		//�ж��Ƿ�����Ʒ
		if(products.size() == 0) {
			throw new ProductNotFoundException("���޸����͵���Ʒ��Ϣ");
		}
		return products;
	}
	
	//������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductNotFoundException, ProductDaoException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.searchProductByPname(pname);
		//�ж��Ƿ�����Ʒ
		if(products.size() == 0) {
			throw new ProductNotFoundException("���ް�������Ʒ���Ƶ���Ʒ��Ϣ");
		}
		return products;
	}
	
	//���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException, ProductNotFoundException {
		//������Ʒ���ݷ��ʲ�Ķ���
		IProductDao dao = ProductFactory.getProductDaoInstance();
		//�������ݷ��ʲ�ķ���
		Vector<Vector<String>> products = dao.searchProductBySname(sname);
		//�ж��Ƿ�����Ʒ
		if(products.size() == 0) {
			throw new ProductNotFoundException("���ް����ù�Ӧ�����Ƶ���Ʒ��Ϣ");
		}
		return products;
	}
}
