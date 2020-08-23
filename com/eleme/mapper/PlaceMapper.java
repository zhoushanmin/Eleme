package com.eleme.mapper;

/**
 * 地点Mapper
 */
import java.util.List;

import com.eleme.bean.Place;
import com.eleme.queryVo.QueryVo;

public interface PlaceMapper {
	
	/**
	 * 查询省份
	 * @return
	 */
	List<Place> findProvince();
	
	/**
	 * 查询城市
	 * @param queryVo
	 * @return
	 */
	List<Place> findCity(QueryVo queryVo);
	
	/**
	 * 查询县、区
	 * @param citycode
	 * @return
	 */
	List<Place> findCounty(String citycode);
}
