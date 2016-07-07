
import java.util.Calendar;

public class Person {
  
  private Calendar birth;
  private Calendar death;
  
  public Person(Calendar birth, Calendar death) {
    this.birth = birth;
    this.death = death;
  }
  
  public boolean wasAliveDuring(Calendar comparison) {
    return comparison.after(birth) && comparison.before(death);
  }
}
