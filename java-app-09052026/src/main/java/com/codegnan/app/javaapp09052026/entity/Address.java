package com.codegnan.app.javaapp09052026.entity;

public class Address {
	private int addressId;
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String state;
	private String pincode;
	private int employeeId;

	public Address() {
	}

	public Address(int addressId, String line1, String line2, String line3, String city, String state, String pincode, int employeeId) {
		this.addressId = addressId;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.employeeId = employeeId;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getLine3() {
		return line3;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", employeeId=" + employeeId + "]";
	}
}