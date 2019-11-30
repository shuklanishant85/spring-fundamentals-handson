package com.spring.rest.client;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.controller.EmpRestURIConstants;
import com.spring.rest.model.Employee;

public class RestTemplateClient {
	public static final String SERVER_URI = "http://localhost:8080";

	public static void main(String[] args) {
		getDummyEmployee();
		getAllEmployees();
		getEmployee(125645);
		createEmployee();
		deleteEmployee(123456);
		getEmployee(123456);
	}

	private static void getDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(SERVER_URI + EmpRestURIConstants.DUMMY_EMP, Employee.class);
		printEmployeeData(employee);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void getAllEmployees() {
		// We can't get List<Employee> because JSON converter doesn't know the
		// type of object in the list and hence convert it to default JSON
		// object type LinkedHashMap
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> employeeList = restTemplate.getForObject(SERVER_URI + EmpRestURIConstants.GET_ALL_EMP,
				List.class);
		for (LinkedHashMap emp : employeeList) {
			Employee employee = new Employee();
			employee.setName((String) emp.get("name"));
			employee.setId((Integer) emp.get("id"));
			printEmployeeData(employee);
		}
	}

	private static void getEmployee(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(
				StringUtils.replace(SERVER_URI + EmpRestURIConstants.GET_EMP, "{id}", String.valueOf(id)),
				Employee.class);
		printEmployeeData(employee);
	}

	private static void createEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = new Employee();
		employee.setId(123456);
		employee.setName("Kushal");
		ResponseEntity<Employee> response = restTemplate.postForEntity(SERVER_URI + EmpRestURIConstants.CREATE_EMP,
				employee, Employee.class);
		printEmployeeData(response.getBody());
	}

	private static void deleteEmployee(int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(SERVER_URI + EmpRestURIConstants.DELETE_EMP, "{id}", String.valueOf(id));
	}

	private static void printEmployeeData(Employee employee) {
		if (null != employee) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Displaying Employee Data : ");
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Employee Id : " + employee.getId());
			if (null != employee.getCreatedDate()) {
				System.out.println("Created Date : " + sdf.format(employee.getCreatedDate()));
			}
		} else {
			System.out.println("Employee not found");
		}

	}
}
