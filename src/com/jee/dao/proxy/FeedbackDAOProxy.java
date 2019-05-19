package com.jee.dao.proxy;

import java.util.List;

import com.jee.dao.IFeedbackDAO;
import com.jee.dao.dbc.DatabaseConnection;
import com.jee.dao.impl.FeedbackDAOImpl;
import com.jee.dao.vo.Feedback;

public class FeedbackDAOProxy implements IFeedbackDAO {
	private DatabaseConnection dbc;  
    private IFeedbackDAO dao = null; 
    
    public FeedbackDAOProxy() throws Exception{
    	dbc = new DatabaseConnection();  
        dao = new FeedbackDAOImpl(dbc.getConnection());
    }
    
	@Override
	public int doCreate(Feedback vo) throws Exception {
		int flag = -1;  
        if(dao.findById(vo.getId()) == null){  
            flag = dao.doCreate(vo);  
        }  
        dbc.close();  
        return flag; 
	}

	@Override
	public List<Feedback> findAll() throws Exception {
		List<Feedback> list = dao.findAll();  
        dbc.close();  
        return list; 
	}

	@Override
	public Feedback findById(Integer id) throws Exception {
		Feedback vo = dao.findById(id);  
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
	public int doUpdate(Feedback vo) throws Exception {
		int result=dao.doUpdate(vo);
    	dbc.close();
    	return result;
	}

}
