package jee.com.core.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class RepairReceipt implements Serializable{
	private static final long serialVersionUID = 1L;
	private int receipt_id;
	private String order_id;
	private int admin_id;
	private Timestamp repair_time;
	private boolean need_parts;
	private String parts_type;
	private String resolvent;
	private String advise;
	private String remark;
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public Timestamp getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(Timestamp repair_time) {
		this.repair_time = repair_time;
	}
	public boolean isNeed_parts() {
		return need_parts;
	}
	public void setNeed_parts(boolean need_parts) {
		this.need_parts = need_parts;
	}
	public String getParts_type() {
		return parts_type;
	}
	public void setParts_type(String parts_type) {
		this.parts_type = parts_type;
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
	
}
