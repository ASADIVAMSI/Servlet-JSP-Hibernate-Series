package com.codegnan.app.javaapp11052026.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.codegnan.app.javaapp11052026.entity.Employee;

import jakarta.persistence.Query;

public class EmployeeDao {
	public boolean save(Employee employee) {
		boolean isEmployeeSaved = false;

		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
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
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee tempEmployee = session.get(Employee.class, employeeId);
		if (tempEmployee != null) {
			employee = new Employee();
			employee.setEmployeeId(tempEmployee.getEmployeeId());
			employee.setFirstName(tempEmployee.getFirstName());
			employee.setLastName(tempEmployee.getLastName());
			employee.setDateOfBirth(tempEmployee.getDateOfBirth());
		}
		
		session.close();
		
		return employee;
	}
	
	public List<Employee> findEmployees() {
		List<Employee> employeesList = new ArrayList<>();
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String hqlQuery = "FROM Employee";
		Query query = session.createQuery(hqlQuery, Employee.class);
		
		List<Employee> listOfEmployees = query.getResultList();
		employeesList.addAll(listOfEmployees);
		
		session.close();
		
		return employeesList;
	}
	
	public List<Employee> findByLastName(String lastName) {
		List<Employee> employeesList = new ArrayList<>();
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String hqlQuery = "FROM Employee e WHERE e.lastName='" + lastName + "'";
		Query query = session.createQuery(hqlQuery, Employee.class);
		
		List<Employee> listOfEmployees = query.getResultList();
		employeesList.addAll(listOfEmployees);
		
		session.close();
		
		return employeesList;
	}
	
	public List<String> findFirstNames() {
		List<String> firstNamesList = new ArrayList<>();
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String hqlQuery = "SELECT e.firstName FROM Employee e";
		Query query = session.createQuery(hqlQuery, Object[].class);
		
		List<Object[]> listOfFirstNames = query.getResultList();
		for (Object[] firstNameArr : listOfFirstNames) {
			String firstName = (String)firstNameArr[0];
			
			firstNamesList.add(firstName);
		}
		
		session.close();
		
		return firstNamesList;
	}
	
	public boolean updateDateOfBirth(int employeeId, String newDateOfBirth) {
		boolean isDateOfBirthUpdated = false;
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			employee.setDateOfBirth(newDateOfBirth);
			
			session.merge(employee);
		
			transaction.commit();
			isDateOfBirthUpdated = true;
		}		
		
		session.close();
		
		return isDateOfBirthUpdated;
	}
	
	public boolean remove(int employeeId) {
		boolean isEmployeeRemoved = false;
		
		SessionFactory sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			session.remove(employee);
		
			transaction.commit();
			isEmployeeRemoved = true;
		}		
		
		session.close();
		
		return isEmployeeRemoved;
	}
}