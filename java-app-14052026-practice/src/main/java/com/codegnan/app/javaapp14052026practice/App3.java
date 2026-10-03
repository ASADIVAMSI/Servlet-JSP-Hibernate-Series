package com.codegnan.app.javaapp14052026practice;

import com.codegnan.app.javaapp14052026practice.service.OrderService;
import com.codegnan.app.javaapp14052026practice.service.PaymentService;
import com.codegnan.app.javaapp14052026practice.service.SellerService;
import com.codegnan.app.javaapp14052026practice.service.ShipmentService;

public class App3 {
    public static void main(String[] args) {
    	
        ShipmentService  shipmentservice = new ShipmentService();
        shipmentservice.Operation1();
        shipmentservice.Operation2();
        
        PaymentService  paymentservice  = new PaymentService();
        paymentservice.Operation1();
        paymentservice.Operation2();
        
        
        SellerService sellerservice = new SellerService();
        sellerservice.Operation1();
        
        
        
        
    }
}
