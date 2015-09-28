package com.lms.zx.dao;

import java.util.Vector;
import com.lms.zx.entity.User;
import com.lms.zx.exception.DAOException;

public interface IUserDAO {
	/*
	 * queryUserByName：通过用户名查询用户信息
	 * @param username 用户名
	 * @return User 用户对象
	 */
	public User queryUserByName(String username) throws DAOException;
	
	/**
	 * 添加用户
	 * @param User 用户
	 * @return boolean
	 * @throws UserDaoException 
	 */
	public  boolean insertUser(User user) throws DAOException;

	/**
	 * 修改密码:用户名为当前的登录用户。只有当前的登录用户才能修改密码
	 * @param User 用户
	 * @param newPassword 新密码
	 *  @return boolean
	 * @throws UserDaoException 
	 *  
	 */
	public boolean updatePwd(User user,String newPassword) throws DAOException;
	/**
	 * 获得所有用户的名称
	 * @throws UserDaoException 
	 * 
	 */
	public Vector<String> queryAllUserName() throws DAOException;
	/**
	 * 超级管理员修改其他用户的权限
	 * @param User用户
	 * @param power 权限
	 * @throws UserDaoException 
	 */
	public boolean updatePowerByName(User user,String power) throws DAOException;
	/**
	 * 查询所有的用户信息
	 * @param Vector<Vector<String>>返回用户的信息
	 * @throws UserDaoException 
	 */
	public Vector<Vector<String>> queryAllUserInfo(String loginUserName) throws DAOException;
	/**
	 * 根据用户名删除用户
	 * @return boolean
	 * @throws UserDaoException 
	 */
	public boolean deleteUserByName(User user) throws DAOException;
}
