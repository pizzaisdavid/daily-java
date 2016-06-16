package pizzaisdavid.com.CriticalHit;

public class Dice {
  
  public int sides;

  public Dice(int sides) {
    this.sides = sides;
  }
  
  public double computeProbabilityToRollAtLeast(int value) {
    return computeRollProbability() + computeProbabilityToRollAbove(value);
  }
  
  public double computeRollProbability() {
    int ONE_DIE_FACE = 1;
    return ONE_DIE_FACE / (double) sides;
  }
  
  public double computeProbabilityToRollAbove(int value) {
    int TOTAL_PROBABILITY = 1;
    return TOTAL_PROBABILITY - computeProbabilityToRollLessThanOrEqual(value);
  }
  
  public double computeProbabilityToRollLessThanOrEqual(int value) {
    return value / (double) sides;
  }
}
