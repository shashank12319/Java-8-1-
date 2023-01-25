package regex;
//This program defines a regex (regular expression) that represents 
//a pattern for a valid email address. It then uses the java.util.regex
//package to compile the regex into a Pattern object, which is used to match against a given string.
//
//The isValid method takes a string as input and 
//returns true if the string is a valid email address, or false if it is not.
//
//The main method tests the isValid method by providing a
//list of test email addresses and printing the result of the isValid method for each one.
//
//Note that this program is just a simple 
//example and does not cover all possible cases of valid email addresses. 
//For example, it does not allow for internationalized domain names (IDNs)
//or addresses with quoted local parts (e.g. "user@domain.com"). 
//If you need to validate email addresses more strictly, you may want 
//to consider using a more comprehensive solution.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
  private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

  public static boolean isValid(String email) {
    Matcher matcher = EMAIL_PATTERN.matcher(email);
    return matcher.matches();
  }

  public static void main(String[] args) {
    String[] emails = {
      "u-ser@domain.com",
      "user@domain.co.in",
      "user.name@domain.com",
      "user@sub.domain.com",
      "user@123.123.123.123",
      "user@[123.123.123.123]",
      "user@[IPv6:2001:db8::1]"
    };

    for (String email : emails) {
      System.out.println(email + ": " + isValid(email));
    }
  }
}

