package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;
import com.lms.zx.factory.SupplieFactory;

 
 
/**
 * ��Ӧ�̹���
 */
public class SupplieContext {
	/**
	 * ��ѯ���й�Ӧ�̵���Ϣ
	 *@return Vector<Vector<String>>
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 */
	public Vector<Vector<String>> findAllInfo() throws SupplieDaoException{
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼��㷽��
			Vector<Vector<String>> suppliers = biz.searchAllSupplier();
			return suppliers;
	}
	
	/** ��ѯ���й�Ӧ�̵����� 
	 * @throws SupplieDaoException */
	public Vector<String> getSupplieNames() throws SupplieDaoException {
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼��㷽��
			Vector<String> names = biz.searchSupplierNames();
			return names;
	}

	/** ���ݹ�Ӧ�̵����Ʋ��ҹ�Ӧ����Ϣ 
	 *@param supplieName ��Ӧ������
	 *return Vector<String> ��Ӧ�� 
	 *[��Ӧ�̱�ţ���Ӧ�����ƣ��绰����ϵ�ˣ����У������ʺţ���ַ]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<String> getSupplieByName(String supplieName) throws SupplieDaoException, SupplierNotFoundException {
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼��㷽��
			Vector<String> supplie = biz.searchSupplierByName(supplieName);
			return supplie;
		}
	
	/** ���ݹ�Ӧ�̵����Ʋ��ҹ�Ӧ����Ϣ ��ģ����ѯ
	 *@param supplieName ��Ӧ������
	 *return Vector<String> ��Ӧ�� 
	 *[��Ӧ�̱�ţ���Ӧ�����ƣ��绰����ϵ�ˣ����У������ʺţ���ַ]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<Vector<String>> getSuppliesByName(String supplieName) throws SupplieDaoException, SupplierNotFoundException {
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼��㷽��
			Vector<Vector<String>> s = biz.searchSuppliersByName(supplieName);
			return s;
		}
	
	/** ���ݹ�Ӧ�̵�id���ҹ�Ӧ�� 
	 *@param sid ��Ӧ��id
	 *return Vector<String> ��Ӧ�� 
	 *[��Ӧ�̱�ţ���Ӧ�����ƣ��绰����ϵ�ˣ����У������ʺţ���ַ]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<String> getSupplieById(int sid) throws SupplieDaoException, SupplierNotFoundException {
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼��㷽��
			return biz.searchSupplierById(sid);
			
	}
	
	
	/**
	 * ��ӹ�Ӧ��
	 *@param suppliers ��Ӧ�̻�����Ϣ
	 *@return int ��Ӧ��������Ϣ
	 * @throws SupplierIsExistedException 
	 * @throws SupplieDaoException 
	 */
	public int saveSupplie(Vector<String> suppliers) throws SupplieDaoException, SupplierIsExistedException {
			//��װ��Ӧ����Ϣ
			Supplie s = new Supplie();
			System.out.print("���");
			int i = 0;
			s.setName(suppliers.get(i++));
			s.setAddress(suppliers.get(i++));
			s.setPhone(suppliers.get(i++));
			s.setLinkman(suppliers.get(i++));
			s.setBank(suppliers.get(i++));
			s.setAccount(suppliers.get(i++));
			s.setEmail(suppliers.get(i++));
			
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼������ӷ���������������ֵ
			return biz.addSupplier(s);
	}

	/**
	 * ���ݹ�Ӧ��id�޸Ĺ�Ӧ�̻�����Ϣ
	 *@param id   ��Ӧ��id
	 *@param name ��Ӧ������
	 *@param linkman ��ϵ��
	 *@param phone   ��ϵ�绰
	 *@param email   email
	 *@param bank    ��������
	 *@param account  �����ʺ�
	 *@param dress    ��ַ
	 *@return 
	 *@return boolean  �Ƿ���ӳɹ�
	 * @throws SupplieDaoException 
	 */
	public boolean updateSupplie(String id, String name, String linkman,
			String phone, String email, String bank, String account,
			String dress) throws SupplieDaoException {
			//��װ��Ӧ��
			Supplie s = new Supplie();
			s.setId(Integer.parseInt(id));
			s.setName(name);
			s.setLinkman(linkman);
			s.setPhone(phone);
			s.setEmail(email);
			s.setBank(bank);
			s.setAccount(account);
			s.setAddress(dress);
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼������ӷ���
			return biz.modifySupplier(s);
		}
    
	/**
	 *���ݹ�Ӧ��id�޸Ĺ�Ӧ�̻�����Ϣ 
	 *@param supplier
	 *@return 
	 *@return boolean
	 * @throws SupplieDaoException 
	 */
	public boolean updateSupplie(Vector<String> suppliers) throws SupplieDaoException {
			System.out.println("---------------------------------------updateActon");
			//��װ��Ӧ����Ϣ
			Supplie s = new Supplie();
			int i = 0;
			s.setName(suppliers.get(i++));
			s.setAddress(suppliers.get(i++));
			s.setPhone(suppliers.get(i++));
			s.setLinkman(suppliers.get(i++));
			s.setBank(suppliers.get(i++));
			s.setAccount(suppliers.get(i++));
			s.setEmail(suppliers.get(i++));
			s.setId(Long.parseLong(suppliers.get(i)));
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼������ӷ���
			return biz.modifySupplier(s);
		}

	/**����idɾ����Ӧ��
	 * @throws SupplieDaoException */
	public boolean deleteSupplieById(int sid) throws SupplieDaoException{
			//�����߼������
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//�����߼������ӷ���
			return biz.deleteSupplierById(sid);
	}
}
