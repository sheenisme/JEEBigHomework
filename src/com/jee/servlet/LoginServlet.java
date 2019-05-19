package com.jee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.control.EncryptImp;
import com.jee.dao.IAdminDAO;
import com.jee.dao.ICustomDAO;
import com.jee.dao.factory.DAOFactory;
import com.jee.dao.vo.Admin;
import com.jee.dao.vo.Custom;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action= request.getParameter("action");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String al=request.getParameter("autoLogin");
		
		//如果是客户要登录
		if("CustomLogin".equals(action)) {
			ICustomDAO dao = null;
			List<Custom> list=new ArrayList<Custom>();
			dao = DAOFactory.getCustom();
			try {
				list=dao.findByName(name);
			} catch (Exception e) {
				System.out.println("通过登录名查找失败！-LoginServlet.java");
				e.printStackTrace();
			}
			
			//如果登录名为空
			if(list==null) {
				System.out.println("登录失败！原因：登录名为空请输入有效的登录名！");
				request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
			}else {//如果登录名非空
				for(Custom vo:list){
					String md5=vo.getPassword();
					if(!new EncryptImp().authenticatePassword(md5,password) || md5==""){
						System.out.println("登录失败！原因：密码错误！");
						request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
					}else{
						System.out.println("登陆成功！");
						if("save".equals(al)) {
							request.getSession().setAttribute("CustomSession", vo.getLoginName());
			                Cookie cookie = new Cookie("CustomCookie",name+"#"+password+"#"+vo.getId());
			                cookie.setMaxAge(60 * 60 * 24); 
			                response.addCookie(cookie);
						}
						request.getRequestDispatcher("/UserMainUI.jsp").forward(request, response);
					}
				}
			}
			
		}
		
		//如果是管理员要登录
		else if("AdminLogin".equals(action)) {
			IAdminDAO dao = null;
			List<Admin> list=new ArrayList<Admin>();
			dao = DAOFactory.getAdmin();
			try {
				list=dao.findByName(name);
			} catch (Exception e) {
				System.out.println("通过登录名查找失败！-LoginServlet.java");
				e.printStackTrace();
			}
			//如果登录名为空
			if(list==null) {
				System.out.println("登录失败！原因：登录名为空请输入有效的登录名！");
				request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
			}else {//如果登录名非空
				for(Admin vo:list){
					String md5=vo.getPassword();
					if(!new EncryptImp().authenticatePassword(md5,password) || md5==""){
						System.out.println("登录失败！原因：密码错误！");
						request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
					}else{
						//System.out.println("登陆成功！");
						if("save".equals(al)) {
							//System.out.println("要存入cookie中的名字是："+name);
			        		//System.out.println("要存入cookie中的密码是"+password);
							request.getSession().setAttribute("AdminSession", vo.getLoginName());
			                Cookie cookie = new Cookie("AdminCookie",name+"#"+password+"#"+vo.getId());
			                cookie.setMaxAge(60 * 60 * 24); 
			                response.addCookie(cookie);
						}
						request.getRequestDispatcher("/AdminMainUI.jsp").forward(request, response);
					}
				}
			}
		}
		
		//如果是其他的非法登录
		else {
			System.out.println("登录失败！原因：权限错误！");
		}
	}
}
