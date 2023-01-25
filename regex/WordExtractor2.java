package regex;
//This program uses the java.util.regex package to define a
//regular expression that matches words that are at least 4
//characters long (\\b\\w{4,}\\b). It then uses the Pattern
//and Matcher classes to find all the occurrences of this pattern in the input string.
//
//The while loop iterates over all the matches and checks if
//each word is at least 4 characters long and contains at
//least one vowel and at least one consonant. If it does,
//the word is added to a list of words.
//
//The extract method takes a string as input and returns a
//list of words that are at least 4

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor2 {
  public static List<String> extract(String str) {
    List<String> words = new ArrayList<>();

    // Use a regular expression to find all the words in the string
    Pattern pattern = Pattern.compile("\\b\\w{4,}\\b");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String word = matcher.group();
      if (word.matches(".*[aeiouAEIOU].*") && word.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*")) {
        words.add(word);
      }
    }

    return words;
  }

  public static void main(String[] args) {
    String str = "Hello, my name is John. I live in New York City.";
    List<String> words = extract(str);

    for (String word : words) {
      System.out.println(word);
    }
  }
}
