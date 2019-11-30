package com.spring.di.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.di.springin5steps.dao.PersonDAO;
import com.spring.di.springin5steps.search.BinarySearch;
import com.spring.di.springin5steps.search.Search;

@ComponentScan(basePackages = { "com.spring.di" })
@SpringBootApplication
public class SpringIn5StepsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		Search binarySearch = applicationContext.getBean(BinarySearch.class);
		Search binarySearchSec = applicationContext.getBean(BinarySearch.class);
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAOSec = applicationContext.getBean(PersonDAO.class);
		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", personDAOSec);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", binarySearch);
		LOGGER.info("{}", binarySearchSec);
		int result = binarySearch.search(new int[] { 1, 4, 3, 7, 2 }, 7);
		int resultSec = binarySearchSec.search(new int[] { 1, 4, 3, 7, 2 }, 7);
		LOGGER.info("{}", result);
		LOGGER.info("{}", resultSec);
	}

}
