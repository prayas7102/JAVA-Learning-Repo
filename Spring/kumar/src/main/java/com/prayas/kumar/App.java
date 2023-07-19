package com.prayas.kumar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Vehicle obj = (Vehicle) context.getBean("vehicle");
		obj.drive();
		
		Car obj1 = (Car) context.getBean("car");
		obj1.drive();
	}
}
