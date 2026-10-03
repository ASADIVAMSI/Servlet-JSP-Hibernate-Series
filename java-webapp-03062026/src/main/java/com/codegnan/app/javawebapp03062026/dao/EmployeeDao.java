package com.codegnan.app.javawebapp03062026.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.app.javawebapp03062026.entity.Employee;

													//ENTITY CLASS MAPPED WITH THE TABLE
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
																//TYPE OF IDENTIFIER COLUMN IN THE TABLE
	Employee findByEmailAddressAndLoginPassword(String emailAddress, String loginPassword);
}