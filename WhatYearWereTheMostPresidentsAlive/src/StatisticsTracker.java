import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class StatisticsTracker extends ArrayList<Person>{
  private static final long serialVersionUID = 1L;
  // TODO private int yearMostPresidentsWereAlive;

  public StatisticsTracker(ArrayList<ArrayList<String>> parsedPresidents) {
    //yearMostPresidentsWereAlive = 0;
    for (ArrayList<String> each : parsedPresidents) {
    	Calendar birth = parseDate(each.get(1));
    	Calendar death = parseDate(each.get(3));
      Person president = new Person(birth, death);
      add(president);
      // TODO update();
    }
  }
  
  private Calendar parseDate(String date) {
    SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy");
    Calendar calendar = Calendar.getInstance();
      try {
        calendar.setTime(format.parse(date));
        return calendar;
      } catch (ParseException e) {
        return calendar;
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
