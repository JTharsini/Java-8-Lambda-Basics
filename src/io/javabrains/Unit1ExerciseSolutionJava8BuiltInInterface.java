package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8BuiltInInterface
{
  public static void main(String[] args)
  {
    List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
                                        new Person("Lewis", "Carroll", 42),
                                        new Person("Thomas", "Carlyle", 51),
                                        new Person("Charlotte", "Bronte", 45),
                                        new Person("Matthew", "Arnold", 39));

    // Step 1: Sort list by last name
    Collections.sort(people, Comparator.comparing(Person::getLastName)); // comparator
    // is a
    // functional
    // interface

    // Step 2: Create a method that prints all elements in the list
    behaveConditionally(people, p -> true, p -> System.out.println(p.getFirstName()));

    // Step 3: Create a method that prints all people that have last name beginning
    // with C
    printConditionally(people, p -> p.getLastName().startsWith("C"));
    printConditionally(people, p -> p.getFirstName().startsWith("C"));
  }

  private static void behaveConditionally(List<Person> people,
                                          Predicate<Person> condition,
                                          Consumer<Person> personConsumer)
  {
    System.out.println("*******************************************************************");
    for (Person person : people)
    {
      if (condition.test(person))
      {
        personConsumer.accept(person);
      }
    }
  }

  // able to change behavior dynamically by passing
  private static void printConditionally(List<Person> people, Predicate<Person> condition)
  {
    System.out.println("*******************************************************************");
    for (Person person : people)
    {
      if (condition.test(person))
      {
        System.out.println(person);
      }
    }
  }
}
