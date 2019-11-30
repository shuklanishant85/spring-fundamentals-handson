package com.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware {
	private String type;
	private int height;
	private ApplicationContext context = null;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(getType() + " Traingle drawn of height " + getHeight());
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public void setBeanName(String name) {
		
	}

}
