package com.pwskill.harshit;

import java.sql.SQLException;
import java.util.Scanner;

import com.pwskill.harshit.Controller.IStudentController;
import com.pwskill.harshit.Student.Student;
import com.pwskill.harshit.factory.StudentControllerFactory;

public class MainApp {

	static Scanner sc = new Scanner(System.in);
	static IStudentController controller = StudentControllerFactory.getStudentController();
	static Student student = new Student();

	public static void main(String[] args) {

		chooseOption();
	}

	private static void chooseOption() {

		System.out.println("                                  CRUD APP                                             ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
				"1. Insert Data into Student Database\t2. Update Data into Student Database\n3. Delete Data into Student Database\t4. View Data of Student Database");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("\nSelect one Option : ");
		int option = sc.nextInt();

		switch (option) {
		case 1: {
			insertApp();
			break;
		}
		case 2: {
			updateApp();
			break;
		}
		case 3: {
			deleteApp();
			break;
		}
		case 4: {
			SelectApp();
			break;
		}
		default:
			System.out.println("\nInvalid Choise.....");
			chooseOption();
		}
	}

	private static void insertApp() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Sid : ");
		int sid = sc.nextInt();

		System.out.print("Enter Sname : ");
		String sname = sc.next();

		System.out.print("Enter Sage : ");
		int sage = sc.nextInt();

		System.out.print("Enter Saddress : ");
		String saddress = sc.next();

		Student.setSid(sid);
		Student.setSname(sname);
		Student.setSage(sage);
		Student.setSaddress(saddress);

		try {
			System.out.println("\nSuccessfully inserted....");
			controller.InsertApp(student);
		} catch (SQLException e) {
			System.out.println("\nFailed in Inserting....");
		}
		sc.close();

	}

	private static void updateApp() {

		System.out.println("\nWhich Data You you want to Update : ");
		System.out.println("\n1. sname \t 2.sage \t 3. saddress");
		System.out.print("\nSelect one Option : ");
		int op = sc.nextInt();

		switch (op) {
		case 1: {
			try {
				System.out.print("\nEnter Id : ");
				int id = sc.nextInt();
				Student.setSid(id);

				System.out.print("\nEnter new Name : ");
				String sname = sc.next();
				Student.setSname(sname);

				controller.updateApp(student, op);
				System.out.println("\nSuccessfully Updated....");
			} catch (SQLException e) {
				System.out.println("\nFailure in Updation....");
			}
			break;
		}
		case 2: {
			try {
				System.out.print("\nEnter Id : ");
				int id = sc.nextInt();
				Student.setSid(id);

				System.out.print("\nEnter new Age : ");
				int age = sc.nextInt();
				Student.setSage(age);

				controller.updateApp(student, op);
				System.out.println("\nSuccessfully Updated....");
			} catch (SQLException e) {
				System.out.println("\nFailure in Updation....");
			}
			break;
		}
		case 3: {
			try {
				System.out.print("\nEnter Id : ");
				int id = sc.nextInt();
				Student.setSid(id);

				System.out.print("\nEnter new Address : ");
				String address = sc.next();
				Student.setSaddress(address);

				controller.updateApp(student, op);
				System.out.println("\nSuccessfully Updated....");
			} catch (SQLException e) {
				System.out.println("\nFailure in Updation....");
			}
			break;
		}

		default:
			System.out.println("\nInvalid Choise.....");
			updateApp();
		}
	}

	private static void deleteApp() {

		System.out.print("\nEnter id which you want to delete : ");
		int sid = sc.nextInt();
		Student.setSid(sid);

		try {
			controller.DeleteApp(student);
			System.out.println("Successfully Deleted....");
		} catch (SQLException e) {
			System.out.println("Failure in Detetion.....");
		}
	}

	private static void SelectApp() {

		System.out.print("\nEnter the id Which data you want : ");
		int sid = sc.nextInt();
		Student.setSid(sid);

		try {
			controller.SelectApp(student);
		} catch (SQLException e) {
			System.out.println("\nSome Problem Accurs....");
		}
	}
}