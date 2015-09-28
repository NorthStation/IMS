package com.lms.zx.factory;

import com.lms.zx.biz.IUserBiz;
import com.lms.zx.biz.impl.user.UserBizImpl;
import com.lms.zx.dao.IUserDAO;
import com.lms.zx.dao.impl.user.UserDaoImpl;

public abstract class UserFactory {
	//�����û��߼������
	public static IUserBiz getUserBizImpl(){
		return new UserBizImpl();
	}
	
	//�����û����ݷ��ʲ����
	public static IUserDAO getUserDAOImpl(){
		return new UserDaoImpl();
	}
}
