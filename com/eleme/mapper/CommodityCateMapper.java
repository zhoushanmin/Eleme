package com.eleme.mapper;

import java.util.List;

import com.eleme.bean.CommodityCate;
import com.eleme.queryVo.QueryVo;

public interface CommodityCateMapper {
	
	/**
	 * 根据商店id查询商品类别
	 * @param id
	 * @return List<CommodityCate>
	 */
	List<CommodityCate> findCommodityCatesByUserId(Integer id);
	
	/**
	 * 添加商品类别
	 * @param queryVo
	 */
	void addCate(QueryVo queryVo);
	
	/**
	 * 删除商品类别
	 * @param id
	 */
	void deleteCate(Integer id);

	/**
	 * 根据商品类别id查询商品类别名称
	 * @param id
	 * @return String
	 */
	String findCateNameById(Integer id);

	/**
	 * 更新商品类别
	 * @param queryVo
	 */
	void updateCate(QueryVo queryVo);
}
