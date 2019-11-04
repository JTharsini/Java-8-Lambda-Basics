package io.javabrains;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLamda myLamda = (String s) -> s.length();
		System.out.println(myLamda.getLength("Hello"));
		
		StringLengthLamda myLamda2 = s -> s.length(); // no need to define String for s and no need for parenthesis since there is only one input argument.
		System.out.println(myLamda2.getLength("Hello"));
		
		System.out.println("*********");
		printLamda(s -> s.length());
	}
	
	public static void printLamda(StringLengthLamda l)
	{
		System.out.println(l.getLength("Hello Lamda"));
	}
	
	interface StringLengthLamda
	{
		int getLength(String s);
	}
}