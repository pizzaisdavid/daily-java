package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("noth");
    }
    
    public static int getCoconutCountFromBeforeGoingToSleep(int numberOfSailors) {
      double multiplier = calculateFairShare(numberOfSailors);
      int countAfterWakingUp = 2;
      while (true) {
        double possibleCountBeforeGoingToSleep = (double) countAfterWakingUp;
        for (int i = 0; i <= numberOfSailors; i++) {
          if (isWholeNumber(possibleCountBeforeGoingToSleep)) {
            possibleCountBeforeGoingToSleep = payMonkeyTax(possibleCountBeforeGoingToSleep);
            if (i == numberOfSailors) {
              return (int) possibleCountBeforeGoingToSleep;
            }
            possibleCountBeforeGoingToSleep *= multiplier;
          } else {
            break;
          }
        }
        countAfterWakingUp++;
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