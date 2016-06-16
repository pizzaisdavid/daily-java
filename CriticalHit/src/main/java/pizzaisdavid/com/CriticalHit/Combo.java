package pizzaisdavid.com.CriticalHit;

public class Combo {
  private GameDice dice;
  private Enemy enemy;
  private int criticalHitValue;
  private double probability;
  
  public Combo(GameDice dice) {
    probability = 1.0;
    this.dice = dice;
  }
  
  public double getProbabilityOfKilling(Enemy enemy) {
    this.enemy = enemy;
    attackEnemyUntilHealthBelowCriticalRoll();
    dealFinishingAttack();
    return probability;
  }

  private void attackEnemyUntilHealthBelowCriticalRoll() {
    criticalHitValue = dice.getCriticalHitValue();
    while (isCriticalRollNeeded()) {
      stack(dice.computeCriticalHitProbability());
      enemy.takeDamage(criticalHitValue);
    }
  }
  
  private boolean isCriticalRollNeeded() {
    return enemy.isHealthAtleast(criticalHitValue);
  }
  
  private void dealFinishingAttack() {
    if (enemy.isAlive()) {
      int remainingHealth = enemy.getHealth();
      double rollProbability = dice.computeProbabilityToRollAtLeast(remainingHealth);
      stack(rollProbability);
    }
  }
  
  private void stack(double rollProbability) {
    probability *= rollProbability;
  }
}
