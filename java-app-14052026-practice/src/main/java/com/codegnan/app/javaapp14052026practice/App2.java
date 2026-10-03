package com.codegnan.app.javaapp14052026practice;

import com.codegnan.app.javaapp14052026practice.service.OrderService;

public class App2 {
    public static void main(String[] args) {
    	
        OrderService orderService = new OrderService();
        orderService.Operation1();
        orderService.Operation2();
        
        App3.main(args);
        
    }
}
