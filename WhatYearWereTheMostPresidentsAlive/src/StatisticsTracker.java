import java.util.ArrayList;
import java.util.Calendar;

public class StatisticsTracker extends ArrayList<Person>{
  private static final long serialVersionUID = 1L;
  // TODO private int yearMostPresidentsWereAlive;

  public StatisticsTracker(ArrayList<ArrayList<String>> parsedPresidents) {
    //yearMostPresidentsWereAlive = 0;
    for (ArrayList<String> each : parsedPresidents) {
      Person president = Person.parse(each);
      add(president);
      // TODO update();
    }
  }


  public void computeAndDisplayResults() {
    for (int i = 1732; i < 2016; i++) {
      int count = 0;
      Calendar year = Calendar.getInstance();
      year.set(Calendar.YEAR, i);
      for (Person p : this) {
        if (p.wasAliveDuring(year)) {
          count++;
        }
      }
      System.out.println("Year: " + i + ", count: " + count);
    }    
  }
}
