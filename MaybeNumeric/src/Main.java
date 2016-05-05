
public class Main {

	public static String main(String pos) {
		return pos;
	}
	
	public static boolean isNumeric(String possibleNumber) {
		final String ACCEPTIABLE_DIGITS = "0123456789.";
		for (int i = 0; i < possibleNumber.length(); i++) {
			String character = possibleNumber.substring(i, i + 1);
			if (ACCEPTIABLE_DIGITS.contains(character) == false) {
				return false;
			}
		}
		return true;
	}
}


