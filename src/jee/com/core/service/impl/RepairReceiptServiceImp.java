package jee.com.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.RepairReceiptDAO;
import jee.com.core.po.RepairReceipt;
import jee.com.core.service.RepairReceiptService;

@Service("RepairReceiptService")
@Transactional
public class RepairReceiptServiceImp implements RepairReceiptService{
	//注入DAO
	@Autowired
	private RepairReceiptDAO dao;
		
	@Override
	public int CreateRepairReceipt(RepairReceipt po) {
		try {
			return dao.doCreate(po);
		} catch (Exception e) {
			System.out.println("创建新维修回执单出现异常！");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<RepairReceipt> showAllRepairReceipt() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
