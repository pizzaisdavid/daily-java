import java.util.ArrayList;
import java.util.Calendar;

import main.java.com.mycompany.daily.Parser;

public class StatisticsTracker {
  private ArrayList<Person> presidents;

  public StatisticsTracker(ArrayList<String> lines) {
    ArrayList<ArrayList<String>> parsed = Parser.parseExcludingHeader(lines);
    presidents = new ArrayList<Person>();
    for (ArrayList<String> rawData : parsed) {
      Person president = new Person(rawData.get(1), rawData.get(3));
      presidents.add(president);
    }
  }

  public void displayResults() {
    for (int i = 1732; i < 2016; i++) {
      int count = 0;
      Calendar year = Calendar.getInstance();
      year.set(Calendar.YEAR, i);
      for (Person p : presidents) {
        if (p.wasAliveDuring(year)) {
          count++;
        }
      }
      System.out.println("Year: " + i + ", count: " + count);
    }    
  }
}
