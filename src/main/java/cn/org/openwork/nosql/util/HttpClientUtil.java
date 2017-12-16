/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  HttpClientUtil.java   
 * @Package cn.bqjr.mysqleye.util   
 * @Description:    HttpClient工具类
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年3月9日 下午4:50:50   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.util;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName: HttpClientUtil
 * @Description:HttpClient工具类
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月9日 下午4:50:50
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class HttpClientUtil {
	public static String get(String url){
		String responseContent="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			
			
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			
			RequestConfig requestConfig = RequestConfig.custom()    
			        .setConnectTimeout(5000).setConnectionRequestTimeout(1000)    
			        .setSocketTimeout(1000).build();    
			httpget.setConfig(requestConfig);  
			
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: " + entity.getContentLength());
					responseContent=EntityUtils.toString(entity);
					// 打印响应内容
					System.out.println("Response content: " + responseContent);
				}
				System.out.println("------------------------------------");
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}

	public final static void main(String[] args) throws Exception {
		get("http://10.89.0.143/10.89.0.137_3306_mysql_summary/mysql-status");
	}
}
