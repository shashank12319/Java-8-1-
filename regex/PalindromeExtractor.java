package regex;
//This program uses the java.util.regex package to define a
//regular expression that matches words (\\b\\w+\\b). It then
//uses the Pattern and Matcher classes to find all the occurrences of this pattern in the input string.
//
//The while loop iterates over all the matches and checks
//if each word is a palindrome using the isPalindrome method. If it is, the word is added to a list of palindromes.
//
//The isPalindrome method takes a string as input and
//returns true if the string is a palindrome, or false if it is not. It compares the characters at
//the beginning and end of the string and returns false if they are not the same.
//
//The extract method takes a string as input and returns a list of palindromes.
//
//The main method demonstrates how to use the extract method by providing a test string and printing the result
//of the extract method.
//
//Note that this program is just a simple example and does not cover all possible
//cases of valid palindromes. For example, it does not allow for palindromes with punctuation or
//palindromes with spaces. If you need to extract palindromes more strictly, you may want to consider
//modifying the regular expression and/or the isPalindrome method accordingly








import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromeExtractor {
  public static List<String> extract(String str) {
    List<String> palindromes = new ArrayList<>();

    // Use a regular expression to find all the words in the string
    Pattern pattern = Pattern.compile("\\b\\w+\\b");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String word = matcher.group();
      if (isPalindrome(word)) {
        palindromes.add(word);
      }
    }

    return palindromes;
  }

  private static boolean isPalindrome(String str) {
    int length = str.length();
    for (int i = 0; i < length / 2; i++) {
      if (str.charAt(i) != str.charAt(length - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str = "Able was I ere I saw Elba.";
    List<String> palindromes = extract(str);

    for (String palindrome : palindromes) {
      System.out.println(palindrome);
    }
  }
}
