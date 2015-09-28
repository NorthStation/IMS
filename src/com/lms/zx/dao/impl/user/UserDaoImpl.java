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
	//����
	public User queryUserByName(String username) throws DAOException {
		Connection conn = null;
		PreparedStatement prtmt = null;
		ResultSet rs = null;
		//�����û���Ϣ
		User u=new User();
		
		try {
			conn = DBConnection.getConnection();
			prtmt = conn.prepareStatement("select * from tb_user where name=?");
			System.out.println(username);
			//��̬��ֵ
			prtmt.setString(1, username);
			//ִ��sql�������û���Ϣ
			rs=prtmt.executeQuery();
			//�������������ȡ�û���Ϣ
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
				//�ر���Դ
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return u;
	}

	//����û�
	public boolean insertUser(User user) throws DAOException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("insert into tb_user values(?,?,default)");
			//��̬��ֵ
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			//ִ��sql���
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}finally{
			try {
				//�ر���Դ
				DBConnection.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}
		return true;
	}
	
	//�޸�����
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
	//�����û���ɾ���û�
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
	//��ѯ���е��û���Ϣ
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
	//��ѯ���е��û�����
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
	//�����û��������û�Ȩ��
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
