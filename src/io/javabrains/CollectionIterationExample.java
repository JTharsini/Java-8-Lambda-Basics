package io.javabrains;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample
{
  public static void main(String[] args)
  {
    List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
                                        new Person("Lewis", "Carroll", 42),
                                        new Person("Thomas", "Carlyle", 51),
                                        new Person("Charlotte", "Bronte", 45),
                                        new Person("Matthew", "Arnold", 39));

    //forLoop(people);
    //forInLoop(people);
    people.forEach(System.out::println);
  }

  private static void forLoop(List<Person> people)
  {
    System.out.println("**************************");
    for (int i = 0; i < people.size(); i++)
    {
      System.out.println(people.get(i));
    }
  }

  private static void forInLoop(List<Person> people)
  {
    System.out.println("**************************");
    for (Person person : people)
    {
      System.out.println(person);
    }
  }
}
