package com.lambdawithfunctionl;


//Java Program to illustrate addThen() method

//Importing interface
import java.util.function.Function;

//Main class
public class Andthen {

	// main driver method
	public static void main(String args[])
	{
		// Function which takes in a number and
		// returns half of it
		Function<Integer, Double> half = a -> a / 2.0;

		// Now treble the output of half function
		half = half.andThen(a -> 3 * a);

		// Applying the function to get the result
		// and printing on console
		System.out.println(half.apply(10));
		
		try {
			 
            // Trying to pass null as parameter
            half = half.andThen(null);
        }
 
        // Catch block to handle exceptions
        catch (Exception e) {
 
            // Print statement
            System.out.println("Exception thrown "
                               + "while passing null: ");
               
	}
}
}