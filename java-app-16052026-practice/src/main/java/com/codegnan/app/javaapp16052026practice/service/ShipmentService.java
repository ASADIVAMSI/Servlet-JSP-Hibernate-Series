package com.codegnan.app.javaapp16052026practice.service;

public class ShipmentService implements EcommerceService{
	//DEPENDENCIES
	OrderService orderService;
	
	protected ShipmentService(OrderService orderService) {
		System.out.println("ShipmentService(orderService)");
		
		this.orderService=orderService;
	}
	
	protected ShipmentService() {
		System.out.println("ShipmentService()");
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	public void operation1() {
		System.out.println("Operation 1 from ShipmentService");
		
		
		orderService.operation1();
	}
	
	public void operation2() {
		System.out.println("Operation 2 from ShipmentService");
	}

}
