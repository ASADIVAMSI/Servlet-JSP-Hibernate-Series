package com.codegnan.app.javaapp15052026practice.service;

//SINGLETON PETTERN CLASS 
public class CustomerService  implements EcommerceService{
	
	
	protected CustomerService() {
		System.out.println("CustomerService()");
	}
	
	public void operation1() {
		System.out.println("Operation 1 from CustomerService");
	}
	
	public void operation2() {
		System.out.println("Operation 2 from CustomerService");
	}

}
