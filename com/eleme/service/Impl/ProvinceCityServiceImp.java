package com.eleme.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eleme.bean.Place;
import com.eleme.mapper.PlaceMapper;
import com.eleme.queryVo.QueryVo;
import com.eleme.service.ProvinceCityService;

@Service
@Transactional
public class ProvinceCityServiceImp  implements ProvinceCityService{

	@Autowired
	private PlaceMapper placeMapper;
	
	@Override
	public List<Place> findProvince() {
		return placeMapper.findProvince();
	}

	@Override
	public List<Place> findCity(String adcode) {
		
		StringBuffer stringBuffer = new StringBuffer(adcode);
		stringBuffer.replace(2, 4, "__");
		QueryVo queryVo = new QueryVo();
		queryVo.setCode1(stringBuffer.toString());
		queryVo.setCode2(adcode);
		return placeMapper.findCity(queryVo);
	}

	@Override
	public List<Place> findCounty(String citycode) {
		return placeMapper.findCounty(citycode);
	}
	
}
