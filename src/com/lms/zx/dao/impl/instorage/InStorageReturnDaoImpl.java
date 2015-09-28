package com.lms.zx.dao.impl.instorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.lms.zx.dao.IinStorageReturnDao;
import com.lms.zx.entity.InStorageReturnDetailOrder;
import com.lms.zx.entity.InStorageReturnOrder;

import com.lms.zx.exception.instorage.InStorageReturnDaoException;
import com.lms.zx.util.DBConnection;

public class InStorageReturnDaoImpl implements IinStorageReturnDao {


	//�������˻���ϸ��Ϣ
	private void insertProcureReturnDetailOrder(Connection conn,ArrayList<InStorageReturnDetailOrder>  sDetail) throws InStorageReturnDaoException {
		PreparedStatement pstmt=null;
		
		
		try {
			pstmt=conn.prepareStatement("insert into tb_inStorageReturnDetailOrder values(?,?,?,?)");
			//��Vector���ϱ���������һ��һ���Ĳ��뵽����˻��굥����
			for(int i=0;i<sDetail.size();i++){
				InStorageReturnDetailOrder s=sDetail.get(i);
				pstmt.setString(1, s.getOrderReturnId());//�����˻�Ʊ��
				pstmt.setLong(2, s.getProId());//���ÿ��id
				pstmt.setInt(3,s.getAmount());//�����˻�����
				pstmt.setDouble(4,s.getReturnPrice() );//�����˻��۸�
				pstmt.addBatch();
			}
			//������ִ��sql���
			pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageReturnDaoException(e.getMessage());
			}
		}
	}
	//�������˻���Ϣ
	private void insertProcureReturnOrder(Connection conn,InStorageReturnOrder order) throws InStorageReturnDaoException  {
		
		PreparedStatement pstmt=null;
		
		
		try {
			 
			pstmt=conn.prepareStatement("insert into tb_inStorageReturnOrder values(?,to_date(?,'yyyy-mm-dd'),?,?,?)");
			//�˻�Ʊ�ţ��˻����ڣ������ˣ��ܽ����ʽ
			pstmt.setString(1, order.getId());//�����˻�Ʊ��
			pstmt.setString(2, order.getTime());//�����˻�����
			pstmt.setString(3, order.getHandle());//���þ�����
			pstmt.setString(4,order.getPayMent());//���ø��ʽ
			//�����ܽ��
			pstmt.setDouble(5, order.getSum());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageReturnDaoException(e.getMessage());
			}
		}
		
	}

	//��������˻�Ʊ�Ų�ѯ�˻�������ϸ��Ϣ
	public Vector<Vector<String>> queryOrderDetailMsgBySid(String sId) throws InStorageReturnDaoException {
		//��ȡ���ݿ�����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector<Vector<String>> returnOrderDetail=new Vector<Vector<String>>();
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("select * from v_inStorageReturnDetailInfo where orderReturnId=?");
			//��̬����
			pstmt.setString(1, sId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Vector<String> data=new Vector<String>();
				data.add(String.valueOf(rs.getInt("proId")));
				data.add(rs.getString("supplieName"));
				data.add(rs.getString("proName"));
				data.add(rs.getString("unit"));
				data.add(rs.getString("specific"));
				data.add(String.valueOf(rs.getDouble("inPrice")));
				data.add(String.valueOf(rs.getDouble("RETURNPRICE")));
				data.add(String.valueOf(rs.getInt("amount")));
				returnOrderDetail.add(data);
			}
			return returnOrderDetail;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}
		
	}

	//����˻���ѯ ��������˻�Ʊ�Ų�ѯ������Ϣ ֧��ģ����ѯ
	public Vector<Vector<String>> queryOrderMsgBySid(String sId) throws InStorageReturnDaoException {
		//��ȡ���ݿ�����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection();
			if(sId.length()==20){
				pstmt=conn.prepareStatement("select * from tb_inStorageReturnOrder where id=?");
				pstmt.setString(1, sId);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));//��ȡid
					row.add(String.valueOf(rs.getDouble("sum")));//��ȡ�ܽ��
					row.add(String.valueOf(rs.getDate("time")));//��ȡ����˻�����
					row.add(rs.getString("handle"));//��ȡ������
					row.add(rs.getString("payMent"));//��ȡ֧����ʽ
					data.add(row);
				}
			}
			if(sId.equalsIgnoreCase("")){
				pstmt=conn.prepareStatement("select * from tb_inStorageReturnOrder");
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));//��ȡid
					row.add(String.valueOf(rs.getDouble("sum")));//��ȡ�ܽ��
					row.add(String.valueOf(rs.getDate("time")));//��ȡ����˻�����
					row.add(rs.getString("handle"));//��ȡ������
					row.add(rs.getString("payMent"));//��ȡ֧����ʽ
					data.add(row);
				}
				
			}else{
				pstmt=conn.prepareStatement("select * from tb_inStorageReturnOrder where id like '%"+sId+"%'");
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));//��ȡid
					row.add(String.valueOf(rs.getDouble("sum")));//��ȡ�ܽ��
					row.add(String.valueOf(rs.getDate("time")));//��ȡ����˻�����
					row.add(rs.getString("handle"));//��ȡ������
					row.add(rs.getString("payMent"));//��ȡ֧����ʽ
					data.add(row);
				}
				
			}
			return data;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}
		
	}
	public void insertReturnMsg(InStorageReturnOrder order) throws InStorageReturnDaoException{
		Connection conn=null;
		try {
			//��ȡ����
			conn=DBConnection.getConnection();
			//�����ֶ��ύ����
			conn.setAutoCommit(false);
			//1.�������˻���Ϣ
			insertProcureReturnOrder(conn,order);
			//2.�������˻���ϸ��Ϣ
			insertProcureReturnDetailOrder(conn,order.getInReturnOrder());
			//3���¿��
			updateStock(conn,order.getInReturnOrder());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		} catch (InStorageReturnDaoException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new InStorageReturnDaoException(e.getMessage());
			}
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}
		
		
	}
	//���¿��
	public void updateStock(Connection conn,
			ArrayList<InStorageReturnDetailOrder> sDetail) throws InStorageReturnDaoException {
		PreparedStatement pstmt=null;
		try {
			
			for(int i=0;i<sDetail.size();i++){
				InStorageReturnDetailOrder s=sDetail.get(i);
				pstmt=conn.prepareStatement("update tb_stock set amount=amount-? where proId=? ");
				pstmt.setInt(1, s.getAmount());
				pstmt.setLong(2, s.getProId());
				//ִ��sql���
				pstmt.executeUpdate();
			}
			} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageReturnDaoException(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageReturnDaoException(e.getMessage());
			}
		}
		
	}
	
}
