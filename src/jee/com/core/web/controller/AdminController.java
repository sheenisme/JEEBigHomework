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
import jee.com.core.po.EvaluationRecord;
import jee.com.core.po.Feedback;
import jee.com.core.po.PcParts;
import jee.com.core.po.RepairOrders;
import jee.com.core.po.RepairReceipt;
import jee.com.core.po.User;
import jee.com.core.service.AdminService;
import jee.com.core.service.EvaluationRecordService;
import jee.com.core.service.FeedbackService;
import jee.com.core.service.PcPartsService;
import jee.com.core.service.RepairOrdersService;
import jee.com.core.service.RepairReceiptService;
import jee.com.core.service.UserService;


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
	* 创建新的维修回执前的预备工作
	*/
	//依赖注入服务
	@Autowired
	private RepairOrdersService repairOrderService;
	
	@RequestMapping(value = "/preCreateRepairReceipt.action")
	public String GetOrderIdForReceipt(Model model) {
		List<RepairOrders> list = repairOrderService.showAllRepairOrders();
		if(list!=null) {
			model.addAttribute("list", list);
			return "CreateRepairReceipt";
		}else {
			model.addAttribute("msg", "很遗憾，创建您的回执信息前的获取已回执的信息失败！");
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
	 * 修改管理员前预备获取信息
	 */
	@RequestMapping(value = "/preReviseAdmin.action", method = RequestMethod.GET)
	public String PreReviseAdmin(Integer id,Model model) {
	    // 执行Service层中的创建方法，返回的是
	    Admin vo =  adminService.findAdminById(id);
	    if(vo != null){
	    	model.addAttribute("vo", vo);
	    	return "ReviseAdmin";		
	    }else{
	    	model.addAttribute("msg", "很遗憾，更新管理员前的获取管理员信息失败，请返回后重试！！");
	         // 返回到提示信息页面
	    	return "message";
	    }
	}
	
	/**
	 * 修改管理员信息
	 */
	@RequestMapping(value = "/reviseAdmin.action")
	public String ReviseAdmin(Admin admin,Model model,HttpServletResponse response) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = adminService.ReviseAdmin(admin);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，修改您的管理员信息成功！退出后重新登陆生效！");
	         // 返回到提示信息页面
	    	return "message";
	    }else{
	    	model.addAttribute("msg", "很遗憾，修改您的管理员信息失败，请返回后重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	
	/**
	 * 修改配件信息
	 */
	@RequestMapping(value = "/revisePcParts.action")
	public String RevisePcParts(PcParts pcParts,Model model,HttpServletResponse response) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = pcPartsService.reviserPcParts(pcParts);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，修改配件信息成功！");
	         // 返回到提示信息页面
	    	return "message";
	    }else{
	    	model.addAttribute("msg", "很遗憾，修改配件信息失败，请重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
	}
	
	/**
	 * 查看所有用户的信息
	 */
	//依赖注入服务
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/showAllUser.action")
	public String ShowAllUser(Model model) {
		// 执行Service层中的创建方法，返回的是结果集
		List<User> list = userService.findAll();
		if(list !=null){
		  model.addAttribute("list",list);
		  // 返回到显示页面
		  return "ShowAllUser";
		}else{
			model.addAttribute("msg", "很遗憾，查看用户信息失败，请返回后重试！！");
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
		List<RepairOrders> list=repairOrderService.showAllRepairOrders();
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
	 * 查询所有的评价
	 * @return 
	 */
	@Autowired
	private EvaluationRecordService evaluationRecordService;
	@RequestMapping(value = "/showAllEvaluationRecord.action")
	public String showAllEvaluationRecord(Model model) {
		List<EvaluationRecord> list=evaluationRecordService.showAllEvaluationRecord();
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowAllEvaluationRecord";
		}else {
			model.addAttribute("msg", "很遗憾，查看所有评价信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
	
	/**
	 * 查看所有反馈信息
	 */
	@Autowired
	private FeedbackService feedbackService;
	@RequestMapping( "/showAllFeedback.action")
	public String ShowAllFeedback(Model model) {
		List<Feedback> list=feedbackService.showAllFeedback();
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowAllFeedback";
		}else {
			model.addAttribute("msg", "很遗憾，查看所有反馈信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
	
	/**
	 * 显示所有的回执信息
	 */
	@RequestMapping( "/showAllRepairReceipt.action")
	public String ShowAllRepairReceipt(Model model) {
		List<RepairReceipt> list=repairReceiptservice.showAllRepairReceipt();
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowAllRepairReceipt";
		}else {
			model.addAttribute("msg", "很遗憾，查看所有回执信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
	
	/**
	 * 查看所有的配件信息
	 */
	@Autowired
	private PcPartsService pcPartsService;
	@RequestMapping( "/showAllPcParts.action")
	public String ShowAllPcParts(Model model) {
		List<PcParts> list= pcPartsService.showAllPcParts();
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowAllPcParts";
		}else {
			model.addAttribute("msg", "很遗憾，查看配件信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
}
