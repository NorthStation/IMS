package com.lms.zx.dao.impl.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.dao.ISalesReturnDao;
import com.lms.zx.entity.SalesReturnDetailOrder;
import com.lms.zx.entity.SalesReturnOrder;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.util.DBConnection;

public class SalesReturnDaoImpl implements ISalesReturnDao{
	//插入销售退货记录
	public void insertSalesReturnOrder(SalesReturnOrder order) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//获取数据库连接
			con = DBConnection.getConnection();
			//设置手动提交事务
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into tb_salesReturnOrder values(?,to_date(?,'yyyy-mm-dd'),?,?,?,?)");
			//动态传值
			ps.setString(1, order.getSalesReturnId());
			ps.setString(2, order.getTime());
			ps.setString(3, order.getHandle());
			ps.setString(4, order.getCurName());
			ps.setString(5, order.getPayMent());
			ps.setDouble(6, order.getSum());
			//执行sql语句，添加销售退货记录
			ps.executeUpdate();
			//添加销售退货详单记录
			insertSalesReturnDetailOrder(con,order.getSalesReturnDetailOrders());
			//更新库存
			updateStock(con,order.getSalesReturnDetailOrders());
			//提交事务
			con.commit();
		} catch (SQLException e) {
			try {
				//事务回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} catch (SalesDaoException e) {
			try {
				//事务回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//更新库存
	public void updateStock(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<details.size();i++) {
				ps = con.prepareStatement("update tb_stock set amount=amount+? where proId=?");
				//获取详单信息
				SalesReturnDetailOrder detail = details.get(i);
				//动态传值
				ps.setInt(1, detail.getAmount());
				ps.setLong(2, detail.getProId());
				//执行sql
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//插入销售退货详单记录
	public void insertSalesReturnDetailOrder(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<details.size();i++) {
				ps = con.prepareStatement("insert into tb_salesReturnDetailOrder values(?,?,?,?)");
				//获取销售退货详单
				SalesReturnDetailOrder detail = details.get(i);
				//动态传值
				ps.setString(1, detail.getSalesReturnId());
				ps.setLong(2, detail.getProId());
				ps.setDouble(3, detail.getReturnPrice());
				ps.setInt(4, detail.getAmount());
				//执行sql
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//根据销售退货票号查询销售退货详单
	public Vector<Vector<String>> querySalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取数据库连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesReturnDetailInfo where salesReturnId=?");
			//动态传值
			ps.setString(1, salesReturnId);
			//执行sql语句
			rs = ps.executeQuery();
			//销售退货详单集合
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			//遍历结果集
			while(rs.next()) {
				Vector<String> d = new Vector<String>();
				d.add(String.valueOf(rs.getLong("PROID")));
				d.add(rs.getString("proName"));
				d.add(rs.getString("genre"));
				d.add(String.valueOf(rs.getDouble("price")));
				d.add(String.valueOf(rs.getInt("amount")));
				d.add(rs.getString("specific"));
				d.add(rs.getString("madeIn"));
				d.add(rs.getString("remarks"));
				details.add(d);
			}
			return details;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//根据销售退货票号查询销售退货单
	public Vector<Vector<String>> querySalesReturnOrderBySid(String salesReturnId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取数据库连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesReturnOrder where id=?");
			//动态传值
			ps.setString(1, salesReturnId);
			//执行sql语句
			rs = ps.executeQuery();
			//销售退货单集合
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> o = new Vector<String>();
				o.add(rs.getString("id"));
				o.add(rs.getString("customerName"));
				o.add(rs.getString("handle"));
				o.add((rs.getDate("time")).toString());
				o.add(rs.getString("payMent"));
				o.add(String.valueOf(rs.getDouble("sum")));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//查询所有的销售退货单
	public Vector<Vector<String>> queryAllSalesReturnOrder() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取数据库连接
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesReturnOrder");
			//执行sql语句
			rs = ps.executeQuery();
			//销售退货单集合
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> o = new Vector<String>();
				o.add(rs.getString("id"));
				o.add(rs.getString("customerName"));
				o.add(rs.getString("handle"));
				o.add((rs.getDate("time")).toString());
				o.add(rs.getString("payMent"));
				o.add(String.valueOf(rs.getDouble("sum")));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
}
