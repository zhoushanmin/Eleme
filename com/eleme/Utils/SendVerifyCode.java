package com.eleme.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhenzi.sms.ZhenziSmsClient;

import net.sf.json.JSONObject;

public class SendVerifyCode {
	//短信平台相关参数
    private static String apiUrl = "https://sms_developer.zhenzikj.com";
    private static String appId = "106567";
    private static String appSecret = "454608ba-e1b3-4630-bf8c-e9968fb6e0d6";
    
    public static void sendCode(String number, HttpServletResponse response, HttpSession session) {
    	try {
			JSONObject json = null;
	        //生成6位验证码
	        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
	        //发送短信
	        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("number",number);
	        params.put("templateId", "1455");
	        String[] templateParams = new String[2];
	        templateParams[0] = verifyCode;
	        templateParams[1] = "5";
	        params.put("templateParams", templateParams);
	        String result = client.send(params);
	        json = JSONObject.fromObject(result);
	        if(json.getInt("code") != 0){//发送短信失败
	            renderData(response, "fail");
	            return;
	        }
	        //将验证码存到session中,同时存入创建时间
	        //以json存放，这里使用的是阿里的fastjson
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("number", number);
	        map.put("verifyCode", verifyCode);
	        map.put("createTime", System.currentTimeMillis());
	        // 将认证码存入SESSION
	        session.setAttribute("verifyCode", map);
	        renderData(response, "success");
	        return ;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		renderData(response, "fail");
	}
    
    protected static void renderData(HttpServletResponse response, String data){
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
