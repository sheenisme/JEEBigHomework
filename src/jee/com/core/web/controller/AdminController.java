package jee.com.core.web.controller;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jee.com.core.po.Admin;
import jee.com.core.service.AdminService;


/**
 * Admin控制器类
 */
@Controller
@RequestMapping( "/admin")
public class AdminController {
	// 依赖注入
	@Autowired
	private AdminService adminService;
	
	/**
	 * Admin登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String loginname, String password,String autoLogin,Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		// 通过账号和密码查询管理员
		List<Admin> list = adminService.findAdminByName(loginname);
		for(Admin admin:list){
			if(admin != null){		
				// 将Admin对象添加到Session
				if(password.trim().equals(admin.getPassword()))
				{
					session.setAttribute("ADMIN_SESSION", admin);
					//System.out.println("这里是：AdminController类的login()方法！   恭喜您登录成功！");
					if("save".equals(request.getParameter("autoLogin"))) {
		                Cookie cookie = new Cookie("ADMIN_COOKIE",loginname+"#"+password+"#"+admin.getId());
		                cookie.setMaxAge(60 * 60 * 24); 
		                response.addCookie(cookie);
					}
					
//					//查看是否存入cookie
//					Cookie cookies[]=request.getCookies();
//					String name1="";
//					String password1="";
//					if(cookies!=null){
//						for(int i=0;i<cookies.length;i++){
//							if(cookies[i].getName().equals("Admin_COOKIE")){
//								name1 = cookies[i].getValue().split("#")[0];
//								password1 = cookies[i].getValue().split("#")[1];
//								System.out.println(name1+password1);
//							}
//						}
//					}
					// 跳转到主页面
					return "AdminMainUI";
				}
			}
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
         // 返回到登录页面
		return "AdminLogin";
	}
	
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
	    // 清除Session
	    session.invalidate();
	    // 重定向到登录页面的跳转方法
	    return "redirect:login.action";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
	    return "AdminLogin";
	}
}
