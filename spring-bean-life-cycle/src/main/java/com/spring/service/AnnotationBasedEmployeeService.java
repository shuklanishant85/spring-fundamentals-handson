package com.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.Employee;

public class AnnotationBasedEmployeeService {
	
	private Employee employee;
	
	@PostConstruct
	public void init(){
		System.out.println("Annotation based post construct method called.");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Annotation based pre destroy method called.");
	}
	
	@Autowired
	public AnnotationBasedEmployeeService(Employee employee){
		System.out.println("MyService no-args constructor called");
		this.employee=employee;
	}
	
	public void displayEmployeeName(){
		if (employee.getName() == null) {
			employee.setName("Nishant Shukla");
		}
		System.out.println("Employee name = "+ employee.getName());
	}
}
