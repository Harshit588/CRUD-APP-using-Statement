package com.pwskill.harshit.Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskill.harshit.Student.Student;
import com.pwskill.harshit.utility.JDBCUtil;

public class StudentRepoImpl implements IStudentRepo {

	private static Connection dbConnection = null;
	private Statement statement = null;
	private int update = 0;

	static {
		try {
			dbConnection = JDBCUtil.getDbConnection();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int InsertApp(Student student) throws SQLException {

		if (dbConnection != null)
			statement = dbConnection.createStatement();

		if (statement != null) {
			String InsertSqlQuery = String.format("insert into Student values(%d,'%s',%d,'%s')", Student.getSid(),
					Student.getSname(), Student.getSage(), Student.getSaddress());

			return statement.executeUpdate(InsertSqlQuery);
		}
		JDBCUtil.cleanUpResources(null, statement, dbConnection);

		return 0;
	}

	@Override
	public int updateApp(Student student, int op) throws SQLException {
		String UpdateSqlQuery = null;
		int update = 0;

		if (dbConnection != null)
			statement = dbConnection.createStatement();

		if (statement != null) {

			if (op == 1) {
				UpdateSqlQuery = "update student set sname= '" + Student.getSname() + "' where sid = "
						+ Student.getSid() + "";
				update = statement.executeUpdate(UpdateSqlQuery);
			} else if (op == 2) {
				UpdateSqlQuery = "update student set sage=" + Student.getSage() + " where sid = " + Student.getSid()
						+ "";
				update = statement.executeUpdate(UpdateSqlQuery);
			} else if (op == 3) {
				UpdateSqlQuery = "update student set saddress= '" + Student.getSaddress() + "' where sid = "
						+ Student.getSid() + "";
				update = statement.executeUpdate(UpdateSqlQuery);
			}

			if (update == 0) {
				System.out.println("No Data Found....");
			}
		}

		JDBCUtil.cleanUpResources(null, statement, dbConnection);

		return update;
	}

	public int deleteApp(Student student) throws SQLException {

		if (dbConnection != null)
			statement = dbConnection.createStatement();

		String DeleteSqlQuery = "delete from Student where sid = " + Student.getSid() + "";
		if (statement != null && DeleteSqlQuery != null) {
			update = statement.executeUpdate(DeleteSqlQuery);
			if (update == 0) {
				System.out.println("No data Found....");
				System.exit(0);
			}
		}
		return update;
	}

	public boolean SelectApp(Student student) throws SQLException {

		if (dbConnection != null)
			statement = dbConnection.createStatement();

		ResultSet resultSet = null;
		if (statement != null) {
			String SelectQuery = "select * from Student where sid = " + Student.getSid() + " ";
			resultSet = statement.executeQuery(SelectQuery);
		}

		if (resultSet != null) {

			if (resultSet.next()) {
				System.out.println("\nSID\tSNAME\tSAGE\tSADDRESS");
				System.out.println("++++++++++++++++++++++++++++++++");
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
						+ "\t" + resultSet.getString(4));
				System.out.println("++++++++++++++++++++++++++++++++");
			} else {
				System.out.println("\nSorry No Data Here....");
			}
		}
		return false;

	}

}