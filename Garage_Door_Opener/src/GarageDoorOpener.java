import java.util.ArrayList;

public class GarageDoorOpener {
	
	private ArrayList<String> input;
	private ArrayList<String> states;
	private String BUTTON_CLICKED = "button_clicked";
	private STATES STATES;
	
	public class STATES {
		private String CLOSED = "CLOSED";
		private String CLOSING = "CLOSING";
		private String OPENING = "OPENING";
		private String OPEN = "OPEN";
		private String STOPPED_WHILE_OPENING = "STOPPED_WHILE_OPENING";
		private String STOPPED_WHILE_CLOSING = "STOPPED_WHILE_CLOSING";
	}
		
	public GarageDoorOpener() {
		this.STATES = new STATES();
		this.input =  new ArrayList<String>();
		this.states = setStartingState(this.STATES.CLOSED);
	}
	
	public GarageDoorOpener(String startingState) {
		this.input =  new ArrayList<String>();
		this.states = setStartingState(startingState);
	}
	
	public void process() {
		for (String command : this.input) {
			String state = getCurrentState();
			states.add(processState(state, command));
		}
	}
	
	public void setInput(ArrayList<String> commands) {
		this.input = commands;
	}
	
	public ArrayList<String> getOutputResults() {
		return this.states;
	}
	
	public ArrayList<String> setStartingState(String startingState) {
		ArrayList<String> states = new ArrayList<String>();
		states.add(startingState);
		return states;
	}
	
	public String getCurrentState() {
		return getLastItem(this.states);
	}
	
	public String getLastItem(ArrayList<String> array) {
		int length = array.size();
		return array.get(length - 1);
	}
	
	public String processState(String state, String command) {
		if (state == this.STATES.CLOSED) {
			return doorInClosedState();
		} else if (state == this.STATES.OPEN) {
			return doorInOpenState();
		} else if (state == this.STATES.CLOSING) {
			return doorInClosingState(command);
		} else if (state == this.STATES.OPENING) {
			return doorInOpeningState(command);
		} else if (state == this.STATES.STOPPED_WHILE_CLOSING) {
			return doorInStoppedWhileClosingState();
		} else if (state == this.STATES.STOPPED_WHILE_OPENING) {
			return doorInStoppedWhileOpeningState();
		}
		return "Invalid Input";
	}
	
	public String doorInClosedState() {
		return this.STATES.OPENING;
	}
	
	public String doorInOpenState() {
		return this.STATES.CLOSING;
	}
	
	public String doorInClosingState(String command) {
		if (command == this.BUTTON_CLICKED) {
			return this.STATES.STOPPED_WHILE_CLOSING;
		}
		return this.STATES.CLOSED;
	}
	
	public String doorInOpeningState(String command) {
		if (command == this.BUTTON_CLICKED) {
			return this.STATES.STOPPED_WHILE_OPENING;
		}
		return this.STATES.OPEN;
	}
	
	public String doorInStoppedWhileClosingState() {
		return this.STATES.OPENING;
	}
	
	public String doorInStoppedWhileOpeningState() {
		return this.STATES.CLOSING;
	}
}
