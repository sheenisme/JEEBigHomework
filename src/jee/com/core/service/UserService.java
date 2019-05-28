package jee.com.core.service;

import java.util.List;
import jee.com.core.po.User;

public interface UserService{
	public List<User> findAll();
	public List<User> findUserByName(String name);
	public User findUserById(Integer id);
	public int createUser(User user);
	public int reviseUser(User user);
}
