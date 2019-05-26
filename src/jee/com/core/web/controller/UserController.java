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

import jee.com.core.po.EvaluationRecord;
import jee.com.core.po.RepairOrders;
import jee.com.core.po.User;
import jee.com.core.service.EvaluationRecordService;
import jee.com.core.service.RepairOrdersService;
import jee.com.core.service.UserService;
import jee.com.core.service.impl.MakeOrderNum;

/**
 * 用户控制器类
 */
@Controller
@RequestMapping( "/user")
public class UserController {
	// 依赖注入
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String username, String password,String autoLogin,Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		// 通过账号和密码查询用户
		List<User> userlist = userService.findUserByName(username);
		for(User user:userlist){
			if(user != null){		
				// 将用户对象添加到Session
				if(password.trim().equals(user.getPassword()))
				{
					session.setAttribute("USER_SESSION", user);
					//System.out.println("这里是：UserController类的login()方法！   恭喜您登录成功！");
					if("save".equals(request.getParameter("autoLogin"))) {
		                Cookie cookie = new Cookie("USER_COOKIE",username+"#"+password+"#"+user.getId());
		                cookie.setMaxAge(60 * 60 * 24); 
		                response.addCookie(cookie);
					}
					
//					//查看是否存入cookie
//					Cookie cookies[]=request.getCookies();
//					String name1="";
//					String password1="";
//					if(cookies!=null){
//						for(int i=0;i<cookies.length;i++){
//							if(cookies[i].getName().equals("USER_COOKIE")){
//								name1 = cookies[i].getValue().split("#")[0];
//								password1 = cookies[i].getValue().split("#")[1];
//								System.out.println(name1+password1);
//							}
//						}
//					}
					// 跳转到主页面
					return "UserMainUI";
				}
			}
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
         // 返回到登录页面
		return "UserLogin";
	}
	
	/**
	 * 创建新用户
	 */
	@RequestMapping(value = "/register.action")
	public String userCreate(User user,Model model, HttpSession session) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
		//System.out.println("创建新用户ing");
	    int rows = userService.createUser(user);
	    if(rows > 0){
	        return "redirect:login.action";
	    }else{
	    	model.addAttribute("msg", "很遗憾，创建新用户失败，请返回后重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	
	@Autowired
	private RepairOrdersService repairOrderService;
	/**
	 * 创建维修订单
	 */
	@RequestMapping(value = "/createRepairOrders.action")
	public String createRepairOrders(RepairOrders po,Model model) {
		
		po.setOrder_id(MakeOrderNum.getOrderNumber());
		int rows = repairOrderService.createRepairOrders(po);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，您的维修订单已提交！");
	         // 返回到提示信息页面
			return "message";

	    }else{
	    	model.addAttribute("msg", "很遗憾，您的订单提交失败，请核对您输入的数据后重试！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	    
	@Autowired
	private EvaluationRecordService evaluationRecordService;
	/**
	* 创建新的评价记录
	*/
	@RequestMapping(value = "/createEvaluationRecord.action")
	public String createEvaluationRecord(EvaluationRecord po,Model model) {			
		int rows = evaluationRecordService.createEvaluationRecord(po);
		if(rows > 0){
			model.addAttribute("msg", "恭喜您，您的评价记录已提交！");
		     // 返回到提示信息页面
			return "message";
		}else{
		    model.addAttribute("msg", "很遗憾，您的评价提交失败，请核对您输入的数据后重试！");
		   // 返回到提示信息页面
			return "message";
		}
	}
	
	/**
	 * 查询所有的维修订单
	 * @return 
	 */
	@RequestMapping(value = "/showAllRepairOrders.action")
	public String showAllRepairOrders(Model model) {
		List<RepairOrders> list=repairOrderService.showAll();
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowAllRepairOrders";
		}else {
			model.addAttribute("msg", "很遗憾，查看所有维修信息失败！");
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
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
	    return "UserLogin";
	}
}
