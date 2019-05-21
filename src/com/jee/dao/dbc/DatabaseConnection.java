package com.jee.dao.dbc;  
import java.sql.*;  

/**
 * 创建数据库连接对象
 * @author 广辉
 *
 */
public class DatabaseConnection{
	private Connection con = null;  
	//Mysql的JDBC连接属性：
	  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
      private static final String URL = "jdbc:mysql://localhost:3306/jeedb?&useSSL=false&serverTimezone=UTC";  
      private static final String USER = "root";  
      private static final String PASS = "";
      
//	 
//	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
//    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=weiyi"; 
//    private static final String USER = "sa";  
//    private static final String PASS = "123456";  
    public DatabaseConnection()throws Exception{
    	//加载驱动
        Class.forName(DRIVER);
        //获取数据库的连接
        con = DriverManager.getConnection(URL,USER,PASS);  
    }  
    
    /**
     * 返回数据库的连接对象
     * @return Connection
     * @throws Exception
     */
    public Connection getConnection()throws Exception{  
       return con;  
    }  
    
    /**
     * 关闭数据库的连接
     * @throws Exception
     */
    public void close()throws Exception{  
        if(con!=null){  
            con.close();  
	   }  
   }
}