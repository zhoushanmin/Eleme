package com.eleme.service;
import java.util.List;

import com.eleme.bean.Place;

/**
 * 地点业务层
 * @author 孤傲de狼
 *
 */
public interface ProvinceCityService {
	
	/**
	 * 查找所有省
	 * @return
	 * @throws SQLException
	 */
	List<Place> findProvince();
	
	/**
	 * 查找市
	 * @param adcode
	 * @return List<Place>
	 * @throws SQLException
	 */
	List<Place> findCity(String adcode);
	
	/**
	 * 查找县
	 * @param citycode
	 * @return List<Place>
	 * @throws SQLException
	 */
	List<Place> findCounty(String citycode);
}
