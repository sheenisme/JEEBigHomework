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
import jee.com.core.po.PcParts;
import jee.com.core.po.RepairOrders;
import jee.com.core.po.RepairReceipt;
import jee.com.core.po.User;
import jee.com.core.service.EvaluationRecordService;
import jee.com.core.service.PcPartsService;
import jee.com.core.service.RepairOrdersService;
import jee.com.core.service.RepairReceiptService;
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
	
	/**
	 * 修改用户个人信息前获取预备信息
	 */
	@RequestMapping(value = "/preReviseUser.action", method = RequestMethod.GET)
	public String PreReviseUser(Integer id,Model model) {
	    // 执行Service层中的创建方法，返回的是
	    User vo =  userService.findUserById(id);
	    if(vo != null){
	    	model.addAttribute("vo", vo);
	    	return "ReviseUser";		
	    }else{
	    	model.addAttribute("msg", "很遗憾，更新管理员前的获取管理员信息失败，请返回后重试！！");
	         // 返回到提示信息页面
	    	return "message";
	    }
	}
	
	/**
	 * 修改管理员信息
	 */
	@RequestMapping(value = "/reviseUser.action")
	public String ReviseUser(User user,Model model,HttpServletResponse response) {
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = userService.reviseUser(user);
	    if(rows > 0){
	    	model.addAttribute("msg", "恭喜您，修改您的用户信息成功！退出后重新登陆生效！");
	         // 返回到提示信息页面
	    	return "message";
	    }else{
	    	model.addAttribute("msg", "很遗憾，修改您的用户信息失败，请返回后重试！！");
	         // 返回到提示信息页面
			return "message";
	    }
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
	
	
	/**
	 * 创建维修订单
	 */
	@Autowired
	private RepairOrdersService repairOrderService;
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
	
	/**
	* 创建新的评价记录的预备工作
	*/
	//依赖注入服务
	@Autowired
	private RepairReceiptService repairReceiptservice;
	@RequestMapping(value = "/perCreateEvaluationRecord.action",method = RequestMethod.GET)
	public String GetOrderIdForEvaluation(Integer id,Model model) {
		List<RepairReceipt> list = repairReceiptservice.showMyRepairReceipt(id);
		if(list!=null) {
			model.addAttribute("list", list);
			return "CreateEvaluationRecord";
		}else {
			model.addAttribute("msg", "很遗憾，创建您的评价信息前的获取已回执的信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
	
	
	/**
	 * 创建新的评价
	 * @param po
	 * @param model
	 * @return
	 */
	@Autowired
	private EvaluationRecordService evaluationRecordService;
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
	 * 查询某人的维修订单
	 * @return 
	 */
	@RequestMapping(value = "/showRepairOrders.action", method = RequestMethod.GET)
	public String showRepairOrders(Integer id,Model model) {
		List<RepairOrders> list=repairOrderService.showMyRepairOrders(id);
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowRepairOrders";
		}else {
			model.addAttribute("msg", "很遗憾，查看您的维修信息失败！");
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
	 * 查询某用户的评价
	 * @return 
	 */
	@RequestMapping(value = "/showEvaluationRecord.action", method = RequestMethod.GET)
	public String showEvaluationRecord(Integer id,Model model) {
		List<EvaluationRecord> list=evaluationRecordService.showMyEvaluationRecord(id);
		if(list!=null) {
			model.addAttribute("list", list);
			return "ShowEvaluationRecord";
		}else {
			model.addAttribute("msg", "很遗憾，查看您的评价信息失败！");
		     // 返回到提示信息页面
			return "message";
		}
	}
	
	/**
	 * 查询所有的评价
	 * @return 
	 */
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
