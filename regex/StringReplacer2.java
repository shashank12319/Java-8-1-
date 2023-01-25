package regex;

//The replace() method uses the java.util.regex.Pattern and java.util.regex.Matcher classes to find
//and replace all occurrences of the given pattern in the input string.
//It sets the CASE_INSENSITIVE flag when compiling the pattern to ignore case,
//and it uses the trim() method to remove leading and trailing whitespace from
//the replacement string. It then uses the appendReplacement() and appendTail()
//methods to perform the replacements and return the modified string.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplacer2 {
  public static String replace(String str, String pattern, String replacement) {
    Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(str);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
      m.appendReplacement(sb, replacement.trim());
    }
    m.appendTail(sb);
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "   The quick brown fox   ";
    String pattern = "\\bfox\\b";
    String replacement = "dog";
    String result = replace(str, pattern, replacement);
    System.out.println(result);  // Output: "   The quick brown dog   "
  }
}
