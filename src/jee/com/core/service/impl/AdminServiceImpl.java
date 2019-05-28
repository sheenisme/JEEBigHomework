package jee.com.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.AdminDAO;
import jee.com.core.po.Admin;
import jee.com.core.service.AdminService;

/*
 * 管理员service接口实现类
 */
@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	//注入AdminDAO
	@Autowired
	private AdminDAO dao;
	@Override
	public List<Admin> findAdminByName(String name) {
		List<Admin> adminlist=null;
		try {
			adminlist=dao.findByName(name);
		} catch (Exception e) {
			System.out.println("AdminServiceImpl类的findAdminByName()出现Exception!");
			e.printStackTrace();
		}
		return adminlist;
	}
	
	/**
	 * 创建新的管理员
	 */
	@Override
	public int CreateAdmin(Admin po) {
		try {
			return dao.doCreate(po);
		} catch (Exception e) {
			System.out.println("创建新管理员出现异常。");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int ReviseAdmin(Admin po) {
		try {
			return dao.doUpdate(po);
		} catch (Exception e) {
			System.out.println("修改管理员出现异常。");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Admin findAdminById(Integer id) {
		Admin vo=null;
		try {
			vo=dao.findById(id);
		} catch (Exception e) {
			System.out.println("AdminServiceImpl类的findAdminById()出现Exception!");
			e.printStackTrace();
		}
		return vo;
	}

}
