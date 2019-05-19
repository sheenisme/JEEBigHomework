package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IAdminDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.AdminDAOImpl;
import com.jee.dao.vo.Admin;

public class AdminDAOProxy implements IAdminDAO {
    private DatabaseConnection dbc;  
    private IAdminDAO dao = null; 

    /**
     * 构造函数，初始化连接对象
     * @throws Exception
     */
    public AdminDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new AdminDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(Admin vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getId())==null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag; 
	}

	@Override
	public List<Admin> findAll() throws Exception {
		List<Admin>list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public Admin findById(Integer id) throws Exception {
		Admin vo = dao.findById(id);  
        dbc.close();  
        return vo;
	}

	@Override
	public int doRemove(Integer id) throws Exception {
		int result=dao.doRemove(id);
    	dbc.close();
    	return result;
	}

	@Override
	public int doUpdate(Admin vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

	@Override
	public List<Admin> findByName(String name) throws Exception {
		List<Admin>list = dao.findByName(name);  
        dbc.close();  
        return list; 
	}

	@Override
	public List<Admin> findByEmail(String email) throws Exception {
		List<Admin>list = dao.findByEmail(email);  
        dbc.close();  
        return list; 
	}

}
