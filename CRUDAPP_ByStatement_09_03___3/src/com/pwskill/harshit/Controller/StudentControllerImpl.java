package com.pwskill.harshit.Controller;

import java.sql.SQLException;

import com.pwskill.harshit.Repository.IStudentRepo;
import com.pwskill.harshit.Service.IStudentService;
import com.pwskill.harshit.Student.Student;
import com.pwskill.harshit.factory.StudentRepoFactory;
import com.pwskill.harshit.factory.StudentserviceFactory;

public class StudentControllerImpl implements IStudentController {

	@Override
	public int InsertApp(Student student) throws SQLException {

		IStudentService service = StudentserviceFactory.getStudentService();

		return service.InsertApp(student);

	}

	@Override
	public int updateApp(Student student, int op) throws SQLException {

		IStudentService service = StudentserviceFactory.getStudentService();

		return service.updateApp(student, op);
	}

	@Override
	public int DeleteApp(Student student) throws SQLException {

		IStudentService service = StudentserviceFactory.getStudentService();

		return service.deleteApp(student);
	}

	@Override
	public boolean SelectApp(Student student) throws SQLException {

		IStudentRepo repo = StudentRepoFactory.getStudentRepo();

		return repo.SelectApp(student);
	}
}