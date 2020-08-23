package com.eleme.mapper;
/**
 * 商品Mapper
 */
import java.util.List;

import com.eleme.bean.Commodity;
import com.eleme.bean.MonthlySales;
import com.eleme.queryVo.QueryVo;

public interface CommodityMapper {

	/**
	 * 根据商品类别id查找商品
	 * @param queryVo
	 * @return
	 */
	List<Commodity> findCommoditysByCateId(QueryVo queryVo);
	
	/**
	 * 根据商品类别id查找商品个数
	 * @param id
	 * @return
	 */
	Integer findCount(Integer id);
	
	/**
	 * 添加商品
	 * @param commodity
	 */
	void insertCommodity(Commodity commodity);
	
	/**
	 * 根据商品id查询商品信息
	 * @param id
	 * @return
	 */
	Commodity findCommodityById(Integer id);
	
	/**
	 * 更新商品信息
	 * @param commodity
	 */
	void updateCommodity(Commodity commodity);
	
	/**
	 * 删除商品
	 * @param id
	 */
	void deleteCommodity(Integer id);
	
	/**
	 * 根据商品名称模糊查询商品信息
	 * @param queryVo
	 * @return
	 */
	List<Commodity> findCommoditysByName(QueryVo queryVo);
	
	/**
	 * 根据商品名称模糊查询商品信息数量用于分页
	 * @param queryVo
	 * @return
	 */
	Integer findCommoditysByNameCount(QueryVo queryVo);

	/**
	 * 根据商品类别查询所有商品信息
	 * @param id
	 * @return
	 */
	List<Commodity> findAllCommodity(Integer id);

	/**
	 * 查询商品的月销量
	 * @param queryVo
	 * @return
	 */
	List<MonthlySales> findCommodityMonthlySales(QueryVo queryVo);

	/**
	 * 查询所用商品的总销量
	 * @param id
	 * @return
	 */
	List<Commodity> findAllCommodityTotalSales(Integer id);
}
