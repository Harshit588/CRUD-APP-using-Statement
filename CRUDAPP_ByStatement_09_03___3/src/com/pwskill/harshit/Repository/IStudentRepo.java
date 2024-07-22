package com.pwskill.harshit.Repository;

import java.sql.SQLException;

import com.pwskill.harshit.Student.Student;

public interface IStudentRepo {

	public int InsertApp(Student student) throws SQLException;

	public int updateApp(Student student, int op) throws SQLException;
	
	public int deleteApp(Student student) throws SQLException;

	public boolean SelectApp(Student student) throws SQLException;
}
