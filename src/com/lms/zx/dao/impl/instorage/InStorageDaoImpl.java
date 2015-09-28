package com.lms.zx.dao.impl.instorage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.dao.IinStorageDao;
import com.lms.zx.entity.InStorageDetailOrder;
import com.lms.zx.entity.InStorageOrder;
import com.lms.zx.entity.Stock;
import com.lms.zx.exception.instorage.InStorageDaoException;
import com.lms.zx.util.DBConnection;

public class InStorageDaoImpl  implements IinStorageDao{
	//�����Ʒ�����
	public void addProductToStock(Connection conn,ArrayList<InStorageDetailOrder> details) throws InStorageDaoException{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		//��ѯ��Ʒ��Ϣ
		try {
			for(int i=0;i<details.size();i++){
				InStorageDetailOrder s=details.get(i);
				pstmt= conn.prepareStatement("select * from v_product where id=?");
				//��̬��ֵ
				pstmt.setLong(1,s.getProId() );
				//ִ��sql����ѯ����Ʒ
				rs=pstmt.executeQuery();
				Stock stock=new Stock();
				//���������
				while(rs.next()){
					stock.setProId(rs.getLong("id"));
					stock.setProName(rs.getString("name"));
					stock.setGenre(rs.getString("genre"));
					stock.setSpecific(rs.getString("specific"));
					stock.setUnit(rs.getString("unit"));
					stock.setSupplieName(rs.getString("supplieName"));
					stock.setRemarks(rs.getString("remarks"));
					stock.setMadeIn(rs.getString("madeIn"));
					stock.setPrice(rs.getDouble("price"));
				}
				stock.setAmount(s.getAmount());
				//��ѯ����Ʒ�ڿ�����Ƿ����
				pstmt=conn.prepareStatement("select * from tb_stock where proId=?");
				pstmt.setLong(1, stock.getProId());
				rs=pstmt.executeQuery();
				if(rs.next()){
					pstmt=conn.prepareStatement("update tb_stock set amount=amount+? where proId=?");
					pstmt.setLong(1, stock.getAmount());
					pstmt.setLong(2, stock.getProId());
					pstmt.executeUpdate();
				}
				else{
					pstmt=conn.prepareStatement("insert into tb_stock values(unique_seq.nextval,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setLong(1, stock.getProId());
					pstmt.setInt(2, stock.getAmount());
					pstmt.setString(3, stock.getProName());
					pstmt.setString(4, stock.getGenre());
					pstmt.setDouble(5, stock.getPrice());
					pstmt.setString(6, stock.getSpecific());
					pstmt.setString(7, stock.getUnit());
					pstmt.setString(8, stock.getSupplieName());
					pstmt.setString(9, stock.getRemarks());
					pstmt.setString(10, stock.getMadeIn());
					//ִ�и���sql���
					pstmt.executeQuery();
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InStorageDaoException(e.getMessage()); 
			
		}finally{
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new InStorageDaoException(e.getMessage()); 
			}
		}
		
	}
	//��������ϸ����
	public void insertProcureDetailOrder(Connection conn, ArrayList<InStorageDetailOrder> details ) throws InStorageDaoException {
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement("insert into tb_inStorageDetailOrder values(?,?,?,?) ");
			for(int i=0;i<details.size();i++) {
				//��ȡ�굥
				InStorageDetailOrder d = details.get(i);
				//��̬��ֵ
				pstmt.setString(1, d.getOrderId());
				pstmt.setLong(2, d.getProId());
				pstmt.setInt(3, d.getAmount());
				pstmt.setDouble(4, d.getPrice());
				//��sql���ӵ��������
				pstmt.addBatch();
			}
			//������
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageDaoException(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageDaoException(e.getMessage());
			}
		}
		
	}
	
	//�����ⶩ��
	public  void insertProcureOrder(Connection conn,InStorageOrder order) throws InStorageDaoException {
		PreparedStatement pstmt=null;
		
		try { 
			pstmt=conn.prepareStatement("insert into tb_inStorageOrder values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?)");
			//��̬��ֵ
			pstmt.setString(1, order.getId());
			pstmt.setInt(2, order.getVarNumber());
			pstmt.setInt(3, order.getProCount());
			pstmt.setDouble(4, order.getSum());
			pstmt.setString(5, order.getPayMent());
			pstmt.setString(6, order.getTime());
			pstmt.setString(7, order.getHandle());
			pstmt.setString(8, order.getConclusion());
			//ִ��sql���
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageDaoException(e.getMessage());
		}finally{
			try{
				//�ر���Դ
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageDaoException(e.getMessage());
			}
		}
		
	}
	//��ѯ��ⶩ����Ϣ֧��ģ����ѯ
	//
	public Vector<Vector<String>> queryOrderMsgByOid(String orderId) {
		//��ȡ���ݿ�����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		 
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection(); 
			//��ѯȫ����ⶩ����Ϣ
			if(orderId.equals("")){
				pstmt=conn.prepareStatement("select * from tb_inStorageOrder");	
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));
					row.add(Integer.toString(rs.getInt("proCount")));
					row.add(Double.toString(rs.getDouble("sum")));
					row.add(rs.getString("conclusion"));
					row.add(Integer.toString(rs.getInt("varNumber")));
					row.add((rs.getDate("time")).toString());
					row.add(rs.getString("payMent"));
					row.add(rs.getString("handle"));
					//��һ��Vector����װ��Vector��
					data.add(row);
				} 
			} else {
				if(orderId.length()==20)
					pstmt=conn.prepareStatement("select * from tb_inStorageOrder where id = ?");
				else {
					pstmt=conn.prepareStatement("select * from tb_inStorageOrder where id like ?");
					orderId = "%"+orderId+"%"; 
				}
				//��̬��ֵ
				pstmt.setString(1, orderId);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));
					row.add(Integer.toString(rs.getInt("proCount")));
					row.add(Double.toString(rs.getDouble("sum")));
					row.add(rs.getString("conclusion"));
					row.add(Integer.toString(rs.getInt("varNumber")));
					row.add((rs.getDate("time")).toString());
					row.add(rs.getString("payMent"));
					row.add(rs.getString("handle"));
					//��һ��Vector����װ��Vector��
					data.add(row);
					}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return data;
	}
	//��ѯ��ⶩ����ϸ��Ϣ
	public Vector<Vector<String>> queryOrderDetailMsgByOid(String orderId) {
		//��ȡ���ݿ�����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();  
			pstmt=conn.prepareStatement("select * from  v_inStorageDetailInfo where orderId=? ");
			pstmt.setString(1,orderId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Vector<String> row=new Vector<String>();
				row.add(rs.getString("proId"));
				row.add(rs.getString("proName"));
				row.add(rs.getString("unit"));
				row.add(rs.getString("specific"));
				row.add(Integer.toString(rs.getInt("amount")));
				row.add(Integer.toString(rs.getInt("price")));
				data.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return data;
	}

	public void addProductInfo(InStorageOrder order) throws InStorageDaoException {
		Connection con = null;
		try {
			//��ȡ����
			con = DBConnection.getConnection();
			//�����ֶ��ύ����
			con.setAutoCommit(false);
			//�����ⶩ��
			insertProcureOrder(con,order);
			//��������ϸ����
			insertProcureDetailOrder(con,order.getDetailOrder());
			//���¿��
			addProductToStock(con,order.getDetailOrder());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InStorageDaoException e) {
			//�ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new InStorageDaoException(e.getMessage());
		}
		
	}


	
}
