package jee.com.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import jee.com.core.po.User;

public interface UserDAO  extends DAO<User, Integer> {
	/**
	 * 根据登录名（loginName）查询指定客户对象
	 * @param name 要查询对象的登录名
	 * @return Custom对象列表
	 * @throws Exception
	 */
	public List<User> findByName(@Param("loginname") String loginnname)throws Exception;
	/**
	 * 根据邮箱查询指定管理员对象
	 * @param email 要查询的邮箱
	 * @return Custom对象列表
	 * @throws Exception
	 */
	public List<User> findByEmail(String email)throws Exception;
}
