package pizzaisdavid.com.CriticalHit;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {
  
  @Test
  public void computeProbabilityToRollAtLeast_100PercentChance() {
    Dice die = new Dice(4);
    assertEquals(1, die.computeProbabilityToRollAtLeast(1), 0.001);
  }
  
  @Test
  public void computeProbabilityToRollAtLeast_75PercentChance() {
    Dice die = new Dice(4);
    assertEquals(0.75, die.computeProbabilityToRollAtLeast(2), 0.001);
  }
  
  @Test
  public void computeProbabilityToRollAtLeast_50PercentChance() {
    Dice die = new Dice(4);
    assertEquals(0.50, die.computeProbabilityToRollAtLeast(3), 0.001);
  }

  @Test
  public void computeProbabilityToRollAtLeast_25PercentChance() {
    Dice die = new Dice(4);
    assertEquals(0.25, die.computeProbabilityToRollAtLeast(4), 0.001);
  }
  
  @Test
  public void computeRollProbability_4SidedDice() {
    Dice die = new Dice(4);
    assertEquals(0.25, die.computeRollProbability(), 0.001);
  }
  
  @Test
  public void computeRollProbability_5SidedDice() {
    Dice die = new Dice(5);
    assertEquals(0.20, die.computeRollProbability(), 0.001);
  }
}
