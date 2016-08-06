package pizza.SimplifyingFractions;

public class App {
	
  public static void main(String[] args) {
  	System.out.println("Hello World!");
  	Fraction fraction = new Fraction(4, 8);
  	fraction.simplify();
  	System.out.println(fraction);
  }
}
