package pizzaisdavid.com.CriticalHit;

public class Player {
  
  private Dice dice;
  
  public Player(int sides) {
    dice = new Dice(sides);
  }
  
  public double computeKillProbability(int hp) {
    Enemy enemy = new Enemy(hp);
    double probability = 1;
    while (isCriticalRollNeeded(enemy)) {
      probability *= dice.computeRollProbability();
      enemy.takeDamage(dice.sides);
    }
    if (enemy.isAlive()) {
      probability *= dice.computeProbabilityToRollAtLeast(enemy.getHealth());
    }
    return probability;
  }

  
  public boolean isCriticalRollNeeded(Enemy enemy) {
    return enemy.getHealth() >= dice.sides;
  }
  
}
