import java.util.ArrayList;

import main.java.com.mycompany.daily.Parser;
import main.java.com.mycompany.daily.TextFile;

public class Main {
  
  public static void main(String[] args) {
    TextFile file = new TextFile("pres.txt");
    ArrayList<String> lines = file.getLines();
    ArrayList<ArrayList<String>> parsedPresidents = Parser.parseExcludingHeader(lines);
    StatisticsTracker tracker = new StatisticsTracker(parsedPresidents);
    tracker.computeAndDisplayResults();
  }
}