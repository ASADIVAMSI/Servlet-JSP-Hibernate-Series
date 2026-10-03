package com.codegnan.app.javawebapp09062026.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.app.javawebapp09062026.entity.Employee;

													
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
																
	Employee findByEmailAddressAndLoginPassword(String emailAddress, String loginPassword);
}