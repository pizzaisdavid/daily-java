import java.util.ArrayList;
import main.java.com.mycompany.daily.TextFile;

public class Main {
  
  public static void main(String[] args) {
    TextFile file = new TextFile("pres.txt");
    ArrayList<String> presidents = file.getLines();
    StatisticsTracker tracker = new StatisticsTracker(presidents);
    tracker.displayResults();
  }
}