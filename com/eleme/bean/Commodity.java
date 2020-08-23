package com.eleme.bean;

/**
 * 商品类
 * @author 孤傲de狼
 *
 */
public class Commodity {
	private Integer id;
	private String commodity_name;
	private String commodity_jianjie;
	private Double commodity_price;
	private String commodity_pic;
	private Integer monthly_sales;
	private Integer total_sales;
	private Integer commodity_cate_id;
	private String commodity_cate_name;
	
	public String getCommodity_cate_name() {
		return commodity_cate_name;
	}
	public void setCommodity_cate_name(String commodity_cate_name) {
		this.commodity_cate_name = commodity_cate_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public String getCommodity_jianjie() {
		return commodity_jianjie;
	}
	public void setCommodity_jianjie(String commodity_jianjie) {
		this.commodity_jianjie = commodity_jianjie;
	}
	public Double getCommodity_price() {
		return commodity_price;
	}
	public void setCommodity_price(Double commodity_price) {
		this.commodity_price = commodity_price;
	}
	public String getCommodity_pic() {
		return commodity_pic;
	}
	public void setCommodity_pic(String commodity_pic) {
		this.commodity_pic = commodity_pic;
	}
	public Integer getMonthly_sales() {
		return monthly_sales;
	}
	public void setMonthly_sales(Integer monthly_sales) {
		this.monthly_sales = monthly_sales;
	}
	public Integer getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(Integer total_sales) {
		this.total_sales = total_sales;
	}
	public Integer getCommodity_cate_id() {
		return commodity_cate_id;
	}
	public void setCommodity_cate_id(Integer commodity_cate_id) {
		this.commodity_cate_id = commodity_cate_id;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", commodity_name=" + commodity_name + ", commodity_jianjie=" + commodity_jianjie
				+ ", commodity_price=" + commodity_price + ", commodity_pic=" + commodity_pic + ", monthly_sales="
				+ monthly_sales + ", total_sales=" + total_sales + ", commodity_cate_id=" + commodity_cate_id + "]";
	}
	
	
}
