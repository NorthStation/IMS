package com.lms.zx.dao.impl.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lms.zx.dao.IUserDAO;
import com.lms.zx.entity.User;
import com.lms.zx.exception.DAOException;
import com.lms.zx.util.DBConnection;


public class UserDaoImpl implements IUserDAO {
	//根据
	public User queryUserByName(String username) throws DAOException {
		Connection conn = null;
		PreparedStatement prtmt = null;
		ResultSet rs = null;
		//保存用户信息
		User u=new User();
		
		try {
			conn = DBConnection.getConnection();
			prtmt = conn.prepareStatement("select * from tb_user where name=?");
			System.out.println(username);
			//动态传值
			prtmt.setString(1, username);
			//执行sql，返回用户信息
			rs=prtmt.executeQuery();
			//遍历结果集，获取用户信息
			while (rs.next()) {
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setPower(rs.getString("power"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} finally {
			try {
				//关闭资源
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return u;
	}

	//添加用户
	public boolean insertUser(User user) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			//获取连接
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("insert into tb_user values(?,?,default)");
			//动态传值
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			//执行sql语句
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				//关闭资源
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return true;
	}
	
	//修改密码
	public boolean updatePwd(User user, String newPassword) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("update tb_user set password=? where name=?");
			pstmt.setString(1, newPassword);
			pstmt.setString(2, user.getName());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return true;
	}
	//根据用户名删除用户
	public boolean deleteUserByName(User user) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("delete from tb_user where name=?");
			pstmt.setString(1, user.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return true;
	}
	//查询所有的用户信息
	public Vector<Vector<String>> queryAllUserInfo(String loginUserName) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Vector<Vector<String>> userInfo=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("select * from tb_user where name not in(?)");
			pstmt.setString(1, loginUserName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Vector<String> row=new Vector<String>();
				row.add(rs.getString("name"));
				row.add(rs.getString("power"));
				userInfo.add(row);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return userInfo;
	}
	//查询所有的用户名称
	public Vector<String> queryAllUserName() throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector<String> userName=new Vector<String>();
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("select name from tb_user");
			rs=pstmt.executeQuery();
			while(rs.next()){
				userName.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return userName;
	}
	//根据用户名更新用户权限
	public boolean updatePowerByName(User user,String power) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("update tb_user set power=? where name=?");
			pstmt.setString(1, power);
			pstmt.setString(2, user.getName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return true;
	}
}
