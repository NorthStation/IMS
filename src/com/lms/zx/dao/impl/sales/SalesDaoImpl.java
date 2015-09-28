package com.lms.zx.dao.impl.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.dao.ISalesDao;
import com.lms.zx.entity.SalesDetailOrder;
import com.lms.zx.entity.SalesOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.sales.SalesDaoException;
import com.lms.zx.util.DBConnection;
/**
 * SalesDaoImpl：销售出库数据访问层实现类
 */
public class SalesDaoImpl implements ISalesDao{
	//插入记录
	public void insertSalesOrder(SalesOrder order) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//获取数据库连接
			con = DBConnection.getConnection();
			//设置手动提交事务
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into tb_salesOrder values(?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)");
			//动态传值
			ps.setString(1, order.getId());
			ps.setString(2, order.getHandle());
			ps.setString(3, order.getTime());
			ps.setString(4, order.getCusName());
			ps.setString(5, order.getPayMent());
			ps.setDouble(6, order.getSum());
			ps.setString(7, order.getRemarks());
			//执行sql语句，更新销售出库单
			ps.executeUpdate();
			//插入销售出库详单信息
			insertSalesDetailOrder(con,order.getDetailOrders());
			//更新库存
			insertStock(con,order.getDetailOrders());
			//提交事务
			con.commit();
		} catch (SQLException e) {
			try {
				//事务回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
			try {
				//关闭资源
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//更新库存
	public void insertStock(Connection con, ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<detailOrders.size();i++) {
				ps = con.prepareStatement("update tb_stock set amount=amount-? where proid=?");
				//获取详单
				SalesDetailOrder detailOrder = detailOrders.get(i);
				//动态传值
				ps.setInt(1, detailOrder.getAmount());
				ps.setLong(2, detailOrder.getProId());
				//执行sql
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			try {
				//关闭资源
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}	
	}

	//插入销售出库详单信息
	public void insertSalesDetailOrder(Connection con,ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException {
		PreparedStatement ps = null;
		try {
			for(int i=0;i<detailOrders.size();i++) {
				ps = con.prepareStatement("insert into tb_salesDetailOrder values(?,?,?,?)");
				//获取详单
				SalesDetailOrder detailOrder = detailOrders.get(i);
				//动态传值
				ps.setString(1, detailOrder.getSalesId());
				ps.setLong(2, detailOrder.getProId());
				ps.setDouble(3, detailOrder.getSalesPrice());
				ps.setInt(4, detailOrder.getAmount());
				//执行sql
				ps.executeUpdate();
			}
			//执行批处理
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//关闭资源
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SalesDaoException(e.getMessage());
				}
			}
		}
	}
	
	//通过商品名更新库存
	public void updateStockByPname(String proName,int amount) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update tb_stock set amount=? where name=?");
			//动态传值
			ps.setInt(1, amount);
			ps.setString(2, proName);
			//执行sql语句
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			try {
				//关闭资源
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//通过销售出库票号查询详单信息：不含有销售票号信息
	public Vector<Vector<String>> querySalesDetailOrderBySid(String sid) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesDetailInfo where salesId=?");
			//动态传值
			ps.setString(1, sid);
			//执行sql语句，返回详单信息
			rs = ps.executeQuery();
			//详单信息集合
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> d = new Vector<String>();
				d.add(String.valueOf(rs.getLong("proId")));
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
	
	//查询所有的销售单信息
	public Vector<Vector<String>> queryAllSales() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesOrder");
			//执行sql语句，返回订单信息
			rs = ps.executeQuery();
			//订单信息集合
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> o = new Vector<String>();
				o.add(rs.getString("id"));
				o.add(String.valueOf(rs.getDouble("sum")));
				o.add(rs.getString("customerName"));
				o.add(rs.getDate("time").toString());
				o.add(rs.getString("handle"));
				o.add(rs.getString("payMent"));
				o.add(rs.getString("remarks"));
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
	
	//根据销售出库票号查询销售订单信息
	public Vector<Vector<String>> querySalesBySid(String sid) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesOrder where id=?");
			//动态传值
			ps.setString(1, sid);
			//执行sql语句，返回订单信息
			rs = ps.executeQuery();
			//订单信息集合
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> o = new Vector<String>();
				o.add(rs.getString("id"));
				o.add(String.valueOf(rs.getDouble("sum")));
				o.add(rs.getString("customerName"));
				o.add(rs.getDate("time").toString());
				o.add(rs.getString("handle"));
				o.add(rs.getString("payMent"));
				o.add(rs.getString("remarks"));
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
	
	//根据商品编号查询库存信息
	public Stock queryStockByPid(long proId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_stock where proId=?");
			//动态传值
			ps.setLong(1, proId);
			//执行sql语句，返回订单信息
			rs = ps.executeQuery();
			//库存
			Stock stock = new Stock();
			
			//遍历结果集
			while(rs.next()) {
				stock.setId(rs.getInt("id"));
				stock.setProId(rs.getLong("proId"));
				stock.setAmount(rs.getInt("amount"));
				stock.setGenre(rs.getString("genre"));
				stock.setMadeIn(rs.getString("madeIn"));
				stock.setPrice(rs.getDouble("price"));
				stock.setProName(rs.getString("name"));
				stock.setRemarks(rs.getString("remarks"));
				stock.setSpecific(rs.getString("specific"));
				stock.setSupplieName(rs.getString("supplieName"));
				stock.setUnit(rs.getString("unit"));
			}
			return stock;
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
	
	//查询所有销售出库票号
	public Vector<String> queryAllSalesNumber() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select id from tb_salesOrder");
			//执行sql语句，返回销售出库票号
			rs = ps.executeQuery();
			Vector<String> numbers = new Vector<String>();
			
			//遍历结果集，获取销售出库票号
			while(rs.next()) {
				numbers.add(rs.getString("id"));
			}
			return numbers;
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

	//通过销售出库票号查询详单信息：含有销售票号信息
	public Vector<Vector<String>> querySDetailOrderBySid(String salesNum) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesDetailInfo where salesId=?");
			//动态传值
			ps.setString(1, salesNum);
			//执行sql语句，返回详单信息
			rs = ps.executeQuery();
			//详单信息集合
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			
			//遍历结果集
			while(rs.next()) {
				Vector<String> d = new Vector<String>();
				d.add(rs.getString("SALESID"));
				d.add(String.valueOf(rs.getLong("proId")));
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
}
