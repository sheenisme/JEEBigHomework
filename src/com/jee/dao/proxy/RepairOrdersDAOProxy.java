package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IRepairOrdersDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.RepairOrdersDAOImpl;
import com.jee.dao.vo.RepairOrders;

public class RepairOrdersDAOProxy implements IRepairOrdersDAO{
	private DatabaseConnection dbc;  
    private IRepairOrdersDAO dao = null; 
    
    public RepairOrdersDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new RepairOrdersDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(RepairOrders vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getOrderId()) == null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag; 
	}

	@Override
	public List<RepairOrders> findAll() throws Exception {
		List<RepairOrders>list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public RepairOrders findById(String id) throws Exception {
		RepairOrders vo = dao.findById(id);  
        dbc.close();  
        return vo;
	}

	@Override
	public int doRemove(String id) throws Exception {
		int result=dao.doRemove(id);
    	dbc.close();
    	return result;
	}

	@Override
	public int doUpdate(RepairOrders vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

	@Override
	public List<String> findOrderId(Integer id) throws Exception {
		List<String>list = dao.findOrderId(id);  
		dbc.close();
        return list; 
	}

}
