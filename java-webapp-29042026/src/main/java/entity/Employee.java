package entity;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String emailAddress;
	private String loginPassword;
	
	public Employee() {
		
	}
	
	public Employee(int employeeId, String firstName, String lastName, String dateOfBirth, String emailAddress,
			String loginPassword) {
		super();
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
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Override
	public String toString() {
		return "EmployeeList [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + ", loginPassword=" + loginPassword
				+ "]";
	}
	

}
