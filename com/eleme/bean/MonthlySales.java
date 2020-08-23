package com.eleme.bean;

/**
 * 月销量
 * @author 孤傲de狼
 *
 */
public class MonthlySales {
	private String date;
	private Integer monthly_sales;
	private Integer commodity_id;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getMonthly_sales() {
		return monthly_sales;
	}
	public void setMonthly_sales(Integer monthly_sales) {
		this.monthly_sales = monthly_sales;
	}
	public Integer getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}
	
}
