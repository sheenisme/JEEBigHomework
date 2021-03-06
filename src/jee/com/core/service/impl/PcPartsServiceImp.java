package jee.com.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.PcPartsDAO;
import jee.com.core.po.PcParts;
import jee.com.core.service.PcPartsService;

@Service("PcPartsService")
@Transactional
public class PcPartsServiceImp implements PcPartsService{
	//注入PcPartsDAO
	@Autowired
	private PcPartsDAO dao;
	
	@Override
	public int CreatePcParts(PcParts po) {
		try {
			return dao.doCreate(po);
		} catch (Exception e) {
			System.out.println("创建新维修订单出现异常！");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<PcParts> showAllPcParts() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int reviserPcParts(PcParts po) {
		try {
			return dao.doUpdate(po);
		} catch (Exception e) {
			System.out.println("修改配件出现异常。");
			e.printStackTrace();
		}
		return -1;
	}

}
