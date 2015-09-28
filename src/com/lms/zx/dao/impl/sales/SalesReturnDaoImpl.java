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
	//���������˻���¼
	public void insertSalesReturnOrder(SalesReturnOrder order) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			//�����ֶ��ύ����
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into tb_salesReturnOrder values(?,to_date(?,'yyyy-mm-dd'),?,?,?,?)");
			//��̬��ֵ
			ps.setString(1, order.getSalesReturnId());
			ps.setString(2, order.getTime());
			ps.setString(3, order.getHandle());
			ps.setString(4, order.getCurName());
			ps.setString(5, order.getPayMent());
			ps.setDouble(6, order.getSum());
			//ִ��sql��䣬��������˻���¼
			ps.executeUpdate();
			//��������˻��굥��¼
			insertSalesReturnDetailOrder(con,order.getSalesReturnDetailOrders());
			//���¿��
			updateStock(con,order.getSalesReturnDetailOrders());
			//�ύ����
			con.commit();
		} catch (SQLException e) {
			try {
				//����ع�
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//���¿��
	public void updateStock(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<details.size();i++) {
				ps = con.prepareStatement("update tb_stock set amount=amount+? where proId=?");
				//��ȡ�굥��Ϣ
				SalesReturnDetailOrder detail = details.get(i);
				//��̬��ֵ
				ps.setInt(1, detail.getAmount());
				ps.setLong(2, detail.getProId());
				//ִ��sql
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//�ر���Դ
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}

	//���������˻��굥��¼
	public void insertSalesReturnDetailOrder(Connection con,ArrayList<SalesReturnDetailOrder> details) throws SalesDaoException {
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<details.size();i++) {
				ps = con.prepareStatement("insert into tb_salesReturnDetailOrder values(?,?,?,?)");
				//��ȡ�����˻��굥
				SalesReturnDetailOrder detail = details.get(i);
				//��̬��ֵ
				ps.setString(1, detail.getSalesReturnId());
				ps.setLong(2, detail.getProId());
				ps.setDouble(3, detail.getReturnPrice());
				ps.setInt(4, detail.getAmount());
				//ִ��sql
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalesDaoException(e.getMessage());
		} finally {
			//�ر���Դ
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//���������˻�Ʊ�Ų�ѯ�����˻��굥
	public Vector<Vector<String>> querySalesReturnDetailOrderBySid(String salesReturnId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from v_salesReturnDetailInfo where salesReturnId=?");
			//��̬��ֵ
			ps.setString(1, salesReturnId);
			//ִ��sql���
			rs = ps.executeQuery();
			//�����˻��굥����
			Vector<Vector<String>> details = new Vector<Vector<String>>();
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//���������˻�Ʊ�Ų�ѯ�����˻���
	public Vector<Vector<String>> querySalesReturnOrderBySid(String salesReturnId) throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesReturnOrder where id=?");
			//��̬��ֵ
			ps.setString(1, salesReturnId);
			//ִ��sql���
			rs = ps.executeQuery();
			//�����˻�������
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//���������
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
			//�ر���Դ
			try {
				DBConnection.close(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalesDaoException(e.getMessage());
			}
		}
	}
	
	//��ѯ���е������˻���
	public Vector<Vector<String>> queryAllSalesReturnOrder() throws SalesDaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡ���ݿ�����
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from tb_salesReturnOrder");
			//ִ��sql���
			rs = ps.executeQuery();
			//�����˻�������
			Vector<Vector<String>> orders = new Vector<Vector<String>>();
			
			//���������
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
