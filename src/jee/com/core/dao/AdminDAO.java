package jee.com.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jee.com.core.po.Admin;

/**
 * 针对Admin对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface AdminDAO extends DAO<Admin, Integer> {
	
	/**
	 * 根据登录名（loginName）查询指定管理员对象
	 * @param name 要查询的对象的登录名
	 * @return Admin对象列表
	 * @throws Exception
	 */
	public List<Admin> findByName(@Param("loginname") String name)throws Exception;
	
	/**
	 * 根据邮箱查询指定管理员对象
	 * @param email 要查询的邮箱
	 * @return Admin对象列表
	 * @throws Exception
	 */
	public List<Admin> findByEmail(String email)throws Exception;
}
