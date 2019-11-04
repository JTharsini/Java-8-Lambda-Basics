package io.javabrains;

public interface Greeting {
	void perform();
	// if I add another method here int add(int a, int b)
	// compiler confuses and shows error in usage place.
	// functional interface should have only one function
}