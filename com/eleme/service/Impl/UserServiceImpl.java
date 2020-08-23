package com.eleme.service.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.eleme.Utils.JedisUtils;
import com.eleme.Utils.UploadUtils;
import com.eleme.bean.InteligenceInformation;
import com.eleme.bean.Shop;
import com.eleme.bean.ShopInformation;
import com.eleme.bean.ShopOwner;
import com.eleme.mapper.ShopMapper;
import com.eleme.service.UserService;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private ShopMapper shopMapper;
	
	@Override
	public Shop findSellerByNumber(String number) {
		
		Jedis jedis = JedisUtils.getJedis();
		// 从Redis缓存中查找
		String string = jedis.get(number);
		if(null == string) {
			// 若没有从mysql数据库中查找
			Shop shop = shopMapper.findSellerByNumber(number);
			if(null != shop) {
				JSONObject jsonObject = JSONObject.fromObject(shop);
				jedis.set(shop.getPhone_number(), jsonObject.toString());
				jedis.expire(shop.getPhone_number(), 24*60*60*2);				// 设置该键存活时间
			}
			return shop;
		}else {
			// 如果有，将字符串转换为shop
			JSONObject jsonObject = JSONObject.fromObject(string);
			return (Shop)JSONObject.toBean(jsonObject,Shop.class);
			 
		}
		
		
	}

	@Override
	public void addSeller(Shop shop) {
		shopMapper.addShop(shop);
	}

	@Override
	public void saveUserInformation(ShopInformation shopInformation,
			InteligenceInformation information,
			ShopOwner shopOwner, MultipartFile[] files) {
		
		Shop shop = new Shop();
		shop.setPhone_number(shopInformation.getContact_number());
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String creatTime = df.format(date);
		shop.setCreate_time(creatTime);
		shop.setIntelligence(2);
		shopMapper.addShop(shop);
		Shop shop2 = shopMapper.findSellerByNumber(shopInformation.getContact_number());
		
		List<String> newFileNames = UploadUtils.uploadFiles(files);
		shopInformation.setFront_door_photo(newFileNames.get(0));
		shopInformation.setShop_inside_photo(newFileNames.get(1));
		shopInformation.setShop_logo(newFileNames.get(2));
		shopInformation.setShop_id(shop2.getId());
		information.setMain_id_photo(newFileNames.get(3));
		information.setIndustry_id_photo(newFileNames.get(4));
		information.setShop_id(shop2.getId());
		shopOwner.setJust_id_photo(newFileNames.get(5));
		shopOwner.setBack_id_photo(newFileNames.get(6));
		shopOwner.setUser_and_id_photo(newFileNames.get(7));
		shopOwner.setShop_id(shop2.getId());

		shopMapper.addShopInformation(shopInformation);
		shopMapper.addInteligenceInformation(information);
		shopMapper.addShopOwner(shopOwner);
	}
}
