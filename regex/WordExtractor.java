package regex;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor {
  public static List<String> extract(String str) {
    List<String> words = new ArrayList<>();

    // Use a regular expression to find all the words in the string
    Pattern pattern = Pattern.compile("\\b\\w{3,}\\b");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String word = matcher.group();
      if (word.matches(".*[aeiouAEIOU].*")) {
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
