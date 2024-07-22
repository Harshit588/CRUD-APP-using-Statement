package com.pwskill.harshit.factory;

import com.pwskill.harshit.Repository.IStudentRepo;
import com.pwskill.harshit.Repository.StudentRepoImpl;

public class StudentRepoFactory {
	private static IStudentRepo Studentrepo = null;

	private StudentRepoFactory() {

	}

	public static IStudentRepo getStudentRepo() {

		if (Studentrepo == null) {
			Studentrepo = new StudentRepoImpl();
		}
		return Studentrepo;
	}
	
}
