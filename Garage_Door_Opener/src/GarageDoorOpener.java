
import java.util.ArrayList;

public class GarageDoorOpener {
  enum State {CLOSED, OPENING, OPEN, CLOSING, STOPPED_WHILE_CLOSING, STOPPED_WHILE_OPENING}
	private String BUTTON_CLICK = "button_clicked";
	private State status;
			
  public GarageDoorOpener(ArrayList<String> commands) {
    status = State.CLOSED;
    process(commands);	}
  
  private void process(ArrayList<String> commands) {
    for (String command : commands) {
      printStatus(status);
      printCommand(command);
      status = processState(status, command);
    }
    printStatus(status);
  }

  private State processState(State status, String command) {
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
  	  default:
  	    return status;
	  }
	}
	
	public State doorInClosedState() {
		return State.OPENING;
	}
	
	public State doorInOpenState() {
		return State.CLOSING;
	}
	
	public State doorInClosingState(String command) {
		if (BUTTON_CLICK.equals(command)) {
			return State.STOPPED_WHILE_CLOSING;
		}
		return State.CLOSED;
	}
	
	public State doorInOpeningState(String command) {
		if (BUTTON_CLICK.equals(command)) {
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
