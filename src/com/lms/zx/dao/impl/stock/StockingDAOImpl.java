package com.lms.zx.dao.impl.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.lms.zx.dao.IStockingDAO;
import com.lms.zx.exception.DAOException;
import com.lms.zx.exception.stock.StockingDAOException;
import com.lms.zx.util.DBConnection;

public  class StockingDAOImpl implements IStockingDAO {
	//创建一个Connection对象
	Connection conn=null;
	//创建一个preparedStatement对象
	PreparedStatement prtmt=null;
	//创建一个ResultSet对象
	ResultSet rs=null;
	/*
	 * 查询并获取库存表中所有的数据
	 * @see com.lms.zx.dao.IStockingDAO#queryAllStorage()
	 */
	public Vector<Vector<String>> queryAllStorage() throws StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try {
			//获取连接
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock ");
			rs=prtmt.executeQuery();
			//获取数据
			while(rs.next()){
				//获取数据
				Vector<String> vs=new Vector<String>();
				String pid=String.valueOf(rs.getInt("proid"));//获取商品编号
				String amount=String.valueOf(rs.getInt("amount"));//获取库存数量
				String pname=rs.getString("name");//获取商品名称
				String price=String.valueOf(rs.getDouble("price"));//获取价格
				String specific=rs.getString("specific");//获取规格
				//添加到Vector对象中
				vs.add(pid);//商品编号
				vs.add(pname);//商品名称
				vs.add(specific);//规格
				vs.add(price);//单价
				vs.add(amount);//库存数量
				v.add(vs);
			}
			//抛出异常
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//关闭连接
		}	finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//返回
		return v;
	}
	/*
	 * 统计库存表的记录总数和货品总数
	 * @see com.lms.zx.dao.IStockingDAO#queryCountMsg()
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException {
		//创建一个List对象
		List<Integer> lis=new ArrayList<Integer>();
		try {
			//获得连接
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select count(*),sum(amount) from tb_stock");
			rs=prtmt.executeQuery();
			//获取数据
			while(rs.next()){
				lis.add(rs.getInt("count(*)"));
				lis.add(rs.getInt("sum(amount)"));
			}
			//抛出异常
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//关闭连接
		} finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//返回值
		return lis;
	}
	/*
	 * 根据库存商品的id更新库存商品的数量
	 * sid：库存id
	 * amount：库存数量
	 * 返回值：返回数据库中受影响的行数
	 * @see com.lms.zx.dao.IStockingDAO#updateStockBySid()
	 */
	public void updateStockBySid(List<int[]> lists) throws StockingDAOException {
		try {
			//获取连接
			conn=DBConnection.getConnection();
			System.out.println(conn);
			Statement stmt=conn.createStatement();
			prtmt = conn.prepareStatement("update tb_stock set amount=? where proId=?");
			System.out.println(stmt);
			//使用for循环获取集合的元素
			for(int i=0;i<lists.size();i++){
				//获取集合的元素
				int[] arr=lists.get(i);
				prtmt.setInt(1, arr[1]);
				prtmt.setInt(2, arr[0]);
				int k =	prtmt.executeUpdate();
				System.out.println(k);
			}
			//抛出异常
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException("数据操作失败");
			//关闭连接
		}  finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException("数据库关闭失败");
			}
		}
	}
	/*
	 * 查询库存表中的所有商品的名称
	 * 返回值：库存表中的所有商品的名称的Vector对象
	 * 抛出DAOException异常
	 */
	public Vector<String> queryAllPname() throws StockingDAOException{
		//创建一个Vector对象
		Vector<String> v=new Vector<String>();
		try {
			//获取连接
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select name from tb_stock");
			rs=prtmt.executeQuery();
			//获取数据
			while(rs.next()){
				v.add(rs.getString("name"));
			}
			//抛出异常
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//关闭连接
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//返回
		return v;
	}
	/*
	 * 根据商品名查询库存商品信息
	 * Pname  商品名
	 * 返回值：包含商品信息的Vector对象
	 */
	public Vector<String> queryProductByPname(String pname) throws StockingDAOException{
		//创建一个Vector对象
		Vector<String> v=new Vector<String>();
		try {
			//获取连接
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock where name='"+pname+"'");
			rs=prtmt.executeQuery();
			//获取数据
			while(rs.next()){
				v.add(String.valueOf(rs.getLong("proId")));
				v.add(rs.getString("name"));
				v.add(rs.getString("genre"));
				v.add(String.valueOf(rs.getDouble("price")));
				v.add(String.valueOf(rs.getInt("amount")));
				v.add(rs.getString("specific"));
				v.add(rs.getString("madeIn"));
				v.add(rs.getString("remarks"));
			}
			//抛出异常
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//关闭连接
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//返回
		return v;
	}
}
