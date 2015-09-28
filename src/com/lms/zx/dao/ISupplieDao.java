package com.lms.zx.dao;

import java.util.Vector;

import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;

/**
 * ISupplieDao:��Ӧ�����ݷ��ʲ�ӿ�
 * @author Administrator
 *
 */
public interface ISupplieDao {
	/*
	 * insertSupplier�����빩Ӧ�̼�¼
	 * @param supplie ��Ӧ����Ϣ
	 */
	public void insertSupplier(Supplie supplie) throws SupplieDaoException;
	
	/*
	 * deleteSupplierById:ɾ����Ӧ����Ϣ
	 * @param id ��Ӧ�̱��
	 * @return int ���صײ����ݿ���Ӱ��ļ�¼��
	 */
	public int deleteSupplierById(long id) throws SupplieDaoException;
	
	/*
	 * updateSuppllie���޸Ĺ�Ӧ����Ϣ
	 * @param supplie �޸���Ϣ
	 * @return int ���صײ����ݿ���Ӱ��ļ�¼��
	 */
	public int updateSupplier(Supplie supplie) throws SupplieDaoException;
	
	/*
	 * queryAllSupplier����ѯ���еĹ�Ӧ����Ϣ
	 * @return Vector<Vector<String>> �������еĹ�Ӧ����Ϣ
	 */
	public Vector<Vector<String>> queryAllSupplier() throws SupplieDaoException ;
	
	/*
	 * querySupplierById��ͨ����Ų�ѯ��Ӧ����Ϣ
	 * @param id ��Ӧ�̱��
	 * @return Vector<String> ���ع�Ӧ����Ϣ
	 */
	public Vector<String> querySupplierById(long id) throws SupplieDaoException;
	
	/*
	 * querySupplierByName��ͨ�����Ʋ�ѯ��Ӧ����Ϣ
	 * @param name ��Ӧ������
	 * @return Vector<String> ��Ӧ����Ϣ
	 */
	public Vector<String> querySupplierByName(String name) throws SupplieDaoException;
	
	/*
	 * querySuppliesByName��ͨ�����Ʋ�ѯ��Ӧ����Ϣ:ģ����ѯ
	 * @param name ��Ӧ������
	 * @return Vector<Vector<String>> ��Ӧ����Ϣ
	 */
	public Vector<Vector<String>> querySuppliersByName(String name) throws SupplieDaoException;
	
	/*
	 * querySupplierNames����ѯ���й�Ӧ�̵�����
	 * @return Vector<String> ���й�Ӧ������
	 */
	public Vector<String> querySupplierNames() throws SupplieDaoException;
}
