package regex;
//This program defines a regex (regular expression) that represents 
//a pattern for a valid date in the format DD/MM/YYYY. It also
//defines a string format for the date.
//
//The isValid method takes a string as input and returns true if
//the string is a valid date, or false if it is not. It uses the
//java.text.SimpleDateFormat class to parse the string into a 
//java.util.Date object and then formats the date back into a string
//using the same format. If the original string and the formatted
//string are the same, then the date is considered to be valid.
//
//The main method tests the isValid method by providing a list
//of test dates and printing the result of the isValid method
//for each one

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
  @SuppressWarnings("unused")
private static final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
  private static final String DATE_FORMAT = "dd/MM/yyyy";

  public static boolean isValid(String date) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
      dateFormat.setLenient(false);
      Date parsedDate = dateFormat.parse(date);
      return date.equals(dateFormat.format(parsedDate));
    } catch (ParseException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    String[] dates = {
      "01/01/1970",
      "01/13/1970",
      "01/01/2100",
      "29/02/2020",
      "29/02/2021",
      "30/02/2021",
      "31/02/2021"
    };

    for (String date : dates) {
      System.out.println(date + ": " + isValid(date));
    }
  }
}
