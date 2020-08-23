package com.eleme.service;

/**
 * 商店业务层
 */
import org.springframework.web.multipart.MultipartFile;

import com.eleme.bean.InteligenceInformation;
import com.eleme.bean.Shop;
import com.eleme.bean.ShopInformation;
import com.eleme.bean.ShopOwner;

public interface UserService {
	Shop findSellerByNumber(String number);

	/**
	 * 添加商店
	 * @param shop
	 */
	void addSeller(Shop shop);
	
	/**
	 * 添加商店信息
	 * @param shopInformation
	 * @param information
	 * @param shopOwner
	 * @param files
	 */
	void saveUserInformation(ShopInformation shopInformation,InteligenceInformation information,
			 ShopOwner shopOwner, MultipartFile[] files);
}
