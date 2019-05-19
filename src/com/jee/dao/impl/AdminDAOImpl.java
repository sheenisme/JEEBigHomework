package com.jee.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.IAdminDAO;
import com.jee.dao.vo.Admin;

public class AdminDAOImpl implements IAdminDAO {
	private Connection con;  
    private PreparedStatement stat = null;
    
    /**
     * 构造函数，初始化数据库的连接对象
     * @param con
     */
    public AdminDAOImpl(Connection con) {
    	this.con=con;
    }
    
	@Override
	public int doCreate(Admin vo) throws Exception {
		String sql = "insert into admin values(?,?,?,?,?,?,?,?,?,?,?) ";  
        stat = con.prepareStatement(sql);   
        //这里是自增的，不用写该语句stat.setInt(1, vo.getId());  
        stat.setString(1, vo.getLoginName());  
        stat.setString(2, vo.getPassword());  
        stat.setString(3, vo.getName());
        stat.setString(4, vo.getSex());
        stat.setString(5, vo.getEmail());
        stat.setString(6, vo.getPhone());
        stat.setString(7, vo.getAddress());
        stat.setTimestamp(8, vo.getDate());
        stat.setString(9, vo.getGrade());
        stat.setInt(10, vo.getUpperId());
        stat.setString(11, vo.getRemark());
        int result = stat.executeUpdate();  
        if(result>0){  
            return result;  
        }  
        else{  
        	System.out.println("插入失败！-AdminDAOImpl.doCreate()方法");
            return -1;  
        } 
	}

	@Override
	public List<Admin> findAll() throws Exception {
        String sql = "select * from admin";  
        stat = con.prepareStatement(sql);  
        ResultSet rs = stat.executeQuery();  
        Admin vo=null;
        List<Admin> list = new ArrayList<Admin>();  
        while(rs.next()){
            //获取属性并将属性写至vo对象中
            vo=new Admin();  
            vo.setId(rs.getInt(1));
            vo.setLoginName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            vo.setName(rs.getString(4));
            vo.setSex(rs.getString(5));
            vo.setEmail(rs.getString(6));
            vo.setPhone(rs.getString(7));
            vo.setAddress(rs.getString(8));
            vo.setDate(rs.getTimestamp(9));
            vo.setGrade(rs.getString(10));
            vo.setUpperId(rs.getInt(11));
            vo.setRemark(rs.getString(12));
            list.add(vo);  
        }  
        return list;
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		 String sql = "select * from admin where id= ? ";  
	     stat = con.prepareStatement(sql);  
	     stat.setInt(1,id);  
	     ResultSet rs = stat.executeQuery();  
	     Admin vo=null;
	     if(rs.next()){   
	       	vo=new Admin();  
	        vo=new Admin();  
            vo.setId(rs.getInt(1));
            vo.setLoginName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            vo.setName(rs.getString(4));
            vo.setSex(rs.getString(5));
            vo.setEmail(rs.getString(6));
            vo.setPhone(rs.getString(7));
            vo.setAddress(rs.getString(8));
            vo.setDate(rs.getTimestamp(9));
            vo.setGrade(rs.getString(10));
            vo.setUpperId(rs.getInt(11));
            vo.setRemark(rs.getString(12));
	    }    
		return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		String sql = "delete from admin where id= ? ";
		stat = con.prepareStatement(sql); 
		stat.setInt(1,id);
		int delete=stat.executeUpdate();
		if (delete > 0) {
			return delete;
		}else {
			System.out.println("删除失败！-AdminDAOImpl.doRemove()方法");
			return -1;
		}
	}

	@Override
	public int doUpdate(Admin vo) throws Exception {
    	String sql = "update admin set loginname=?,password=?,name=?,sex=?,email=?,phone=?,address=?,date=?,grade=?,upperid=?,remark=? where id=?";  
        stat = con.prepareStatement(sql);    
        stat.setString(1, vo.getLoginName());  
        stat.setString(2, vo.getPassword());  
        stat.setString(3, vo.getName());
        stat.setString(4, vo.getSex());
        stat.setString(5, vo.getEmail());
        stat.setString(6, vo.getPhone());
        stat.setString(7, vo.getAddress());
        stat.setTimestamp(8, vo.getDate());
        stat.setString(9, vo.getGrade());
        stat.setInt(10, vo.getUpperId());
        stat.setString(11, vo.getRemark());
        stat.setInt(12, vo.getId());
        int update=stat.executeUpdate();
        if(update>0) {
        	return update;
        }else{
        	System.out.println("更新失败！-AdminDAOImpl.doUpdate()方法");
        	return -1;
        }
	}

	@Override
	public List<Admin> findByName(String name) throws Exception {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select id from admin where loginname=? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,name);  
        ResultSet rs = stat.executeQuery(); 
        Admin vo=null;
        while(rs.next()){      	
        	vo=new Admin();
        	vo=this.findById(rs.getInt(1));
           	list.add(vo);
        }  
        return list;
	}

	@Override
	public List<Admin> findByEmail(String email) throws Exception {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select id from admin where email=? ";  
        stat = con.prepareStatement(sql);  
        stat.setString(1,email);  
        ResultSet rs = stat.executeQuery(); 
        Admin vo=null;
        while(rs.next()){      	
        	vo=new Admin();
        	vo=this.findById(rs.getInt(1));
           	list.add(vo);
        }  
        return list;
	}

}
