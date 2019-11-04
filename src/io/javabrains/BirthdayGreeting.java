package io.javabrains;

public class BirthdayGreeting implements Greeting {
	@Override
	public void perform() {
		System.out.println("Many many happy returns of the day");
	}
}
