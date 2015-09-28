package com.lms.zx.dao.impl.instorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lms.zx.dao.IReturnProductMsgDao;
import com.lms.zx.exception.instorage.ReturnProductMsgDaoException;

import com.lms.zx.util.DBConnection;

public class ReturnProductMsgDaoImpl  implements IReturnProductMsgDao{
	//根据商品名称查询库存信息  价格，库存数量，商品规格，库存id
	public Vector<String> queryStorageByProName(String proName) throws ReturnProductMsgDaoException {
		//获取数据库连接
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Vector<String>  stockMsg=new Vector<String>();
		try {
			conn=DBConnection.getConnection(); 
			String sql="select proId,supplieName,name,price,specific,unit,amount from tb_stock where name=?";
			pstmt=conn.prepareStatement(sql);
			//传值
			pstmt.setString(1, proName);
			System.out.println(sql);
			//执行sql语句
			rs=pstmt.executeQuery();
			while(rs.next()){
				stockMsg.add(String.valueOf(rs.getInt("price")));
				stockMsg.add(rs.getString("amount"));
				stockMsg.add(rs.getString("specific"));
				stockMsg.add(String.valueOf(rs.getLong("proId")));
			}
			return stockMsg;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ReturnProductMsgDaoException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ReturnProductMsgDaoException(e.getMessage());
			}
		}
		
	}
	//根据供应商名称查询商品名称
	public Vector<String> queryStorageProductName(String supplierName) throws ReturnProductMsgDaoException {
		//获取数据库连接
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Vector<String> proName=new Vector<String>();
		try {
			conn=DBConnection.getConnection(); 
			pstmt=conn.prepareStatement("select name from v_product where supplieName=?");
			pstmt.setString(1, supplierName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				proName.add(rs.getString("name"));
			}
			return proName;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ReturnProductMsgDaoException(e.getMessage());
		}finally{
			try {
				DBConnection.close(conn, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ReturnProductMsgDaoException(e.getMessage());
			}
		}
		
	}

}
