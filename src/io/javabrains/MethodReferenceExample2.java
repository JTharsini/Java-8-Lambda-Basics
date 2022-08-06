package io.javabrains;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2
{
  public static void main(String[] args)
  {
    List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
                                        new Person("Lewis", "Carroll", 42),
                                        new Person("Thomas", "Carlyle", 51),
                                        new Person("Charlotte", "Bronte", 45),
                                        new Person("Matthew", "Arnold", 39));

    behaveConditionally(people, p -> true, p -> System.out.println(p));
    behaveConditionally(people, p -> true, System.out::println);
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
}
