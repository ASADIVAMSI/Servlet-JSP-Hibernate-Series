package com.codegnan.app.javaapp14052026practice.service;

//SINGLETON PETTERN CLASS ->JVM CAN CREATE ONLY ONE OBJ   NO MORE THEN ONE IS CALL SINGLETON CLASS PETTERN.
public class CustomerService {
	//PRIVATE -> CLASS LEVEL SCOPE
	//STATIC VARIABLE-> INITILAIZING MEMORY ONE'S
	private static CustomerService  customerService = new CustomerService();
	
	private CustomerService() {
		System.out.println("CustomerService()");
	}
	//STATIC METHOD ->CALL DIRECTLY  USING CLASS NAME (NO NEED TO CREATE AN OBJECT).
								//getObj
	public static CustomerService getInstance() {
		return customerService;
	}
	
	public void Operation1() {
		System.out.println("Operation 1 from CustomerService");
	}
	
	public void Operation2() {
		System.out.println("Operation 2 from CustomerService");
	}

}
