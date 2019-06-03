package com.pxm.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pxm.method.FormDataMethod;
import com.pxm.method.JsonMethod;

import net.sf.json.JSONObject;

public class InterfaceTest {

	//登录退出接口
    @Test(groups = { "Login"})
    public void Login_succ() throws IOException{
   
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/login";
	    Map<String, String> paramsMap = new HashMap<String, String>();
	    paramsMap.put("mobile", "18601632189");
	    paramsMap.put("password", "dc483e80a7a0bd9ef71d8cf973673924");
	    paramsMap.put("type", "1");
	    paramsMap.put("code", "");
	    // 发送post请求并接收返回结果
	    String resultData = FormDataMethod.httpPostWithForm(requestUrl, paramsMap);
	    Assert.assertEquals("\"status\":0", resultData.substring(1, 11));
	   
    }
    
    @Test(groups = { "Login"})
    public void mobile_fail() throws IOException{
   
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/login";
	    Map<String, String> paramsMap = new HashMap<String, String>();
	    paramsMap.put("mobile", "18601632188");
	    paramsMap.put("password", "dc483e80a7a0bd9ef71d8cf973673924");
	    paramsMap.put("type", "1");
	    paramsMap.put("code", "");
	    // 发送post请求并接收返回结果
	    String resultData = FormDataMethod.httpPostWithForm(requestUrl, paramsMap);
	    System.out.println(resultData);
	    Assert.assertEquals("\"status\":1", resultData.substring(1, 11));
	   
	    
    }
    
    @Test(groups = { "Login"})
    public void password_fail() throws IOException{
   
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/login";
	    Map<String, String> paramsMap = new HashMap<String, String>();
	    paramsMap.put("mobile", "18601632189");
	    paramsMap.put("password", "");
	    paramsMap.put("type", "1");
	    paramsMap.put("code", "");
	    // 发送post请求并接收返回结果
	    String resultData = FormDataMethod.httpPostWithForm(requestUrl, paramsMap);
	    System.out.println(resultData);
	    Assert.assertEquals("\"status\":1", resultData.substring(1, 11));
	   
    }
    
    //价币接口
    @Test(groups = { "BaseCase"})
    public void currency_price() throws IOException{
    	String ADD_URL ="https://service.magicdapps.com/api/openApi/currencyPrice";
    	String method = "POST";
    	JSONObject obj = new JSONObject();
    	String resultData = new String(JsonMethod.appadd(ADD_URL,method,obj,null));
    	Assert.assertEquals("\"status\":0", resultData.substring(1, 11));
    	Reporter.log(resultData);
    }
    
    @Test(groups = { "BaseCase"})
    public void promotion() throws IOException{
    	String ADD_URL ="https://service.magicdapps.com/api/"
    			+ "promotion/snatchActivityRecord/participation";
    	String method = "POST";
    	String token = "eyJhbGciOiJSUzI1NiJ9."
    			+ "eyJzdWIiOiIxODYwMTYzMjE4OSIsInVzZXJJZCI6IjE5"
    			+ "IiwibmFtZSI6IjE4NioqKioyMTg5IiwiZXhwIjoxNTU5NzI2MTUzfQ."
    			+ "Zy0LU13wa0dGizOI8NBDSGr7F6LdGE6VzpUtBGZTM-vpt_b95DtzGVr1X5x_"
    			+ "rZ1Li-vIrm7dKbGPreTSguvjiCIK50C1YLhVRxbEMgB04na5CqPILjjD0tMWY"
    			+ "yoDFgGZoK7_Bj90xSYSTb5ixznjp443bdJWEI2r5kGPHV9mcPE";
    	JSONObject obj = new JSONObject();
    	obj.accumulate("activityId", 0);
    	obj.accumulate("count", 10);
    	obj.accumulate("password", "e10adc3949ba59abbe56e057f20f883e");
    	String resultData = new String(JsonMethod.appadd(ADD_URL,method,obj,token));
    	//Assert.assertEquals("\"status\":40103", resultData.substring(30, 44));
    	Reporter.log(resultData);
    }
    
    @Test(groups = { "Login"})
    public void login_out() throws IOException{
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/loginOut";
	    String paramsMap = "eyJhbGciOiJSUzI1NiJ9."
	    		+ "eyJzdWIiOiIxODYwMTYzMjE4OSIsIn"
	    		+ "VzZXJJZCI6IjE5IiwibmFtZSI6IjE4"
	    		+ "NioqKioyMTg5IiwiZXhwIjoxNTU5NzI2MTUzfQ."
	    		+ "Zy0LU13wa0dGizOI8NBDSGr7F6LdGE"
	    		+ "6VzpUtBGZTM-vpt_b95DtzGVr1X5x_rZ1Li"
	    		+ "-vIrm7dKbGPreTSguvjiCIK50C1YLhVRxbEMg"
	    		+ "B04na5CqPILjjD0tMWYyoDFgGZoK7_Bj90xSYST"
	    		+ "b5ixznjp443bdJWEI2r5kGPHV9mcPE";
    	String resultData = FormDataMethod.httpGetWithForm(requestUrl, paramsMap);
    	System.out.println(resultData);
    	Assert.assertEquals("\"status\":0", resultData.substring(1, 11));
        
    }
    
    @Test(groups = { "BaseCase"})
    public void loginout_fail() throws IOException{
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/loginOut";
	    String paramsMap = "";
    	String resultData = FormDataMethod.httpGetWithForm(requestUrl, paramsMap);
    	System.out.println(resultData);
    	Assert.assertEquals("\"status\":0", resultData.substring(1, 11)); 
    }
}
