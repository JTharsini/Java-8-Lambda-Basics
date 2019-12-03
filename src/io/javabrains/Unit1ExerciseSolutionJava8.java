package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1ExerciseSolutionJava8 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// Step 1: Sort list by last name
		Collections.sort(people, (person1, person2) -> person1.getLastName().compareTo(person2.getLastName())); // comparator
																												// is a
																												// functional
																												// interface

		// Step 2: Create a method that prints all elements in the list
		printConditionally(people, p -> true);

		// Step 3: Create a method that prints all people that have last name beginning
		// with C
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
	}

	// able to change behavior dynamically by passing
	private static void printConditionally(List<Person> people, Condition condition) {
		System.out.println("*******************************************************************");
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}
}