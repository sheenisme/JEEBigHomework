package com.jee.dao;

import java.util.List;

/**
 * 所有数据对象的顶层抽象接口
 * @author 广辉
 *
 * @param <T> 数据对象名称
 * @param <K> 数据对象的主键类型
 */
public interface IDAO<T,K> {
	/**
	 * 添加一条记录，执行insert操作
	 * @param vo 数据对象
	 * @return 影响行数
	 * @throws Exception
	 */
	public int doCreate(T vo)throws Exception; 
	
	/**
	 * 查询所有的数据
	 * @return 表格中所有数据对象的List集合
	 * @throws Exception
	 */
    public List<T> findAll()throws Exception;  
    
    /**
     * 根据主键值查询指定的对象
     * @param id 主键值
     * @return 特定的数据对象vo
     * @throws Exception
     */
    public T findById(K id)throws Exception;
    
    /**
     * 删除一条记录，执行delete操作
     * @param id 主键值
     * @return 受影响行数
     * @throws Exception
     */
    public int doRemove(K id)throws Exception;
    
    /**
     * 修改一条记录，执行update操作
     * @param vo 数据对象
     * @return 受影响行数
     * @throws Exception
     */
    public int doUpdate(T vo)throws Exception;
}
