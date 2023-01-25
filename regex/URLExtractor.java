package regex;
//This program uses the java.util.regex package to define a 
//regular expression that matches URLs
//in the formats://..., https://..., and ftp://.... It 
//	then uses the Pattern and Matcher classes to find 
//	all the occurrences of this pattern in the input 
//string.
//
//The while loop iterates over all the
//matches and prints each one using the 
//group method of the Matcher class.
//
//Note that this program is just a simple 
//example and does not cover all possible cases of valid URLs.
//For example, it does not allow for URLs with IP addresses or 
//URLs with non-standard ports. If you need to extract URLs more 
//strictly, you may want to consider using a more comprehensive solution.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLExtractor {
  public static void main(String[] args) {
    String str = "Here are some URLs: www.example.com, https://www.example.com, http://www.example.com, and ftp://ftp.example.com.";

    // Use a regular expression to find all the URLs in the string
    Pattern pattern = Pattern.compile("(http|https|ftp)://[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
