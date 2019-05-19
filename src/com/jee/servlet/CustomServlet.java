package com.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.control.Conversion;
import com.jee.control.EncryptImp;
import com.jee.control.MakeOrderNum;
import com.jee.dao.IDAO;
import com.jee.dao.factory.DAOFactory;
import com.jee.dao.vo.Custom;
import com.jee.dao.vo.EvaluationRecord;
import com.jee.dao.vo.RepairOrders;

/**
 * Servlet implementation class CustomService
 */
@WebServlet("/CustomServlet")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action= request.getParameter("action");
		
		//如果是要报修
		if("CreateRepairOrders".equals(action)) {
			RepairOrders vo=new RepairOrders();
			//System.out.println("repairTime的值是"+req.getParameter("repairTime"));
			vo.setOrderId(MakeOrderNum.getOrderNumber());
			Conversion.convert(vo, request);
			IDAO<RepairOrders,String> dao=DAOFactory.getRepairOrders();
			try {
				dao.doCreate(vo);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title>报修成功页面！</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>报修成功，您的维修单号为："+vo.getOrderId()+"!</h2><br><br><h2>请注意接听电话!</h2><br>");
				out.println("<pre><a href='#'>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
				out.println("</body></html>");
				//System.out.println("报修成功，您的维修单号为："+vo.getOrderId());
			} catch (Exception e) {
				System.out.println("CustomService.java文件插入数据出现错误！");
				e.printStackTrace();
			}
		}
		
		//如果是要评价
		else if("CreateEvaluationRecord".equals(action)) {
			EvaluationRecord vo=new EvaluationRecord();
			Conversion.convert(vo, request);
			IDAO<EvaluationRecord,Integer> dao=DAOFactory.getEvaluationRecord();
			try {
				dao.doCreate(vo);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title>评价成功页面！</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>评价成功！"+"!</h2><br><br><h2>感谢您对我们的服务做出的评价！</h2><br>");
				out.println("<pre><a href='#'>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
				out.println("</body></html>");
			} catch (Exception e) {
				System.out.println("CustomServlet.java文件插入数据出现错误！");
				e.printStackTrace();
			}
		}
		
		//如果是要修改自己的信息
		else if("CustomUpdate".equals(action)) {
			Custom vo=new Custom();
			Conversion.convert(vo, request);
			IDAO<Custom,Integer> dao=DAOFactory.getCustom();
			vo.setPassword(new EncryptImp().md5(vo.getPassword()));
			try {
				if(dao.doUpdate(vo)<= 0){
					System.out.println("CustomServlet.java修改账户信息失败，失败原因：dao.doUpdate(vo)<0！");
					request.getRequestDispatcher("/ReviseUser.jsp").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
//					out.println("<html>");
//					out.println("<head><title>修改成功页面！</title>");
//					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
//					out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
//					out.println("<body>");
//					out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
//					out.println("<div class='box'>	<div id='register_box'>");
//					out.println("<h2>修改账户信息成功！<br> 修改后您的账户名为："+vo.getLoginName()+"!</h2><br>");
//					out.println("<a href='UserLogin.jsp' target='_top'>点击此处返回重新登录</a><br><br>");
//					out.println("<pre><a>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
//					out.println("</body></html>");
					//request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
				    out.println("<html>");  
				    out.println("<script>");  
				    out.println("window.open ('/com.jeenetclient/UserLogin.jsp','_top')");  
				    out.println("</script>");  
				    out.println("</html>");  
				}
			} catch (Exception e) {
				System.out.println("捕获到异常！源于：CustomServlet.java文件修改客户信息出现错误！- dao.doUpdate(vo)产生异常信息！");
				e.printStackTrace();
			}
		}

		
		
		
		else {
			System.out.println("传参出错！CustomServlet.java文件");
			request.getRequestDispatcher("/UserMainUI.jsp").forward(request, response);
		}
	}

}
