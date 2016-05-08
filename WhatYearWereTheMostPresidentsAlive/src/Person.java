import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
  
  private String name;
  private Calendar birth;
  private Calendar death;
  
  public Person(String name, String birth, String death) {
    this.name = name;
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
  
  public boolean isAlive(Calendar year) {
    return year.after(this.birth) && year.before(this.death);
  }
}
