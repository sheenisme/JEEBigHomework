package com.jee.dao;

import java.util.List;

import com.jee.dao.vo.PcParts;

public interface IPcPartsDAO extends IDAO<PcParts, Integer>  {
	/**
	 * 根据配件名返回配件对象列表
	 * @param name 配件名
	 * @return 配件列表
	 * @throws Exception
	 */
	public List<PcParts> findByName(String name)throws Exception;
}
