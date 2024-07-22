package com.pwskill.harshit.Controller;

import java.sql.SQLException;

import com.pwskill.harshit.Student.Student;

public interface IStudentController {

	public int InsertApp(Student student) throws SQLException;

	public int updateApp(Student student, int op) throws SQLException;
	
	public int DeleteApp(Student student) throws SQLException;
	
	public boolean SelectApp(Student student) throws SQLException;

}
