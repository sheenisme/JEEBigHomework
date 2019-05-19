package com.jee.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IRepairReceiptDAO;
import com.jee.dao.vo.RepairReceipt;

public class RepairReceiptDAOImpl implements IRepairReceiptDAO {
	Connection con = null;
	CallableStatement stmt = null;
	
	public RepairReceiptDAOImpl(Connection con) {
		this.con=con;
	}
	
	@Override
	public int doCreate(RepairReceipt vo) throws Exception {
		String sql = "{call RepairReceiptInsert(?,?,?,?,?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, vo.getOrderId());
	    stmt.setInt(2,vo.getAdminId());
	    stmt.setTimestamp(3,vo.getRepairTime());
	    stmt.setBoolean(4, vo.getNeedParts());
	    stmt.setString(5,vo.getPartsType());
	    stmt.setString(6, vo.getResolvent());
	    stmt.setString(7, vo.getAdvise());
	    stmt.setString(8, vo.getRemark());
	   
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		    return result;
	    }
	    else {
		    return -1;
	    }
	}

	@Override
	public List<RepairReceipt> findAll() throws Exception {
		String sql = "{call RepairReceiptSelectALL}"; 
	    stmt = con.prepareCall(sql);
	    ResultSet rs = stmt.executeQuery();  
	    RepairReceipt vo=null;
	    List<RepairReceipt> list = new ArrayList<RepairReceipt>();
	    while(rs.next()){   
	       	vo=new RepairReceipt(); 
	       	vo.setReceiptId(rs.getInt(1));
	       	vo.setOrderId(rs.getString(2));
	       	vo.setAdminId(rs.getInt(3));
	       	vo.setRepairTime(rs.getTimestamp(4));
	       	vo.setNeedParts(rs.getBoolean(5));
	       	vo.setPartsType(rs.getString(6));
	       	vo.setResolvent(rs.getString(7));
	       	vo.setAdvise(rs.getString(8));
	       	vo.setRemark(rs.getString(9));
	       	list.add(vo);
	       	//System.out.println(vo.getOrderId());
	    }    
		return list;
	}

	@Override
	public RepairReceipt findById(Integer id) throws Exception {
		String sql = "{call RepairReceiptSelect(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();  
	    RepairReceipt vo=null;
	    while(rs.next()){   
	       	vo=new RepairReceipt();  
	       	vo.setReceiptId(rs.getInt(1));
	       	vo.setOrderId(rs.getString(2));
	       	vo.setAdminId(rs.getInt(3));
	       	vo.setRepairTime(rs.getTimestamp(4));
	       	vo.setNeedParts(rs.getBoolean(5));
	       	vo.setPartsType(rs.getString(6));
	       	vo.setResolvent(rs.getString(7));
	       	vo.setAdvise(rs.getString(8));
	       	vo.setRemark(rs.getString(9));
	    }    
		return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "{call RepairReceiptDelete(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setInt(1, id);
	    boolean rs = stmt.execute();  
	    if(rs == true){
	    	return 1;
	    }else {
	    	return -1;
	    }
	}

	@Override
	public int doUpdate(RepairReceipt vo) throws Exception {
		String sql = "{call RepairReceiptUpdate(?,?,?,?,?,?,?,?,?)}"; 
		stmt = con.prepareCall(sql);
		stmt.setInt(1, vo.getReceiptId());
		stmt.setString(2, vo.getOrderId());
	    stmt.setInt(3,vo.getAdminId());
	    stmt.setTimestamp(4,vo.getRepairTime());
	    stmt.setBoolean(5, vo.getNeedParts());
	    stmt.setString(6,vo.getPartsType());
	    stmt.setString(7, vo.getResolvent());
	    stmt.setString(8, vo.getAdvise());
	    stmt.setString(9, vo.getRemark());
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		   return result;
	    }
	    else {
		   return -1;
	    }
	}

	@Override
	public List<String> findOrderId(Integer id) throws Exception {
		String sql = "{call OrdersIdByReceipt(?)}"; 
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
