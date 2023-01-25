package regex;
//This program uses the java.util.regex package to define a 
//regular expression that matches one or more digits (\d+). It
//then uses the Pattern and Matcher classes to find all the occurrences of this pattern in the input string.
//
//The while loop iterates over all the matches and prints
//each one using the group method of the Matcher class.
//
//Note that this program does not handle numbers with
//decimal points (e.g. 3.14) or negative numbers. If you 
//need to extract these types of numbers as well, you will 
//need to modify the regular expression accordingly.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {
	  public static void main(String[] args) {
	    String str = "Hello, my phone number is 123-456-7890 and my social security number is 123-45-6789.";

	    // Use a regular expression to find all the numbers in the string
	    Pattern pattern = Pattern.compile("\\d+");
	    Matcher matcher = pattern.matcher(str);

	    while (matcher.find()) {
	      System.out.println(matcher.group());
	    }
	  }
	}
