package com.codegnan.app.javaapp16052026practice;

import com.codegnan.app.javaapp16052026practice.service.CustomerService;
import com.codegnan.app.javaapp16052026practice.service.EcommerceService;
import com.codegnan.app.javaapp16052026practice.service.OrderService;
import com.codegnan.app.javaapp16052026practice.service.ProductService;
import com.codegnan.app.javaapp16052026practice.service.ServiceFactory;

public class App {
    public static void main(String[] args) {
    	ServiceFactory.setUp();
    	
    	EcommerceService customerService = ServiceFactory.getService("customer");
    	customerService.operation1();
    	customerService.operation2();
    	
    	
    	EcommerceService productService = ServiceFactory.getService("product");
    	customerService.operation1();
    	customerService.operation2();
    	
    	App3.main(args);
    
    }
}
