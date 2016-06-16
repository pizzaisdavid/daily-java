package pizzaisdavid.com.CriticalHit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class DiceTest {
  
  @RunWith(Parameterized.class)
  public static class computeProbabilityToRollAtLeast {
    
    @Parameters(name = "{0} chance")
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {1.00, 1},
        {0.75, 2},
        {0.50, 3},
        {0.25, 4}
     });
    }
    
    @Parameter(value = 0)
    public double probability;
    
    @Parameter(value = 1)
    public int minimumValue;
    
    @Test
    public void test() {
      Dice die = new Dice(4);
      assertEquals(probability, die.computeProbabilityToRollAtLeast(minimumValue), 0.001);
    }
  }
  
  @RunWith(Parameterized.class)
  public static class computeRollProbability {
    
    @Parameters(name = "{0} sided die")
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {4, 0.25},
        {5, 0.20},
        {6, 0.166666666}
     });
    }
    
    @Parameter(value = 0)
    public int numberOfSides;
    
    @Parameter(value = 1)
    public double probability;
    
    @Test
    public void test() {
      Dice die = new Dice(numberOfSides);
      assertEquals(probability, die.computeRollProbability(), 0.001);
    }
  }
}

//  
//  @Test
//  public void computeRollProbability_5SidedDice() {
//    Dice die = new Dice(5);
//    assertEquals(0.20, die.computeRollProbability(), 0.001);
//  }
//}
