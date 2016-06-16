package pizzaisdavid.com.CriticalHit;

public class Player {
  
  private Dice dice;
  private Combo combo;
  
  public Player(int sides) {
    dice = new Dice(sides);
  }
  
  public double computeKillProbability(int health) {
    Enemy enemy = new Enemy(health);
    combo = new Combo(dice, enemy);
    combo.attackEnemyUntilHealthBelowCriticalRoll();
    combo.dealFinishingBlow();
    return combo.getProbability();
  }
}
