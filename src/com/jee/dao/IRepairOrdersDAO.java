package com.jee.dao;

import java.util.List;

import com.jee.dao.vo.RepairOrders;

/**
 * 针对RepairOrders对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface IRepairOrdersDAO extends IDAO<RepairOrders, String> {
	
	/**
	 * 通过客户编号，返回查找其orderid
	 * @param id 客户编号
	 * @return 所有他的orderid
	 * @throws Exception
	 */
	public List<String> findOrderId(Integer id)throws Exception;
}
