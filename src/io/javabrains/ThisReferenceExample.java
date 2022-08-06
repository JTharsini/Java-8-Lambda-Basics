package io.javabrains;

public class ThisReferenceExample
{
  public void doProcess(int i, Process p)
  {
    p.process(i);
  }

  public void execute()
  {
    System.out.println(this);
    doProcess(10, (i) -> {
      System.out.println("Value of i is " + i);
      System.out.println(this);
    });
  }

  @Override
  public String toString()
  {
    return "ThisReferenceExample reference";
  }

  public static void main(String[] args)
  {
    ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
    thisReferenceExample.doProcess(10, new Process()
    {
      @Override
      public void process(int i)
      {
        System.out.println("Value of i is " + i);
        System.out.println(this);
        // this is ThisReferenceExample before overriding toString.
        // because class is annonymous innerclass.
        // once toString is overridden it will be that value.
        // in the static method, accessing instance of an object.
        // outside printing would not work.
      }

      @Override
      public String toString()
      {
        return "This is annonymous inner class";
      }
    });
    //System.out.println(this); // this will not work
    thisReferenceExample.doProcess(10, (i) -> {
      System.out.println("Value of i is " + i);
      //System.out.println(this); can't use like this. no object to print
    });
    thisReferenceExample.execute();
  }
}
