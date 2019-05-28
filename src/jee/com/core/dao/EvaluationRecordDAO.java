package jee.com.core.dao;

import java.util.List;

import jee.com.core.po.EvaluationRecord;

/**
 * 针对EvaluationRecord对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface EvaluationRecordDAO extends DAO<EvaluationRecord, Integer> {
	/**
	 * 通过userid查找他的评价信息
	 * @param id
	 * @return
	 */
	public List<EvaluationRecord> findByUserId(Integer id) throws Exception;
}
