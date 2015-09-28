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
	 * ��ѯ�����е�������Ʒ����Ϣ
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
				//��ȡ����
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//��ȡ��Ӧ������
				String unit=rs.getString("unit");//��ȡ��λ
				String pid=String.valueOf(rs.getInt("proid"));//��ȡ��Ʒ���
				String amount=String.valueOf(rs.getInt("amount"));//��ȡ�������
				String pname=rs.getString("name");//��ȡ��Ʒ����
				String price=String.valueOf(rs.getDouble("price"));//��ȡ�۸�
				String specific=rs.getString("specific");//��ȡ���
				//��ӵ�Vector������
				vs.add(pid);//��Ʒ���
				vs.add(suppliename);//��Ӧ������
				vs.add(pname);//��Ʒ����
				vs.add(price);//����
				vs.add(specific);//���
				vs.add(unit);//��λ
				vs.add(amount);//�������
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
	 * ���ݿ����Ʒ�����ͣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
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
				//��ȡ����
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//��ȡ��Ӧ������
				String unit=rs.getString("unit");//��ȡ��λ
				String pid=String.valueOf(rs.getInt("proid"));//��ȡ��Ʒ���
				String amount=String.valueOf(rs.getInt("amount"));//��ȡ�������
				String pname=rs.getString("name");//��ȡ��Ʒ����
				String price=String.valueOf(rs.getDouble("price"));//��ȡ�۸�
				String specific=rs.getString("specific");//��ȡ���
				//��ӵ�Vector������
				vs.add(pid);//��Ʒ���
				vs.add(suppliename);//��Ӧ������
				vs.add(pname);//��Ʒ����
				vs.add(price);//����
				vs.add(specific);//���
				vs.add(unit);//��λ
				vs.add(amount);//�������
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
	 * ���ݿ����Ʒ�����ƣ���ѯ�����Ʒ����Ϣ��֧��ģ����ѯ
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
				//��ȡ����
				Vector<String> vs=new Vector<String>();
				String suppliename=rs.getString("suppliename");//��ȡ��Ӧ������
				String unit=rs.getString("unit");//��ȡ��λ
				String pid=String.valueOf(rs.getInt("proid"));//��ȡ��Ʒ���
				String amount=String.valueOf(rs.getInt("amount"));//��ȡ�������
				String pname=rs.getString("name");//��ȡ��Ʒ����
				String price=String.valueOf(rs.getDouble("price"));//��ȡ�۸�
				String specific=rs.getString("specific");//��ȡ���
				//��ӵ�Vector������
				//��Ʒ���
				vs.add(pid);
				vs.add(suppliename);//��Ӧ������
				vs.add(pname);//��Ʒ����
				vs.add(price);//����
				vs.add(specific);//���
				vs.add(unit);//��λ
				vs.add(amount);//�������
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
