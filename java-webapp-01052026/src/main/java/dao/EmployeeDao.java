package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Employee;

public class EmployeeDao {
	public Employee findEmployeeByEmailAddressAndPassword(String emailAddress, String loginPassword) {
		Employee employee = null;

		Connection dbConn = null;
		Statement dbStmt = null;
		ResultSet dbRs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();

			String sqlQuery = "SELECT employee_id, first_name, last_name, date_of_birth FROM employee_personal ";
			sqlQuery += "WHERE email_address='" + emailAddress + "' AND login_password='" + loginPassword + "'";

			dbRs = dbStmt.executeQuery(sqlQuery);
			if (dbRs.next()) {
				employee = new Employee();				
				employee.setEmployeeId(dbRs.getInt(1));
				employee.setFirstName(dbRs.getString(2));
				employee.setLastName(dbRs.getString(3));
				employee.setDateOfBirth(dbRs.getString(4));
				employee.setEmailAddress(emailAddress);
				employee.setLoginPassword(loginPassword);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
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
	
	public boolean saveEmployee(Employee employee) {
		boolean isEmployeeSaved = false;

		Connection dbConn = null;
		Statement dbStmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdg_hyd_jfs_049", "root", "root");
			dbStmt = dbConn.createStatement();

			String sqlQuery = "INSERT INTO employee_personal VALUES("; 
			sqlQuery += employee.getEmployeeId() + ", '" + employee.getFirstName() + "', '" + employee.getLastName() + "', '";
			sqlQuery += employee.getDateOfBirth() + "', '" + employee.getEmailAddress() + "', '" + employee.getLoginPassword() + "')";
	

			int numOfRowsAffected = dbStmt.executeUpdate(sqlQuery);
			if (numOfRowsAffected != 0) {
				isEmployeeSaved = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
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
}