package jee.com.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.EvaluationRecordDAO;
import jee.com.core.po.EvaluationRecord;
import jee.com.core.service.EvaluationRecordService;

@Service("EvalauationRecordService")
@Transactional
public class EvaluationRecordServiceImp implements EvaluationRecordService{
	//注入EvaluationRecordDAO
	@Autowired
	private EvaluationRecordDAO dao;
	
	@Override
	public int createEvaluationRecord(EvaluationRecord po) {
		try {
			return dao.doCreate(po);
		} catch (Exception e) {
			System.out.println("创建新维修订单出现异常！");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<EvaluationRecord> showAllEvaluationRecord() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EvaluationRecord> showMyEvaluationRecord(Integer id) {
		try {
			return dao.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
