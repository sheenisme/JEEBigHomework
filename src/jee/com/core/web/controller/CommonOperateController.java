package jee.com.core.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jee.com.core.po.Feedback;
import jee.com.core.service.FeedbackService;


/*
 * 用户操作控制器类
 */
@Controller
@RequestMapping( "/userop")
public class CommonOperateController {
		// 依赖注入,注入operate服务的实现类
		@Autowired
		private FeedbackService service;
		
		/**
		 * 创建新的反馈
		 * @param feedback 反馈
		 * @param model 视图
		 * @return
		 */
		@RequestMapping("/createfeedback.action")
		public String CreateFeedback(Feedback feedback,Model model) {
			//System.out.println("创建新feedback ing");
			int rows = service.doCreateFeedback(feedback);
		    if(rows > 0){
		        return "UserMainUI";
		    }else{
		    	model.addAttribute("msg", "创建失败！");
		        return "redirect:feedbck.jsp";
		    }	
		}
		
}
