package jee.com.core.service.impl;

import org.springframework.stereotype.Service;
import jee.com.core.po.User;
import jee.com.core.service.UserService;

/*
 * 用户service接口实现类
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

	@Override
	public User findUserById(Integer id) {
		return null;
	}

}
