package io.javabrains;

public class ClosureExample
{
  public static void main(String[] args)
  {
    int a = 20;
    int b = 10;
    // before Java 8, need to make b as final. but with Java 8,
    // it makes the value as effectively final itself
    // it freeze the value of b
    doProcess(a, i -> {
      //b = 40; // should be final : compilation error
      System.out.println(i + b);
    });
    // this process is actually executing in doProcess method
    // in that place no value for b
    // still compiler keep the value for b in that place
  }

  public static void doProcess(int i, Process p)
  {
    p.process(i);
  }
}

interface Process
{
  void process(int i);
}
