package com.coupling.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class War {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
		BraveKnight knight = (BraveKnight) context.getBean("knight");
		knight.embarkOnQuest();
		((ClassPathXmlApplicationContext) context).close();
	}
}
