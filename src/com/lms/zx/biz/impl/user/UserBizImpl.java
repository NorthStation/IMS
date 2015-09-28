package com.lms.zx.biz.impl.user;

import java.util.Vector;

import com.lms.zx.biz.IUserBiz;
import com.lms.zx.dao.IUserDAO;
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

public class UserBizImpl implements IUserBiz {
	/*
	 * ΪUserBizImpl�ṩһ��String ���͵� ������ loginUserName,��ʾ����Ա���� ���û���¼�ɹ�֮��ΪlogingUserName��ֵ
	 */
	private static String loginUserName;//����Ա����
	
	public void login(User user) throws DAOException,UserNotFoundException,UserPasswordIsWrongException,UserPowerIsWrongException{
		//�����û����ݷ��ʲ����
		IUserDAO dao=UserFactory.getUserDAOImpl();
		//��ѯ�û���Ϣ
		User u=dao.queryUserByName(user.getName());
		System.out.println(user.getName());
		//�ж��û��Ƿ����
		if(u.getName() == null){
			throw new UserNotFoundException("���û�������");
		}
		//�ж��û������Ƿ���ȷ
		if(!(user.getPassword().equals(u.getPassword()))){
			throw new UserPasswordIsWrongException("��������");
		}
		//�ж�Ȩ���Ƿ�����
		if(!(user.getPower().equals(u.getPower()))){
			throw new UserPowerIsWrongException("Ȩ������");
		}
		//��¼�ɹ�
		loginUserName=user.getName();
	}

	//����û�
	public boolean addUser(User user) throws UserIsExistException, DAOException, UserIsNotHavePower, UserIsNotFound {
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//�ж��Ƿ���ϵͳ����Ա
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//�ж��û��Ƿ����
		User u=userDao.queryUserByName(user.getName());
		if(user.getName().equals(u.getName())){
			throw new UserIsExistException("���û��Ѿ����ڣ�");
		}
		boolean flag=userDao.insertUser(user);
		return flag;
	}
	//�����û����Ƽ���Ƿ���ϵͳ����Ա
	public boolean checkUserRank(User user) throws UserIsNotHavePower, DAOException, UserIsNotFound {
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//�����û��������û�
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("�û������ڣ�");
		}
		if(!("ϵͳ����Ա".equals(u.getPower()))){
			throw new UserIsNotHavePower("��û�й���ԱȨ�ޣ�");
		}
		return true;
	}
	//�����û���ɾ���û�
	public boolean deleteUserByName(User user) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//�ж��Ƿ���ϵͳ����Ա
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//�����û��Ƿ����
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("�û������ڣ�");
		}
		
		boolean flag=userDao.deleteUserByName(user);
		return flag;
	}
	//��ѯ���е��û�����
	public Vector<String> getAllName() throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//�ж��Ƿ���ϵͳ����Ա
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		Vector<String> userName=userDao.queryAllUserName();
		if(userName.size()==0){
			throw new UserIsNotFound("�û������ڣ�");
		}
		return userName;
	}
	//�޸��û���Ȩ��
	public boolean modifyPower(User user, String power) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//�ж��Ƿ���ϵͳ����Ա
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//�����û��Ƿ����
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("�û������ڣ�");
		}
		return userDao.updatePowerByName(user, power);
	}
	
	//�޸��û�������
	public boolean modifyPwd(User user, String newPassword) throws DAOException, UserIsNotFound, UserInfoWrongException {
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//�����û�
		User u=userDao.queryUserByName(user.getName());
		//����ԭ�����Ƿ�����
		if(!(user.getPassword().equals(u.getPassword()))){
			throw new UserInfoWrongException("ԭ��������");
		}
		return userDao.updatePwd(user, newPassword);
	}
	
	//��ѯ�����û���������Ϣ
	public Vector<Vector<String>> searchAllInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound {
		//�ж��Ƿ���ϵͳ����Ա
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//����userDao����
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		Vector<Vector<String>> userInfo=userDao.queryAllUserInfo(loginUserName);
		return userInfo;
	}
}
