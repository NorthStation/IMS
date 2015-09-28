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


	//添加入库退货详细信息
	private void insertProcureReturnDetailOrder(Connection conn,ArrayList<InStorageReturnDetailOrder>  sDetail) throws InStorageReturnDaoException {
		PreparedStatement pstmt=null;
		
		
		try {
			pstmt=conn.prepareStatement("insert into tb_inStorageReturnDetailOrder values(?,?,?,?)");
			//对Vector集合遍历将对象一个一个的插入到入库退货详单表中
			for(int i=0;i<sDetail.size();i++){
				InStorageReturnDetailOrder s=sDetail.get(i);
				pstmt.setString(1, s.getOrderReturnId());//设置退货票号
				pstmt.setLong(2, s.getProId());//设置库存id
				pstmt.setInt(3,s.getAmount());//设置退货数量
				pstmt.setDouble(4,s.getReturnPrice() );//设置退货价格
				pstmt.addBatch();
			}
			//批处理执行sql语句
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
	//添加入库退货信息
	private void insertProcureReturnOrder(Connection conn,InStorageReturnOrder order) throws InStorageReturnDaoException  {
		
		PreparedStatement pstmt=null;
		
		
		try {
			 
			pstmt=conn.prepareStatement("insert into tb_inStorageReturnOrder values(?,to_date(?,'yyyy-mm-dd'),?,?,?)");
			//退货票号，退货日期，经手人，总金额，付款方式
			pstmt.setString(1, order.getId());//设置退货票号
			pstmt.setString(2, order.getTime());//设置退货日期
			pstmt.setString(3, order.getHandle());//设置经手人
			pstmt.setString(4,order.getPayMent());//设置付款方式
			//设置总金额
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

	//根据入库退货票号查询退货订单详细信息
	public Vector<Vector<String>> queryOrderDetailMsgBySid(String sId) throws InStorageReturnDaoException {
		//获取数据库连接
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector<Vector<String>> returnOrderDetail=new Vector<Vector<String>>();
		
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement("select * from v_inStorageReturnDetailInfo where orderReturnId=?");
			//动态传参
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

	//入库退货查询 根据入库退货票号查询订单信息 支持模糊查询
	public Vector<Vector<String>> queryOrderMsgBySid(String sId) throws InStorageReturnDaoException {
		//获取数据库连接
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
					row.add(rs.getString("id"));//获取id
					row.add(String.valueOf(rs.getDouble("sum")));//获取总金额
					row.add(String.valueOf(rs.getDate("time")));//获取入库退货日期
					row.add(rs.getString("handle"));//获取经手人
					row.add(rs.getString("payMent"));//获取支付方式
					data.add(row);
				}
			}
			if(sId.equalsIgnoreCase("")){
				pstmt=conn.prepareStatement("select * from tb_inStorageReturnOrder");
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));//获取id
					row.add(String.valueOf(rs.getDouble("sum")));//获取总金额
					row.add(String.valueOf(rs.getDate("time")));//获取入库退货日期
					row.add(rs.getString("handle"));//获取经手人
					row.add(rs.getString("payMent"));//获取支付方式
					data.add(row);
				}
				
			}else{
				pstmt=conn.prepareStatement("select * from tb_inStorageReturnOrder where id like '%"+sId+"%'");
				rs=pstmt.executeQuery();
				while(rs.next()){
					Vector<String> row=new Vector<String>();
					row.add(rs.getString("id"));//获取id
					row.add(String.valueOf(rs.getDouble("sum")));//获取总金额
					row.add(String.valueOf(rs.getDate("time")));//获取入库退货日期
					row.add(rs.getString("handle"));//获取经手人
					row.add(rs.getString("payMent"));//获取支付方式
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
			//获取连接
			conn=DBConnection.getConnection();
			//设置手动提交事务
			conn.setAutoCommit(false);
			//1.添加入库退货信息
			insertProcureReturnOrder(conn,order);
			//2.添加入库退货详细信息
			insertProcureReturnDetailOrder(conn,order.getInReturnOrder());
			//3更新库存
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
	//更新库存
	public void updateStock(Connection conn,
			ArrayList<InStorageReturnDetailOrder> sDetail) throws InStorageReturnDaoException {
		PreparedStatement pstmt=null;
		try {
			
			for(int i=0;i<sDetail.size();i++){
				InStorageReturnDetailOrder s=sDetail.get(i);
				pstmt=conn.prepareStatement("update tb_stock set amount=amount-? where proId=? ");
				pstmt.setInt(1, s.getAmount());
				pstmt.setLong(2, s.getProId());
				//执行sql语句
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
