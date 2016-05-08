import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class PersonTests {
  
  public static class initialization {
    
    @Test
    public void emptyStrings() {
      new Person("", "");
    }
  }

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
      Calendar beforeBirth = Calendar.getInstance();
      Calendar afterDeath = Calendar.getInstance();
      beforeBirth.set(Calendar.YEAR, 1990);
      afterDeath.set(Calendar.YEAR, 2100);
      assertFalse(person.wasAliveDuring(beforeBirth));
      assertFalse(person.wasAliveDuring(afterDeath));  
    }
  }
}
