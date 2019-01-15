package com.atguigu.day01_ws_cxf_client.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用HttpURLConnection发送webservice请求
 */
public class HttpURLConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("doPost "+name);
		
		String data = "<soap:Envelope xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body><ns2:sayHello xmlns:ns2='http://ws.day01_ws.atguigu.com/'><arg0>"+name+"</arg0></ns2:sayHello></soap:Body></soap:Envelope>";
		URL url = new URL("http://localhost:7777/day01_ws/datatypews");
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
		
		OutputStream os = connection.getOutputStream();
		os.write(data.getBytes("utf-8"));
		
		int responseCode = connection.getResponseCode();
		if(responseCode==200) {
			InputStream is = connection.getInputStream();//String xml
			System.out.println("return "+is.available());
			
			response.setContentType("text/xml;charset=utf-8");
			ServletOutputStream outputStream = response.getOutputStream();
			
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=is.read(buffer))>0) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.flush();
		}
	}

}
