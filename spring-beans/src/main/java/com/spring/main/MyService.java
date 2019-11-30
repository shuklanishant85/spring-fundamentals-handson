package com.spring.main;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public void log(String message) {
		System.out.println(new Date() + "::" + message);
	}

}
