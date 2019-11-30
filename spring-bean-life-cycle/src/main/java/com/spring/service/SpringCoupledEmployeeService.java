package com.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.Employee;

public class SpringCoupledEmployeeService implements InitializingBean, DisposableBean{

	@Autowired
	private Employee employee;

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public SpringCoupledEmployeeService(){
		System.out.println("Employee service called with no-args constructor");
	}

	public void destroy() throws Exception {
		System.out.println("EmployeeService Closing resources");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("EmployeeService initializing to dummy value");
		if(employee.getName() == null){
			employee.setName("Nishant");
		}		
	}
	
}
