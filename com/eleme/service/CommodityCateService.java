package com.eleme.service;

import java.util.List;

import com.eleme.bean.CommodityCate;

public interface CommodityCateService {
	/**
	 * 根据商店id查询所有商品类别
	 * @param id
	 * @return
	 */
	List<CommodityCate> findCommodityCatesByUserId(Integer id);
	
	/**
	 * 添加商品类别
	 * @param id
	 * @param cate
	 * @return
	 */
	List<CommodityCate> addCate(Integer id, String cate);

	/**
	 * 删除商品类别
	 * @param cateId
	 * @param userId
	 * @return
	 */
	List<CommodityCate> deleteCate(Integer cateId, Integer userId);

	/**
	 * 更新商品类别
	 * @param cateId
	 * @param userId
	 * @param cateName
	 * @return
	 */
	List<CommodityCate> updateCate(Integer cateId, Integer userId, String cateName);

	
	/**
	 * 根据商品类别id查询商品类别名称
	 * @param id
	 * @return
	 */
	String findCateNameById(Integer id);

}
