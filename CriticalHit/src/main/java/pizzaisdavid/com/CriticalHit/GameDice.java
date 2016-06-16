package pizzaisdavid.com.CriticalHit;

public class GameDice extends Dice {
  
  public GameDice(int sides) {
    super(sides);
  }

  public boolean isCriticalHitRollNeeded(Enemy enemy) {
    return enemy.getHealth() >= sides;
  }
  
  public double computeCriticalHitProbability() {
    return computeRollProbability();
  }
  
  public int getCriticalHitValue() {
    return sides;
  }
}
