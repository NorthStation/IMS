package com.lms.zx.dao;

import java.util.Vector;
import com.lms.zx.entity.User;
import com.lms.zx.exception.DAOException;

public interface IUserDAO {
	/*
	 * queryUserByName��ͨ���û�����ѯ�û���Ϣ
	 * @param username �û���
	 * @return User �û�����
	 */
	public User queryUserByName(String username) throws DAOException;
	
	/**
	 * ����û�
	 * @param User �û�
	 * @return boolean
	 * @throws UserDaoException 
	 */
	public  boolean insertUser(User user) throws DAOException;

	/**
	 * �޸�����:�û���Ϊ��ǰ�ĵ�¼�û���ֻ�е�ǰ�ĵ�¼�û������޸�����
	 * @param User �û�
	 * @param newPassword ������
	 *  @return boolean
	 * @throws UserDaoException 
	 *  
	 */
	public boolean updatePwd(User user,String newPassword) throws DAOException;
	/**
	 * ��������û�������
	 * @throws UserDaoException 
	 * 
	 */
	public Vector<String> queryAllUserName() throws DAOException;
	/**
	 * ��������Ա�޸������û���Ȩ��
	 * @param User�û�
	 * @param power Ȩ��
	 * @throws UserDaoException 
	 */
	public boolean updatePowerByName(User user,String power) throws DAOException;
	/**
	 * ��ѯ���е��û���Ϣ
	 * @param Vector<Vector<String>>�����û�����Ϣ
	 * @throws UserDaoException 
	 */
	public Vector<Vector<String>> queryAllUserInfo(String loginUserName) throws DAOException;
	/**
	 * �����û���ɾ���û�
	 * @return boolean
	 * @throws UserDaoException 
	 */
	public boolean deleteUserByName(User user) throws DAOException;
}
