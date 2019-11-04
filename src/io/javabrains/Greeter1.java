package io.javabrains;

public class Greeter1 {
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
	
	public void java8Greet(MyLamda greetingFunction)
	{
		greetingFunction.foo();
	}
	
	
	public static void main(String[]args)
	{
		Greeter1 greeter = new Greeter1();
		Greeting greeting = new BirthdayGreeting();
		greeter.java7Greet(greeting); // a behavior is passed to the method for execution
		
		// what if we are able to pass an action
		// instead for an object? Lamda makes it possible
		// functions that executes in isolation - lamda
		// functions as values - lamda
		
		MyLamda greetingFunction = () -> System.out.println("As functional interface with declaration of variable!");
		greeter.java8Greet(greetingFunction);
		
		greeter.java8Greet(() -> System.out.println("As functional interface without declaration of variable!"));
		
		MyAdd addFunction = (int a, int b) -> a + b;
		System.out.println(addFunction.add(5, 10));
	}
}

interface MyLamda // looks like Greeting
{
	void foo(); // this method signature should be same as the whatever method used inside lamda
}

interface MyAdd
{
	int add(int x, int y);
}