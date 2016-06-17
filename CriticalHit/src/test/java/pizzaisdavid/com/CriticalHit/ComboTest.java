package pizzaisdavid.com.CriticalHit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComboTest {

  @Test
  public void computeKillProbability_enemyMaintainsHealth() {
    int STARTING_HEALTH = 4;
    GameDice die = new GameDice(4);
    Combo combo = new Combo(die);
    Enemy enemy = new Enemy(STARTING_HEALTH);
    combo.computeKillProbability(enemy);
    assertEquals(STARTING_HEALTH, enemy.getHealth());
  }

}
