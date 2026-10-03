package com.codegnan.app.javaapp09052026practice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.codegnan.app.javaapp09052026practice.entity.Employee;


public class EmployeeDao {
	public boolean save(Employee employee) {
		boolean isEmployeeSaved = false;
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.persist(employee);
		
		transaction.commit();
		session.close();
		isEmployeeSaved = true;
		
		return isEmployeeSaved;
		
	}
	
	public Employee findByEmployeeId(int employeeId) {
		Employee employee = null;
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionfactory();
		Session session = sessionFactory.openSession();
		
		Employee tempEmployee = session.get(Employee.class,employeeId);
		if(tempEmployee !=null) {
			employee = new Employee();
			employee.setEmployeeId(tempEmployee.getEmployeeId());
			employee.setFirstName(tempEmployee.getFirstName());
			employee.setLastName(tempEmployee.getLastName());
			employee.setDateOfBirth(tempEmployee.getDateOfBirth());
		}
		
		session.clear();
		
		return employee;
	}
	

}
