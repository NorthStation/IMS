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
	//添加商品到库存
	public void addProductToStock(Connection conn,ArrayList<InStorageDetailOrder> details) throws InStorageDaoException{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		//查询商品信息
		try {
			for(int i=0;i<details.size();i++){
				InStorageDetailOrder s=details.get(i);
				pstmt= conn.prepareStatement("select * from v_product where id=?");
				//动态传值
				pstmt.setLong(1,s.getProId() );
				//执行sql语句查询出商品
				rs=pstmt.executeQuery();
				Stock stock=new Stock();
				//遍历结果集
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
				//查询该商品在库存中是否存在
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
					//执行更新sql语句
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
	//添加入库详细订单
	public void insertProcureDetailOrder(Connection conn, ArrayList<InStorageDetailOrder> details ) throws InStorageDaoException {
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement("insert into tb_inStorageDetailOrder values(?,?,?,?) ");
			for(int i=0;i<details.size();i++) {
				//获取详单
				InStorageDetailOrder d = details.get(i);
				//动态传值
				pstmt.setString(1, d.getOrderId());
				pstmt.setLong(2, d.getProId());
				pstmt.setInt(3, d.getAmount());
				pstmt.setDouble(4, d.getPrice());
				//将sql语句加到缓冲池中
				pstmt.addBatch();
			}
			//批处理
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
	
	//添加入库订单
	public  void insertProcureOrder(Connection conn,InStorageOrder order) throws InStorageDaoException {
		PreparedStatement pstmt=null;
		
		try { 
			pstmt=conn.prepareStatement("insert into tb_inStorageOrder values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?)");
			//动态传值
			pstmt.setString(1, order.getId());
			pstmt.setInt(2, order.getVarNumber());
			pstmt.setInt(3, order.getProCount());
			pstmt.setDouble(4, order.getSum());
			pstmt.setString(5, order.getPayMent());
			pstmt.setString(6, order.getTime());
			pstmt.setString(7, order.getHandle());
			pstmt.setString(8, order.getConclusion());
			//执行sql语句
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InStorageDaoException(e.getMessage());
		}finally{
			try{
				//关闭资源
				if(pstmt!=null){pstmt.close();}
			}catch(SQLException e){
				e.printStackTrace();
				throw new InStorageDaoException(e.getMessage());
			}
		}
		
	}
	//查询入库订单信息支持模糊查询
	//
	public Vector<Vector<String>> queryOrderMsgByOid(String orderId) {
		//获取数据库连接
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		 
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		try {
			conn=DBConnection.getConnection(); 
			//查询全部入库订单信息
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
					//把一个Vector对象装入Vector中
					data.add(row);
				} 
			} else {
				if(orderId.length()==20)
					pstmt=conn.prepareStatement("select * from tb_inStorageOrder where id = ?");
				else {
					pstmt=conn.prepareStatement("select * from tb_inStorageOrder where id like ?");
					orderId = "%"+orderId+"%"; 
				}
				//动态传值
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
					//把一个Vector对象装入Vector中
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
	//查询入库订单详细信息
	public Vector<Vector<String>> queryOrderDetailMsgByOid(String orderId) {
		//获取数据库连接
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
			//获取连接
			con = DBConnection.getConnection();
			//设置手动提交事务
			con.setAutoCommit(false);
			//添加入库订单
			insertProcureOrder(con,order);
			//添加入库详细订单
			insertProcureDetailOrder(con,order.getDetailOrder());
			//更新库存
			addProductToStock(con,order.getDetailOrder());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InStorageDaoException e) {
			//回滚事务
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
