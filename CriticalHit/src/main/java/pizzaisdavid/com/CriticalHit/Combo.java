package pizzaisdavid.com.CriticalHit;

public class Combo {
  private double probability;
  private Dice dice;
  private Enemy enemy;
  
  public Combo(Dice dice, Enemy enemy) {
    probability = 1;
    this.dice = dice;
    this.enemy = enemy;
  }
  
  public double getProbability() {
    return probability;
  }

  public void attackEnemyUntilHealthBelowCriticalRoll() {
    while (isCriticalRollNeeded(enemy)) {
      stack(dice.computeRollProbability());
      enemy.takeDamage(dice.sides);
    }
  }
  
  public boolean isCriticalRollNeeded(Enemy enemy) {
    return enemy.getHealth() >= dice.sides;
  }
  
  protected void killEnemy() {
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
