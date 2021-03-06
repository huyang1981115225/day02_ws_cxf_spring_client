package com.atguigu.day02_ws_cxf_spring.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.9
 * 2014-03-12T11:20:48.018+08:00
 * Generated source version: 2.5.9
 * 
 */
@WebService(targetNamespace = "http://ws.day02_ws_cxf_spring.atguigu.com/", name = "OrderWS")
@XmlSeeAlso({ObjectFactory.class})
public interface OrderWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getOrderById", targetNamespace = "http://ws.day02_ws_cxf_spring.atguigu.com/", className = "com.atguigu.day02_ws_cxf_spring.ws.GetOrderById")
    @WebMethod
    @ResponseWrapper(localName = "getOrderByIdResponse", targetNamespace = "http://ws.day02_ws_cxf_spring.atguigu.com/", className = "com.atguigu.day02_ws_cxf_spring.ws.GetOrderByIdResponse")
    public com.atguigu.day02_ws_cxf_spring.ws.Order getOrderById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );
}
