package io.javabrains;

public class Greeter2 {
	public void java7Greet(Greeting greeting)
	{
		/**
		 * we could accept an argument and based
		 * on the argument we could do something
		 * with Switch. But that is not a 
		 * proper idea in object orientation
		 */
		greeting.perform();
	}
	
	public void java8Greet(Greeting greetingFunction)
	{
		greetingFunction.perform();
	}
	
	public static void main(String[]args)
	{
		Greeter2 greeter = new Greeter2();
		Greeting birthdayGreeting = new BirthdayGreeting();
		
		// interface MyLamda looks like Greeting
		// The method signature in that foo method is same as that of Greeting
		Greeting lamdaGreeting = () -> System.out.println("Many many happy returns of the day");
		greeter.java8Greet(lamdaGreeting);
		
		// birthdayGreeting and lamdaGreeting looks same.
		// birthdayGreeting is an instance of specific implementation and 
		// lamdaGreeting implementing the interface just by implementing
		// the interface function. (inline implementation)
		
		System.out.println("********");
		birthdayGreeting.perform();
		lamdaGreeting.perform();
		
		Greeting innerClassGreeting = new Greeting() {
			@Override
			public void perform() {
				System.out.println("Many many happy returns of the day");
			}
			
		};
		innerClassGreeting.perform();
		// in lamda we do the similar thing as inner class. Inner class with only one method.
		// it seems like shortcut of innerclass. Not exactly
		System.out.println("********");
		greeter.java8Greet(lamdaGreeting);
		greeter.java8Greet(innerClassGreeting);
	}
}