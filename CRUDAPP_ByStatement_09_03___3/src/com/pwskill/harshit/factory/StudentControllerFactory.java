package com.pwskill.harshit.factory;

import com.pwskill.harshit.Controller.IStudentController;
import com.pwskill.harshit.Controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController controller = null;

	public static IStudentController getStudentController() {

		try {
			if (controller == null) {
				return new StudentControllerImpl();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return controller;
	}
}