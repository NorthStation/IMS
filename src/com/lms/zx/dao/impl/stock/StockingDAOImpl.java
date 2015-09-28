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
	//����һ��Connection����
	Connection conn=null;
	//����һ��preparedStatement����
	PreparedStatement prtmt=null;
	//����һ��ResultSet����
	ResultSet rs=null;
	/*
	 * ��ѯ����ȡ���������е�����
	 * @see com.lms.zx.dao.IStockingDAO#queryAllStorage()
	 */
	public Vector<Vector<String>> queryAllStorage() throws StockingDAOException {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock ");
			rs=prtmt.executeQuery();
			//��ȡ����
			while(rs.next()){
				//��ȡ����
				Vector<String> vs=new Vector<String>();
				String pid=String.valueOf(rs.getInt("proid"));//��ȡ��Ʒ���
				String amount=String.valueOf(rs.getInt("amount"));//��ȡ�������
				String pname=rs.getString("name");//��ȡ��Ʒ����
				String price=String.valueOf(rs.getDouble("price"));//��ȡ�۸�
				String specific=rs.getString("specific");//��ȡ���
				//��ӵ�Vector������
				vs.add(pid);//��Ʒ���
				vs.add(pname);//��Ʒ����
				vs.add(specific);//���
				vs.add(price);//����
				vs.add(amount);//�������
				v.add(vs);
			}
			//�׳��쳣
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//�ر�����
		}	finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//����
		return v;
	}
	/*
	 * ͳ�ƿ���ļ�¼�����ͻ�Ʒ����
	 * @see com.lms.zx.dao.IStockingDAO#queryCountMsg()
	 */
	public List<Integer> queryCountMsg() throws StockingDAOException {
		//����һ��List����
		List<Integer> lis=new ArrayList<Integer>();
		try {
			//�������
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select count(*),sum(amount) from tb_stock");
			rs=prtmt.executeQuery();
			//��ȡ����
			while(rs.next()){
				lis.add(rs.getInt("count(*)"));
				lis.add(rs.getInt("sum(amount)"));
			}
			//�׳��쳣
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//�ر�����
		} finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//����ֵ
		return lis;
	}
	/*
	 * ���ݿ����Ʒ��id���¿����Ʒ������
	 * sid�����id
	 * amount���������
	 * ����ֵ���������ݿ�����Ӱ�������
	 * @see com.lms.zx.dao.IStockingDAO#updateStockBySid()
	 */
	public void updateStockBySid(List<int[]> lists) throws StockingDAOException {
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			System.out.println(conn);
			Statement stmt=conn.createStatement();
			prtmt = conn.prepareStatement("update tb_stock set amount=? where proId=?");
			System.out.println(stmt);
			//ʹ��forѭ����ȡ���ϵ�Ԫ��
			for(int i=0;i<lists.size();i++){
				//��ȡ���ϵ�Ԫ��
				int[] arr=lists.get(i);
				prtmt.setInt(1, arr[1]);
				prtmt.setInt(2, arr[0]);
				int k =	prtmt.executeUpdate();
				System.out.println(k);
			}
			//�׳��쳣
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException("���ݲ���ʧ��");
			//�ر�����
		}  finally {
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException("���ݿ�ر�ʧ��");
			}
		}
	}
	/*
	 * ��ѯ�����е�������Ʒ������
	 * ����ֵ�������е�������Ʒ�����Ƶ�Vector����
	 * �׳�DAOException�쳣
	 */
	public Vector<String> queryAllPname() throws StockingDAOException{
		//����һ��Vector����
		Vector<String> v=new Vector<String>();
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select name from tb_stock");
			rs=prtmt.executeQuery();
			//��ȡ����
			while(rs.next()){
				v.add(rs.getString("name"));
			}
			//�׳��쳣
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//�ر�����
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//����
		return v;
	}
	/*
	 * ������Ʒ����ѯ�����Ʒ��Ϣ
	 * Pname  ��Ʒ��
	 * ����ֵ��������Ʒ��Ϣ��Vector����
	 */
	public Vector<String> queryProductByPname(String pname) throws StockingDAOException{
		//����һ��Vector����
		Vector<String> v=new Vector<String>();
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			prtmt=conn.prepareStatement("select * from tb_stock where name='"+pname+"'");
			rs=prtmt.executeQuery();
			//��ȡ����
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
			//�׳��쳣
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StockingDAOException(e.getMessage());
			//�ر�����
		} finally{
			try {
				DBConnection.close(conn, prtmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new StockingDAOException(e.getMessage());
			}
		}
		//����
		return v;
	}
}
