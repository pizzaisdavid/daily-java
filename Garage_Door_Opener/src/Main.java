import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> commands =  new ArrayList<String>(
		  Arrays.asList(
	      "button_clicked",
	      "cycle_complete",
	      "button_clicked",
	      "button_clicked",
	      "button_clicked",
	      "button_clicked",
	      "button_clicked",
	      "cycle_complete"
		  )
		);
		
		GarageDoorOpener opener = new GarageDoorOpener(commands);
	}
}


