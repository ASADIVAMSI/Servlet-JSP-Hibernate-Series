package com.codegnan.app.javaapp14052026practice;

import com.codegnan.app.javaapp14052026practice.service.CustomerService;
import com.codegnan.app.javaapp14052026practice.service.OrderService;
import com.codegnan.app.javaapp14052026practice.service.ProductService;

public class App {
    public static void main(String[] args) {
    	
    OrderService orderService = new OrderService();
      orderService.Operation1();
      orderService.Operation2();
      
      System.out.println();
    	
//    	ProductService.getInstance();
//    	ProductService.getInstance();
//    	ProductService.getInstance();
//    	
//    	CustomerService.getInstance();
//    	CustomerService.getInstance();
//    	CustomerService.getInstance();
    	
    	
    	
//        OrderService orderService = new OrderService();
//        orderService.Operation1();
//        orderService.Operation2();
//        
//        System.out.println();
//        
//        App2.main(args);
        
    }
}
