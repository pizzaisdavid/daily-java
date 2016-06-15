package pizzaisdavid.com.CriticalHit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CriticalHitTest {
  
  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
      {"guaranteedKill", 4, 1, 1.0},
      {"criticalRequired", 4, 4, 0.25},
      {"criticalRequiredAndChance", 4, 6, 0.1875}
   });
  }
  
  @Parameter(value = 0)
  public String name;
  
  @Parameter(value = 1)
  public int sidesOnDie;
  
  @Parameter(value = 2)
  public int hp;
  
  @Parameter(value = 3)
  public double killProbability;
  

  @Test
  public void test() {
    CriticalHit critical = new CriticalHit();
    assertEquals(killProbability, critical.computeKillProbability(sidesOnDie, hp), .0001);
  }
}