package jee.com.core.service;

import java.util.List;
import jee.com.core.po.Feedback;

public interface FeedbackService {
	public int doCreateFeedback(Feedback feedback);
	public List<Feedback> findAllFeedback();
}
