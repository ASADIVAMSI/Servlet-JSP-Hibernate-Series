package com.codegnan.app.javaapp14052026practice.service;

public class ShipmentService {
	//DEPENDENCIES
	OrderService orderservice = new OrderService();
	
	public ShipmentService() {
		System.out.println("ShipmentService()");
	}
	
	
	
	public void Operation1() {
		System.out.println("Operation 1 from ShipmentService");
		
		
        orderservice.Operation1();
	}
	
	public void Operation2() {
		System.out.println("Operation 2 from ShipmentService");
	}

}
