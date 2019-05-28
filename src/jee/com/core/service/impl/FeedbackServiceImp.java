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
	private FeedbackDAO dao;

	@Override
	public int doCreateFeedback(Feedback feedback) {
		try {
			return dao.doCreate(feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Feedback> showAllFeedback() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
