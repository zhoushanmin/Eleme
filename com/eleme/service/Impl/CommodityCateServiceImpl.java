package com.eleme.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eleme.bean.CommodityCate;
import com.eleme.mapper.CommodityCateMapper;
import com.eleme.queryVo.QueryVo;
import com.eleme.service.CommodityCateService;

@Service
@Transactional
public class CommodityCateServiceImpl implements CommodityCateService {
	
	@Autowired
	private CommodityCateMapper commodityCateMapper;
	
	@Override
	public List<CommodityCate> findCommodityCatesByUserId(Integer id) {
		return  commodityCateMapper.findCommodityCatesByUserId(id);
	}
	
	@Override
	public List<CommodityCate> addCate(Integer id, String cate) {
		QueryVo queryVo = new QueryVo();
		queryVo.setId(id);
		queryVo.setName(cate);
		commodityCateMapper.addCate(queryVo);
		return commodityCateMapper.findCommodityCatesByUserId(id);

	}

	public List<CommodityCate> deleteCate(Integer cateId, Integer userId) {
		commodityCateMapper.deleteCate(cateId);
		return commodityCateMapper.findCommodityCatesByUserId(userId);
	}

	@Override
	public String findCateNameById(Integer id) {
		return commodityCateMapper.findCateNameById(id);
	}

	@Override
	public List<CommodityCate> updateCate(Integer cateId, Integer userId, String cateName) {
		QueryVo queryVo = new QueryVo();
		queryVo.setId(cateId);
		queryVo.setName(cateName);
		commodityCateMapper.updateCate(queryVo);
		return commodityCateMapper.findCommodityCatesByUserId(userId);
	}
}
