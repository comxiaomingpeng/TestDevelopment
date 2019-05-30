package com.pxm.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
	    System.out.println("返回结果："+resultData);
        
     
        //type=1;
        //userName="18601632189";
        //Pwd="dc483e80a7a0bd9ef71d8cf973673924";
       /* String Info="type"+"="+"1"+"&"+"mobile"+"="+"18601632189"+"&"+"password"+"="+"dc483e80a7a0bd9ef71d8cf973673924";
        Reporter.log(URLConnection.GetResponse(Info));
        Reporter.log(Info);*/
        /*Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
        httpResult=weather.getHttpRespone(cityCode);
        Reporter.log("请求地址: "+weather.geturl());
        Reporter.log("返回结果: "+httpResult);
        weatherinfo=Common.getJsonValue(httpResult, "weatherinfo");
        city=Common.getJsonValue(weatherinfo, "city");
        Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city);*/
    }
    @Test(groups = { "BaseCase"})
    public void currency_price() throws IOException{
    	String ADD_URL ="https://service.magicdapps.com/api/openApi/currencyPrice";
    	String method = "POST";
    	JsonMethod.appadd(ADD_URL,method);
    }
    @Test(groups = { "BaseCase"})
    public void login_out() throws IOException{
    	String requestUrl = "https://service.magicdapps.com/api/auth/login/loginOut";
	    String paramsMap = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxODYwMTYzMjE4OSIsInVzZXJJZCI6IjE5IiwibmFtZSI6IjE4NioqKioyMTg5IiwiZXhwIjoxNTU5NzI2MTUzfQ.Zy0LU13wa0dGizOI8NBDSGr7F6LdGE6VzpUtBGZTM-vpt_b95DtzGVr1X5x_rZ1Li-vIrm7dKbGPreTSguvjiCIK50C1YLhVRxbEMgB04na5CqPILjjD0tMWYyoDFgGZoK7_Bj90xSYSTb5ixznjp443bdJWEI2r5kGPHV9mcPE";
    	String resultData = FormDataMethod.httpGetWithForm(requestUrl, paramsMap);
	    System.out.println("返回结果："+resultData);
        
    }
}
