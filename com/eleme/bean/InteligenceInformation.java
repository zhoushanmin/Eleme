package com.eleme.bean;

/**
 * 资质证照
 */
public class InteligenceInformation {
	private Integer id;
	private String	main_document_type;			// 主体资质证件类型
	private String	main_id_photo;					// 主体资质证件照片
	private String	industry_document_type;	// 行业资质证件类型
	private String	industry_id_photo;				// 行业资质证件照片
	private Integer shop_id;
	
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMain_document_type() {
		return main_document_type;
	}
	public void setMain_document_type(String main_document_type) {
		this.main_document_type = main_document_type;
	}
	public String getMain_id_photo() {
		return main_id_photo;
	}
	public void setMain_id_photo(String main_id_photo) {
		this.main_id_photo = main_id_photo;
	}
	public String getIndustry_document_type() {
		return industry_document_type;
	}
	public void setIndustry_document_type(String industry_document_type) {
		this.industry_document_type = industry_document_type;
	}
	public String getIndustry_id_photo() {
		return industry_id_photo;
	}
	public void setIndustry_id_photo(String industry_id_photo) {
		this.industry_id_photo = industry_id_photo;
	}
	@Override
	public String toString() {
		return "InteligenceInformation [id=" + id + ", main_document_type=" + main_document_type + ", main_id_photo="
				+ main_id_photo + ", industry_document_type=" + industry_document_type + ", industry_id_photo="
				+ industry_id_photo + "]";
	}
	
	
	
}
