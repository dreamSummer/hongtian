package com.hotent.core.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * http操作类
 *
 */
public class HttpUtil {
	
	/**
	 * 发送数据到指定的URL并读取返回结果。
	 * @param url
	 * @param data
	 * @return
	 */
	public static String sendData(String url,String data,String charset){
		URL uRL;
		URLConnection conn;
		
		BufferedReader bufferedReader = null;
		try {
			uRL = new URL(url);
			conn = uRL.openConnection();
			conn.setDoOutput(true);
			if(StringUtil.isNotEmpty(data)){
				OutputStream stream=conn.getOutputStream();
				stream.write(data.getBytes(charset));
				stream.flush();
				stream.close();
			}
			

			// Get the response
			bufferedReader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuffer response = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}

			bufferedReader.close();
			
			return response.toString();
		}
		 catch (MalformedURLException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	/**
	 * 根据url取得数据，支持gzip类网站
	 * @param url
	 * @param charset
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String getContentByUrl(String url,String charset) throws ParseException, IOException
	{
		HttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		
		
		if(StringUtil.isEmpty(charset)){
			String defaultCharset="iso-8859-1";
			Header contentTypeHeader=response.getFirstHeader("Content-Type");
			String contentType=contentTypeHeader.getValue().toLowerCase();
			if(contentType.indexOf("gbk")>-1 || contentType.indexOf("gb2312") >-1 || contentType.indexOf("gb18030")>-1){
				defaultCharset="gb18030";
			}
			else if(contentType.indexOf("utf-8")>-1){
				defaultCharset="utf-8";
			}
			else if(contentType.indexOf("big5")>-1){
				defaultCharset="big5";
			}
			charset=defaultCharset;
		}
		Header contentEncoding=response.getFirstHeader("Content-Encoding");
		StatusLine line=response.getStatusLine();
		if(line.getStatusCode()==200)
		{
			HttpEntity entity = response.getEntity();
			InputStream is;
			if(contentEncoding!=null && contentEncoding.getValue().toLowerCase().equals("gzip"))
			{
				 is=new GZIPInputStream( entity.getContent());
			}
			else
			{
				is=entity.getContent();
			}
			String str=FileUtil.inputStream2String(is, charset);
			is.close();
			return str;
			 
		}
		return "";
	}
	
	
	public static String getContentByUrl(String url) throws ParseException, IOException
	{
		return getContentByUrl(url,"");
	}
	
	/**
	 * 保存远程文件到本地
	 * @param remoteFile 远程文件
	 * @param localFile  本地文件
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void saveRemoteFile(String remoteFile,String localFile) throws ParseException, IOException
	{
		HttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(remoteFile);
		HttpResponse response = httpclient.execute(httpget);
		Header contentEncoding=response.getFirstHeader("Content-Encoding");
		StatusLine line=response.getStatusLine();
		if(line.getStatusCode()==200)
		{
			HttpEntity entity = response.getEntity();
			InputStream is;
			if(contentEncoding!=null && contentEncoding.getValue().toLowerCase().equals("gzip")){
				 is=new GZIPInputStream( entity.getContent());
			}
			else{
				is=entity.getContent();
			}
			FileUtil.createFolder(localFile, true);
			FileOutputStream fs = new FileOutputStream(localFile); 
			
			int bytesum = 0; 
			int byteread = 0; 
			byte[] buffer = new byte[30000]; 
			while ((byteread = is.read(buffer)) != -1){ 
				bytesum += byteread; // 字节数 文件大小 
				fs.write(buffer, 0, byteread); 
			} 
			is.close();
			fs.close();
		}
		
	}
	
	
	/**
	 * 发送请求。
	 * 
	 * @param url
	 *            URL地址
	 * @param params
	 *            发送参数
	 * @param requestMethod
	 *            GET,POST
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static String sendHttpsRequest(String url, String params,
			String requestMethod) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		HttpsURLConnection conn = getHttpsConnection(url);
		conn.setRequestMethod(requestMethod);

		conn.setDoInput(true);
		conn.setDoOutput(true);

		if (StringUtil.isNotEmpty(params)) {
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(params.getBytes("utf-8"));
			outputStream.close();
		}

		String str = getOutPut(conn);

		return str;
	}

	/**
	 * 获取https连接。
	 * @param accessUrl
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsConnection(String accessUrl)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		URL url = new URL(accessUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url
				.openConnection();

		TrustManager[] tm = { new MyX509TrustManager() };

		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		connection.setSSLSocketFactory(ssf);
		return connection;
	}

	/**
	 * 读取返回数据。
	 * 
	 * @param conn
	 * @return
	 * @throws IOException
	 */
	public static String getOutPut(HttpsURLConnection conn) throws IOException {
		InputStream inputStream = conn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer buffer = new StringBuffer();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		conn.disconnect();
		return buffer.toString();
	}

	/**
	 * 上传附件到服务器。
	 * @param url			服务器接收文件地址	
	 * @param filePath		本地文件路径
	 * @return
	 * @throws IOException
	 */
	public static String uploadFile(String url, String filePath) throws IOException {

		String result = null;

		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		/**
		 * 第一部分
		 */
		URL urlObj = new URL(url);
		// 连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		/**
		 * 设置关键值
		 */
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);

		// 请求正文信息

		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}

		}
		return result;
		
	}
	



}
