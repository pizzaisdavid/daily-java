package pizzaisdavid.com.CriticalHit;

public class Enemy {

  private int health;
  
  public Enemy(int health) {
    this.health = health;
  }
  
  public void takeDamage(int damage) {
    health -= damage;
  }
  
  public boolean isAlive() {
    return health > 0;
  }

  public int getHealth() {
    return health;
  }

  public boolean isHealthAtleast(int minimumValue) {
    return health >= minimumValue;
  }
}
