package com.pwskill.harshit.Student;

public class Student {

	private static Integer sid;
	private static String sname;
	private static Integer sage;
	private static String saddress;

	public static Integer getSid() {
		return sid;
	}

	public static void setSid(Integer sid) {
		Student.sid = sid;
	}

	public static String getSname() {
		return sname;
	}

	public static void setSname(String sname) {
		Student.sname = sname;
	}

	public static Integer getSage() {
		return sage;
	}

	public static void setSage(Integer sage) {
		Student.sage = sage;
	}

	public static String getSaddress() {
		return saddress;
	}

	public static void setSaddress(String saddress) {
		Student.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}