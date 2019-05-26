package jee.com.core.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jee.com.core.po.Admin;
import jee.com.core.po.User;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("这里是：LoginInterceptor类的preHandle()方法！");
		// 获取请求的URL
		String url = request.getRequestURI();
		// URL:除了登录请求外，其他的URL都进行拦截控制
		//判断是不是用户登录
		if(url.indexOf("/user") >= 0) {
			if (url.indexOf("/login.action") >= 0 || url.indexOf("/register.action") >= 0) {
				return true;
			}
			// 获取Session
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("USER_SESSION");
			// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
			if (user != null) {
				return true;
			}
			// 不符合条件的给出提示信息，并转发到登录页面
			request.setAttribute("msg", "您还没有登录，请先登录！");
			request.getRequestDispatcher("/WEB-INF/jsp/UserLogin.jsp")
			                                        .forward(request, response);
		}
		
		//判断是不是管理员登陆
		if(url.indexOf("/admin") >= 0) {
			if (url.indexOf("/login.action") >= 0) {
				return true;
			}
			// 获取Session
			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("ADMIN_SESSION");
			// 判断Session中是否有管理员的数据，如果有，则返回true,继续向下执行
			if (admin != null) {
				return true;
			}
			// 不符合条件的给出提示信息，并转发到登录页面
			request.setAttribute("msg", "亲爱滴管理员，您还没有登录，请先登录！");
			request.getRequestDispatcher("/WEB-INF/jsp/AdminLogin.jsp")
			                                        .forward(request, response);
		}
		return false;		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
