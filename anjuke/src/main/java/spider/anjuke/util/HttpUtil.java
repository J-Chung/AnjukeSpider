package spider.anjuke.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtil {

	//private static final String COOKIE = "q_c1=1f7d1580f49345b9bd90673faa52f875|1468810259000|1460541358000; _zap=28161fd2-3adc-4479-aac7-84a2d78777c5; d_c0=\"AHBA-8zWwwmPTp2RHmqUVLycON_G_VCsJUo=|1460541359\"; _za=37a26eda-eaef-4c74-b896-36ca0171f2b5; __utma=155987696.260420154.1463557836.1470293332.1470293332.1; __utmz=155987696.1470293332.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ga=GA1.2.260420154.1463557836; l_cap_id=\"YWVhMTM3ZThmODlhNDM5NTk4ODhiZjRiNzU5ZjI1YTE=|1470217406|a25a47fb7822552a43f475eefccd99051633b029\"; cap_id=\"MTQxYmM0YTAxYTA3NDA1Y2IzZDkzNzFjNjAxNjI4NDg=|1470217406|391701adf3aeedefd44bdb5679c741edd4ac2d6f\"; _xsrf=0610e59b006a2cfe9e476c7ebbdc7507; __utmc=155987696; s-q=%E5%8D%B0%E8%B1%A1%E7%AC%94%E8%AE%B0%E6%94%B6%E8%B4%B9; s-i=6; sid=hn2t7abk; s-t=autocomplete; n_c=1; a_t=\"2.0AADAU20mAAAXAAAAyzPKVwAAwFNtJgAAAHBA-8zWwwkXAAAAYQJVTSxKyVcAJGBACBdTsMQ2ho3nbMk51zyUShHbHP5EM5pFsCWZ6F599HoUbZjcmw==\"; z_c0=Mi4wQUFEQVUyMG1BQUFBY0VEN3pOYkRDUmNBQUFCaEFsVk5MRXJKVndBa1lFQUlGMU93eERhR2plZHN5VG5YUEpSS0VR|1470217516|5334cc23296859ce4c5c8b6662295be65520a9e9; __utmb=155987696.2.10.1470293332";
	private static final String COOKIE = "";

	
	public static String post(String url, Map<String, String> params) {
		// 创建httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 返回值
			String body = null;
			// 创建post方法
			HttpPost httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if (params != null) {
				// 取出key
				for (String rk : params.keySet()) {
					// 设置对应key,value
					nvps.add(new BasicNameValuePair(rk, params.get(rk)));
				}
			}
			// 组合链接参数
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			// 创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// 执行httppost
			body = httpclient.execute(httpPost, responseHandler);
			// 关闭流
			httpclient.close();
			return body;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String get(String url, Map<String, String> params) {
		// 创建httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 返回值
			String body = null;
			// 创建get
			HttpGet httpGet = new HttpGet(url);
			// cookie
			httpGet.setHeader("cookie", COOKIE);
			// 设置参数
			if (params != null) {
				// 链接后+？拼接get请求参数
				url += "?";
				// 取出key
				if (params.size() > 1) {
					for (String rk : params.keySet()) {
						// 设置对应参数
						url += rk + "=" + params.get(rk) + "&";
					}
				} else {
					for (String rk : params.keySet()) {
						// 设置对应参数
						url += rk + "=" + params.get(rk);
					}
				}
			}
			// 创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// 执行httppost
			body = httpclient.execute(httpGet, responseHandler);
			// 关闭流
			httpclient.close();
			return body;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
