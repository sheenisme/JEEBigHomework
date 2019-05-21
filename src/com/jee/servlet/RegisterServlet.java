package com.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.control.EncryptImp;
import com.jee.control.Conversion;
import com.jee.dao.IDAO;
import com.jee.dao.factory.DAOFactory;
import com.jee.dao.vo.Admin;
import com.jee.dao.vo.Custom;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action= request.getParameter("action");
		
		//如果是注册新的顾客账户
		if(action.equals("CustomRegister")) {
			Custom vo=new Custom();
			Conversion.convert(vo, request);
			IDAO<Custom,Integer> dao=DAOFactory.getCustom();
			vo.setPassword(new EncryptImp().md5(vo.getPassword()));
			try {
				if(dao.doCreate(vo)<= 0){
					System.out.println("RegiterServlet.java注册账户失败，失败原因：dao.doCreate(vo)<0！");
					request.getRequestDispatcher("/UserRegister.jsp").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
					out.println("<html>");
					out.println("<head><title>注册成功页面！</title>");
					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
					out.println("<body>");
					out.println("<div class='container'><p class='title'>myjee客户服务系统</p>");
					out.println("<div class='box'>	<div id='register_box'>");
					out.println("<h2>注册账户成功！您的账户名为："+vo.getLoginName()+"!</h2><br>");
					out.println("<pre><a href='UserLogin.jsp'>返回登录页面</a></pre></div></div></div>");//
					out.println("</body></html>");
					request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("捕获到异常！源于：RegiterServlet.java文件插入数据出现错误！");
				e.printStackTrace();
			}
			
		}
		
		//如果是注册新的管理员账户
		else if(action.equals("AdminRegister")){
			Admin vo=new Admin();
			Conversion.convert(vo, request);
			IDAO<Admin,Integer> dao=DAOFactory.getAdmin();
			vo.setPassword(new EncryptImp().md5(vo.getPassword()));
			try {
				if(dao.doCreate(vo)<= 0){
					System.out.println("RegiterServlet.java注册管理员账户失败，失败原因：dao.doCreate(vo)<0！");
					request.getRequestDispatcher("/AdminRegister.jsp").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
					out.println("<html>");
					out.println("<head><title>注册管理员成功页面！</title>");
					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
					out.println("<body>");
					out.println("<div class='container'><p class='title'>myjee客户服务系统</p>");
					out.println("<div class='box'>	<div id='register_box'>");
					out.println("<h2>注册管理员成功！您的账户名为："+vo.getLoginName()+"!</h2><br>");
					out.println("<pre><a href='AdminLogin.jsp' target='_top'>返回登录页面</a></pre></div></div></div>");//
					out.println("</body></html>");
					request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("捕获到异常！源于：RegiterServlet.java文件插入数据出现错误！");
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("注册失败！原因：注册账户类型错误！");
		}
	}

}
