package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.ISupplieBiz;
import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.exception.supplie.SupplierIsExistedException;
import com.lms.zx.exception.supplie.SupplierNotFoundException;
import com.lms.zx.factory.SupplieFactory;

 
 
/**
 * 供应商管理
 */
public class SupplieContext {
	/**
	 * 查询所有供应商的信息
	 *@return Vector<Vector<String>>
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 */
	public Vector<Vector<String>> findAllInfo() throws SupplieDaoException{
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层方法
			Vector<Vector<String>> suppliers = biz.searchAllSupplier();
			return suppliers;
	}
	
	/** 查询所有供应商的名称 
	 * @throws SupplieDaoException */
	public Vector<String> getSupplieNames() throws SupplieDaoException {
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层方法
			Vector<String> names = biz.searchSupplierNames();
			return names;
	}

	/** 根据供应商的名称查找供应商信息 
	 *@param supplieName 供应商名称
	 *return Vector<String> 供应商 
	 *[供应商编号，供应商名称，电话，联系人，银行，银行帐号，地址]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<String> getSupplieByName(String supplieName) throws SupplieDaoException, SupplierNotFoundException {
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层方法
			Vector<String> supplie = biz.searchSupplierByName(supplieName);
			return supplie;
		}
	
	/** 根据供应商的名称查找供应商信息 ，模糊查询
	 *@param supplieName 供应商名称
	 *return Vector<String> 供应商 
	 *[供应商编号，供应商名称，电话，联系人，银行，银行帐号，地址]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<Vector<String>> getSuppliesByName(String supplieName) throws SupplieDaoException, SupplierNotFoundException {
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层方法
			Vector<Vector<String>> s = biz.searchSuppliersByName(supplieName);
			return s;
		}
	
	/** 根据供应商的id查找供应商 
	 *@param sid 供应商id
	 *return Vector<String> 供应商 
	 *[供应商编号，供应商名称，电话，联系人，银行，银行帐号，地址]
	 * @throws SupplierNotFoundException 
	 * @throws SupplieDaoException 
	 **/
	public Vector<String> getSupplieById(int sid) throws SupplieDaoException, SupplierNotFoundException {
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层方法
			return biz.searchSupplierById(sid);
			
	}
	
	
	/**
	 * 添加供应商
	 *@param suppliers 供应商基本信息
	 *@return int 供应商主键信息
	 * @throws SupplierIsExistedException 
	 * @throws SupplieDaoException 
	 */
	public int saveSupplie(Vector<String> suppliers) throws SupplieDaoException, SupplierIsExistedException {
			//封装供应商信息
			Supplie s = new Supplie();
			System.out.print("添加");
			int i = 0;
			s.setName(suppliers.get(i++));
			s.setAddress(suppliers.get(i++));
			s.setPhone(suppliers.get(i++));
			s.setLinkman(suppliers.get(i++));
			s.setBank(suppliers.get(i++));
			s.setAccount(suppliers.get(i++));
			s.setEmail(suppliers.get(i++));
			
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层的添加方法，并返回主键值
			return biz.addSupplier(s);
	}

	/**
	 * 根据供应商id修改供应商基本信息
	 *@param id   供应商id
	 *@param name 供应商名称
	 *@param linkman 联系人
	 *@param phone   联系电话
	 *@param email   email
	 *@param bank    开户银行
	 *@param account  银行帐号
	 *@param dress    地址
	 *@return 
	 *@return boolean  是否添加成功
	 * @throws SupplieDaoException 
	 */
	public boolean updateSupplie(String id, String name, String linkman,
			String phone, String email, String bank, String account,
			String dress) throws SupplieDaoException {
			//封装供应商
			Supplie s = new Supplie();
			s.setId(Integer.parseInt(id));
			s.setName(name);
			s.setLinkman(linkman);
			s.setPhone(phone);
			s.setEmail(email);
			s.setBank(bank);
			s.setAccount(account);
			s.setAddress(dress);
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层的添加方法
			return biz.modifySupplier(s);
		}
    
	/**
	 *根据供应商id修改供应商基本信息 
	 *@param supplier
	 *@return 
	 *@return boolean
	 * @throws SupplieDaoException 
	 */
	public boolean updateSupplie(Vector<String> suppliers) throws SupplieDaoException {
			System.out.println("---------------------------------------updateActon");
			//封装供应商信息
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
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层的添加方法
			return biz.modifySupplier(s);
		}

	/**根据id删除供应商
	 * @throws SupplieDaoException */
	public boolean deleteSupplieById(int sid) throws SupplieDaoException{
			//创建逻辑层对象
			ISupplieBiz biz = SupplieFactory.getSupplieBizInstance();
			//调用逻辑层的添加方法
			return biz.deleteSupplierById(sid);
	}
}
