package com.jee.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IEvaluationRecordDAO;
import com.jee.dao.vo.EvaluationRecord;

public class EvaluationRecordDAOImpl implements IEvaluationRecordDAO {
	Connection con = null;
	CallableStatement stmt = null;
	
	public EvaluationRecordDAOImpl(Connection con) {
		this.con=con;
	}
	
	@Override
	public int doCreate(EvaluationRecord vo) throws Exception {
		String sql = "{call EvaluationRecordInsert(?,?,?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1, vo.getOrderId());
	    stmt.setInt(2,vo.getUserId());
	    stmt.setTimestamp(3, vo.getEvaluateDate());
	    stmt.setInt(4,vo.getStarLevel());
	    stmt.setString(5, vo.getContext());
	    stmt.setString(6, vo.getRemark());
	   
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		    return result;
	    }
	    else {
		    return -1;
	    }
	}

	@Override
	public List<EvaluationRecord> findAll() throws Exception {
		String sql = "{call EvaluationRecordSelectALL}"; 
	    stmt = con.prepareCall(sql);
	    ResultSet rs = stmt.executeQuery();  
	    EvaluationRecord vo=null;
	    List<EvaluationRecord> list = new ArrayList<EvaluationRecord>();
	    while(rs.next()){   
	       	vo=new EvaluationRecord(); 
	       	vo.setEvaluateId(rs.getInt(1));
	       	vo.setOrderId(rs.getString(2));
	       	vo.setUserId(rs.getInt(3));
	       	vo.setEvaluateDate(rs.getTimestamp(4));
	       	vo.setStarLevel(rs.getInt(5));
	       	vo.setContext(rs.getString(6));
	       	vo.setRemark(rs.getString(7));
	       	list.add(vo);
	       	//System.out.println(vo.getOrderId());
	    }    
		return list;
	}

	@Override
	public EvaluationRecord findById(Integer id) throws Exception {
		String sql = "{call EvaluationRecordSelect(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();  
	    EvaluationRecord vo=null;
	    while(rs.next()){   
	       	vo=new EvaluationRecord();  
	       	vo.setEvaluateId(rs.getInt(1));
	       	vo.setOrderId(rs.getString(2));
	       	vo.setUserId(rs.getInt(3));
	       	vo.setEvaluateDate(rs.getTimestamp(4));
	       	vo.setStarLevel(rs.getInt(5));
	       	vo.setContext(rs.getString(6));
	       	vo.setRemark(rs.getString(7));
	    }    
		return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "{call EvaluationRecordDelete(?)}"; 
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
	public int doUpdate(EvaluationRecord vo) throws Exception {
		String sql = "{call EvaluationRecordUpdate(?,?,?,?,?,?,?)}"; 
		stmt = con.prepareCall(sql);
		stmt.setInt(1, vo.getEvaluateId());
	    stmt.setString(2, vo.getOrderId());
	    stmt.setInt(3,vo.getUserId());
	    stmt.setTimestamp(4, vo.getEvaluateDate());
	    stmt.setInt(5,vo.getStarLevel());
	    stmt.setString(6, vo.getContext());
	    stmt.setString(7, vo.getRemark());
	    
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		   return result;
	    }
	    else {
		   return -1;
	    }
	}
}
