import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Person {
  
  private Calendar birth_;
  private Calendar death_;
  
  public Person(String birth, String death) {
    birth_ = parseDate(birth);
    death_ = parseDate(death);
  }
  
  public static Person parse(ArrayList<String> each) {
    return new Person(each.get(1), each.get(3));
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
    return comparison.after(birth_) && comparison.before(death_);
  }
}
