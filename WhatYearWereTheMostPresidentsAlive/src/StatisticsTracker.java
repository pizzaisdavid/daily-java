import java.util.ArrayList;
import java.util.Calendar;

public class StatisticsTracker extends ArrayList<Person>{
  private static final long serialVersionUID = 1L;
  private ArrayList<Person> presidents;

  public StatisticsTracker(ArrayList<ArrayList<String>> parsedPresidents) {
    for (ArrayList<String> each : parsedPresidents) {
      Person president = Person.parse(each);
      add(president);
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
