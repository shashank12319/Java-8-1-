package com.lambdawithfunctionl;


//Java program to illustrate OR Predicate

import java.util.function.Predicate;
class PredicateInterfaceExample4 {
	public static Predicate<String> hasLengthOf10 =(t)-> t.length() > 10;
		

	public static void predicate_or()
	{

		Predicate<String> containsLetterA = p -> p.contains("A");
		String containsA = "And";
		boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
		System.out.println(outcome);
	}
	public static void main(String[] args)
	{
		predicate_or();
	}
}
