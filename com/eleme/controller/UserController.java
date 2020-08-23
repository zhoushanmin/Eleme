package com.eleme.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eleme.Utils.SendVerifyCode;
import com.eleme.bean.InteligenceInformation;
import com.eleme.bean.Shop;
import com.eleme.bean.ShopInformation;
import com.eleme.bean.ShopOwner;
import com.eleme.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public void login(String number, String verifyCode, HttpServletResponse response, HttpSession session) {
		register(number, verifyCode, response, session);
	}
	
	@RequestMapping(value = "sendSms")
	public void sendSms(String number, HttpServletResponse response, HttpSession session) {
		SendVerifyCode.sendCode(number, response, session);
	}
	
	@RequestMapping(value = "register")
	public void register(String number, String verifyCode, HttpServletResponse response, HttpSession session) {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>)session.getAttribute("verifyCode");
		if(map == null){
            renderData(response, "验证码错误");
            return ;
        }
        if(!map.get("number").equals(number)){
            renderData(response, "手机号错误");
            return ;
        }
        if(!map.get("verifyCode").equals(verifyCode)){
            renderData(response, "验证码错误");
            return ;
        }
        if((System.currentTimeMillis() - (Long)map.get("createTime")) > 1000 * 60 * 5){
            renderData(response, "验证码已过期");
            return ;
        }
       
        Shop shop = userService.findSellerByNumber(number);
		if(shop != null) {
			if(shop.getIntelligence() == 1) {
				// 审核通过
				session.setAttribute("shop", shop);
				//登录成功
		        renderData(response, "success");
		        return;
			}
			if(shop.getIntelligence() == 2) {
				// 待审核
				renderData(response, "pending_review");
				return;
			}
		}else {
        	// 未注册，前往注册页面
        	renderData(response, "prompt_page");
        	return ;
		}
	}
	
	 private void renderData(HttpServletResponse response, String data){
	        try {
	            response.setContentType("text/plain;charset=UTF-8");
	            response.getWriter().write(data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 @RequestMapping(value = "prompt_page")
	 public String getPrompt_page() {
		return "prompt_page";
	}
	 
	 @RequestMapping(value = "pending_review")
	 public String getPending_review() {
		return "pending_review";
	}
	 
	 @RequestMapping(value = "saveUserInformation",method = RequestMethod.POST)
	 public String saveUserInformation(ShopInformation shopInformation,InteligenceInformation information,
			 ShopOwner shopOwner,@RequestParam("imgFile") MultipartFile[] files) {
		 
		 userService.saveUserInformation(shopInformation, information, shopOwner, files);
		 // 跳转到待审核页面
		 return "pending_review";
	}
	 
	 /**
	  * 退出登录
	  * @param session
	  * @param response
	  * @throws IOException
	  */
	 @RequestMapping("quit")
	 public void quit(HttpSession session, HttpServletResponse response) throws IOException {
		session.removeAttribute("shop");
		response.getWriter().print("success");
	}
	 
}
