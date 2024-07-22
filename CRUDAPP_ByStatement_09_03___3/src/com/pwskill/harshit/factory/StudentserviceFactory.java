package com.pwskill.harshit.factory;

import com.pwskill.harshit.Service.IStudentService;
import com.pwskill.harshit.Service.StudentServiceImpl;

public class StudentserviceFactory {

	private static IStudentService service = null;

	private StudentserviceFactory() {

	}

	public static IStudentService getStudentService() {

		if (service == null) {
			service = new StudentServiceImpl();
		}

		return service;
	}
}