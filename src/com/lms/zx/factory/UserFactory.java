package com.lms.zx.factory;

import com.lms.zx.biz.IUserBiz;
import com.lms.zx.biz.impl.user.UserBizImpl;
import com.lms.zx.dao.IUserDAO;
import com.lms.zx.dao.impl.user.UserDaoImpl;

public abstract class UserFactory {
	//返回用户逻辑层对象
	public static IUserBiz getUserBizImpl(){
		return new UserBizImpl();
	}
	
	//返回用户数据访问层对象
	public static IUserDAO getUserDAOImpl(){
		return new UserDaoImpl();
	}
}
