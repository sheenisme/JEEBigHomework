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
import jee.com.core.po.PcParts;
import jee.com.core.po.RepairReceipt;
import jee.com.core.service.AdminService;
import jee.com.core.service.PcPartsService;
import jee.com.core.service.RepairReceiptService;


/**
 * 管理员控制器类
 */
@Controller
@RequestMapping( "/admin")
public class AdminController {
	// 依赖注入
	@Autowired
	private AdminService adminService;
	
	/**
	 * 管理员登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String login_name, String password,String autoLogin,Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		// 通过账号和密码查询管理员
		List<Admin> list = adminService.findAdminByName(login_name);
		for(Admin admin:list){
			if(admin != null){		
				// 将管理员对象添加到Session
				if(password.trim().equals(admin.getPassword()))
				{
					session.setAttribute("ADMIN_SESSION", admin);
					//System.out.println("这里是：AdminController类的login()方法！   恭喜您登录成功！");
					if("save".equals(request.getParameter("autoLogin"))) {
		                Cookie cookie = new Cookie("ADMIN_COOKIE",login_name+"#"+password+"#"+admin.getId());
		                cookie.setMaxAge(60 * 60 * 24); 
		                response.addCookie(cookie);
					}
					
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
	 * 创建新的管理员
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/register.action")
	public String CreateAdmin(Admin admin,Model model) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = adminService.CreateAdmin(admin);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，创建新管理员成功！！！您可以退出当前账号登陆新账号了！");
	         // 返回到提示信息页面
			return "message";
	    }else{
	    	model.addAttribute("msg", "很遗憾，创建新管理员失败，请返回后重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	
	
	/**
	 * 添加新的配件
	 */
	//依赖注入服务
	@Autowired
	private PcPartsService pcPartservice;
	
	@RequestMapping(value = "/createPcParts.action")
	public String CreatePcParts(PcParts pcparts,Model model) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = pcPartservice.CreatePcParts(pcparts);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，添加新的配件成功！！！");
	         // 返回到提示信息页面
			return "message";
	    }else{
	    	model.addAttribute("msg", "很遗憾，添加新配件失败，请返回后重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	
	/**
	 * 添加维修回执单
	 */
	//依赖注入服务
	@Autowired
	private RepairReceiptService repairReceiptservice;
	@RequestMapping(value = "/createRepairReceipt.action")
	public String CreateRepairReceipt(RepairReceipt repairReceipt,Model model) {
		 // 执行Service层中的创建方法，返回的是受影响的行数
		int rows = repairReceiptservice.CreateRepairReceipt(repairReceipt);
		if(rows > 0){
		    model.addAttribute("msg", "恭喜您，添加新的维修回执单成功！！！");
		    // 返回到提示信息页面
			return "message";
		}else{
		    model.addAttribute("msg", "很遗憾，添加新的维修回执单失败，请返回后重试！！");
		    // 返回到提示信息页面
			return "message";
		}
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
	 * 向登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
	    return "AdminLogin";
	}
}
