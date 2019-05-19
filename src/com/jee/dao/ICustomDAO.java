package com.jee.dao;

import java.util.List;

import com.jee.dao.vo.Custom;

/**
 * 针对Custom对象，新增DAO操作的功能
 * @author 广辉
 *
 */
public interface ICustomDAO extends IDAO<Custom, Integer> {
	/**
	 * 根据登录名（loginName）查询指定客户对象
	 * @param name 要查询对象的登录名
	 * @return Custom对象列表
	 * @throws Exception
	 */
	public List<Custom> findByName(String name)throws Exception;
	/**
	 * 根据邮箱查询指定管理员对象
	 * @param email 要查询的邮箱
	 * @return Custom对象列表
	 * @throws Exception
	 */
	public List<Custom> findByEmail(String email)throws Exception;
}
