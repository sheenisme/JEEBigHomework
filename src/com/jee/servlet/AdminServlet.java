package com.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.control.Conversion;
import com.jee.control.EncryptImp;
import com.jee.dao.IDAO;
import com.jee.dao.factory.DAOFactory;
import com.jee.dao.vo.Admin;
import com.jee.dao.vo.PcParts;
import com.jee.dao.vo.RepairReceipt;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action= request.getParameter("action");
		
		//如果是要修改管理员的信息
		if("AdminUpdate".equals(action)) {
			Admin vo=new Admin();
			Conversion.convert(vo, request);
			IDAO<Admin,Integer> dao=DAOFactory.getAdmin();
			vo.setPassword(new EncryptImp().md5(vo.getPassword()));
			try {
				if(dao.doUpdate(vo) < 0){
					System.out.println("AdminServlet.java修改账户信息失败，失败原因：dao.doUpdate(vo)<0！");
					request.getRequestDispatcher("/ReviseAdmin.jsp").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
				    out.println("<html>");  
				    out.println("<script>");  
				    out.println("window.open ('/com.jeenetclient/AdminLogin.jsp','_top')");  
				    out.println("</script>");  
				    out.println("</html>");  
				}
			} catch (Exception e) {
				System.out.println("捕获到异常！源于：AdminServlet.java文件修改管理员信息出现错误！- dao.doUpdate(vo)产生异常信息！");
				e.printStackTrace();
			}			
		}else if("CreateRepairReceipt".equals(action)){//如果是要填写回执单
			RepairReceipt vo=new RepairReceipt();
			Conversion.convert(vo, request);
			IDAO<RepairReceipt,Integer> dao=DAOFactory.getRepairReceipt();
			try {
				dao.doCreate(vo);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title>回执成功页面！</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>回执成功！"+"!</h2><br><br><h2>感谢您对我们的客户做出的服务！</h2><br>");
				out.println("<pre><a href='#'>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
				out.println("</body></html>");
			} catch (Exception e) {
				System.out.println("CustomServlet.java文件插入数据出现错误！");
				e.printStackTrace();
			}
		}else if("CreatePcParts".equals(action)){//如果是要录入配件
			PcParts vo=new PcParts();
			Conversion.convert(vo, request);
			IDAO<PcParts,Integer> dao=DAOFactory.getPcParts();
			try {
				dao.doCreate(vo);
				//录入完成前，将刚写入的配件信息写到Cookie中
                Cookie cookie = new Cookie("PcPartsCookie",vo.getName()+"#");
                cookie.setMaxAge(60 * 60 * 24); 
                response.addCookie(cookie);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title>录入配件成功页面！</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>录入配件成功！"+"!</h2><br><br><h2>感谢您对我们的客户做出的服务！</h2><br>");
				out.println("<pre><a href='#'>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
				out.println("</body></html>");
				
			} catch (Exception e) {
				System.out.println("AdminServlet.java文件插入配件数据出现错误！");
				e.printStackTrace();
			}
		}else if("PcPartsUpdate".equals(action)) {
			PcParts vo=new PcParts();
			Conversion.convert(vo, request);
			IDAO<PcParts,Integer> dao=DAOFactory.getPcParts();
			try {
				if(dao.doUpdate(vo) < 0){
					System.out.println("AdminServlet.java修改配件信息失败，失败原因：dao.doUpdate(vo)<0！");
					request.getRequestDispatcher("/#").forward(request, response);
				}else {
					PrintWriter out=response.getWriter();
//				    out.println("<html>");  
//				    out.println("<script>");  
//				    out.println("window.open ('/com.jeenetclient/AdminLogin.jsp','_top')");  
//				    out.println("</script>");  
//				    out.println("</html>");  
					out.println("<html>");
					out.println("<head><title>修改成功页面！</title>");
					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
					out.println("<body>");
					out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
					out.println("<div class='box'>	<div id='register_box'>");
					out.println("<h2>修改配件信息成功！<br> "+"!</h2><br><br><h2>感谢您对我们的系统做出的贡献！</h2><br>");
					out.println("<pre><a>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
					out.println("</body></html>");
				}
			} catch (Exception e) {
				System.out.println("捕获到异常！源于：AdminServlet.java文件修改配件信息出现错误！- dao.doUpdate(vo)产生异常信息！");
				e.printStackTrace();
			}			
		}
	}

}
