package com.eleme.service;

/**
 * 商品业务层
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.eleme.bean.Commodity;
import com.eleme.bean.CommodityCate;
import com.eleme.bean.PageBean;

public interface CommodityService {
	
	
	
	/**
	 * 通过商品类别id查询所有商品并分页显示
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean<Commodity> findByPage(Integer id,Integer page,Integer rows);
	
	/**
	 * 保存商品
	 * @param commodity
	 * @param file
	 * @return
	 */
	boolean saveCommodity(Commodity commodity, MultipartFile file);
	
	/**
	 * 通过商品id查询商品
	 * @param id
	 * @return
	 */
	Commodity findCommodityById(Integer id);

	/**
	 * 更新商品信息
	 * @param commodity
	 * @param file
	 * @param session
	 * @return
	 */
	boolean updateCommodity(Commodity commodity, MultipartFile file, HttpSession session);
	
	/**
	 * 删除商品信息
	 * @param id
	 */
	void deleteCommodity(Integer id);

	/**
	 * 通过商品名称模糊查询商品，并分页显示
	 * @param commo_name
	 * @param page
	 * @param rows
	 * @param userId
	 * @return
	 */
	PageBean<Commodity> findCommoditysByName(String commo_name, Integer page, Integer rows, Integer userId);
	
	/**
	 * 根据商品类别id查询所有商品
	 * @param id
	 * @return
	 */
	List<Commodity> findAllCommodity(Integer id);

	/**
	 * 查新指定商品id的月销量
	 * @param id
	 * @param date
	 * @return
	 */
	Map<String, Object> findCommodityMonthlySales(Integer id, String date);

	/**
	 * 根据商店id查询所有商品的总销量
	 * @param id
	 * @return
	 */
	Map<String, Object> findAllCommodityTotalSales(Integer id);
}
