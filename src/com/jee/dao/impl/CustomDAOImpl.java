package com.jee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.ICustomDAO;
import com.jee.dao.vo.Custom;

public class CustomDAOImpl implements ICustomDAO{
	private Connection con;  
    private PreparedStatement stat = null;
	
	public CustomDAOImpl(Connection con) {
    	this.con=con;
	}
	
	@Override
	public int doCreate(Custom vo) throws Exception {
		String sql = "insert into custom values(?,?,?,?,?,?,?,?,?,?,?,?) ";  
        stat = con.prepareStatement(sql);   
        //这里是自增的，不用写该语句stat.setInt(1, vo.getId());  
        stat.setString(1, vo.getLoginName());  
        stat.setString(2, vo.getPassword());  
        stat.setString(3, vo.getName());
        stat.setString(4, vo.getSex());
        stat.setString(5, vo.getEmail());
        stat.setString(6, vo.getPhone());
        stat.setString(7, vo.getAddress());
        stat.setDate(8, vo.getBirthday());
        stat.setTimestamp(9, vo.getDate());
        stat.setString(10, vo.getPoint());
        stat.setString(11, vo.getUnit());
        stat.setString(12, vo.getRemark());
        int update = stat.executeUpdate();  
        if(update>0){  
            return update;  
        }  
        else{  
        	System.out.println("插入失败！-CustomDAOImp.doCreate()方法");
            return -1;  
        } 
	}

	@Override
	public List<Custom> findAll() throws Exception {
		String sql = "select * from custom";  
        stat = con.prepareStatement(sql);  
        ResultSet rs = stat.executeQuery();  
        Custom vo=null;
        List<Custom> list = new ArrayList<Custom>();  
        while(rs.next()){
            //获取属性并将属性写至vo对象中
            vo=new Custom();  
            vo.setId(rs.getInt(1));
            vo.setLoginName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            vo.setName(rs.getString(4));
            vo.setSex(rs.getString(5));
            vo.setEmail(rs.getString(6));
            vo.setPhone(rs.getString(7));
            vo.setAddress(rs.getString(8));
            vo.setBirthday(rs.getDate(9));
            vo.setDate(rs.getTimestamp(10));
            vo.setPoint(rs.getString(11));
            vo.setUnit(rs.getString(12));
            vo.setRemark(rs.getString(13));
            list.add(vo);  
        }  
        return list;
	}

	@Override
	public Custom findById(Integer id) throws Exception {
		if(id != null ) {
			String sql = "select * from custom where id= ? ";  
			stat = con.prepareStatement(sql);  
			stat.setInt(1,id);  
			ResultSet rs = stat.executeQuery();  
			Custom vo=null;
			if(rs.next()){   
				vo=new Custom();  
				vo.setId(rs.getInt(1));
	            vo.setLoginName(rs.getString(2));
	            vo.setPassword(rs.getString(3));
	            vo.setName(rs.getString(4));
	            vo.setSex(rs.getString(5));
	            vo.setEmail(rs.getString(6));
	            vo.setPhone(rs.getString(7));
	            vo.setAddress(rs.getString(8));
	            vo.setBirthday(rs.getDate(9));
	            vo.setDate(rs.getTimestamp(10));
	            vo.setPoint(rs.getString(11));
	            vo.setUnit(rs.getString(12));
	            vo.setRemark(rs.getString(13));
			}    
			return vo;
		}
		else {
			return null;
		}
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "delete from custom where id= ? ";
		stat = con.prepareStatement(sql); 
		stat.setInt(1,id);
		int delete=stat.executeUpdate();
		if (delete > 0) {
			return delete;
		}else {
			System.out.println("删除失败！-CustomDAOImpl.doRemove()方法");
			return -1;
		}
	}

	@Override
	public int doUpdate(Custom vo) throws Exception {
		String sql = "update custom set loginname=?,password=?,name=?,sex=?,email=?,phone=?,address=?,birthday=?,date=?,point=?,unit=?,remark=? where id=?";  
        stat = con.prepareStatement(sql);     
        stat.setString(1, vo.getLoginName());  
        stat.setString(2, vo.getPassword());  
        stat.setString(3, vo.getName());
        stat.setString(4, vo.getSex());
        stat.setString(5, vo.getEmail());
        stat.setString(6, vo.getPhone());
        stat.setString(7, vo.getAddress());
        stat.setDate(8, vo.getBirthday());
        stat.setTimestamp(9, vo.getDate());
        stat.setString(10, vo.getPoint());
        stat.setString(11, vo.getUnit());
        stat.setString(12, vo.getRemark());
        stat.setInt(13, vo.getId());
        int update=stat.executeUpdate();
        if(update>0) {
        	return update;
        }else{
        	System.out.println("更新失败！-CustomDAOImpl.doUpdate()方法");
        	return -1;
        }
	}

	@Override
	public List<Custom> findByName(String name) throws Exception {
		List<Custom> list = new ArrayList<Custom>();
		String sql = "select id from custom where loginname=? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,name);  
        ResultSet rs = stat.executeQuery(); 
        Custom vo=null;
        while(rs.next()){      	
        	vo=new Custom();
        	vo=this.findById(rs.getInt(1));
           	list.add(vo);
        }  
        return list;
	}

	@Override
	public List<Custom> findByEmail(String email) throws Exception {
		List<Custom> list = new ArrayList<Custom>();
		String sql = "select id from custom where email=? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,email);  
        ResultSet rs = stat.executeQuery(); 
        Custom vo=null;
        while(rs.next()){      	
        	vo=new Custom();
        	vo=this.findById(rs.getInt(1));
           	list.add(vo);
        }  
        return list;
	}
	
}
