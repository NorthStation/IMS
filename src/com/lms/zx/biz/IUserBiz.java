package com.lms.zx.biz;

import java.util.Vector;

import com.lms.zx.entity.User;
import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.user.UserInfoWrongException;
import com.lms.zx.exception.user.UserIsExistException;
import com.lms.zx.exception.user.UserIsNotFound;
import com.lms.zx.exception.user.UserIsNotHavePower;
import com.lms.zx.exception.user.UserNotFoundException;
import com.lms.zx.exception.user.UserPasswordIsWrongException;
import com.lms.zx.exception.user.UserPowerIsWrongException;

public interface IUserBiz {
	/*
	 * login���û���¼
	 * @param user �û���Ϣ���û��������룬Ȩ�ޣ�
	 */
	public void login(User user) throws DAOException,UserNotFoundException,UserPasswordIsWrongException,UserPowerIsWrongException;

	/*
	 * ����û�
	 * @param User �û�
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean addUser(User user) throws UserIsExistException, DAOException, UserIsNotHavePower, UserIsNotFound;
	
	/*
	 * �����û����Ƽ���Ƿ���ϵͳ����Ա
	 * @param User �û�
	 */
	public boolean checkUserRank(User user) throws UserIsNotHavePower, DAOException, UserIsNotFound;
	
	/*
	 * �޸�����:�û���Ϊ��ǰ�ĵ�¼�û���ֻ�е�ǰ�ĵ�¼�û������޸�����
	 * @param user �û�����
	 * @param newPassword �޸ĵ�����
	 * @return boolean ���� �����Ƿ�ɹ�
	 */
	public boolean modifyPwd(User user,String newPassword) throws DAOException, UserIsNotFound, UserInfoWrongException;
	/*
	 * ��������û�����
	 * @return Vector<String> ���е��û�������
	 */
	public Vector<String> getAllName() throws DAOException, UserIsNotFound, UserIsNotHavePower;
	/*
	 * ��������û���Ϣ
	 * @return Vector<Vector<String>> �û�����
	 */
	public  Vector<Vector<String>> searchAllInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound;
	/*
	 * �޸�Ȩ��:ֻ�й���Ա�����޸��û�Ȩ��
	 * @param user �û���Ϣ
	 * @param power �޸ĵ�Ȩ��
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean modifyPower(User user,String power) throws DAOException, UserIsNotFound, UserIsNotHavePower;
	/*
	 * �����û���ɾ���û�
	 * @param user �û���Ϣ
	 * @return boolean ���ز����Ƿ�ɹ�
	 */
	public boolean deleteUserByName(User user) throws DAOException, UserIsNotFound, UserIsNotHavePower;
}
