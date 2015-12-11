package com.chronosystems.cdi.qualifiers;

@Informal
public class InformalGreeting extends Greeting {
	public String greet(String name) {
		return "Hi, " + name + "!";
	}
}