import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class PersonTests {
	public Person person;
	
	@Before
	public void before() {
  	Calendar birth = Calendar.getInstance();
  	birth.set(1995, Calendar.NOVEMBER, 3);
  	Calendar death = Calendar.getInstance();
  	death.set(2050, Calendar.AUGUST, 25);
  	person = new Person(birth, death);
	}

  @Test
  public void wasAliveDuring() {
    Calendar year = Calendar.getInstance();
    year.set(Calendar.YEAR, 2000);
    assertTrue(person.wasAliveDuring(year));
  }
  
  @Test
  public void wasNotAlive_beforeBirth() {
    Calendar year = Calendar.getInstance();
    year.set(Calendar.YEAR, 1990);
    assertFalse(person.wasAliveDuring(year));  
  }
  
  @Test
  public void wasNotAlive_afterDeath() {
    Calendar year = Calendar.getInstance();
    year.set(Calendar.YEAR, 2100);
    assertFalse(person.wasAliveDuring(year));  
  }
}
