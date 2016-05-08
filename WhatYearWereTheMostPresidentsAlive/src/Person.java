import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
  
  private Calendar birth;
  private Calendar death;
  
  public Person(String birth, String death) {
    this.birth = parseDate(birth);
    this.death = parseDate(death);
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
  
  public boolean wasAliveDuring(Calendar comparison) {
    return comparison.after(this.birth) && comparison.before(this.death);
  }
}
