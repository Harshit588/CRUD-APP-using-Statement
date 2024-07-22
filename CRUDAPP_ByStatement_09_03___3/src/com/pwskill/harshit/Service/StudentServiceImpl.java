package com.pwskill.harshit.Service;

import java.sql.SQLException;

import com.pwskill.harshit.Repository.IStudentRepo;
import com.pwskill.harshit.Student.Student;
import com.pwskill.harshit.factory.StudentRepoFactory;

public class StudentServiceImpl implements IStudentService {

	@Override
	public int InsertApp(Student student) throws SQLException {

		IStudentRepo repo = StudentRepoFactory.getStudentRepo();

		return repo.InsertApp(student);

	}

	@Override
	public int updateApp(Student student, int op) throws SQLException {
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.updateApp(student, op);
	}

	@Override
	public int deleteApp(Student student) throws SQLException {
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.deleteApp(student);
	}

	@Override
	public boolean SelectApp(Student student) throws SQLException {
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.SelectApp(student);
	}

}
