package com.pwskill.harshit.Service;

import java.sql.SQLException;

import com.pwskill.harshit.Student.Student;

public interface IStudentService {

	public int InsertApp(Student student) throws SQLException;

	public int updateApp(Student student, int op) throws SQLException;
	
	public int deleteApp(Student student) throws SQLException;
	
	public boolean SelectApp(Student student) throws SQLException;

}
