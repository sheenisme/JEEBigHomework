package com.jee.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IFeedbackDAO;
import com.jee.dao.vo.Feedback;

public class FeedbackDAOImpl implements IFeedbackDAO {
	Connection con = null;
	CallableStatement stmt = null;
	
	public FeedbackDAOImpl(Connection con) {
		this.con=con;
	}
	@Override
	public int doCreate(Feedback vo) throws Exception {
		String sql = "{call FeedbackInsert(?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setString(1,vo.getLinkName());
	    stmt.setString(2,vo.getLinkEmail());
	    stmt.setString(3, vo.getTheme());
	    stmt.setString(4, vo.getDescription());
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		    return result;
	    }
	    else {
		    return -1;
	    }
	}

	@Override
	public List<Feedback> findAll() throws Exception {
		String sql = "{call FeedbackSelectALL}"; 
	    stmt = con.prepareCall(sql);
	    ResultSet rs = stmt.executeQuery();  
	    Feedback vo=null;
	    List<Feedback> list = new ArrayList<Feedback>();
	    while(rs.next()){   
	       	vo=new Feedback(); 
	        vo.setId(rs.getInt(1));
	        vo.setLinkName(rs.getString(2));
	        vo.setLinkEmail(rs.getString(3));
	        vo.setTheme(rs.getString(4));
	        vo.setDescription(rs.getString(5));
	       	list.add(vo);
	       	//System.out.println(vo.getOrderId());
	    }    
		return list;
	}

	@Override
	public Feedback findById(Integer id) throws Exception {
		String sql = "{call FeedbackSelect(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();  
	    Feedback vo=null;
	    while(rs.next()){   
	       	vo=new Feedback();  
	       	vo.setId(rs.getInt(1));
	        vo.setLinkName(rs.getString(2));
	        vo.setLinkEmail(rs.getString(3));
	        vo.setTheme(rs.getString(4));
	        vo.setDescription(rs.getString(5));
	    }    
		return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "{call FeedbackDelete(?)}"; 
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
	public int doUpdate(Feedback vo) throws Exception {
		String sql = "{call FeedbackUpdate(?,?,?,?,?)}"; 
		stmt = con.prepareCall(sql);
		stmt.setInt(1,vo.getId());
		stmt.setString(2,vo.getLinkName());
	    stmt.setString(3,vo.getLinkEmail());
	    stmt.setString(4, vo.getTheme());
	    stmt.setString(5, vo.getDescription());
	    int result=stmt.executeUpdate();
	    if(result > 0) {
		   return result;
	    }
	    else {
		   return -1;
	    }
	}

}
