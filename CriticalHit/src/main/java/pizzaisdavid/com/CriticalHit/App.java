package pizzaisdavid.com.CriticalHit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(killProbability(4, 6));
    }
    
    public static double killProbability(int newSidesOnDie, int newEnemyHp) {
      double sidesOnDie = newSidesOnDie;
      double enemyHp = newEnemyHp;
      
      double probabilityToRollCritical = 1.0 / sidesOnDie;
      int numberOfCriticalsNeeded = (int) ((int) enemyHp / sidesOnDie);
      double remainingEnemyHp = enemyHp - (sidesOnDie * numberOfCriticalsNeeded);
      double probabilityForNeededCombo = numberOfCriticalsNeeded * probabilityToRollCritical;

      if (remainingEnemyHp > 0.0) {
        double probabilityForFinishingBlow = (double) (remainingEnemyHp + 1) / (double) sidesOnDie;
        return probabilityForNeededCombo * probabilityForFinishingBlow;
      } 
      return probabilityForNeededCombo;
    }
}
