package jee.com.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.RepairOrdersDAO;
import jee.com.core.po.RepairOrders;
import jee.com.core.service.RepairOrdersService;

@Service("RepairOrderService")
@Transactional
public class RepairOrdersServiceImp implements RepairOrdersService{
	@Autowired
	private RepairOrdersDAO  dao;
	public int createRepairOrders(RepairOrders po) {
		try {
			return dao.doCreate(po);
		} catch (Exception e) {
			System.out.println("创建新维修订单出现异常！");
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public List<RepairOrders> showAll() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
