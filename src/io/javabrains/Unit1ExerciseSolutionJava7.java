package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// Step 1: Sort list by last name
		sort(people);

		// Step 2: Create a method that prints all elements in the list
		display(people);

		// Step 3: Create a method that prints all people that have last name beginning
		// with C
		displayLastNameStartsWithC(people);
		
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
		
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});
	}

	private static void displayLastNameStartsWithC(List<Person> people) {
		System.out.println("*******************************************************************");
		for (Person person : people) {
			if (person.getLastName().startsWith("C")) {
				System.out.println(person);
			}
		}
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

	private static void display(List<Person> people) {
		System.out.println("*******************************************************************");
		for (Person person : people) {
			System.out.println(person);
		}
	}

	private static void sort(List<Person> people) {
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				return person1.getLastName().compareTo(person2.getLastName());
			}
		});
	}
}

interface Condition {
	boolean test(Person p);
}