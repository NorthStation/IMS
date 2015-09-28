package com.lms.zx.biz.impl.supplie;

import java.util.Vector;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.dao.ISupplieDao;
import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;
import com.lms.zx.factory.SupplieFactory;

public class SupplieBizImpl implements ISupplieBiz{
	//��ӹ�Ӧ��
	public int addSupplier(Supplie supplie) throws SupplieDaoException, SupplierIsExistedException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//ͨ�����Ʋ�ѯ��Ӧ��
		Vector<String> s = dao.querySupplierByName(supplie.getName());
		//�жϹ�Ӧ���Ƿ��Ѵ���
		if(s.size() != 0) {
			throw new SupplierIsExistedException("�ù�Ӧ���Ѵ���");
		}
		//�������ݷ��ʲ�ķ���
		dao.insertSupplier(supplie);
		//�������ݷ��ʲ�ķ���
		Vector<String> p = dao.querySupplierByName(supplie.getName());
		int id = Integer.parseInt(p.get(0));
		return id;
	}

	//ɾ����Ӧ��
	public boolean deleteSupplierById(long id) throws SupplieDaoException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽���������صײ����ݿ���Ӱ��ļ�¼��
		int number = dao.deleteSupplierById(id);
		return number != 0;
	}
	
	//�޸Ĺ�Ӧ����Ϣ
	public boolean modifySupplier(Supplie supplier) throws SupplieDaoException {
		System.out.println("---------------------------------------updateBiz");
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽���������صײ����ݿ���Ӱ��ļ�¼��
		int number = dao.updateSupplier(supplier);
		return number != 0;
	}
	
	//��ѯ���еĹ�Ӧ����Ϣ
	public Vector<Vector<String>> searchAllSupplier() throws SupplieDaoException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽��
		Vector<Vector<String>> suppliers = dao.queryAllSupplier();
		return suppliers;
	}
	
	//���ݱ�Ų�ѯ��Ӧ����Ϣ
	public Vector<String> searchSupplierById(long id) throws SupplieDaoException, SupplierNotFoundException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽��
		Vector<String> s = dao.querySupplierById(id);
		//�ж��Ƿ���ڸù�Ӧ����Ϣ
		if(s.size() == 0) {
			throw new SupplierNotFoundException("��Ӧ�̲�����");
		}
		return s;
	}
	
	//�������Ʋ�ѯ��Ӧ����Ϣ
	public Vector<String> searchSupplierByName(String name) throws SupplieDaoException, SupplierNotFoundException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽��
		Vector<String> s = dao.querySupplierByName(name);
		//�ж��Ƿ���ڸù�Ӧ����Ϣ
		if(s.size() == 0) {
			throw new SupplierNotFoundException("��Ӧ�̲�����");
		}
		return s;
	}
	
	//�������Ʋ�ѯ��Ӧ����Ϣ:ģ����ѯ
	public Vector<Vector<String>> searchSuppliersByName(String name) throws SupplieDaoException, SupplierNotFoundException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽��
		Vector<Vector<String>> s = dao.querySuppliersByName(name);
		//�ж��Ƿ���ڸù�Ӧ����Ϣ
		if(s.size() == 0) {
			throw new SupplierNotFoundException("��Ӧ�̲�����");
		}
		return s;
	}
	
	//��ѯ���еĹ�Ӧ������
	public Vector<String> searchSupplierNames() throws SupplieDaoException {
		//������Ӧ�����ݲ����
		ISupplieDao dao = SupplieFactory.getSupplieDaoInstance();
		//�������ݷ��ʲ�Ĳ��뷽��
		Vector<String> s = dao.querySupplierNames();
		return s;
	}
}
