lambda enables functional programming

-functional programming (function or behaviour as argument)
-less number of lines
-readable and maintainable code
-better APIs & libraries
-enable support for parallel processing

problem in OOP:
-everything is an object
-all code blocks are associated with classes and objects
-when need to pass a behavior, need to pass an object which have a behavior
-Lambda resolves this problem. actions passed as Lamda doesn't belongs to any classes.

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
-Need an interface which is having single method with signature of the function to write Lambda
-Assign the Lambda to the interface

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

-Lambda vs Interface implementation: 
Greeting g = ()-> SoS("Hello World!!");
Greeting g = new HelloWorldGreeting();

-Lambda behaves like implementation of the interface, by just implementing the single method that interface has(without creating objects for that). Interface implementation on the otherhand implements the whole interface
-Lambda is kind of shortcut to create annonymous inner class with single method

-Creating interfaces is extra work. There are common type of functionalities needed to be implemented. java.util.function package contains such functional interfaces
-When accepting an object and returning boolean ==> Predicate
-Supplier : just return value
-Function : accept a type and return another type
-method which accepts Lambda handling the exception:
  private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer)
  {
    for (int i : someNumbers)
    {
      try
      {
        biConsumer.accept(i, key);
      }
      // but you don't know what is the behavior going to be passed.
      // then ArithmeticException might not be applicable (for example addition is the behaviour)
      catch (ArithmeticException e)
      {
        
      }
    }
  }
-Lambda handling the exception:
 process(someNumbers, key, (v, k) -> {
      try
      {
        System.out.println(v / k);
      }
      catch (ArithmeticException e)
      {
        System.out.println("An ArithmeticException happened");
      }
    });
-use wrapper Lambda in another Lambda to handle exception
Method reference:
Static method:
-Thread t = new Thread(() -> printMessage()); can be shortened as Thread t2 = new Thread(MethodReferenceExample1::printMessage);
When no argument and no parameters or when function call on passing argument ==> Method reference is applicable
p -> method(p)
() -> method()
Instance method:
-behaveConditionally(people, p -> true, p -> System.out.println(p)); ==> behaveConditionally(people, p -> true, System.out::println);

-Java8 introduces new way to iterate over collection : stream
-for loop and for in loops are called external iterators: writing code to perform iteration imperatively, we are writing code to control
the iteration
-In Java8 : internal iteration: giving control to runtime
-forEach: every collection has method forEach which has an argument : Consumer
-For multi-processor computor: forEach is easy to parallelize for runtime
-when we control: it's sequential
