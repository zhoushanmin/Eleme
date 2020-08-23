package com.eleme.bean;

/**
 * 店铺类
 * @author 孤傲de狼
 *
 */
public class Shop {
	private Integer id;
	private String phone_number;
	private String create_time;
	private Integer intelligence;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Integer getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Seller [id=" + id + ", phone_number=" + phone_number + ", create_time=" + create_time
				+ ", intelligence=" + intelligence + ", status=" + status + "]";
	}
	
}
