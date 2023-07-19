package com.prayas.kumar;

import org.springframework.stereotype.Component;

@Component
public class Bike extends Vehicle{
	public void drive() {
		System.out.println("Bike");
	}
}
