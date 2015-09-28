package com.lms.zx.dao.impl.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lms.zx.dao.IProductDao;
import com.lms.zx.entity.Product;
import com.lms.zx.exception.product.ProductDaoException;
import com.lms.zx.util.DBConnection;

public class ProductDaoImpl implements IProductDao{
	//�����¼
	public void insertProduct(Product product) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into tb_product values(unique_seq.nextval,?,?,?,?,?,?,?,?)");
			//��̬��ֵ
			ps.setString(1, product.getName());
			ps.setString(2, product.getGenre());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getSpecific());
			ps.setString(5, product.getUnit());
			ps.setLong(6, product.getSupplieId());
			ps.setString(7, product.getRemarks());
			ps.setString(8, product.getMadeIn());
			//ִ��sql���
			ps.executeUpdate();
			/*//��ȡ��������ֵ
			rs = ps.getGeneratedKeys();
			rs.next();
			//������������ֵ
			return rs.getInt(1);*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}

	//ɾ����¼
	public void deleteProductById(long id) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from tb_product where id=?");
			//��̬��ֵ
			ps.setLong(1, id);
			//ִ��sql���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//���¼�¼
	public void updateProduct(Product product) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("update tb_product set name=?,genre=?,price=?,specific=?,unit=?,supplieId=?,remarks=?,madeIn=? where id=?");
			//��̬��ֵ
			ps.setString(1, product.getName());
			ps.setString(2, product.getGenre());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getSpecific());
			ps.setString(5, product.getUnit());
			ps.setLong(6, product.getSupplieId());
			ps.setString(7, product.getRemarks());
			ps.setString(8, product.getMadeIn());
			ps.setLong(9, product.getId());
			//ִ��sql���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ������Ʒ
	public Vector<Vector<String>> queryAllProduct() throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product");
			//ִ��sql���
			rs = ps.executeQuery();
			
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(rs.getString("genre"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("supplieName"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//���ݹ�Ӧ�̱�Ų�ѯ��Ʒ��Ϣ
	public Vector<Vector<String>> queryProductBySid(long sid) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieId=?");
			//��̬��ֵ
			ps.setLong(1, sid);
			//ִ��sql���
			rs = ps.executeQuery();
			
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				p.add(rs.getString("genre"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ
	public Vector<Vector<String>> queryProductBySname(String sname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieName=?");
			//��̬��ֵ
			ps.setString(1, sname);
			//ִ��sql���
			rs = ps.executeQuery();
			
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				p.add(rs.getString("genre"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//������Ʒ���Ͳ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where genre like ?");
			String value = "%"+category+"%";
			//��̬��ֵ
			ps.setString(1, value);
			//ִ��sql���
			rs = ps.executeQuery();
			//��Ʒ��ţ���Ʒ���ƣ���𣬼۸񣬹�񣬵�λ����Ӧ�����ƣ���ע������
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(rs.getString("genre"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("supplieName"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//������Ʒ���Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where name like ?");
			String value = "%"+pname+"%";
			//��̬��ֵ
			ps.setString(1, value);
			//ִ��sql���
			rs = ps.executeQuery();
			
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(rs.getString("genre"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("supplieName"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//���ݹ�Ӧ�����Ʋ�ѯ��Ʒ��Ϣ��ģ����ѯ
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieName like ?");
			String value = "%"+sname+"%";
			//��̬��ֵ
			ps.setString(1, value);
			//ִ��sql���
			rs = ps.executeQuery();
			
			//���������
			while(rs.next()) {
				Vector<String> p = new Vector<String>();
				p.add(String.valueOf(rs.getLong("id")));
				p.add(rs.getString("name"));
				p.add(rs.getString("genre"));
				p.add(String.valueOf(rs.getDouble("price")));
				p.add(rs.getString("specific"));
				p.add(rs.getString("unit"));
				p.add(rs.getString("supplieName"));
				p.add(rs.getString("remarks"));
				p.add(rs.getString("madeIn"));
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
}
