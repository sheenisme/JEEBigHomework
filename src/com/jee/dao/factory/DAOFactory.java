package com.jee.dao.factory;

import com.jee.dao.IAdminDAO;
import com.jee.dao.ICustomDAO;
import com.jee.dao.IEvaluationRecordDAO;
import com.jee.dao.IFeedbackDAO;
import com.jee.dao.IPcPartsDAO;
import com.jee.dao.IRepairOrdersDAO;
import com.jee.dao.IRepairReceiptDAO;
import com.jee.dao.proxy.AdminDAOProxy;
import com.jee.dao.proxy.CustomDAOProxy;
import com.jee.dao.proxy.EvaluationRecordDAOProxy;
import com.jee.dao.proxy.FeedbackDAOProxy;
import com.jee.dao.proxy.PcPartsDAOProxy;
import com.jee.dao.proxy.RepairOrdersDAOProxy;
import com.jee.dao.proxy.RepairReceiptDAOProxy;

public class DAOFactory{  
    public static IAdminDAO getAdmin() {
    	 IAdminDAO dao = null;  
         try{  
             dao = new AdminDAOProxy();      
         }  
         catch(Exception e){  
             e.printStackTrace();  
         }  
         return dao; 
    }
    
    public static ICustomDAO getCustom() {
    	ICustomDAO dao = null;  
        try{  
            dao = new CustomDAOProxy();      
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao; 
    }
    
    public static IRepairOrdersDAO getRepairOrders() {
    	IRepairOrdersDAO dao=null;
    	try {
    		dao=new RepairOrdersDAOProxy();
    	}catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao; 
    }
    
    public static IEvaluationRecordDAO getEvaluationRecord() {
    	IEvaluationRecordDAO dao=null;
    	try {
    		dao=new EvaluationRecordDAOProxy();
    	}catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao; 
    }
    
    public static IRepairReceiptDAO getRepairReceipt() {
    	IRepairReceiptDAO dao=null;
    	try {
    		dao=new RepairReceiptDAOProxy();
    	}catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao;
    }
    
    public static IFeedbackDAO getFeedback() {
    	IFeedbackDAO dao=null;
    	try {
    		dao=new FeedbackDAOProxy();
    	}catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao;
    }
    
    public static IPcPartsDAO getPcParts() {
    	IPcPartsDAO dao=null;
    	try {
    		dao=new PcPartsDAOProxy();
    	}catch(Exception e){  
            e.printStackTrace();  
        }  
        return dao;
    }
}  