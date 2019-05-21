package jee.com.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jee.com.core.dao.AdminDAO;
import jee.com.core.po.Admin;
import jee.com.core.service.AdminService;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	//注入AdminDAO
	@Autowired
	private AdminDAO admindao;
	@Override
	public List<Admin> findAdminByName(String name) {
		List<Admin> adminlist=null;
		try {
			adminlist=admindao.findByName(name);
		} catch (Exception e) {
			System.out.println("AdminServiceImpl类的findAdminByName()出现Exception!");
			e.printStackTrace();
		}
		return adminlist;
	}

}
