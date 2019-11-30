package com.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.bean.Employee;
import com.spring.service.AnnotationBasedEmployeeService;

@Configuration
public class SpringAnnotationMain {

	@Bean
	public Employee employee(){
		return new Employee();
	}
	
	@Bean
	public AnnotationBasedEmployeeService annotationBasedEmployeeService(Employee employee){
		return new AnnotationBasedEmployeeService(employee);
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAnnotationMain.class);
		AnnotationBasedEmployeeService service = (AnnotationBasedEmployeeService) context.getBean("annotationBasedEmployeeService");
		service.displayEmployeeName();
		context.close();
	}
}

