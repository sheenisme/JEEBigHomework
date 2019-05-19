package com.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.control.Conversion;
import com.jee.dao.IDAO;
import com.jee.dao.factory.DAOFactory;
import com.jee.dao.vo.Feedback;


/**
 * Servlet implementation class Feedback
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action= request.getParameter("action");
		
		//如果是新增反馈信息
		if("CreateFeedback".equals(action)) {
			Feedback vo=new Feedback();
			Conversion.convert(vo, request);
			IDAO<Feedback,Integer> dao=DAOFactory.getFeedback();
			try {
				dao.doCreate(vo);
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><title>反馈成功页面！</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>唯e客户服务系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>您的信息反馈成功！"+"!</h2><br><br><h2>感谢您对我们的服务做出反馈！</h2><br>");
				out.println("<pre><a href='UserLogin.jsp' target='_top'>唯e数码，您身边的电脑专家</a></pre></div></div></div>");//
				out.println("</body></html>");
			} catch (Exception e) {
				System.out.println("FeedbackServlet.java文件插入数据出现错误！");
				e.printStackTrace();
			}
		}else {
			System.out.println("FeedbackServlet.java文件出现错误！");
		}
	}

}
