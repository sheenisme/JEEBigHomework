package com.jee.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IRepairOrdersDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.vo.RepairOrders;

public class RepairOrdersDAOImpl implements IRepairOrdersDAO {
	Connection con = null;
	CallableStatement stmt = null;
	
	public RepairOrdersDAOImpl(Connection con) {
		this.con=con;
	}
	
	@Override
	public int doCreate(RepairOrders vo) throws Exception {
		String sql = "{call RepairOrdersInsert(?,?,?,?,?,?,?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, vo.getOrderId());
	    stmt.setInt(2, vo.getCustomId());
	    stmt.setTimestamp(3, vo.getApplyTime());
	    stmt.setString(4,vo.getLinkName());
	    stmt.setString(5, vo.getLinkPhone());
	    stmt.setString(6, vo.getLinkAddress());
	    stmt.setTimestamp(7, vo.getRepairTime());
	    stmt.setString(8,vo.getType());
	    stmt.setString(9, vo.getDescription());
	    stmt.setString(10, vo.getRemark());
	   
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		    return result;
	    }
	    else {
		    return -1;
	    }
	 }

	@Override
	public List<RepairOrders> findAll() throws Exception {
		String sql = "{call RepairOrdersSelectALL(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.registerOutParameter(1,java.sql.Types.INTEGER);
	    ResultSet rs = stmt.executeQuery();  
	    RepairOrders vo=null;
	    List<RepairOrders> list = new ArrayList<RepairOrders>();
	    while(rs.next()){   
	       	vo=new RepairOrders();  
	       	vo.setOrderId(rs.getString(1));
	       	vo.setCustomId(rs.getInt(2));
	       	vo.setApplyTime(rs.getTimestamp(3));
	       	vo.setLinkName(rs.getString(4));
	       	vo.setLinkPhone(rs.getString(5));
	       	vo.setLinkAddress(rs.getString(6));
	       	vo.setRepairTime(rs.getTimestamp(7));
	       	vo.setType(rs.getString(8));
	       	vo.setDescription(rs.getString(9));
	       	vo.setRemark(rs.getString(10));
	       	list.add(vo);
	       	//System.out.println(vo.getOrderId());
	    }    
		return list;
	}

	@Override
	public RepairOrders findById(String id) throws Exception {
		String sql = "{call RepairOrdersSelect(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, id);
	    ResultSet rs = stmt.executeQuery();  
	    RepairOrders vo=null;
	    while(rs.next()){   
	       	vo=new RepairOrders();  
	       	vo.setOrderId(rs.getString(1));
	       	vo.setCustomId(rs.getInt(2));
	       	vo.setApplyTime(rs.getTimestamp(3));
	       	vo.setLinkName(rs.getString(4));
	       	vo.setLinkPhone(rs.getString(5));
	       	vo.setLinkAddress(rs.getString(6));
	       	vo.setRepairTime(rs.getTimestamp(7));
	       	vo.setType(rs.getString(8));
	       	vo.setDescription(rs.getString(10));
	       	vo.setRemark(rs.getString(11));
	    }    
		return vo;
	}

	@Override
	public int doUpdate(RepairOrders vo) throws Exception {
		String sql = "{call RepairOrdersUpdate(?,?,?,?,?,?,?,?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, vo.getOrderId());
	    stmt.setInt(2, vo.getCustomId());
	    stmt.setTimestamp(3, vo.getApplyTime());
	    stmt.setString(4,vo.getLinkName());
	    stmt.setString(5, vo.getLinkPhone());
	    stmt.setString(6, vo.getLinkAddress());
	    stmt.setTimestamp(7, vo.getRepairTime());
	    stmt.setString(8,vo.getType());
	    stmt.setString(9, vo.getDescription());
	    stmt.setString(10, vo.getRemark());
	    
	    int result=stmt.executeUpdate();
	   if(result > 0) {
		   return result;
	   }
	   else {
		   return -1;
	   }
	}
	@Override
	public int doRemove(String id) throws Exception {
		String sql = "{call RepairOrdersDelete(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, id);
	    boolean rs = stmt.execute();  
	    if(rs == true){
	    	return 1;
	    }else {
	    	return -1;
	    }
	}

	@Override
	public List<String> findOrderId(Integer id) throws Exception {
		if(!con.isClosed()) {
			String sql = "{call OrdersId(?)}"; 
			stmt = con.prepareCall(sql);
	    	stmt.setInt(1, id);
	    	ResultSet rs = stmt.executeQuery();
	    	List<String> list=new ArrayList<String>();
	    	String vo=null;
	    	while(rs.next()){   
	    		vo=new String();  
	    		vo=rs.getString(1);
	    		list.add(vo);
	    	}    
	    	return list;
		}
		else {
			this.con= new DatabaseConnection().getConnection();
			String sql = "{call OrdersId(?)}"; 
			stmt = con.prepareCall(sql);
	    	stmt.setInt(1, id);
	    	ResultSet rs = stmt.executeQuery();
	    	List<String> list=new ArrayList<String>();
	    	String vo=null;
	    	while(rs.next()){   
	    		vo=new String();  
	    		vo=rs.getString(1);
	    		list.add(vo);
	    	}    
	    	return list;
		}
			
	}

}
