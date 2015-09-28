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
	 * login：用户登录
	 * @param user 用户信息（用户名，密码，权限）
	 */
	public void login(User user) throws DAOException,UserNotFoundException,UserPasswordIsWrongException,UserPowerIsWrongException;

	/*
	 * 添加用户
	 * @param User 用户
	 * @return boolean 返回操作是否成功
	 */
	public boolean addUser(User user) throws UserIsExistException, DAOException, UserIsNotHavePower, UserIsNotFound;
	
	/*
	 * 根据用户名称检查是否是系统管理员
	 * @param User 用户
	 */
	public boolean checkUserRank(User user) throws UserIsNotHavePower, DAOException, UserIsNotFound;
	
	/*
	 * 修改密码:用户名为当前的登录用户。只有当前的登录用户才能修改密码
	 * @param user 用户对象
	 * @param newPassword 修改的密码
	 * @return boolean 返回 操作是否成功
	 */
	public boolean modifyPwd(User user,String newPassword) throws DAOException, UserIsNotFound, UserInfoWrongException;
	/*
	 * 获得所有用户名称
	 * @return Vector<String> 所有的用户名集合
	 */
	public Vector<String> getAllName() throws DAOException, UserIsNotFound, UserIsNotHavePower;
	/*
	 * 获得所有用户信息
	 * @return Vector<Vector<String>> 用户集合
	 */
	public  Vector<Vector<String>> searchAllInfo() throws DAOException, UserIsNotHavePower, UserIsNotFound;
	/*
	 * 修改权限:只有管理员才能修改用户权限
	 * @param user 用户信息
	 * @param power 修改的权限
	 * @return boolean 返回操作是否成功
	 */
	public boolean modifyPower(User user,String power) throws DAOException, UserIsNotFound, UserIsNotHavePower;
	/*
	 * 根据用户名删除用户
	 * @param user 用户信息
	 * @return boolean 返回操作是否成功
	 */
	public boolean deleteUserByName(User user) throws DAOException, UserIsNotFound, UserIsNotHavePower;
}
