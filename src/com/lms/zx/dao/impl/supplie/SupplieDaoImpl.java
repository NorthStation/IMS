package com.lms.zx.dao.impl.supplie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lms.zx.dao.ISupplieDao;
import com.lms.zx.entity.Supplie;
import com.lms.zx.exception.supplie.SupplieDaoException;
import com.lms.zx.util.DBConnection;

public class SupplieDaoImpl implements ISupplieDao {
	//�����¼
	public void insertSupplier(Supplie supplie) throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet key = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into tb_supplie values(unique_seq.nextval,?,?,?,?,?,?,?)");
			//��̬��ֵ
			ps.setString(1, supplie.getName());
			ps.setString(2, supplie.getLinkman());
			ps.setString(3, supplie.getPhone());
			ps.setString(4, supplie.getEmail());
			ps.setString(5, supplie.getBank());
			ps.setString(6, supplie.getAccount());
			ps.setString(7, supplie.getAddress());
			//ִ��sql
			ps.executeUpdate();
			/*//��ȡ��������ֵ
			key = ps.getGeneratedKeys();
			key.next();
			//��������ֵ
			return key.getInt(1);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, key);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}

	//ɾ����¼
	public int deleteSupplierById(long id) throws SupplieDaoException  {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from tb_supplie where id=?");
			//��̬��ֵ
			ps.setLong(1, id);
			//ִ��sql
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}
	
	//�޸ļ�¼
	public int updateSupplier(Supplie supplie) throws SupplieDaoException {
		System.out.println("---------------------------------updateDao");
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("update tb_supplie set name=?,linkman=?,phone=?,email=?,bank=?,account=?,address=? where id=?");
			//��̬��ֵ
			ps.setString(1, supplie.getName());
			ps.setString(2, supplie.getLinkman());
			ps.setString(3, supplie.getPhone());
			ps.setString(4, supplie.getEmail());
			ps.setString(5, supplie.getBank());
			ps.setString(6, supplie.getAccount());
			ps.setString(7, supplie.getAddress());
			ps.setLong(8, supplie.getId());
			//ִ��sql
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ���м�¼
	public Vector<Vector<String>> queryAllSupplier() throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> supplie = new Vector<Vector<String>>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_supplie");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector<String> s = new Vector<String>();
				s.add(String.valueOf(rs.getLong("id")));
				s.add(rs.getString("name"));
				s.add(rs.getString("address"));
				s.add(rs.getString("phone"));
				s.add(rs.getString("linkman"));
				s.add(rs.getString("bank"));
				s.add(rs.getString("account"));
				s.add(rs.getString("email"));
				supplie.add(s);
			}
			return supplie;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}	
	}
	
	//ͨ����Ų�ѯ��¼
	public Vector<String> querySupplierById(long id) throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<String> s = new Vector<String>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_supplie where id=?");
			//��̬��ֵ
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				s.add(String.valueOf(rs.getLong("id")));
				s.add(rs.getString("name"));
				s.add(rs.getString("address"));
				s.add(rs.getString("phone"));
				s.add(rs.getString("linkman"));
				s.add(rs.getString("bank"));
				s.add(rs.getString("account"));
				s.add(rs.getString("email"));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}	
	}
	
	//ͨ�����Ʋ�ѯ��¼
	public Vector<String> querySupplierByName(String name) throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<String> s = new Vector<String>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_supplie where name=?");
			//��̬��ֵ
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				s.add(String.valueOf(rs.getLong("id")));
				s.add(rs.getString("name"));
				s.add(rs.getString("address"));
				s.add(rs.getString("phone"));
				s.add(rs.getString("linkman"));
				s.add(rs.getString("bank"));
				s.add(rs.getString("account"));
				s.add(rs.getString("email"));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}
	
	//ͨ�����Ʋ�ѯ��¼:ģ����ѯ
	public Vector<Vector<String>> querySuppliersByName(String name) throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> supplies = new Vector<Vector<String>>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_supplie where name like ?");
			String value = "%"+name+"%";
			//��̬��ֵ
			ps.setString(1, value);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector<String> s = new Vector<String>();
				s.add(String.valueOf(rs.getLong("id")));
				s.add(rs.getString("name"));
				s.add(rs.getString("address"));
				s.add(rs.getString("phone"));
				s.add(rs.getString("linkman"));
				s.add(rs.getString("bank"));
				s.add(rs.getString("account"));
				s.add(rs.getString("email"));
				supplies.add(s);
			}
			return supplies;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ��Ӧ������
	public Vector<String> querySupplierNames() throws SupplieDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<String> s = new Vector<String>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select name from tb_supplie");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				s.add(rs.getString("name"));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SupplieDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SupplieDaoException(e.getMessage());
			}
		}
	}
}
