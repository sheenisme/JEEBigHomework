package jee.com.core.service;

import java.util.List;
import jee.com.core.po.EvaluationRecord;

public interface EvaluationRecordService {
	public int createEvaluationRecord(EvaluationRecord po);
	public List<EvaluationRecord> showAllEvaluationRecord();
	public List<EvaluationRecord> showMyEvaluationRecord(Integer id);
}
