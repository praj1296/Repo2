package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.lti.entity.Customer;

//Data Access Object
public class CustomerDao {

	public void add(Customer customer) { // passing Customer class as object
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Properties dbProps = new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("prod-db.properties"));			

			Class.forName(dbProps.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("username"),dbProps.getProperty("password"));

			String sql = "insert into customer_D values(?,?,?) "; // inserting values into CustomerDB
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customer.getid());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.executeUpdate(); // Update Table

		} catch (Exception e) {
			e.printStackTrace(); // bad, should catch individual exception(s)
		} finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}