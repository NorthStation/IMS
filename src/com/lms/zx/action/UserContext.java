package com.lms.zx.action;

import java.util.Vector;

import com.lms.zx.biz.IUserBiz;
import com.lms.zx.entity.User;
import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.user.UserInfoWrongException;
import com.lms.zx.exception.user.UserIsExistException;
import com.lms.zx.exception.user.UserIsNotFound;
import com.lms.zx.exception.user.UserIsNotHavePower;
import com.lms.zx.exception.user.UserNotFoundException;
import com.lms.zx.exception.user.UserPasswordIsWrongException;
import com.lms.zx.exception.user.UserPowerIsWrongException;
import com.lms.zx.factory.UserFactory;

 

/**
 * �û�����
 * <font color='red'><h1>ע�⣺</h1>
 *   ΪUserBizImpl�ṩһ��String ���͵� ������ loginUserName,��ʾ����Ա����
 *   ���û���¼�ɹ�֮��ΪlogingUserName��ֵ
  * </font>
 */
public class UserContext {
	/**
     * ��¼
     *@param userName  �û���
     *@param password  �û�����
     *@param power     Ȩ��
	 * @throws UserPowerIsWrongException 
	 * @throws UserPasswordIsWrongException 
	 * @throws UserNotFoundException 
	 * @throws DAOException 
     *@throws Exception �����쳣
     */
	public void login(String userName,String password,String power) throws DAOException, UserNotFoundException, UserPasswordIsWrongException, UserPowerIsWrongException{
		//�����û����󣬲���װ�û���Ϣ
		User user = new User(userName,password,power);
		IUserBiz biz=UserFactory.getUserBizImpl();
		//��¼
		biz.login(user);
	}
 	/**
	 * �����û����Ƽ���Ƿ���ϵͳ����Ա
	 * 
	 * @param username
	 *            �û�����
	 * @throws DAOException
	 *             �Զ����쳣
	 * @return boolean
 	 * @throws UserIsNotFound 
 	 * @throws DAOException 
 	 * @throws UserIsNotHavePower 
	 */
	public boolean checkUser(String username) throws UserIsNotHavePower, DAOException, UserIsNotFound{
		User user=new User();
		user.setName(username);
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		return userBiz.checkUserRank(user);
	
	}

	/**
	 * ����û�
	 * 
	 * @param username
	 *            �û�����
	 * @param password
	 *            ����
	 * @throws DAOException
	 *             �Զ����쳣
	 * @return boolean
	 * @throws UserIsNotFound 
	 * @throws UserIsNotHavePower 
	 * @throws DAOException 
	 * @throws UserIsExistException 
	 */
	public boolean add(String username, String password) throws UserIsExistException, DAOException, UserIsNotHavePower, UserIsNotFound{
		User user=new User();
		 user.setName(username);
		 user.setPassword(password);
		 IUserBiz userBiz=UserFactory.getUserBizImpl();
		 return userBiz.addUser(user);

	}

	/**
	 * �޸�����:�û���Ϊ��ǰ�ĵ�¼�û���ֻ�е�ǰ�ĵ�¼�û������޸�����
	 *@param userName
	 *@param newpwd
	 *@param oldpwd
	 *@throws DAOException 
	 *@return boolean
	 * @throws UserInfoWrongException 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public boolean modifyPwd(String userName,String newpwd, String oldpwd) throws DAOException, UserIsNotFound, UserInfoWrongException{
	 
		User user=new User();
		user.setName(userName);
		user.setPassword(oldpwd);
		 IUserBiz userBiz=UserFactory.getUserBizImpl();
		 return userBiz.modifyPwd(user, newpwd);
	}
	
	/**
	 * ��������û�������
	 * 
	 * @throws DAOException
	 * @return Vector<String>
	 * @throws UserIsNotHavePower 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public Vector<String> getNames() throws DAOException, UserIsNotFound, UserIsNotHavePower {
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		return userBiz.getAllName();

	}

	/**
	 * ��������Ա�޸������û���Ȩ��
	 * 
	 * @param username
	 *            �û���
	 * @param power
	 *            Ȩ��
	 * @throws DAOException
	 * @return boolean
	 * @throws UserIsNotHavePower 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public boolean modifyPower(String username, String power) throws DAOException, UserIsNotFound, UserIsNotHavePower {
 
		//������������
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		User user=new User();
		user.setName(username);
		user.setPower(power);
		return userBiz.modifyPower(user, power);
	}

	/**
	 * ��ɾ���û������չʾ�����û���Ϣ
	 * 
	 * @throws DAOException
	 * @return Vector<Vector<String>>
	 * @throws UserIsNotFound 
	 * @throws UserIsNotHavePower 
	 * @throws DAOException 
	 */
	public Vector<Vector<String>> showUserInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound {
		//������������
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		return userBiz.searchAllInfo();
	}

	/**
	 * �����û�����ɾ���û�
	 * 
	 * @param username �û���Ϣ
	 * @throws DAOException
	 * @return boolean
	 * @throws UserIsNotHavePower 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public boolean deleteUser(String username) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//������������
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		User user=new User();
		user.setName(username);
		return userBiz.deleteUserByName(user);
	}

}