package regex;
//This program defines a regex (regular expression) that represents a pattern for a valid IP address
//in the format X.X.X.X, where X is a number between 0 and 255.
//
//The isValid method takes an IP address as input and returns true if
//the string is a valid IP address, or false if it is not. It uses the
//java.util.regex.Pattern and java.util.regex.Matcher classes to match the string against the regex pattern.
//
//The main method tests the isValid method by providing a list of test
//IP addresses and printing the result of the isValid method for each one.
//
//Note that this program is just a simple example and does not cover
//all possible cases of valid IP addresses. For example, it does not
//allow for IP addresses with leading zeros or with non-standard subnet masks.
//If you need to validate IP addresses more strictly, you may want to consider using a more comprehensive solution.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
  private static final String IP_ADDRESS_REGEX = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

  public static boolean isValid(String ipAddress) {
    Pattern pattern = Pattern.compile(IP_ADDRESS_REGEX);
    Matcher matcher = pattern.matcher(ipAddress);
    return matcher.matches();
  }

  public static void main(String[] args) {
    String[] addresses = {
      "192.168.0.1",
      "0.0.0.0",
      "255.255.255.255",
      "256.0.0.0",
      "0.0.0.256",
      "192.168.0",
      "192.168.0.0.1",
      "192.168.0.1.",
      "192.168.0.1.2"
    };

    for (String address : addresses) {
      System.out.println(address + ": " + isValid(address));
    }
  }
}
