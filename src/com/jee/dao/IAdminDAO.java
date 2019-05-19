package com.jee.dao;

import java.util.List;

import com.jee.dao.vo.Admin;


/**
 * 针对Admin对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface IAdminDAO extends IDAO<Admin, Integer> {
	
	/**
	 * 根据登录名（loginName）查询指定管理员对象
	 * @param name 要查询的对象的登录名
	 * @return Admin对象列表
	 * @throws Exception
	 */
	public List<Admin> findByName(String name)throws Exception;
	
	/**
	 * 根据邮箱查询指定管理员对象
	 * @param email 要查询的邮箱
	 * @return Admin对象列表
	 * @throws Exception
	 */
	public List<Admin> findByEmail(String email)throws Exception;
}
