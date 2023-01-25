package regex;
//This program uses the java.util.regex package to define a regular expression
//that represents the pattern to be replaced. It then uses the Pattern and Matcher
//classes to find all the occurrences of this pattern in the input string.
//
//The replace method takes a string, a pattern, and a replacement string 
//as input and returns the original string with all occurrences of the pattern
//replaced by the replacement string.
//
//The main method demonstrates how to use the replace method by
//providing a test string, a pattern, and a replacement string, and
//printing the result of the replace method.
//
//Note that this program only replaces the pattern globally, i.e. 
//it replaces all occurrences of the pattern regardless of whether 
//they are whole words or part of larger words. If you need to
//replace the pattern only when it appears as a whole word, you
//will need to modify the regular expression accordingly
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplacer {
  public static String replace(String str, String pattern, String replacement) {
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(str);
    return m.replaceAll(replacement);
  }

  public static void main(String[] args) {
    String str = "Hello, my phone number is 123-456-7890 and my social security number is 123-45-6789.";
    String pattern = "\\d+";
    String replacement = "XXX-XXX-XXXX";

    System.out.println(replace(str, pattern, replacement));
  }
}
