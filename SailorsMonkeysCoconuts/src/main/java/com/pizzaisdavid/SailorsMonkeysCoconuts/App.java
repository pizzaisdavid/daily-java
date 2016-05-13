package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("");
    }
    
    public static int getStartingCoconutCount(int numberOfSailors) {
      double multiplier = calculateFairShare(numberOfSailors);
      int countAfterWakingUp = 2;
      while (true) {
        double countBeforeGoingToSleep = (double) countAfterWakingUp;
        for (int i = 0; i <= numberOfSailors; i++) {
          if (i == numberOfSailors) {
            return (int) countBeforeGoingToSleep;
          } 
          countBeforeGoingToSleep *= multiplier;
          if (isWholeNumber(countBeforeGoingToSleep)) {
            countBeforeGoingToSleep = payMonkeyTax(countBeforeGoingToSleep);
          } else {
            countAfterWakingUp++;
            break;
          }
        }
      }
    }
    
    public static double calculateFairShare(int sailors) {
      return (double) sailors / (double) (sailors - 1);
    }
    
    public static boolean isWholeNumber(double d) {
      return (d % 1) == 0;
    }
    
    public static double payMonkeyTax(double d) {
      final int AMOUNT_TO_PAY_MONKEY = 1;
      return d + AMOUNT_TO_PAY_MONKEY;
    }
}
