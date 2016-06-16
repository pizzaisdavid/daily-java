package pizzaisdavid.com.CriticalHit;

public class Combo {
  private double probability;
  private GameDice dice;
  private Enemy enemy;
  
  public Combo(GameDice dice, Enemy enemy) {
    probability = 1;
    this.dice = dice;
    this.enemy = enemy;
  }
  
  public double getProbability() {
    return probability;
  }

  public void attackEnemyUntilHealthBelowCriticalRoll() {
    while (dice.isCriticalHitRollNeeded(enemy)) {
      stack(dice.computeCriticalHitProbability());
      int damage = dice.getCriticalHitValue();
      enemy.takeDamage(damage);
    }
  }
  
  protected void dealFinishingBlow() {
    if (enemy.isAlive()) {
      int remainingHealth = enemy.getHealth();
      double rollProbability = dice.computeProbabilityToRollAtLeast(remainingHealth);
      stack(rollProbability);
    }
  }
  
  public void stack(double rollProbability) {
    probability *= rollProbability;
  }
}
