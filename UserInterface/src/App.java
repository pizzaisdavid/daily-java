import java.util.Scanner;

public class App {
	
  public static void main( String[] args ) {
  	int integer = askInteger("Please enter an integer: ");
  	System.out.println(integer);
  }

	private static int askInteger(String prompt) {
		Scanner reader = makeInputScanner();
		System.out.println(prompt);
		int n = reader.nextInt();
		return n;
	}

	private static Scanner makeInputScanner() {
		return new Scanner(System.in);
	}

}
