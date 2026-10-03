package com.codegnan.app.javaapp12052026.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passport_id")
	private int passportId;
	
	@Column(name="number")
	private String number;
	
	@Column(name="type")
	private String type;
	
	@Column(name="issue_date")
	private String issueDate;
	
	@Column(name="expiry_date")
	private String expityDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="citizen_id")
	private Citizen citizen;
	
	
	public Passport() {
	}


	public Passport(int passportId, String number, String type, String issueDate, String expityDate, Citizen citizen) {
		super();
		this.passportId = passportId;
		this.number = number;
		this.type = type;
		this.issueDate = issueDate;
		this.expityDate = expityDate;
		this.citizen = citizen;
	}


	public int getPassportId() {
		return passportId;
	}


	public String getNumber() {
		return number;
	}


	public String getType() {
		return type;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public String getExpityDate() {
		return expityDate;
	}


	public Citizen getCitizen() {
		return citizen;
	}


	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public void setExpityDate(String expityDate) {
		this.expityDate = expityDate;
	}


	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}


	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", number=" + number + ", type=" + type + ", issueDate="
				+ issueDate + ", expityDate=" + expityDate + ", citizen=" + citizen + "]";
	}

	
	
	

	
}