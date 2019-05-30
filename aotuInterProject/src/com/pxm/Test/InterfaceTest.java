package com.pxm.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pxm.Login.FormDataMethod;
import com.pxm.Login.JsonMethod;

public class InterfaceTest {

    @Test(groups = { "BaseCase"})
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
    
    @Test(groups = { "BaseCase"})
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
    
    @Test(groups = { "BaseCase"})
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
    
    @Test(groups = { "BaseCase"})
    public void currency_price() throws IOException{
    	String ADD_URL ="https://service.magicdapps.com/api/openApi/currencyPrice";
    	String method = "POST";
    	String resultData = new String(JsonMethod.appadd(ADD_URL,method));
    	Assert.assertEquals("\"status\":0", resultData.substring(1, 11));
    	Reporter.log(resultData);
    }
    
    @Test(groups = { "BaseCase"})
    public void login_out() throws IOException{
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/loginOut";
	    String paramsMap = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxODYwMTYzMjE4OSIsInVzZXJJZCI6IjE5IiwibmFtZSI6IjE4NioqKioyMTg5IiwiZXhwIjoxNTU5NzI2MTUzfQ.Zy0LU13wa0dGizOI8NBDSGr7F6LdGE6VzpUtBGZTM-vpt_b95DtzGVr1X5x_rZ1Li-vIrm7dKbGPreTSguvjiCIK50C1YLhVRxbEMgB04na5CqPILjjD0tMWYyoDFgGZoK7_Bj90xSYSTb5ixznjp443bdJWEI2r5kGPHV9mcPE";
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
