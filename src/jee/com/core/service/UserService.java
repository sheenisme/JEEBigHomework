package jee.com.core.service;

import java.util.List;
import jee.com.core.po.User;

public interface UserService{
	public List<User> findUserByName(String name);
	public int createUser(User user);
}
