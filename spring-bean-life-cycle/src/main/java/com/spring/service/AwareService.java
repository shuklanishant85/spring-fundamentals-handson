package com.spring.service;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class AwareService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware{

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("Set Applicaion Context called.");
		System.out.println("Bean defiations in ApplicationContext :: "+ Arrays.toString(context.getBeanDefinitionNames()));
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		System.out.println("setApplicationEventPublisher called");
	}

	public void setBeanClassLoader(ClassLoader loader) {
		System.out.println("setBeanClassLoader called");
		System.out.println("setBeanClassLoader:: ClassLoader Name="
				+ loader.getClass().getName());	
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory called");
		System.out.println("setBeanFactory:: employee bean singleton="
				+ beanFactory.isSingleton("employee"));
	}

}
