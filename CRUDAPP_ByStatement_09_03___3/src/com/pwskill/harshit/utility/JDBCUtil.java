package com.pwskill.harshit.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static Properties properties = null;

	private JDBCUtil() {
	}

	static {

		FileInputStream fileInputStream = null;
		String fileInfo = "/Users/apple/eclipse-workspace/ADVANCED_JAVA/CRUDAPP_ByStatement_09_03___3/src/com/pwskill/harshit/property/database.properties";

		try {
			fileInputStream = new FileInputStream(fileInfo);
			if (fileInputStream != null) {
				properties = new Properties();
				properties.load(fileInputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Connection getDbConnection() throws IOException, SQLException {
		// Establish the Connection
		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
				properties.getProperty("password"));
	}

	// Close Resources
	public static void cleanUpResources(ResultSet resultSet, Statement statement, Connection connection) {

		if (resultSet != null) {
			try {
				// closing ResultSet
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				// closing statement
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				// closing connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
