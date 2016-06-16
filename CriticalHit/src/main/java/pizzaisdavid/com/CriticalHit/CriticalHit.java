package pizzaisdavid.com.CriticalHit;

public class CriticalHit {
  
  public static double computeProbability(int sides, int health) {
    Enemy enemy = new Enemy(health);
    GameDice dice = new GameDice(sides);
    Combo combo = new Combo(dice, enemy);
    combo.attackEnemyUntilHealthBelowCriticalRoll();
    combo.dealFinishingBlow();
    return combo.getProbability();
  }
}
