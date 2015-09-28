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
	 * 为UserBizImpl提供一个String 类型的 类属性 loginUserName,表示操作员名称 在用户登录成功之后为logingUserName赋值
	 */
	private static String loginUserName;//操作员名称
	
	public void login(User user) throws DAOException,UserNotFoundException,UserPasswordIsWrongException,UserPowerIsWrongException{
		//创建用户数据访问层对象
		IUserDAO dao=UserFactory.getUserDAOImpl();
		//查询用户信息
		User u=dao.queryUserByName(user.getName());
		System.out.println(user.getName());
		//判断用户是否存在
		if(u.getName() == null){
			throw new UserNotFoundException("该用户不存在");
		}
		//判断用户密码是否正确
		if(!(user.getPassword().equals(u.getPassword()))){
			throw new UserPasswordIsWrongException("密码有误");
		}
		//判断权限是否有误
		if(!(user.getPower().equals(u.getPower()))){
			throw new UserPowerIsWrongException("权限有误");
		}
		//登录成功
		loginUserName=user.getName();
	}

	//添加用户
	public boolean addUser(User user) throws UserIsExistException, DAOException, UserIsNotHavePower, UserIsNotFound {
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//判断是否是系统管理员
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//判断用户是否存在
		User u=userDao.queryUserByName(user.getName());
		if(user.getName().equals(u.getName())){
			throw new UserIsExistException("该用户已经存在！");
		}
		boolean flag=userDao.insertUser(user);
		return flag;
	}
	//根据用户名称检查是否是系统管理员
	public boolean checkUserRank(User user) throws UserIsNotHavePower, DAOException, UserIsNotFound {
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//根据用户名查找用户
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("用户不存在！");
		}
		if(!("系统管理员".equals(u.getPower()))){
			throw new UserIsNotHavePower("你没有管理员权限！");
		}
		return true;
	}
	//根据用户名删除用户
	public boolean deleteUserByName(User user) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//判断是否是系统管理员
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//查找用户是否存在
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("用户不存在！");
		}
		
		boolean flag=userDao.deleteUserByName(user);
		return flag;
	}
	//查询所有的用户名称
	public Vector<String> getAllName() throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//判断是否是系统管理员
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		Vector<String> userName=userDao.queryAllUserName();
		if(userName.size()==0){
			throw new UserIsNotFound("用户不存在！");
		}
		return userName;
	}
	//修改用户的权限
	public boolean modifyPower(User user, String power) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//判断是否是系统管理员
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//查找用户是否存在
		User u=userDao.queryUserByName(user.getName());
		if(u==null){
			throw new UserIsNotFound("用户不存在！");
		}
		return userDao.updatePowerByName(user, power);
	}
	
	//修改用户的密码
	public boolean modifyPwd(User user, String newPassword) throws DAOException, UserIsNotFound, UserInfoWrongException {
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		//查找用户
		User u=userDao.queryUserByName(user.getName());
		//查找原密码是否有误
		if(!(user.getPassword().equals(u.getPassword()))){
			throw new UserInfoWrongException("原密码有误");
		}
		return userDao.updatePwd(user, newPassword);
	}
	
	//查询所有用户的所有信息
	public Vector<Vector<String>> searchAllInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound {
		//判断是否是系统管理员
		User s=new User();
		s.setName(loginUserName);
		checkUserRank(s);
		//创建userDao对象
		IUserDAO userDao=UserFactory.getUserDAOImpl();
		Vector<Vector<String>> userInfo=userDao.queryAllUserInfo(loginUserName);
		return userInfo;
	}
}
