import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
  
  public static ArrayList<String> parse(String input, String delimiter) {
    ArrayList<String> trimmedParsedInput = new ArrayList<String>();
    ArrayList<String> parsedInput = split(input, delimiter);
    for (String element: parsedInput) {
      trimmedParsedInput.add(element.trim());
    }
    return trimmedParsedInput;
  }
  
  private static ArrayList<String> split(String input, String delimiter) {
    String[] tokens = input.split(delimiter);
    return convert(tokens);
  }
  
  private static ArrayList<String> convert(String[] array) {
    List<String> list = Arrays.asList(array);
    return new ArrayList<String>(list);
  }
}