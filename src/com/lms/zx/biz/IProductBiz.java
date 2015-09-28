package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductIdExistedException;
import com.lms.zx.exception.product.ProductNotFoundException;

/**
 * IProductBiz����Ʒ�߼��ӿ�
 * @author Administrator
 *
 */
public interface IProductBiz {
	/*
	 * addProduct�������Ʒ��Ϣ
	 * @param product ��Ʒ��Ϣ
	 * @return int ��Ʒ������ֵ
	 */
	public int addProduct(Product product) throws ProductDaoException, ProductIdExistedException;
	
	/*
	 * deleteProductById��������Ʒ���ɾ����Ʒ��Ϣ
	 * @param id ��Ʒ���
	 */
	public void deleteProductById(long id) throws ProductDaoException;
	
	/*
	 * modifyProduct���޸���Ʒ��Ϣ
	 * @param product ���޸ĵ���Ʒ��Ϣ
	 */
	public void modifyProduct(Product product) throws ProductDaoException;
	
	/*
	 * getAllProduct����ѯ������Ʒ��Ϣ
	 */
	public Vector<Vector<String>> getAllProduct() throws ProductDaoException;
	
	/*
	 * getProductBySid�����ݹ�Ӧ�̱�Ų�ѯ��Ʒ��Ϣ
	 * @param sid ��Ӧ�̱��
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> getProductBySid(long sid) throws ProductNotFoundException, ProductDaoException;
	
	/*
	 * getProductBySname�����ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ
	 * @param sname ��Ӧ������
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> getProductBySname(String sname) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductBySname�����ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param sname ��Ӧ������
	 * @return Vector<Vecotr<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductByPcategory��������Ʒ���Ͳ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param category ��Ʒ����
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException, ProductNotFoundException;
	
	/*
	 * searchProductByPname��������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	 * @param pname ��Ʒ����
	 * @return Vector<Vector<String>> ��Ʒ��Ϣ����
	 */
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductNotFoundException, ProductDaoException;
}
