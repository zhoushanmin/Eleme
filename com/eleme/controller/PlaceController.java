package com.eleme.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleme.bean.Place;
import com.eleme.service.ProvinceCityService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("place")
public class PlaceController {
	
	@Autowired
	private ProvinceCityService provinceCityService;
	
	@RequestMapping(value = "getFill_information")
	 public String getFill_information(Model model) {
		List<Place> list = provinceCityService.findProvince();
		model.addAttribute("list", list);
		return "fill_Information";
	}
	
	@RequestMapping(value = "finAllCity")
	public void finAllCity(String adcode, HttpServletResponse response) throws IOException {
		List<Place> city = provinceCityService.findCity(adcode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.putIfAbsent("city", city);
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(jsonObject.toString());
	}
	
	@RequestMapping(value = "findAllCounty")
	public void findAllCounty(String citycode, HttpServletResponse response) throws IOException {
		List<Place> county = provinceCityService.findCounty(citycode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.putIfAbsent("county", county);
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(jsonObject.toString());
	}
}
