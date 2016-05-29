package pizzaisdavid.com.CriticalHit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void guaranteedKill() {
    int sidesOnDie = 4;
    int enemyHp = 1;
    assertEquals("Hp: 1", 1.0, App.killProbability(sidesOnDie, enemyHp), .0001);
  }
  
  @Test
  public void criticalRequired() {
    int sidesOnDie = 4;
    int enemyHp = 4;
    assertEquals(0.25, App.killProbability(sidesOnDie, enemyHp), .0001);
  }
  
  @Test
  public void criticalRequiredAndChance() {
    int sidesOnDie = 4;
    int enemyHp = 6;
    assertEquals(0.1875, App.killProbability(sidesOnDie, enemyHp), .0001);
  }
  
  

}
