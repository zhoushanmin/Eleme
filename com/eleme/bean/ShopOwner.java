package com.eleme.bean;

/**
 * 开店人信息类
 */
public class ShopOwner {
	private Integer id;
	private String	user_name;			// 姓名
	private String	user_sex;				// 性别
	private String	user_nation;			// 民族
	private String	user_birthday;		// 出生年月
	private String	user_home_address;		// 家庭住址
	private String	just_id_photo;					// 身份证件正面照片
	private String	back_id_photo;				// 身份证件反面照片
	private String 	user_and_id_photo;			// 手持身份证正面照片
	private Integer shop_id;							// 商铺id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_nation() {
		return user_nation;
	}
	public void setUser_nation(String user_nation) {
		this.user_nation = user_nation;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_home_address() {
		return user_home_address;
	}
	public void setUser_home_address(String user_home_address) {
		this.user_home_address = user_home_address;
	}
	public String getJust_id_photo() {
		return just_id_photo;
	}
	public void setJust_id_photo(String just_id_photo) {
		this.just_id_photo = just_id_photo;
	}
	public String getBack_id_photo() {
		return back_id_photo;
	}
	public void setBack_id_photo(String back_id_photo) {
		this.back_id_photo = back_id_photo;
	}
	public String getUser_and_id_photo() {
		return user_and_id_photo;
	}
	public void setUser_and_id_photo(String user_and_id_photo) {
		this.user_and_id_photo = user_and_id_photo;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	@Override
	public String toString() {
		return "ShopOwner [id=" + id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_nation="
				+ user_nation + ", user_birthday=" + user_birthday + ", user_home_address=" + user_home_address
				+ ", just_id_photo=" + just_id_photo + ", back_id_photo=" + back_id_photo + ", user_and_id_photo="
				+ user_and_id_photo + ", shop_id=" + shop_id + "]";
	}
	
	
	
}
