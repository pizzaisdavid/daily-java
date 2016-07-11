package main.java.com.mycompany.daily;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
  
  public static ArrayList<ArrayList<String>> parseExcludingHeader(ArrayList<String> lines) {
    String DEFAULT_SEPARATOR = ",";
    return parseExcludingHeader(lines, DEFAULT_SEPARATOR);
  }
  
  public static ArrayList<ArrayList<String>> parseExcludingHeader(ArrayList<String> lines, String delimiter) {
    lines.remove(0);
    return parse(lines, delimiter);
  }
  
  public static ArrayList<ArrayList<String>> parse(ArrayList<String> lines) {
    String DEFAULT_SEPARATOR = ",";
    return parse(lines, DEFAULT_SEPARATOR);
  }

  public static ArrayList<ArrayList<String>> parse(ArrayList<String> rawLines, String delimiter) {
    ArrayList<ArrayList<String>> parsedLines = new ArrayList<ArrayList<String>>();
    for (String line : rawLines) {
      ArrayList<String> parsedLine = parse(line, delimiter);
      parsedLines.add(parsedLine);
    }
    return parsedLines;
  }

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

	public static ArrayList<Integer> integersFromList(String content) {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		ArrayList<String> strings = parse(content, ",");
		for (String stringNumber : strings) {
			int integer = Integer.parseInt(stringNumber);
			integers.add(integer);
		}
		return integers;
	}
}