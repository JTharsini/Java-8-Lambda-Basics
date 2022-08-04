lambda enables functional programming

-functional programming (function or behaviour as argument)
-less number of lines
-readable and maintainable code
-better APIs & libraries
-enable support for parallel processing

problem in OOP:
-everything is an object
-all code blocks are associated with classes and objects

functions as values:
Inline value:- Eg: String name = "foo", double pi = 3.14
A piece of code which can be executed is assigned to a variable just like values.
Eg: aBlockOfCode = {
....
....
}

public void perform()													aBlockOfCode = () -> {							Since one line
{																			System.out.println("Hello world!");				=> 				aBlockOfCode = () -> System.out.println("Hello world!");
	System.out.println("Hello world!");              =>					};
}

for a function in isolation, no need to have public. If we assign this method to a variable, no need to have a separate name. Compiler is able to identify the return type
by looking at the code. No need to have return type.
If one line, can remove curly brace and the return keyword

public int double(int a){return a * 2;}              =>                doubleNumberFunction = (int a) -> a * 2;

addFunction = (int a, int b) -> a + b;

safeDivideFunction = (int a, int b) -> {
	if(b == 0) return 0;
	return a / b;
};

stringLengthCountFunction = (String s) -> s.length();

In lamda, java compiler is doing type inference: Type of arguments and return type can be inferred.

greetingFunction = () -> System.out.println("Hello world");
-Declaring it as variable
1. Able to  pass as argument Eg: greet(greetingFunction);

public void greet(------)
{
	---------(); // action to perform
}

encapsulate a function inside variable and pass it to other places.

No need to declare it as variable. Able to pass lamda as inline. Eg: greet(() -> System.out.println("Hello world"));

Advantage of using interface as lamda type instead for function type:
1. backward compatibility
No need to write new functional interface for a specific purpose. Eg: Runnable

Interface should have only one abstract method to fit into lambda expression ==> Functional interface
why "abstract" is mentioned : because, from java8 interface can have default implementation.

We can define now it as a functional interface. Later if someone add method, can't be used as functional interface.
So in java8 there is a way to explicitly tell it's a functional interface. ==> @FunctionalInterface
Even though it is optional. It's better to add to avoid confusion.
