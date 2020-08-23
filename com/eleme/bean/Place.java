package com.eleme.bean;

/**
 * 地址类
 * @author 孤傲de狼
 *
 */
public class Place {
	private int id;
	private String name;
	private String adcode;
	private String citycode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", adcode=" + adcode + ", citycode=" + citycode + "]";
	}
	
	
}
