package regex;
//This program defines a regular expression that includes the (?i) flag,
//which makes the pattern case-insensitive. It then uses the replaceAll method of the String class to replace all occurrences of the pattern with the replacement string.
//
//The replace method takes a string, a pattern, and a replacement
//string as input and returns the original string with all occurrences
//of the pattern replaced by the replacement string, ignoring the case of the pattern.
//
//The main method demonstrates how to use the replace method by 
//providing a test string, a pattern, and a replacement string,
//and printing the result of the replace method.
//
//Note that this program only replaces the pattern globally,
//i.e. it replaces all occurrences of the pattern regardless of whether they are whole words or part of larger
//words. If you need to replace the pattern only when it appears as a whole word, you will need to modify
//the regular expression accordingly.

public class CaseInsensitiveReplacer {
	  public static String replace(String str, String pattern, String replacement) {
	    String regex = "(?i)" + pattern;
	    return str.replaceAll(regex, replacement);
	  }

	  public static void main(String[] args) {
	    String str = "Hello, my name is John. My name is also john.";
	    String pattern = "john";
	    String replacement = "Jane";

	    System.out.println(replace(str, pattern, replacement));
	  }
	}
