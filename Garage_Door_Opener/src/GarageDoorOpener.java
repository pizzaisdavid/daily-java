
import java.util.ArrayList;

public class GarageDoorOpener {
  enum State {CLOSED, OPENING, OPEN, CLOSING, STOPPED_WHILE_CLOSING, STOPPED_WHILE_OPENING}
	private String BUTTON_CLICKED = "button_clicked";
			
  public GarageDoorOpener(ArrayList<String> commands) {
		State status = State.CLOSED;
		for (String command : commands) {
		  printStatus(status);
		  printCommand(command);
			status = processState(status, command);
		}
	}

  public State processState(State status, String command) {
	  switch (status) {
  	  case CLOSED:
  	    return doorInClosedState();
  	  case OPEN:
  	    return doorInOpenState();
  	  case CLOSING:
  	    return doorInClosingState(command);
  	  case OPENING:
  	    return doorInOpeningState(command);
  	  case STOPPED_WHILE_CLOSING:
  	    return doorInStoppedWhileClosingState();
  	  case STOPPED_WHILE_OPENING:
  	    return doorInStoppedWhileOpeningState();
	  }
    return status;
	}
	
	public State doorInClosedState() {
		return State.OPENING;
	}
	
	public State doorInOpenState() {
		return State.CLOSING;
	}
	
	public State doorInClosingState(String command) {
		if (command == this.BUTTON_CLICKED) {
			return State.STOPPED_WHILE_CLOSING;
		}
		return State.CLOSED;
	}
	
	public State doorInOpeningState(String command) {
		if (command == this.BUTTON_CLICKED) {
			return State.STOPPED_WHILE_OPENING;
		}
		return State.OPEN;
	}
	
	public State doorInStoppedWhileClosingState() {
		return State.OPENING;
	}
	
	public State doorInStoppedWhileOpeningState() {
		return State.CLOSING;
	}
	
	protected void printStatus(State status) {
    System.out.println("Door: " + status);
	}
	
	protected void printCommand(String command) {
	  System.out.println("> " + command);
	}
}
