import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> inputCommands =  new ArrayList<String>();
		inputCommands.add("button_clicked");
		inputCommands.add("cycle_complete");
		inputCommands.add("button_clicked");
		inputCommands.add("button_clicked");
		inputCommands.add("button_clicked");
		inputCommands.add("button_clicked");
		inputCommands.add("button_clicked");
		inputCommands.add("cycle_complete");
		
		GarageDoorOpener opener = new GarageDoorOpener();
		opener.setInput(inputCommands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();

		for (int i = 0; i < inputCommands.size(); i++) {;
			System.out.println("Door: " + outputResults.get(i));
			System.out.println("> " + inputCommands.get(i) + ".");
		}
		System.out.println("Door: " + outputResults.get(outputResults.size() - 1));
	}
}


