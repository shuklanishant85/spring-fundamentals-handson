package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.bean.Employee;
import com.spring.service.AwareService;
import com.spring.service.SpringCoupledEmployeeService;

@Configuration
public class SpringAwareMain {
	
	@Bean
	public AwareService awareService(){
		return new AwareService();
	}
	
	@Bean
	public Employee employee(){
		return new Employee();
	}
	
	@Bean
	public SpringCoupledEmployeeService employeeService(){
		return new SpringCoupledEmployeeService();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringAwareMain.class);
		SpringCoupledEmployeeService employeeService = (SpringCoupledEmployeeService)context.getBean("employeeService");
		System.out.println("employee name :: "+employeeService.getEmployee().getName());
		AwareService awareService = (AwareService) context.getBean("awareService");
		awareService.setApplicationContext(context);
		((AnnotationConfigApplicationContext) context).close();
	}

}
