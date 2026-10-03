package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfs_049", "root", "root");
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
}