package com.jee.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IPcPartsDAO;
import com.jee.dao.vo.PcParts;

public class PcPartsDAOImp implements IPcPartsDAO {
	Connection con = null;
	CallableStatement stmt = null;
	
	public PcPartsDAOImp(Connection con) {
		this.con=con;
	}
	
	@Override
	public int doCreate(PcParts vo) throws Exception {
		String sql = "{call PcPartsInsert(?,?,?,?,?,?,?,?)}"; 
	    stmt = con.prepareCall(sql);
	    //stmt.setInt(1, vo.getId());
	    stmt.setString(1,vo.getName());
	    stmt.setString(2,vo.getType());
	    stmt.setString(3, vo.getProducer());
	    stmt.setInt(4, vo.getTotal());
	    stmt.setInt(5, vo.getRemainder());
	    stmt.setFloat(6, vo.getBid());
	    stmt.setFloat(7, vo.getPrice());
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
	public List<PcParts> findAll() throws Exception {
		String sql = "{call PcPartsSelectALL}"; 
	    stmt = con.prepareCall(sql);
	    ResultSet rs = stmt.executeQuery();  
	    PcParts vo=null;
	    List<PcParts> list = new ArrayList<PcParts>();
	    while(rs.next()){   
	       	vo=new PcParts(); 
	        vo.setId(rs.getInt(1));
	        vo.setName(rs.getString(2));
	        vo.setType(rs.getString(3));
	        vo.setProducer(rs.getString(4));
	        vo.setTotal(rs.getInt(5));
	        vo.setRemainder(rs.getInt(6));
	        vo.setBid(rs.getFloat(7));
	        vo.setPrice(rs.getFloat(8));
	       	vo.setRemark(rs.getString(9));
	       	list.add(vo);
	       	//System.out.println(vo.getOrderId());
	    }    
		return list;
	}

	@Override
	public PcParts findById(Integer id) throws Exception {
		String sql = "{call PcPartsSelect(?)}"; 
	    stmt = con.prepareCall(sql);
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();  
	    PcParts vo=null;
	    while(rs.next()){   
	       	vo=new PcParts();  
	        vo.setId(rs.getInt(1));
	        vo.setName(rs.getString(2));
	        vo.setType(rs.getString(3));
	        vo.setProducer(rs.getString(4));
	        vo.setTotal(rs.getInt(5));
	        vo.setRemainder(rs.getInt(6));
	        vo.setBid(rs.getFloat(7));
	        vo.setPrice(rs.getFloat(8));
	       	vo.setRemark(rs.getString(9));
	    }    
		return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "{call PcPartsDelete(?)}"; 
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
	public int doUpdate(PcParts vo) throws Exception {
		String sql = "{call PcPartsUpdate(?,?,?,?,?,?,?,?,?)}"; 
		stmt = con.prepareCall(sql);
		stmt.setInt(1, vo.getId());
	    stmt.setString(2,vo.getName());
	    stmt.setString(3,vo.getType());
	    stmt.setString(4, vo.getProducer());
	    stmt.setInt(5, vo.getTotal());
	    stmt.setInt(6, vo.getRemainder());
	    stmt.setFloat(7, vo.getBid());
	    stmt.setFloat(8, vo.getPrice());
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
	public List<PcParts> findByName(String name) throws Exception {
		PreparedStatement stat = null;
		List<PcParts> list = new ArrayList<PcParts>();
		String sql = "select id from pcparts where name=? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,name);  
        ResultSet rs = stat.executeQuery(); 
        PcParts vo=null;
        while(rs.next()){      	
        	vo=new PcParts();
        	vo=this.findById(rs.getInt(1));
           	list.add(vo);
        }
        return list;
	}

}
