package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.ICustomDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.CustomDAOImpl;
import com.jee.dao.vo.Custom;

public class CustomDAOProxy implements ICustomDAO {
	private DatabaseConnection dbc;  
    private ICustomDAO dao = null; 
    
    /**
     * 构造函数，初始化连接对象
     * @throws Exception
     */
    public CustomDAOProxy()throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new CustomDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(Custom vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getId())==null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag;
	}

	@Override
	public List<Custom> findAll() throws Exception {
		List<Custom>list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public Custom findById(Integer id) throws Exception {
		Custom vo = dao.findById(id);  
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
	public int doUpdate(Custom vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

	@Override
	public List<Custom> findByName(String name) throws Exception {
		List<Custom> list = dao.findByName(name);  
        dbc.close();  
        return list;
	}

	@Override
	public List<Custom> findByEmail(String email) throws Exception {
		List<Custom> list = dao.findByEmail(email);  
        dbc.close();  
        return list;
	}

}
