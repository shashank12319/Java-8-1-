package regex;
//This program defines a regex (regular expression) that represents 
//a pattern for a valid phone number in the format (XXX) XXX-XXXX. 
//It then uses the java.util.regex package to compile the regex 
//into a Pattern object, which is used to match against a given string.
//
//The isValid method takes a string as input and returns true if
//the string is a valid phone number, or false if it is not. It
//first uses the matcher.matches method to check if the string
//matches the regex pattern, and then checks if the area code 
// with 0 or 1.
//
//The main method tests the isValid method by providing a 
//list of test phone numbers and printing the result of the
//isValid method for each one.
//
//Note that this program is just a simple example and does 
//not cover all possible cases of valid phone numbers. 
//For example, it does not allow for phone numbers with
//extensions or international phone numbers. If you 
//need to validate phone numbers more strictly, you
//may want to consider using a more comprehensive solution.


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
  private static final String PHONE_REGEX = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
  private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

  public static boolean isValid(String phoneNumber) {
    Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
    return matcher.matches() && !phoneNumber.startsWith("(0") && !phoneNumber.startsWith("(1");
  }

  public static void main(String[] args) {
    String[] phoneNumbers = {
      "(123) 456-7890",
      "(234) 567-8901",
      "(345) 678-9012",
      "(456) 789-0123",
      "(567) 890-1234",
      "(678) 901-2345",
      "(789) 012-3456",
      "(890) 123-4567",
      "(901) 234-5678",
      "(012) 345-6789",
      "(111) 111-1111",
      "(000) 000-0000",
      "(001) 001-0001"
    };

    for (String phoneNumber : phoneNumbers) {
      System.out.println(phoneNumber + ": " + isValid(phoneNumber));
    }
  }
}
