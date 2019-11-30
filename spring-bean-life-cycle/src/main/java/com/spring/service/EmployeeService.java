package com.spring.service;

import com.spring.bean.Employee;

public class EmployeeService {

	private Employee employee;
	
	public EmployeeService(Employee employee){
		System.out.println("Into Employee Service Constructor");
		this.employee = employee;
	}
	
	public void init(){
		System.out.println("XML based post construct method called.");
	}

	public void destroy(){
		System.out.println("XML based pre destroy method called.");
	}
	
	public void displayEmployeeName(){
		if (employee.getName() == null) {
			employee.setName("Ek Aur Nishant");
		}
		System.out.println("Employee name = "+ employee.getName());
	}
}
