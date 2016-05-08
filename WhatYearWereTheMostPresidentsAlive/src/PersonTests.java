import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class PersonTests {

  public static class isAlive {

    @Test
    public void wasAliveDuring() {
      Person person = new Person("March 1 1995", "March 1 2016");
      Calendar year = Calendar.getInstance();
      year.set(Calendar.YEAR, 2000);
      assertTrue(person.wasAliveDuring(year));
    }
    
    @Test
    public void wasNotAliveDuring() {
      Person person = new Person("March 1 1995", "March 1 2016");
      Calendar year = Calendar.getInstance();
      year.set(Calendar.YEAR, 2200);
      assertFalse(person.wasAliveDuring(year));
    }
  }

}
