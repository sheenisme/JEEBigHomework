package jee.com.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jee.com.core.dao.UserDAO;
import jee.com.core.po.User;
import jee.com.core.service.UserService;

/*
 * 用户service接口实现类
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	//注入UserDAO
	@Autowired
	private UserDAO userdao;
	
	@Override
	public List<User> findUserByName(String name) {
		java.util.List<User> user=null;
		try {
			user=this.userdao.findByName(name);
		} catch (Exception e) {
			System.out.println("UserServiceImpl类的findUserByName()出现Exception!");
			e.printStackTrace();
		}
		return  user;
	}

	@Override
	public int createUser(User user) {
		try {
			return userdao.doCreate(user);
		} catch (Exception e) {
			System.out.println("创建新用户出现异常。");
			e.printStackTrace();
		}
		return -1;
	}
}
