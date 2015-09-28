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
 * SalesDaoImpl�����۳������ݷ��ʲ�ʵ����
 */
public class SalesDaoImpl implements ISalesDao{
	//�����¼
	public void insertSalesOrder(SalesOrder order) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			//�����ֶ��ύ����
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into tb_salesOrder values(?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)");
			//��̬��ֵ
			ps.setString(1, order.getId());
			ps.setString(2, order.getHandle());
			ps.setString(3, order.getTime());
			ps.setString(4, order.getCusName());
			ps.setString(5, order.getPayMent());
			ps.setDouble(6, order.getSum());
			ps.setString(7, order.getRemarks());
			//ִ��sql��䣬�������۳��ⵥ
			ps.executeUpdate();
			//�������۳����굥��Ϣ
			insertSalesDetailOrder(con,order.getDetailOrders());
			//���¿��
			insertStock(con,order.getDetailOrders());
			//�ύ����
			con.commit();
		} catch (SQLException e) {
			try {
				//����ع�
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SalesDaoException(e.getMessage());
		} catch (SalesDaoException e) {
			try {
				//����ع�
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//���¿��
	public void insertStock(Connection con, ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<detailOrders.size();i++) {
				ps = con.prepareStatement("update tb_stock set amount=amount-? where proid=?");
				//��ȡ�굥
				SalesDetailOrder detailOrder = detailOrders.get(i);
				//��̬��ֵ
				ps.setInt(1, detailOrder.getAmount());
				ps.setLong(2, detailOrder.getProId());
				//ִ��sql
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}	
	}

	//�������۳����굥��Ϣ
	public void insertSalesDetailOrder(Connection con,ArrayList<SalesDetailOrder> detailOrders) throws SalesDaoException {
		PreparedStatement ps = null;
		try {
			for(int i=0;i<detailOrders.size();i++) {
				ps = con.prepareStatement("insert into tb_salesDetailOrder values(?,?,?,?)");
				//��ȡ�굥
				SalesDetailOrder detailOrder = detailOrders.get(i);
				//��̬��ֵ
				ps.setString(1, detailOrder.getSalesId());
				ps.setLong(2, detailOrder.getProId());
				ps.setDouble(3, detailOrder.getSalesPrice());
				ps.setInt(4, detailOrder.getAmount());
				//ִ��sql
				ps.executeUpdate();
			}
			//ִ��������
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//�ر���Դ
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
	
	//ͨ����Ʒ�����¿��
	public void updateStockByPname(String proName,int amount) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update tb_stock set amount=? where name=?");
			//��̬��ֵ
			ps.setInt(1, amount);
			ps.setString(2, proName);
			//ִ��sql���
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			try {
				//�ر���Դ
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//ͨ�����۳���Ʊ�Ų�ѯ�굥��Ϣ������������Ʊ����Ϣ
	public Vector<Vector<String>> querySalesDetailOrderBySid(String sid) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesDetailInfo where salesId=?");
			//��̬��ֵ
			ps.setString(1, sid);
			//ִ��sql��䣬�����굥��Ϣ
			rs = ps.executeQuery();
			//�굥��Ϣ����
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ���е����۵���Ϣ
	public Vector<Vector<String>> queryAllSales() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesOrder");
			//ִ��sql��䣬���ض�����Ϣ
			rs = ps.executeQuery();
			//������Ϣ����
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//�������۳���Ʊ�Ų�ѯ���۶�����Ϣ
	public Vector<Vector<String>> querySalesBySid(String sid) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesOrder where id=?");
			//��̬��ֵ
			ps.setString(1, sid);
			//ִ��sql��䣬���ض�����Ϣ
			rs = ps.executeQuery();
			//������Ϣ����
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//������Ʒ��Ų�ѯ�����Ϣ
	public Stock queryStockByPid(long proId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_stock where proId=?");
			//��̬��ֵ
			ps.setLong(1, proId);
			//ִ��sql��䣬���ض�����Ϣ
			rs = ps.executeQuery();
			//���
			Stock stock = new Stock();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ�������۳���Ʊ��
	public Vector<String> queryAllSalesNumber() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select id from tb_salesOrder");
			//ִ��sql��䣬�������۳���Ʊ��
			rs = ps.executeQuery();
			Vector<String> numbers = new Vector<String>();
			
			//�������������ȡ���۳���Ʊ��
			while(rs.next()) {
				numbers.add(rs.getString("id"));
			}
			return numbers;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//ͨ�����۳���Ʊ�Ų�ѯ�굥��Ϣ����������Ʊ����Ϣ
	public Vector<Vector<String>> querySDetailOrderBySid(String salesNum) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesDetailInfo where salesId=?");
			//��̬��ֵ
			ps.setString(1, salesNum);
			//ִ��sql��䣬�����굥��Ϣ
			rs = ps.executeQuery();
			//�굥��Ϣ����
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
}
