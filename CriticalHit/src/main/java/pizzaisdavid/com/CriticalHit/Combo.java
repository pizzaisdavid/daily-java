package pizzaisdavid.com.CriticalHit;

public class Combo {
  private GameDice dice;
  private Enemy enemy;
  private int maximumDamage;
  private double probability;
  
  public Combo(GameDice dice) {
    probability = 1.0;
    this.dice = dice;
    maximumDamage = dice.getCriticalHitValue();
  }
  
  public double computeKillProbability(Enemy enemy) {
    this.enemy = enemy.clone();
    attackEnemyUntilHealthBelowCriticalRoll();
    dealFinishingAttack();
    return probability;
  }

  private void attackEnemyUntilHealthBelowCriticalRoll() {
    while (isCriticalRollNeeded()) {
      stack(dice.computeCriticalHitProbability());
      enemy.takeDamage(maximumDamage);
    }
  }
  
  private boolean isCriticalRollNeeded() {
    return enemy.isHealthAtleast(maximumDamage);
  }
  
  private void dealFinishingAttack() {
    if (enemy.isAlive()) {
      int remainingHealth = enemy.getHealth();
      double rollProbability = dice.computeProbabilityToRollAtLeast(remainingHealth);
      stack(rollProbability);
      enemy.takeDamage(remainingHealth);
    }
  }
  
  private void stack(double rollProbability) {
    probability *= rollProbability;
  }
}
