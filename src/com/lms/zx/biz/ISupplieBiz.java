package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;

/**
 * ISupplieBiz����Ӧ���߼���ӿ�
 * @author Administrator
 *
 */
public interface ISupplieBiz {
	/*
	 * addSupplier����ӹ�Ӧ��
	 * @param supplie ��Ӧ�̵ľ�����Ϣ
	 * @return int ���ع�Ӧ�̵�����ֵ
	 */
	public int addSupplier(Supplie supplie) throws SupplieDaoException, SupplierIsExistedException;
	
	/*
	 * deleteSupplierById�����ݱ��ɾ����Ӧ����Ϣ
	 * @param id ��Ӧ�̱��
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean deleteSupplierById(long id) throws SupplieDaoException;
	
	/*
	 * modifySupplier���޸Ĺ�Ӧ����Ϣ
	 * @param supplier ���޸ĵĹ�Ӧ����Ϣ
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean modifySupplier(Supplie supplier) throws SupplieDaoException;
	
	/*
	 * searchAllSupplier����ѯ���еĹ�Ӧ����Ϣ
	 * @return Vector<Vector<String>> ��Ӧ����Ϣ
	 */
	public Vector<Vector<String>> searchAllSupplier() throws SupplieDaoException;
	
	/*
	 * searchSupplierById�����ݱ�Ų�ѯ��Ӧ����Ϣ
	 * @param id ��Ӧ�̱��
	 * @return Vector<String> ��Ӧ����Ϣ
	 */
	public Vector<String> searchSupplierById(long id) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSupplierByName���������Ʋ�ѯ��Ӧ����Ϣ
	 * @param name ��Ӧ������
	 * @return Vector<String> ��Ӧ����Ϣ
	 */
	public Vector<String> searchSupplierByName(String name) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSuppliersByName���������Ʋ�ѯ��Ӧ����Ϣ:ģ����ѯ
	 * @param name ��Ӧ������
	 * @return Vector<String> ��Ӧ����Ϣ
	 */
	public Vector<Vector<String>> searchSuppliersByName(String name) throws SupplieDaoException, SupplierNotFoundException;
	
	/*
	 * searchSupplierNames:��ѯ���еĹ�Ӧ������
	 * @return Vector<String> ���еĹ�Ӧ������
	 */
	public Vector<String> searchSupplierNames() throws SupplieDaoException;
}
