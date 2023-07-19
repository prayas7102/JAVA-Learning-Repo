package com.prayas.kumar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle {
	@Autowired
	private Tyre tyre;

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void drive() {
		System.out.println("Car "+tyre);
	}
}
