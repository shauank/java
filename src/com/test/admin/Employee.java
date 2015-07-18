package com.test.admin;

import java.time.LocalDate;

public class Employee {

	private String name;

	public enum SEX {
		MALE, FEMALE
	}
	
	public Employee(String name, int age, SEX gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
	}

	SEX gender;
	public SEX getGender() {
		return gender;
	}

	public void setGender(SEX gender) {
		this.gender = gender;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	LocalDate birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	private boolean isAdmin;

	public void printPersion() {
		System.out.println("Name: " + this.name + "Age: " + this.age
				+ "Gender: " + this.gender);
	}
	
	public static int compareByName(Employee e1, Employee e2){
		return e1.getName().compareTo(e2.getName());
	}

}
