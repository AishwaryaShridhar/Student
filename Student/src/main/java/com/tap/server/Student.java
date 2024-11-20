package com.tap.server;

public class Student {
	private int student_id;
	private String student_name;
	private String student_email;
	private String student_address;
	private String student_mobile;
	private String password;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_mobile() {
		return student_mobile;
	}
	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Student(int student_id, String student_name, String student_email, String student_address,
			String student_mobile, String password) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_address = student_address;
		this.student_mobile = student_mobile;
		this.password = password;
	}
	
	public Student(String student_name, String student_email, String student_address, String student_mobile,
			String password) {
		super();
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_address = student_address;
		this.student_mobile = student_mobile;
		this.password = password;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return student_id + "  " + student_name + "  "
				+ student_email + "  " + student_address + "  " + student_mobile
				+ "  " + password;
	}
}