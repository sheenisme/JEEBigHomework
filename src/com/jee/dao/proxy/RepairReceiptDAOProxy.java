package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IRepairReceiptDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.RepairReceiptDAOImpl;
import com.jee.dao.vo.RepairReceipt;

public class RepairReceiptDAOProxy implements IRepairReceiptDAO {
	private DatabaseConnection dbc;  
    private IRepairReceiptDAO dao = null; 
    
    public RepairReceiptDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new RepairReceiptDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(RepairReceipt vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getReceiptId()) == null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag;
	}

	@Override
	public List<RepairReceipt> findAll() throws Exception {
		List<RepairReceipt> list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public RepairReceipt findById(Integer id) throws Exception {
		RepairReceipt vo = dao.findById(id);  
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
	public int doUpdate(RepairReceipt vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

	@Override
	public List<String> findOrderId(Integer id) throws Exception {
		List<String> list=dao.findOrderId(id);
		dbc.close();
		return list;
	}

}
