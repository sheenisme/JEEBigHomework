package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IEvaluationRecordDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.EvaluationRecordDAOImpl;
import com.jee.dao.vo.EvaluationRecord;

public class EvaluationRecordDAOProxy implements IEvaluationRecordDAO {
	private DatabaseConnection dbc;  
    private IEvaluationRecordDAO dao = null; 
    
    public EvaluationRecordDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new EvaluationRecordDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(EvaluationRecord vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getEvaluateId()) == null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag; 
	}

	@Override
	public List<EvaluationRecord> findAll() throws Exception {
		List<EvaluationRecord> list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public EvaluationRecord findById(Integer id) throws Exception {
		EvaluationRecord vo = dao.findById(id);  
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
	public int doUpdate(EvaluationRecord vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

}
