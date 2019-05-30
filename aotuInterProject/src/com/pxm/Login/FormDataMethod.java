package com.pxm.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author pengxiaoming
 * form-data接口方法
 *
 */
public class FormDataMethod {
	/**
	 * 以form表单形式提交数据，发送post请求
	 * @explain 
	 *   1.请求头：httppost.setHeader("Content-Type","application/x-www-form-urlencoded")
	 *   2.提交的数据格式：key1=value1&key2=value2...
	 * @param url 请求地址
	 * @param paramsMap 具体数据
	 * @return 服务器返回数据
	 */
	public static String httpPostWithForm(String url,Map<String, String> paramsMap){
	    // 用于接收返回的结果
	    String resultData ="";
	     try {
	            HttpPost post = new HttpPost(url);
	            List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
	            // 迭代Map-->取出key,value放到BasicNameValuePair对象中-->添加到list中
	            for (String key : paramsMap.keySet()) {
	                pairList.add(new BasicNameValuePair(key, paramsMap.get(key)));
	            }
	            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairList, "utf-8");
	            post.setEntity(uefe); 
	            // 创建一个http客户端
	            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	            // 发送post请求
	            HttpResponse response = httpClient.execute(post);
	            
	            // 状态码为：200
	            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	                // 返回数据：
	                resultData = EntityUtils.toString(response.getEntity(),"UTF-8");
	            }else{
	                throw new RuntimeException("接口连接失败！");
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("接口连接失败！");
	        }
	     return resultData;
	}
	
	/**
	 * 
	 * @param url
	 * @param paramsMap
	 * @return resultData
	 * 
	 */
	public static String httpGetWithForm(String url,String paramsMap){
	    // 用于接收返回的结果
	    String resultData ="";
	     try {
	            HttpGet get = new HttpGet(url);           
	            get.setHeader(url, paramsMap);
	            // 创建一个http客户端
	            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	            // 发送post请求
	            HttpResponse response = httpClient.execute(get);
	            
	            // 状态码为：200
	            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	                // 返回数据：
	                resultData = EntityUtils.toString(response.getEntity(),"UTF-8");
	            }else{
	                throw new RuntimeException("接口连接失败！");
	            }
	        } catch (Exception e) {
	            throw new RuntimeException("接口连接失败！");
	        }
	     return resultData;
	}
}

