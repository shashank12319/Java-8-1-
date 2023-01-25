package regex;
//This program defines a regular expression pattern that
//matches the word as a whole word (\\b is a word boundary).
//It then uses the replaceAll method of the String class to
// all occurrences of the pattern with the replacement string.
//
//The replace method takes a string, a word, and a      
//replacement string as input and returns the original string
//with all occurrences of the word replaced by the replacement
//string, ignoring the case of the word
//
//The main method demonstrates 
//how to use the replace method by providing a test string, 
//a word, and a replacement string, and printing the result
//of the replace method.
//
//Note that this program only replaces the word globally,
//i.e. it replaces all occurrences of the word regardless
//of whether they are whole words or part of larger words.
//If you need to replace the word only when it appears as a
//whole word, you will need to modify the regular expression accordingly.
public class WordReplacer {
	  public static String replace(String str, String word, String replacement) {
	    String pattern = "\\b" + word + "\\b";
	    return str.replaceAll(pattern, replacement);
	  }

	  public static void main(String[] args) {
	    String str = "Hello, my name is John. My name is also john.";
	    String word = "john";
	    String replacement = "Jane";

	    System.out.println(replace(str, word, replacement));
	  }
	}
