package io.javabrains;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsExample1
{
  public static void main(String[] args)
  {
    List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
                                        new Person("Lewis", "Carroll", 42),
                                        new Person("Thomas", "Carlyle", 51),
                                        new Person("Charlotte", "Bronte", 45),
                                        new Person("Matthew", "Arnold", 39));
    long streamStart = System.nanoTime();
    people.stream().filter(person -> person.getLastName().startsWith("C"))
      .forEach(p -> System.out.println(p.getFirstName()));
    long streamEnd = System.nanoTime();
    System.out.println("Stream time: " + (streamEnd - streamStart) / 1000000000.0);
    Stream<Person> stream = people.stream().filter(person -> person.getLastName().startsWith("C"));
    System.out.println(stream.count());
    long parallelStreamStart = System.nanoTime();
    people.parallelStream().filter(person -> person.getLastName().startsWith("C"))
      .forEach(p -> System.out.println(p.getFirstName()));
    long parallelStreamEnd = System.nanoTime();
    System.out.println("Parallel stream time" + (parallelStreamEnd - parallelStreamStart) / 1000000000.0);
  }
}
