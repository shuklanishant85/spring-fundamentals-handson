package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.ListedPolygon;
import com.spring.beans.Polygon;
import com.spring.beans.Triangle;

public class DrawingApp {

	private static ApplicationContext context;

	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle = (Triangle) factory.getBean("triangle");

		context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		System.out.println("");
		triangle.draw();
		System.out.println("\nFor regular polygon");
		Polygon polygon = (Polygon)context.getBean("polygon");
		polygon.draw();
		System.out.println("\nFor listed polygon");
		ListedPolygon listedPolygon = (ListedPolygon)context.getBean("listedPolygon");
		listedPolygon.draw();
	}
}
