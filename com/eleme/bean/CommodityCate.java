package com.eleme.bean;

/**
 * 商品类别
 * @author 孤傲de狼
 *
 */
public class CommodityCate {
	private Integer id;
	private String commodity_cate_name;
	private Integer shop_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCommodity_cate_name() {
		return commodity_cate_name;
	}
	public void setCommodity_cate_name(String commodity_cate_name) {
		this.commodity_cate_name = commodity_cate_name;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	
	
}
