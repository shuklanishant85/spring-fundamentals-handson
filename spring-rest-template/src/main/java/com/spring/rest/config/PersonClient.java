package com.spring.rest.config;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.spring.rest.model.Person;

public interface PersonClient {
	
	public List<Person> getAllPerson();
	
	public Person getPersonById(Long id);
	
	public HttpStatus addPerson(Person person);
	
	public void updatePerson(Person person);
	
	public void deletePerson(Long id);

}
 