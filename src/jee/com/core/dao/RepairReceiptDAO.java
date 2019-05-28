package jee.com.core.dao;

import java.util.List;
import jee.com.core.po.RepairReceipt;

/**
 * 针对RepairReceipt对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface RepairReceiptDAO extends DAO<RepairReceipt, Integer> {
	/**
	 * 通过客户ID返回其已经回执的
	 * @throws Exception
	 */
	public List<RepairReceipt> findByUserId(Integer id) throws Exception;
}
