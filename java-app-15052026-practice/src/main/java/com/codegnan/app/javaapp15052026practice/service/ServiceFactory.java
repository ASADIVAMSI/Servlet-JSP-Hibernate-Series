package com.codegnan.app.javaapp15052026practice.service;


public class ServiceFactory  {
	
	static CustomerService customerService;
	static OrderService orderService;
	static PaymentService paymentService;
	static ProductService productService;
	static SellerService sellerService;
	static ShipmentService shipmentService;
	
	public static void setUp(){
		customerService = new CustomerService();
		orderService = new OrderService();
		sellerService = new SellerService();
		
		productService.setSellerService(sellerService);
		sellerService.setProductService(productService);
		
		orderService = new OrderService(customerService,productService);
		paymentService = new PaymentService(customerService,sellerService,orderService);
		
		productService.setSellerService(sellerService);
		sellerService.setProductService(productService);
	}
	
	public static EcommerceService getService(String serviceName) {
		EcommerceService ecommerceService = null;
		
		if(serviceName.equals("customer")) {
			ecommerceService = customerService;
		}else if(serviceName.equals("order")) {
			ecommerceService = orderService;
		}else if(serviceName.equals("payment")) {
			ecommerceService = paymentService;
		}else if(serviceName.equals("product")) {
			ecommerceService = productService;
		}else if(serviceName.equals("seller")) {
			ecommerceService = sellerService;
		}else if(serviceName.equals("shipment")) {
			ecommerceService = shipmentService;
		}
		
		return null;
	}
	

}
