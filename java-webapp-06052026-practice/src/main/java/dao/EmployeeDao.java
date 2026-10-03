package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Employee;

public class EmployeeDao {
	public boolean saveEmployee(Employee employee) {
		boolean isEmployeeSaved = false;

		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbConn.setAutoCommit(false);
			dbStmt = dbConn.createStatement();

			String sqlQuery1 = "INSERT INTO employee_personal(first_name, last_name, date_of_birth) VALUES("; 
			sqlQuery1 += "'" + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getDateOfBirth() + "')";
	
			int numOfRowsAffected = dbStmt.executeUpdate(sqlQuery1, Statement.RETURN_GENERATED_KEYS);
			if (numOfRowsAffected != 0) {
				dbRs = dbStmt.getGeneratedKeys();
				dbRs.next();
				int employeeId = dbRs.getInt(1);
				
				Address address = employee.getAddress();
				
				String sqlQuery2 = "INSERT INTO employee_address(line_1, line_2, line_3, city, state, pincode, employee_id) VALUES("; 
				sqlQuery2 += "'" + address.getLine1() + "', '" + address.getLine2() + "', '" + address.getLine3() + "'";
				sqlQuery2 += ", '" + address.getCity() + "', '" + address.getState() + "', '" + address.getPincode() + "'";
				sqlQuery2 += ", " + employeeId + ")";				
				numOfRowsAffected = dbStmt.executeUpdate(sqlQuery2);
				if (numOfRowsAffected != 0) {
					dbConn.commit();
					
					isEmployeeSaved = true;
				}
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			try {
				dbConn.rollback();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
			
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeSaved;
	}
	
	public List<Employee> findEmployees() {
		List<Employee> employeesList = new ArrayList<>();
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbConn.setAutoCommit(false);
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT employee_id, first_name, last_name, date_of_birth FROM employee_personal";
	
			dbRs = dbStmt.executeQuery(sqlQuery);
			while (dbRs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(dbRs.getInt(1));
				employee.setFirstName(dbRs.getString(2));
				employee.setLastName(dbRs.getString(3));
				employee.setDateOfBirth(dbRs.getString(4));
				
				employeesList.add(employee);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			try {
				dbConn.rollback();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
			
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return employeesList;
	}
	
	public List<Employee> findEmployeesAndAddresses() {
		List<Employee> employeesList = new ArrayList<>();
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbConn.setAutoCommit(false);
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT t1.employee_id, t1.first_name, t1.last_name, t1.date_of_birth, ";
				  sqlQuery += "t2.address_id, t2.line_1, t2.line_2, t2.line_3, t2.city, t2.state, t2.pincode ";
				  sqlQuery += "FROM employee_personal t1 ";
				  sqlQuery += "INNER JOIN employee_address t2 ";
				  sqlQuery += "ON t1.employee_id = t2.employee_id";
	
			dbRs = dbStmt.executeQuery(sqlQuery);
			while (dbRs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(dbRs.getInt(1));
				employee.setFirstName(dbRs.getString(2));
				employee.setLastName(dbRs.getString(3));
				employee.setDateOfBirth(dbRs.getString(4));
				
				Address address = new Address();
				address.setAddressId(dbRs.getInt(5));
				address.setLine1(dbRs.getString(6));
				address.setLine2(dbRs.getString(7));
				address.setLine3(dbRs.getString(8));
				address.setCity(dbRs.getString(9));
				address.setState(dbRs.getString(10));
				address.setPincode(dbRs.getString(11));
				
				employee.setAddress(address);
				
				employeesList.add(employee);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			try {
				dbConn.rollback();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
			
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return employeesList;
	}
	
	public Employee findByEmployeeId(int employeeId) {
		Employee employee = null;
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbConn.setAutoCommit(false);
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT employee_id, first_name, last_name, date_of_birth FROM employee_personal WHERE employee_id=" + employeeId;
	
			dbRs = dbStmt.executeQuery(sqlQuery);
			if (dbRs.next()) {
				employee = new Employee();
				employee.setEmployeeId(dbRs.getInt(1));
				employee.setFirstName(dbRs.getString(2));
				employee.setLastName(dbRs.getString(3));
				employee.setDateOfBirth(dbRs.getString(4));
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			try {
				dbConn.rollback();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
			
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return employee;
	}
	
	public List<Employee> findByLastName(String lastName) {
		List<Employee> employeesList = new ArrayList<>();
		
		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			dbConn.setAutoCommit(false);
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT employee_id, first_name, date_of_birth FROM employee_personal WHERE last_name='" + lastName + "'";
	
			dbRs = dbStmt.executeQuery(sqlQuery);
			while (dbRs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(dbRs.getInt(1));
				employee.setFirstName(dbRs.getString(2));
				employee.setLastName(lastName);
				employee.setDateOfBirth(dbRs.getString(3));
				
				employeesList.add(employee);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			try {
				dbConn.rollback();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
			
			sqlEx.printStackTrace();
		} finally {
			try {
				if (dbRs != null) {
					dbRs.close();
				}
				
				if (dbStmt != null) {
					dbStmt.close();
				}

				if (dbConn != null) {
					dbConn.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return employeesList;
	}
}