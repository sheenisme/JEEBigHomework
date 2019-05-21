package jee.com.core.dao;

import java.util.List;
import jee.com.core.po.PcParts;

public interface PcPartsDAO extends DAO<PcParts, Integer>  {
	/**
	 * 根据配件名返回配件对象列表
	 * @param name 配件名
	 * @return 配件列表
	 * @throws Exception
	 */
	public List<PcParts> findByName(String name)throws Exception;
}
