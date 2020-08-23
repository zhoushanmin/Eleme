package com.eleme.mapper;

/**
 * 商店Mapper
 */
import com.eleme.bean.InteligenceInformation;
import com.eleme.bean.Shop;
import com.eleme.bean.ShopInformation;
import com.eleme.bean.ShopOwner;

public interface ShopMapper {
	
	/**
	 * 通过号码查找商店
	 * @param number
	 * @return
	 */
	Shop findSellerByNumber(String number);
	
	/**
	 * 添加商店
	 * @param shop
	 */
	void addShop(Shop shop);
	
	/**
	 * 添加商店信息
	 * @param shopInformation
	 */
	void addShopInformation(ShopInformation shopInformation);
	
	/**
	 * 添加商店资质
	 * @param intelInformation
	 */
	void addInteligenceInformation(InteligenceInformation intelInformation);
	
	/**
	 * 添加商店注册人
	 * @param shopOwner
	 */
	void addShopOwner(ShopOwner shopOwner);
}
