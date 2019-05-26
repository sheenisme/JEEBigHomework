package jee.com.core.service;

import java.util.List;
import jee.com.core.po.RepairOrders;

public interface RepairOrdersService {
	List<RepairOrders> showAll();
	public int createRepairOrders(RepairOrders po);
}
