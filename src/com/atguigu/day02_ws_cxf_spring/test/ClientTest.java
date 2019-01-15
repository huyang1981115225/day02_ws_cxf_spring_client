package com.atguigu.day02_ws_cxf_spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.day02_ws_cxf_spring.ws.Order;
import com.atguigu.day02_ws_cxf_spring.ws.OrderWS;

public class ClientTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]  {"client-beans.xml"});
		OrderWS orderWS = (OrderWS) context.getBean("orderClient");
		Order order = orderWS.getOrderById(24);
		System.out.println(order);
	}
}
