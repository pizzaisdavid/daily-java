
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

  public static ArrayList<String> parse(String line, String delimiter) {
    ArrayList<String> parsed = split(line, delimiter);
    ArrayList<String> trimmed = trim(parsed);
    return trimmed;
  }
  
  private static ArrayList<String> split(String string, String delimiter) {
    String[] tokens = string.split(delimiter);
    return convert(tokens);
  }
  
  private static ArrayList<String> convert(String[] array) {
    List<String> list = Arrays.asList(array);
    return new ArrayList<String>(list);
  }
  
  private static ArrayList<String> trim(ArrayList<String> array) {
    ArrayList<String> trimmed = new ArrayList<String>();
    for (String element: array) {
      trimmed.add(element.trim());
    }
    return trimmed;
  }
}