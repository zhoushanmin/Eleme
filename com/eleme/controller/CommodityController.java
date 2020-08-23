package com.eleme.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eleme.bean.Commodity;
import com.eleme.bean.CommodityCate;
import com.eleme.bean.PageBean;
import com.eleme.bean.Shop;
import com.eleme.service.CommodityService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@SuppressWarnings("unused")
	private void sendJsonDate(Object object, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(object);
		response.setContentType("text/html ; Charset=utf-8");
		response.getWriter().write(jsonObject.toString());
	}

	// 通过商品类别id查找商品
	@RequestMapping(value = "/findCommoditysByCateId")
	public void findCommoditysByCateId(Integer id,Integer page,Integer rows,HttpServletResponse response) throws IOException {
		PageBean<Commodity> pageBean = commodityService.findByPage(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		sendJsonDate(map, response);
	}
	
	// 添加商品
	@RequestMapping(value = "/addCommodity")
	public void addCommodity(Commodity commodity,@RequestParam("good_pic") MultipartFile file,
			Model model, HttpServletResponse response) throws IOException {
		boolean flag = commodityService.saveCommodity(commodity, file);
		Map<String, String> map = new HashMap<String, String>();
		if(flag) {
			map.put("msg", "保存成功!");
		} else {
			map.put("msg", "保存失败!");
		}
		// 将map转成JSON:
		sendJsonDate(map, response);
	}
	
	// 通过商品id查询商品
	@RequestMapping(value = "/findCommodityById")
	public void findCommodityById(Integer id,HttpServletResponse response, Model model, HttpSession session) throws IOException {
		Commodity commodity = commodityService.findCommodityById(id);
		session.setAttribute("picPath", commodity.getCommodity_pic());
		sendJsonDate(commodity, response);
	
	}
	
	/**
     * 处理图片显示请求
     * @param fileName
     */
    @RequestMapping("/showPic")
    public void showPicture(String pic,
                            HttpServletResponse response){
        File imgFile = new File(pic);
        responseFile(response, imgFile);
    }

    /**
     * 响应输出图片文件
     * @param response
     * @param imgFile
     */
    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
	
	// 更新商品
	@RequestMapping(value = "/updateCommodity")
	public void updateCommodity(Commodity commodity,@RequestParam("good_pic") MultipartFile file,HttpSession session,
			HttpServletResponse response) throws IOException {
		boolean flag = commodityService.updateCommodity(commodity, file,session);
		Map<String, String> map = new HashMap<String, String>();
		if(flag) {
			map.put("msg", "修改成功!");
		} else {
			map.put("msg", "修改失败!");
		}
		// 将map转成JSON:
		sendJsonDate(map, response);

	}
	
	// 删除商品
	@RequestMapping(value = "/deleteCommodity")
	public void deleteCommodity(Integer id,HttpServletResponse response) throws IOException {
		commodityService.deleteCommodity(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "删除成功!");
		// 将map转成JSON:
		sendJsonDate(map, response);
	}
	
	// 通过商品名称模糊查询
	@RequestMapping(value = "/findCommoditysByName")
	public void findCommoditysByName(String commo_name,Integer page,Integer rows,HttpServletResponse response, HttpSession session) throws IOException {
		Shop shop = (Shop)session.getAttribute("shop");
		Integer id = shop.getId();
		commo_name = new String(commo_name.getBytes("ISO-8859-1"), "UTF-8");
		PageBean<Commodity> pageBean = commodityService.findCommoditysByName(commo_name,page,rows,id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		sendJsonDate(map, response);
	}
	
	// 查询用户下的所有商品
	@RequestMapping(value = "/findAllCommodity")
	public String findAllCommodity(HttpSession session, HttpServletResponse response, Model model) {
		Shop shop = (Shop)session.getAttribute("shop");
		Integer id = shop.getId();
		List<Commodity> list = commodityService.findAllCommodity(id);
		model.addAttribute("list", list);
		return "commo_monthlySales";
	}
	
	// 查询各商品的月销售情况
	@RequestMapping(value = "/findCommodityMonthlySales")
	public void findCommodityMonthlySales(Integer id, String date, HttpServletResponse response) throws IOException {
		Map<String, Object> map = commodityService.findCommodityMonthlySales(id, date);
		sendJsonDate(map, response);
	}
	
	@RequestMapping(value = "/getCommo_totalSalesJSP")
	public String getCommo_totalSalesJSP() {
		return "commo_totalSales";
	}
	
	// 查询所有商品的总销售量
	@RequestMapping(value = "/findAllCommodityTotalSales")
	public void findAllCommodityTotalSales(HttpSession session, HttpServletResponse response) throws IOException {
		Shop shop = (Shop)session.getAttribute("shop");
		Integer id = shop.getId();
		Map<String, Object> map = commodityService.findAllCommodityTotalSales(id);
		sendJsonDate(map, response);
	}
	
}
