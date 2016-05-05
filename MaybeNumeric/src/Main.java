import java.util.regex.Pattern;

public class Main {

	public static String main(String pos) {
		return pos;
	}
	
	public static boolean isNumeric(String possibleNumber) {
	  if (possibleNumber == "." ||
	      possibleNumber == "") {
	    return false;
	  }
		return Pattern.matches("\\d*.?\\d*", possibleNumber);
	}
}


