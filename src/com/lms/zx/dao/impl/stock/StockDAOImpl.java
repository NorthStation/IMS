package com.lms.zx.dao.impl.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lms.zx.dao.IStockDAO;
import com.lms.zx.exception.stock.StockDAOException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.util.DBConnection;

public class StockDAOImpl implements IStockDAO {
	Connection conn=null;
	PreparedStatement prtmt=null;
	ResultSet rs=null;
	/*
	 * 查询库存表中的所有商品的信息
	 * @see com.lms.zx.dao.IStockDAO#queryAll()
	 */
	public Vector<Vector<String>> queryAll() throws StockDAOException, StockingDAOException {
		// TODO Auto-generated method stub
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock ");
			rs=prtmt.executeQuery();
			while(rs.next()){
				//获取数据
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//获取供应商名称
				String unit=rs.getString("unit");//获取单位
				String pid=String.valueOf(rs.getInt("proid"));//获取商品编号
				String amount=String.valueOf(rs.getInt("amount"));//获取库存数量
				String pname=rs.getString("name");//获取商品名称
				String price=String.valueOf(rs.getDouble("price"));//获取价格
				String specific=rs.getString("specific");//获取规格
				//添加到Vector对象中
				vs.add(pid);//商品编号
				vs.add(suppliename);//供应商名称
				vs.add(pname);//商品名称
				vs.add(price);//单价
				vs.add(specific);//规格
				vs.add(unit);//单位
				vs.add(amount);//库存数量
				v.add(vs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockDAOException();
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		return v;
	}
	/*
	 * 根据库存商品的类型，查询库存商品的信息，支持模糊查询
	 * @see com.lms.zx.dao.IStockDAO#queryByGenre(java.lang.String)
	 */
	public Vector<Vector<String>> queryByGenre(String genre) throws StockDAOException, StockingDAOException {
		// TODO Auto-generated method stub
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock where genre like '%"+genre+"%'");
			rs=prtmt.executeQuery();
			while(rs.next()){
				//获取数据
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//获取供应商名称
				String unit=rs.getString("unit");//获取单位
				String pid=String.valueOf(rs.getInt("proid"));//获取商品编号
				String amount=String.valueOf(rs.getInt("amount"));//获取库存数量
				String pname=rs.getString("name");//获取商品名称
				String price=String.valueOf(rs.getDouble("price"));//获取价格
				String specific=rs.getString("specific");//获取规格
				//添加到Vector对象中
				vs.add(pid);//商品编号
				vs.add(suppliename);//供应商名称
				vs.add(pname);//商品名称
				vs.add(price);//单价
				vs.add(specific);//规格
				vs.add(unit);//单位
				vs.add(amount);//库存数量
				v.add(vs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockDAOException();
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		return v;
	}
	/*
	 * 根据库存商品的名称，查询库存商品的信息，支持模糊查询
	 * @see com.lms.zx.dao.IStockDAO#queryByProductName(java.lang.String)
	 */
	public Vector<Vector<String>> queryByProductName(String proName) throws StockDAOException, StockingDAOException {
		// TODO Auto-generated method stub
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock where name like '%"+proName+"%'");
			rs=prtmt.executeQuery();
			while(rs.next()){
				//获取数据
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//获取供应商名称
				String unit=rs.getString("unit");//获取单位
				String pid=String.valueOf(rs.getInt("proid"));//获取商品编号
				String amount=String.valueOf(rs.getInt("amount"));//获取库存数量
				String pname=rs.getString("name");//获取商品名称
				String price=String.valueOf(rs.getDouble("price"));//获取价格
				String specific=rs.getString("specific");//获取规格
				//添加到Vector对象中
				//商品编号
				vs.add(pid);
				vs.add(suppliename);//供应商名称
				vs.add(pname);//商品名称
				vs.add(price);//单价
				vs.add(specific);//规格
				vs.add(unit);//单位
				vs.add(amount);//库存数量
				v.add(vs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockDAOException();
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		return v;
		
	}

}
