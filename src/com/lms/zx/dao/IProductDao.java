package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;

public interface IProductDao {
	/*
	 * insertProduct��������Ʒ��¼
	 * @param product ��Ʒ��Ϣ
	 */
	public void insertProduct(Product product) throws ProductDaoException;
	
	/*
	 * deleteProductById�����ݱ��ɾ����Ʒ��¼
	 * @param id ��Ʒ���
	 */
	public void deleteProductById(long id) throws ProductDaoException;
	
	/*
	 * updateProduct��������Ʒ��¼
	 * @param product ���޸ĵ���Ʒ��Ϣ
	 */
	public void updateProduct(Product product) throws ProductDaoException;
	
	/*
	 * queryAllProduct����ѯ���е���Ʒ��Ϣ
	 * @return Vector<Product> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> queryAllProduct() throws ProductDaoException;
	
	/*
	 * queryProductBySid�����ݹ�Ӧ�̱�Ų�ѯ��Ʒ��Ϣ
	 * @param sid ��Ӧ�̱��
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> queryProductBySid(long sid) throws ProductDaoException;
	
	/*
	 * queryProductBySname:���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ
	 * @param sname ��Ӧ������
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ���� 
	 */
	public Vector<Vector<String>> queryProductBySname(String sname) throws ProductDaoException;
	
	/*
	 * searchProductBySname�����ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param sname ��Ӧ������
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException;
	
	/*
	 * searchProductByPcategory��������Ʒ���Ͳ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param category ��Ʒ����
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException;
	
	/*
	 * searchProductByPname��������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param pname ��Ʒ����
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductDaoException;
}
