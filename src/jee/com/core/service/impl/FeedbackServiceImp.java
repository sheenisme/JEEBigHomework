package jee.com.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.FeedbackDAO;
import jee.com.core.po.Feedback;
import jee.com.core.service.FeedbackService;

/*
 * 操作的service接口实现类
 */
@Service("FeedbackService")
@Transactional
public class FeedbackServiceImp implements FeedbackService {
	//注入DAO
	@Autowired
	private FeedbackDAO feedbackdao;
	
	@Override
	public List<Feedback> findAllFeedback() {
		
		return null;
	}

	@Override
	public int doCreateFeedback(Feedback feedback) {
		try {
			return feedbackdao.doCreate(feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
