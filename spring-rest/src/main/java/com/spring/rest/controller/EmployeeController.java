package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.rest.model.Employee;

@Controller
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	public Map<Integer, Employee> employeeMap = new HashMap<>();

	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	@ResponseBody
	public Employee getDummyEmployee() {
		LOGGER.info("getting dummy Employee");
		Employee employee = new Employee();
		employee.setId(125645);
		employee.setName("Nishant Shukla");
		employee.setCreatedDate(new Date());
		employeeMap.put(employee.getId(), employee);
		return employee;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee(@PathVariable("id") int id) {
		LOGGER.info("getting Employee with id : " + id);
		if (employeeMap.containsKey(id)) {
			return employeeMap.get(id);
		}
		LOGGER.error("no employee found with id : " + id);
		return null;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployees() {
		LOGGER.info("getting all Employees");
		if (employeeMap.isEmpty()) {
			LOGGER.error("no employee found in the Database");
			return new ArrayList<>();
		}
		return new ArrayList<>(employeeMap.values());
	}

	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	@ResponseBody
	public Employee createEmployee(@RequestBody Employee employee) {
		LOGGER.info("creating Employee");
		employee.setCreatedDate(new Date());
		employeeMap.put(employee.getId(), employee);
		return employee;
	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable("id") int id) {
		LOGGER.info("deleting Employee with id : " + id);
		if (employeeMap.containsKey(id)) {
			Employee employee = employeeMap.get(id);
			employeeMap.remove(id);
			return employee;
		}
		LOGGER.error("couldnot find employee with id : " + id);
		return null;
	}
}
