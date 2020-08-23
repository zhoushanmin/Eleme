package com.eleme.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.eleme.Utils.PathParam;
import com.eleme.Utils.UploadUtils;
import com.eleme.bean.Commodity;
import com.eleme.bean.CommodityCate;
import com.eleme.bean.MonthlySales;
import com.eleme.bean.PageBean;
import com.eleme.mapper.CommodityCateMapper;
import com.eleme.mapper.CommodityMapper;
import com.eleme.queryVo.QueryVo;
import com.eleme.service.CommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Override
	public PageBean<Commodity> findByPage(Integer id, Integer page, Integer rows) {
		PageBean<Commodity> pageBean = new PageBean<Commodity>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = commodityMapper.findCount(id);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage( num.intValue());
		Integer begin = (page - 1 )* rows;
		QueryVo queryVo = new QueryVo();
		queryVo.setId(id);
		queryVo.setBegin(begin);
		queryVo.setRows(rows);
		List<Commodity> list = commodityMapper.findCommoditysByCateId(queryVo);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public boolean saveCommodity(Commodity commodity, MultipartFile file) {
		String good_pic = null;
		if(file != null) {
			if(file.getOriginalFilename() != "") {
				String newFileName = UploadUtils.getNewFileName(file.getOriginalFilename());
				String realPath = UploadUtils.getPath(newFileName);
				String url = PathParam.PATH + realPath;
				File file1 = new File(url);
				if(!file1.exists()) {
					file1.mkdirs();
				}
				File saveFile = new File(good_pic = (url + "/" + newFileName));
				
				try {
					file.transferTo(saveFile);
					commodity.setCommodity_pic(good_pic);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			commodityMapper.insertCommodity(commodity);
			return true;
		}
		return false;
	}

	
	@Override
	public Commodity findCommodityById(Integer id) {
		return commodityMapper.findCommodityById(id);
	}

	@Override
	public boolean updateCommodity(Commodity commodity,MultipartFile file, HttpSession session) {
		String good_pic = null;
		String oldPath = (String) session.getAttribute("picPath");
		session.removeAttribute("picPath");
		if(file != null ) {
			if(file.getOriginalFilename() != "") {
				// 删除原来的图片
				File file2 = new File(oldPath);
				file2.delete();
				String newFileName = UploadUtils.getNewFileName(file.getOriginalFilename());
				String realPath = UploadUtils.getPath(newFileName);
				String url = PathParam.PATH + realPath;
				File file1 = new File(url);
				if(!file1.exists()) {
					file1.mkdirs();
				}
				File saveFile = new File(good_pic = (url + "/" + newFileName));
				
				try {
					file.transferTo(saveFile);
					commodity.setCommodity_pic(good_pic);
					commodityMapper.updateCommodity(commodity);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}else {
				System.out.println(oldPath + "--------------------->");
				commodity.setCommodity_pic(oldPath);
				commodityMapper.updateCommodity(commodity);
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteCommodity(Integer id) {
		commodityMapper.deleteCommodity(id);
	}

	@Override
	public PageBean<Commodity> findCommoditysByName(String commo_name, Integer page, Integer rows,Integer userId) {
		String string = "%";
		char[] c = commo_name.toCharArray();
		for (int i = 0; i < c.length; i++) {
			string = string + c[i] + "%";
		}
		PageBean<Commodity> pageBean = new PageBean<Commodity>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		QueryVo queryVo = new QueryVo();
		queryVo.setUserId(userId);
		queryVo.setName(string);
		Integer totalCount = commodityMapper.findCommoditysByNameCount(queryVo);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage( num.intValue());
		Integer begin = (page - 1 )* rows;
		queryVo.setName(string);
		queryVo.setBegin(begin);
		queryVo.setRows(rows);
		List<Commodity> list = commodityMapper.findCommoditysByName(queryVo);
		pageBean.setList(list);
		return pageBean;
	}



	@Override
	public List<Commodity> findAllCommodity(Integer id) {
		return commodityMapper.findAllCommodity(id);
	}

	@Override
	public Map<String, Object> findCommodityMonthlySales(Integer id, String date) {
		QueryVo queryVo = new QueryVo();
		queryVo.setId(id);
		queryVo.setName(date);
		List<MonthlySales> list = commodityMapper.findCommodityMonthlySales(queryVo);
		List<String> monthList = new ArrayList<String>();
		List<Integer> salesList = new ArrayList<Integer>();
		for (MonthlySales monthlySales : list) {
			monthList.add(monthlySales.getDate().substring(0, monthlySales.getDate().lastIndexOf("-")));
			salesList.add(monthlySales.getMonthly_sales());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("month", monthList);
		map.put("sales", salesList);
		return map;
	}

	@Override
	public Map<String, Object> findAllCommodityTotalSales(Integer id) {
		List<Commodity> list = commodityMapper.findAllCommodityTotalSales(id);
		List<List> data = new ArrayList<List>();
		List<String> nameList = new ArrayList<String>();
		nameList.add("name");
		nameList.add("totalSales");
		data.add(nameList);
		for (Commodity commodity : list) {
			List<Object> totalSalesList = new ArrayList<Object>();
			totalSalesList.add(commodity.getCommodity_name());
			totalSalesList.add(commodity.getTotal_sales());
			data.add(totalSalesList);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		return map;
	}


	
}
