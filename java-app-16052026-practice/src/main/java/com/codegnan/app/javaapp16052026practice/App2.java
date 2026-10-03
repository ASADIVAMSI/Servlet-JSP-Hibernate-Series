package com.codegnan.app.javaapp16052026practice;

import com.codegnan.app.javaapp16052026practice.service.EcommerceService;
import com.codegnan.app.javaapp16052026practice.service.OrderService;
import com.codegnan.app.javaapp16052026practice.service.ServiceFactory;

public class App2 {
    public static void main(String[] args) {
    	EcommerceService orderService = ServiceFactory.getService("order");
    	
    	orderService.operation1();
    	orderService.operation2();
    	
    	
    	EcommerceService shipmentService = ServiceFactory.getService("shipment");
    	shipmentService.operation1();
    	shipmentService.operation2();
    	
    	App3.main(args);
    	
    }
}
