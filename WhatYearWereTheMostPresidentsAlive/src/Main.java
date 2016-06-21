import java.util.ArrayList;
import main.java.com.mycompany.daily.TextFile;

public class Main {
  
  public static void main(String[] args) {
    
    TextFile file = new TextFile("pres.txt");
    ArrayList<String> lines = file.getLines();
    StatisticsTracker tracker = new StatisticsTracker(lines);
    tracker.displayResults();
  }
}