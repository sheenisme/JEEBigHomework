package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IPcPartsDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.PcPartsDAOImp;
import com.jee.dao.vo.PcParts;

public class PcPartsDAOProxy implements IPcPartsDAO {
	private DatabaseConnection dbc;  
    private IPcPartsDAO dao = null; 
    
    public PcPartsDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new PcPartsDAOImp(dbc.getConnection());
    }
    
	@Override
	public int doCreate(PcParts vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getId()) == null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag;
	}

	@Override
	public List<PcParts> findAll() throws Exception {
		List<PcParts> list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public PcParts findById(Integer id) throws Exception {
		PcParts vo = dao.findById(id);  
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
	public int doUpdate(PcParts vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

	@Override
	public List<PcParts> findByName(String name) throws Exception {
		List<PcParts>list = dao.findByName(name);  
        dbc.close();  
        return list; 
	}

}
