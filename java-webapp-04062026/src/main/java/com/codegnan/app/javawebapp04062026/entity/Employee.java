package com.codegnan.app.javawebapp04062026.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employee_personal")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "first_name")
	@NotBlank(message = "First Name cannot be left blank")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Last Name cannot be left blank")
	private String lastName;
	@Column(name = "date_of_birth")
	@NotBlank(message = "Date of Birth cannot be left blank")
	private String dateOfBirth;
	@Column(name = "email_address")
	@NotBlank(message = "Email Address cannot be left blank")
	private String emailAddress;
	@Column(name = "login_password")
	@NotBlank(message = "Login Password cannot be left blank")
	private String loginPassword;

	public Employee() {
	}

	public Employee(int employeeId, String firstName, String lastName, String dateOfBirth, String emailAddress,
			String loginPassword) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.loginPassword = loginPassword;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + ", loginPassword=" + loginPassword
				+ "]";
	}
}