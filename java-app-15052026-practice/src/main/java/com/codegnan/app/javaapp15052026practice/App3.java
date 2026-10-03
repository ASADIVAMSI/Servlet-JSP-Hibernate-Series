package com.codegnan.app.javaapp15052026practice;

import com.codegnan.app.javaapp15052026practice.service.EcommerceService;
import com.codegnan.app.javaapp15052026practice.service.OrderService;
import com.codegnan.app.javaapp15052026practice.service.PaymentService;
import com.codegnan.app.javaapp15052026practice.service.SellerService;
import com.codegnan.app.javaapp15052026practice.service.ServiceFactory;
import com.codegnan.app.javaapp15052026practice.service.ShipmentService;

public class App3 {
    public static void main(String[] args) {
    	
    	EcommerceService sellerService = ServiceFactory.getService("seller");
    	sellerService.operation1();
    	sellerService.operation2();
    	
    	EcommerceService paymentService = ServiceFactory.getService("payment");
    	paymentService.operation1();
    	paymentService.operation2();
    }
}
