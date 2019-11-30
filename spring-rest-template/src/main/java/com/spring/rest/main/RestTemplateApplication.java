package com.spring.rest.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;

import com.spring.rest.config.AppConfig;
import com.spring.rest.config.PersonClient;
import com.spring.rest.config.PersonClientImpl;
import com.spring.rest.model.Person;

public class RestTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonClient client = context.getBean(PersonClientImpl.class);
		System.out.println("Getting list of all people:");
		List<Person> listOfPersons = client.getAllPerson();
		for (Person person : listOfPersons) {
			person.toString();
		}

		System.out.println("\nAdding a new Person");
		Person newPerson = new Person();
		newPerson.setFirstName("Nishant");
		newPerson.setLastName("Shukla");
		newPerson.setAge(26);
		newPerson.setId(125645L);
		HttpStatus status = client.addPerson(newPerson);
		System.out.println("new addition Status code : " + status);

		System.out.println("\nGetting details of new Person");
		newPerson = client.getPersonById(125645L);
		newPerson.toString();

		System.out.println("\nUpdating new Person");
		newPerson = new Person();
		newPerson.setFirstName("Nishant");
		newPerson.setLastName("Shukla");
		newPerson.setAge(26);
		newPerson.setId(125645L);

		((AnnotationConfigApplicationContext) context).close();
	}
}
