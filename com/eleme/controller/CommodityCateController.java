package com.eleme.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleme.bean.CommodityCate;
import com.eleme.bean.Shop;
import com.eleme.service.CommodityCateService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "commodity_cate")
public class CommodityCateController {
	
	@Autowired
	private CommodityCateService commodityCateService;
	
	@SuppressWarnings("unused")
	private void sendJsonDate(Object object, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(object);
		response.setContentType("text/html ; Charset=utf-8");
		response.getWriter().write(jsonObject.toString());
	}
	
	// 查询所有的商品类别
	@RequestMapping(value = "/findCommodityCates")
	public String findCommodityCatesByUserId(HttpServletResponse response, HttpSession session, Model model) throws IOException {
	
		Shop shop = (Shop)session.getAttribute("shop");
		Integer id = shop.getId();
		List<CommodityCate> list = commodityCateService.findCommodityCatesByUserId(id);
		model.addAttribute("list", list);
		return "goods";
	}
	
	@RequestMapping(value = "/addCate")
	public void addCate(HttpSession session, String cate,HttpServletResponse response) throws IOException {
		Shop shop = (Shop)session.getAttribute("shop");
		Integer id = shop.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommodityCate> list = commodityCateService.addCate(id, cate);
		map.put("list", list);
		map.put("msg", "添加成功！");
		sendJsonDate(map, response);
	}
	
	//删除商品类别 回显商品类别列表
		@RequestMapping(value = "/deleteCate")
		public void deleteCate(Integer cateId,HttpSession session,HttpServletResponse response) throws IOException {
			Shop shop = (Shop)session.getAttribute("shop");
			Integer id = shop.getId();
			Map<String, Object> map = new HashMap<String, Object>();
			List<CommodityCate> list = commodityCateService.deleteCate(cateId,id);
			map.put("list", list);
			map.put("msg", "删除成功！");
			sendJsonDate(map, response);
		}
		
		// 根据品类Id查找品类名称
		@RequestMapping(value = "/findCateNameById")
		public void findCateNameById(Integer id, HttpServletResponse response) throws IOException {
			String cateName = commodityCateService.findCateNameById(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cateName", cateName);
			sendJsonDate(map, response);
		}
		
		// 更新品类名称
		@RequestMapping(value = "/updateCate")
		public void updateCate(Integer cateId, HttpSession session, String cateName, HttpServletResponse response) throws IOException {
			Shop shop = (Shop)session.getAttribute("shop");
			Integer shopId = shop.getId();
			Map<String, Object> map = new HashMap<String, Object>();
			List<CommodityCate> list = commodityCateService.updateCate(cateId,shopId,cateName);
			map.put("list", list);
			map.put("msg", "修改成功！");
			sendJsonDate(map, response);
		}
}
