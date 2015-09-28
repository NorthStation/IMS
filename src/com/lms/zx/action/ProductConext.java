package com.lms.zx.action;


import java.util.Vector;

import com.lms.zx.biz.IProductBiz;
import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.exception.product.ProductIdExistedException;
import com.lms.zx.exception.product.ProductNotFoundException;
import com.lms.zx.factory.ProductFactory;

/**
 * ��Ʒ�����߼�
 */
public class ProductConext {
	/**
	 * ���ݹ�Ӧ��id���������Ʒ
	 * 
	 * @param sId
	 *            ��Ӧ�̵�id
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> getProductMsgBySid(int sId) throws ProductNotFoundException, ProductDaoException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.getProductBySid(sId);
		}

	/**
	 * ������е���Ʒ��Ϣ
	 * 
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> getAllProductMsg() throws ProductDaoException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.getAllProduct();
		}

	/**
	 * ���ݹ�Ӧ��id���������Ʒ
	 * 
	 * @param setId
	 *            ��Ӧ�̵�id
	 * @return
	 * @return Vector<Vector<String>>
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> getProductMsgBysetSid(int setSid) throws ProductNotFoundException, ProductDaoException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.getProductBySid(setSid);
		}

	/**
	 * ���ݹ�Ӧ�̵����ƻ����Ʒ����Ϣ
	 * 
	 * @param supplieName
	 *            ��Ӧ�̵�����
	 * @return Vector<Vector<String>>
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> getProductMsgBySupplieName(String supplieName) throws ProductDaoException, ProductNotFoundException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.getProductBySname(supplieName);
		}

	/**
	 * �����Ʒ
	 * 
	 * @param name
	 *            ��Ʒ����
	 * @param genre
	 *            ��Ʒ����
	 * @param price
	 *            ��Ʒ�۸�
	 * @param specific
	 *            ���
	 * @param unit
	 *            ��λ
	 * @param supplierId
	 *            ��Ӧ��id
	 * @param madeIn
	 *            ����
	 * @param remark
	 *            ��ע
	 * @return
	 * @throws Exception
	 * @return int ���ز�����Ʒ������
	 * @throws ProductIdExistedException 
	 * @throws ProductDaoException 
	 */
	public int addProduct(String name, String genre, double price,
			String specific, String unit, int supplierId, String madeIn,
			String remark) throws ProductDaoException, ProductIdExistedException {
			//��װ��Ʒ
			Product product = new Product();
			product.setName(name);
			product.setGenre(genre);
			product.setMadeIn(madeIn);
			product.setPrice(price);
			product.setSpecific(specific);
			product.setUnit(unit);
			product.setSupplieId(supplierId);
			product.setRemarks(remark);
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.addProduct(product);
		}

	/**
	 * ������Ʒid�޸���Ʒ��Ϣ
	 * 
	 * @param pid
	 *            ��Ʒid
	 * @param name
	 *            ��Ʒ����
	 * @param category
	 *            ��Ʒ����
	 * @param price
	 *            ��Ʒ�۸�
	 * @param specific
	 *            ���
	 * @param unit
	 *            ��λ
	 * @param supplierId
	 *            ��Ӧ��id
	 * @param madeIn
	 *            ����
	 * @param remark
	 *            ��ע
	 * @throws Exception
	 * @return void
	 * @throws ProductDaoException 
	 */
	public void modifyProduct(int pid, String name, String category,
			double price, String specific, String unit, int supplierId,
			String madeIn, String remark) throws ProductDaoException {
			//��װ��Ʒ
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
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			biz.modifyProduct(product);
		}

	/**
	 * ������Ʒidɾ����Ʒ
	 * 
	 * @param id
	 *            ��Ʒid
	 * @throws Exception
	 * @return void
	 * @throws ProductDaoException 
	 */
	public void deleteProduct(long id) throws ProductDaoException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			biz.deleteProductById(id);
		}

	/**
	 * ������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��ʹ��ģ����ѯ
	 * 
	 * @param productName
	 *            ��Ʒ����
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [��Ʒ��ţ���Ʒ���ƣ���𣬼۸񣬹�񣬵�λ����Ӧ�����ƣ���ע������]
	 * @throws ProductDaoException 
	 * @throws ProductNotFoundException 
	 */
	public Vector<Vector<String>> searchByProductName(String productName) throws ProductNotFoundException, ProductDaoException{
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.searchProductByPname(productName);
		}

	/**
	 * ���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ��֧��ģ����ѯ
	 * 
	 * @param supplierName
	 *            ��Ӧ������
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [��Ʒ��ţ���Ʒ���ƣ���𣬼۸񣬹�񣬵�λ����Ӧ�����ƣ���ע������]
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> searchByProductSupplier(String supplierName) throws ProductDaoException, ProductNotFoundException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.searchProductBySname(supplierName);
		}

	/**
	 * ������Ʒ���Ͳ�ѯ��Ʒ��Ϣ��֧��ģ����ѯ
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 * @return Vector<Vector<String>> [��Ʒ��ţ���Ʒ���ƣ���𣬼۸񣬹�񣬵�λ����Ӧ�����ƣ���ע������]
	 * @throws ProductNotFoundException 
	 * @throws ProductDaoException 
	 */
	public Vector<Vector<String>> searchByProductCategory(String category) throws ProductDaoException, ProductNotFoundException {
			//������Ʒ�߼������
			IProductBiz biz = ProductFactory.getProductBizInstance();
			//�����߼��㷽��
			return biz.searchProductByPcategory(category);
		}
}
