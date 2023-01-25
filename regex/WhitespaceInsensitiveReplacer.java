package regex;


public class WhitespaceInsensitiveReplacer {
	  public static String replace(String str, String pattern, String replacement) {
	    // Use a regular expression to match the pattern and ignore leading and trailing whitespace
	    String regex = "\\s*" + pattern + "\\s*";
	    return str.replaceAll(regex, replacement);
	  }

	  public static void main(String[] args) {
	    String str = "   Hello, my name is John.   My name is also john.   ";
	    String pattern = "john";
	    String replacement = "Jane";

	    System.out.println(replace(str, pattern, replacement));
	  }
	}
