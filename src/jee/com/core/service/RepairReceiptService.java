package jee.com.core.service;

import java.util.List;
import jee.com.core.po.RepairReceipt;

public interface RepairReceiptService {
	public List<RepairReceipt> showAllRepairReceipt();
	public int CreateRepairReceipt(RepairReceipt po);
	public List<RepairReceipt> showMyRepairReceipt(Integer id);
}
