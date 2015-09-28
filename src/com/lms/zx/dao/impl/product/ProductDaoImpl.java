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
	//插入记录
	public void insertProduct(Product product) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into tb_product values(unique_seq.nextval,?,?,?,?,?,?,?,?)");
			//动态传值
			ps.setString(1, product.getName());
			ps.setString(2, product.getGenre());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getSpecific());
			ps.setString(5, product.getUnit());
			ps.setLong(6, product.getSupplieId());
			ps.setString(7, product.getRemarks());
			ps.setString(8, product.getMadeIn());
			//执行sql语句
			ps.executeUpdate();
			/*//获取自增主键值
			rs = ps.getGeneratedKeys();
			rs.next();
			//返回自增主键值
			return rs.getInt(1);*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}

	//删除记录
	public void deleteProductById(long id) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from tb_product where id=?");
			//动态传值
			ps.setLong(1, id);
			//执行sql语句
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//关闭资源
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//更新记录
	public void updateProduct(Product product) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("update tb_product set name=?,genre=?,price=?,specific=?,unit=?,supplieId=?,remarks=?,madeIn=? where id=?");
			//动态传值
			ps.setString(1, product.getName());
			ps.setString(2, product.getGenre());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getSpecific());
			ps.setString(5, product.getUnit());
			ps.setLong(6, product.getSupplieId());
			ps.setString(7, product.getRemarks());
			ps.setString(8, product.getMadeIn());
			ps.setLong(9, product.getId());
			//执行sql语句
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductDaoException(e.getMessage());
		} finally {
			try {
				//关闭资源
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//查询所有商品
	public Vector<Vector<String>> queryAllProduct() throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product");
			//执行sql语句
			rs = ps.executeQuery();
			
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//根据供应商编号查询商品信息
	public Vector<Vector<String>> queryProductBySid(long sid) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieId=?");
			//动态传值
			ps.setLong(1, sid);
			//执行sql语句
			rs = ps.executeQuery();
			
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//根据供应商名称查询商品信息
	public Vector<Vector<String>> queryProductBySname(String sname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieName=?");
			//动态传值
			ps.setString(1, sname);
			//执行sql语句
			rs = ps.executeQuery();
			
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//根据商品类型查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductByPcategory(String category) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where genre like ?");
			String value = "%"+category+"%";
			//动态传值
			ps.setString(1, value);
			//执行sql语句
			rs = ps.executeQuery();
			//商品编号，商品名称，类别，价格，规格，单位，供应商名称，备注，产地
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//根据商品名称查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductByPname(String pname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where name like ?");
			String value = "%"+pname+"%";
			//动态传值
			ps.setString(1, value);
			//执行sql语句
			rs = ps.executeQuery();
			
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
	
	//根据供应商名称查询商品信息：模糊查询
	public Vector<Vector<String>> searchProductBySname(String sname) throws ProductDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Vector<String>> products = new Vector<Vector<String>>();
		
		try {
			//获取连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_product where supplieName like ?");
			String value = "%"+sname+"%";
			//动态传值
			ps.setString(1, value);
			//执行sql语句
			rs = ps.executeQuery();
			
			//遍历结果集
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
				//关闭资源
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ProductDaoException(e.getMessage());
			}
		}
	}
}
