package com.lms.zx.factory;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.biz.impl.supplie.SupplieBizImpl;
import com.lms.zx.dao.ISupplieDao;
import com.lms.zx.dao.impl.supplie.SupplieDaoImpl;

/**
 * SupplieFactory����Ӧ�̹���
 * @author Administrator
 *
 */
public abstract class SupplieFactory {
	//���ع�Ӧ���߼������
	public static ISupplieBiz getSupplieBizInstance() {
		return new SupplieBizImpl();
	}
	
	//���ع�Ӧ�����ݷ��ʲ����
	public static ISupplieDao getSupplieDaoInstance() {
		return new SupplieDaoImpl();
	}
}
