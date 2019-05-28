package jee.com.core.service;

import java.util.List;
import jee.com.core.po.Admin;

public interface AdminService {
	public List<Admin> findAdminByName(String name);
	public Admin findAdminById(Integer id);
	public int CreateAdmin(Admin po);
	public int ReviseAdmin(Admin admin);
}
