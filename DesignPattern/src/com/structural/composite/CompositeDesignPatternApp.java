package com.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPatternApp {
	public static void main(String args[]) {
		Developer dev1 = new Developer("100", "Lokesh Sharma", "Pro Developer");
		Developer dev2 = new Developer("101", "Vinay Sharma", "Developer");
		CompanyAccount engDirectory = new CompanyAccount();
		engDirectory.addEmployee(dev1);
		engDirectory.addEmployee(dev2);

		Manager man1 = new Manager("200", "Kushagra Garg", "SEO Manager");
		Manager man2 = new Manager("201", "Vikram Sharma ", "Kushagra's Manager");

		CompanyAccount accDirectory = new CompanyAccount();
		accDirectory.addEmployee(man1);
		accDirectory.addEmployee(man2);

		CompanyAccount directory = new CompanyAccount();
		directory.addEmployee(engDirectory);
		directory.addEmployee(accDirectory);
		directory.showDetails();
	}
}

interface Employee {
	void showDetails();
}

class Developer implements Employee {

	private String id;
	private String name;
	private String department;

	public Developer(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void showDetails() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
}

class Manager implements Employee {

	private String id;
	private String name;
	private String department;

	public Manager(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void showDetails() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}

class CompanyAccount implements Employee {
	List<Employee> employees = new ArrayList<>();

	void addEmployee(Employee e) {
		employees.add(e);
	}

	public void showDetails() {
		employees.forEach(e -> e.showDetails());
	}
}