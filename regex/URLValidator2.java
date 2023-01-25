package regex;
//This code uses a regular expression pattern to match the given URL against the specified criteria.
//If the URL matches the pattern, it is considered to be a valid URL. Otherwise, it is considered to
//be an invalid URL.
//
//The Matcher class is used to perform the actual pattern matching. The matcher()
//method is called on the pattern object, and the URL is passed as an argument.
// matches() method of the Matcher object is then called to check if the URL
// matches the pattern. If it does, the URL is considered to be valid and a
// message is printed to the console. If it does not, the URL is considered
// to be invalid and a different message is printed to the console

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator2 {
    public static void main(String[] args) {
        // Set up the regular expression for a valid URL
        String regex = "^(https?)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+(/[a-zA-Z0-9-]*)*$";
        Pattern pattern = Pattern.compile(regex);

        // Test some URLs
        String[] testURLs = {
            "http://www.example.com",
            "https://www.example.com",
            "http://www.example.com/path/to/resource",
            "https://www.example.com/path/to/resource",
            "http://www.example.com/path/to/resource/",
            "https://www.example.com/path/to/resource/",
            "http://www.example.com/path/to/resource/123",
            "https://www.example.com/path/to/resource/123",
            "http://www.example.com/path/to/resource/123/",
            "https://www.example.com/path/to/resource/123/",
            "http://www.example.com/path/to/resource/abc-def",
            "https://www.example.com/path/to/resource/abc-def",
            "http://www.example.com/path/to/resource/abc-def/",
            "https://www.example.com/path/to/resource/abc-def/",
            "http://www.example.com/path/to/resource/abc-def/123",
            "https://www.example.com/path/to/resource/abc-def/123",
            "http://www.example.com/path/to/resource/abc-def/123/",
            "https://www.example.com/path/to/resource/abc-def/123/",
            "http://invalid.com",
            
            "http://invalid-url.com/path/to/resource/",
            "http://invalid/path/to/resource/",
            "http://invalid:80/path/to/resource/",
            "http://www.example.com:8080/path/to/resource/",
            "http://user:password@www.example.com/path/to/resource/",
            "http://user@www.example.com/path/to/resource/",
            "http://:password@www.example.com/path/to/resource/",
            "http://@www.example.com/path/to/resource/",
            "http://www.example.com/path/to/invalid resource/",
            "http://www.example.com/path/to/invalid%20resource/",
            "http://www.example.com/path/to/invalid%EF%BF%BDresource/"
        };

        // Validate the URLs
        for (String url : testURLs) {
        	   Matcher matcher = pattern.matcher(url);
               if (matcher.matches()) {
                   System.out.println(url + " is a valid URL");
               } else {
                   System.out.println(url + " is NOT a valid URL");
               }
           }
       }
   
        }
        
