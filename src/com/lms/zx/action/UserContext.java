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
 * 用户管理
 * <font color='red'><h1>注意：</h1>
 *   为UserBizImpl提供一个String 类型的 类属性 loginUserName,表示操作员名称
 *   在用户登录成功之后为logingUserName赋值
  * </font>
 */
public class UserContext {
	/**
     * 登录
     *@param userName  用户名
     *@param password  用户密码
     *@param power     权限
	 * @throws UserPowerIsWrongException 
	 * @throws UserPasswordIsWrongException 
	 * @throws UserNotFoundException 
	 * @throws DAOException 
     *@throws Exception 处理异常
     */
	public void login(String userName,String password,String power) throws DAOException, UserNotFoundException, UserPasswordIsWrongException, UserPowerIsWrongException{
		//创建用户对象，并封装用户信息
		User user = new User(userName,password,power);
		IUserBiz biz=UserFactory.getUserBizImpl();
		//登录
		biz.login(user);
	}
 	/**
	 * 根据用户名称检查是否是系统管理员
	 * 
	 * @param username
	 *            用户名称
	 * @throws DAOException
	 *             自定义异常
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
	 * 添加用户
	 * 
	 * @param username
	 *            用户名称
	 * @param password
	 *            密码
	 * @throws DAOException
	 *             自定义异常
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
	 * 修改密码:用户名为当前的登录用户。只有当前的登录用户才能修改密码
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
	 * 获得所有用户的名称
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
	 * 超级管理员修改其他用户的权限
	 * 
	 * @param username
	 *            用户名
	 * @param power
	 *            权限
	 * @throws DAOException
	 * @return boolean
	 * @throws UserIsNotHavePower 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public boolean modifyPower(String username, String power) throws DAOException, UserIsNotFound, UserIsNotHavePower {
 
		//创建工厂对象
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		User user=new User();
		user.setName(username);
		user.setPower(power);
		return userBiz.modifyPower(user, power);
	}

	/**
	 * 在删除用户面板中展示所有用户信息
	 * 
	 * @throws DAOException
	 * @return Vector<Vector<String>>
	 * @throws UserIsNotFound 
	 * @throws UserIsNotHavePower 
	 * @throws DAOException 
	 */
	public Vector<Vector<String>> showUserInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound {
		//创建工厂对象
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		return userBiz.searchAllInfo();
	}

	/**
	 * 根据用户名称删除用户
	 * 
	 * @param username 用户信息
	 * @throws DAOException
	 * @return boolean
	 * @throws UserIsNotHavePower 
	 * @throws UserIsNotFound 
	 * @throws DAOException 
	 */
	public boolean deleteUser(String username) throws DAOException, UserIsNotFound, UserIsNotHavePower {
		//创建工厂对象
		IUserBiz userBiz=UserFactory.getUserBizImpl();
		User user=new User();
		user.setName(username);
		return userBiz.deleteUserByName(user);
	}

}