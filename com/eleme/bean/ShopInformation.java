package com.eleme.bean;

/**
 * 	门店信息
 * @return
 */
public class ShopInformation {
	private Integer Id;
	private String shop_name;				// 店铺名称
	private String ssq;							// 店铺地址(省市区)
	private String	detailed_address;		// 详细地址
	private String	business_category;	// 经营类目
	private String	front_door_photo;	// 门脸照
	private String	shop_inside_photo;	// 店内照
	private String	shop_logo;				// 门店LOGO
	private String	take_out_phone;		// 外卖电话
	private String	contact_name;			// 联系人姓名
	private String	contact_number;		// 联系电话
	private Integer shop_id;					// 商铺id
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getSsq() {
		return ssq;
	}
	public void setSsq(String ssq) {
		this.ssq = ssq;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}
	public String getBusiness_category() {
		return business_category;
	}
	public void setBusiness_category(String business_category) {
		this.business_category = business_category;
	}
	public String getFront_door_photo() {
		return front_door_photo;
	}
	public void setFront_door_photo(String front_door_photo) {
		this.front_door_photo = front_door_photo;
	}
	public String getShop_inside_photo() {
		return shop_inside_photo;
	}
	public void setShop_inside_photo(String shop_inside_photo) {
		this.shop_inside_photo = shop_inside_photo;
	}
	public String getShop_logo() {
		return shop_logo;
	}
	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}
	public String getTake_out_phone() {
		return take_out_phone;
	}
	public void setTake_out_phone(String take_out_phone) {
		this.take_out_phone = take_out_phone;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	@Override
	public String toString() {
		return "ShopInformation [Id=" + Id + ", shop_name=" + shop_name + ", ssq=" + ssq + ", detailed_address="
				+ detailed_address + ", business_category=" + business_category + ", front_door_photo="
				+ front_door_photo + ", shop_inside_photo=" + shop_inside_photo + ", shop_logo=" + shop_logo
				+ ", take_out_phone=" + take_out_phone + ", contact_name=" + contact_name + ", contact_number="
				+ contact_number + ", shop_id=" + shop_id + "]";
	}
	
	
	
}
