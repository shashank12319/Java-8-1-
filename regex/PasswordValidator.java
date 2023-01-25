package regex;
//This program defines a regex (regular expression) that represents a
//pattern for a valid password. It then uses the java.util.regex package
//to compile the regex into a Pattern object, which is used to match against a given string.
//
//The isValid method takes a string as input and returns 
//true if the string is a valid password, or false if it is not.
//
//The main method tests the isValid method by providing
//a list of test passwords and printing the result of the
//isValid method for each one.
//
//Note that this program is just a simple example and
//does not cover all possible cases of valid passwords. 
//For example, it does not check for the presence of special
//characters or require a certain number of special characters.
//If you need to validate passwords more strictly, you may want 
//to consider using a more comprehensive solution.

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//This program defines a regex (regular expression) that represents a pattern 
//for a valid password. It then uses the java.util.regex package to compile the
//regex into a Pattern object, which is used to match against a given string.
//
//The isValid method takes a string as input and returns true if the
//string is a valid password, or false if it is not.
//
//The main method tests the isValid method by providing a list
//of test passwords and printing the result of the isValid method for each one.
//
//Note that this program is just a simple example and does
//not cover all possible cases of valid passwords. 
//For example, it does not check for the presence of special
//characters or require a certain number of special characters.
//If you need to validate passwords more strictly, you may want to 
//consider using a more comprehensive solution.
public class PasswordValidator {
  private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
  private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

  public static boolean isValid(String password) {
    Matcher matcher = PASSWORD_PATTERN.matcher(password);
    return matcher.matches();
  }

  public static void main(String[] args) {
    String[] passwords = {
      "password",
      "Password1",
      "Password1!",
      "Passw0rd!",
      "Passw0rd!1",
      "p@ssword1"
    };

    for (String password : passwords) {
      System.out.println(password + ": " + isValid(password));
    }
  }
}
