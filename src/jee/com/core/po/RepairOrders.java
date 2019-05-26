package jee.com.core.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class RepairOrders implements Serializable{
	private static final long serialVersionUID = 1L;
	private String order_id;
	private int custom_id;
	private Timestamp apply_time;
	private String link_name;
	private String link_phone;
	private String link_address;
	private Timestamp repair_time;
	private String type;//repair type故障的类型
	private String description;//problem description 故障问题的详细描述
	private String remark;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(int custom_id) {
		this.custom_id = custom_id;
	}
	public Timestamp getApply_time() {
		return apply_time;
	}
	public void setApply_time(Timestamp apply_time) {
		this.apply_time = apply_time;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_phone() {
		return link_phone;
	}
	public void setLink_phone(String link_phone) {
		this.link_phone = link_phone;
	}
	public String getLink_address() {
		return link_address;
	}
	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}
	public Timestamp getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(Timestamp repair_time) {
		this.repair_time = repair_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
