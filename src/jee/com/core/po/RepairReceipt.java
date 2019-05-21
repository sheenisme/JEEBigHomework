package jee.com.core.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class RepairReceipt implements Serializable{
	private static final long serialVersionUID = 1L;
	private int receiptId;
	private String orderId;;
	private int adminId;
	private Timestamp repairTime;
	private boolean needParts;
	private String partsType;
	private String resolvent;
	private String advise;
	private String remark;
	
	public boolean getNeedParts() {
		return needParts;
	}
	public void setNeedParts(boolean needParts) {
		this.needParts = needParts;
	}
	public String getPartsType() {
		return partsType;
	}
	public void setPartsType(String partsType) {
		this.partsType = partsType;
	}
	public String getResolvent() {
		return resolvent;
	}
	public void setResolvent(String resolvent) {
		this.resolvent = resolvent;
	}
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Timestamp getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Timestamp repairTime) {
		this.repairTime = repairTime;
	}

}
