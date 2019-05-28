package jee.com.core.service;

import java.util.List;

import jee.com.core.po.PcParts;

public interface PcPartsService {
	public int CreatePcParts(PcParts po);
	public List<PcParts> showAllPcParts();
}
