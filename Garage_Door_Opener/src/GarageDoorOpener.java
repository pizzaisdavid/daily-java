
import java.util.ArrayList;

public class GarageDoorOpener {
  enum State_ {CLOSED, OPENING, OPEN, CLOSING, STOPPED_WHILE_CLOSING, STOPPED_WHILE_OPENING}
	private String BUTTON_CLICK = "button_clicked";
	private State_ status_;
			
  public GarageDoorOpener(ArrayList<String> commands) {
    status_ = State_.CLOSED;
    process(commands);	}
  
  private void process(ArrayList<String> commands) {
    for (String command : commands) {
      printStatus(status_);
      printCommand(command);
      status_ = processState(status_, command);
    }
    printStatus(status_);
  }

  private State_ processState(State_ status, String command) {
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
	
	public State_ doorInClosedState() {
		return State_.OPENING;
	}
	
	public State_ doorInOpenState() {
		return State_.CLOSING;
	}
	
	public State_ doorInClosingState(String command) {
		if (BUTTON_CLICK.equals(command)) {
			return State_.STOPPED_WHILE_CLOSING;
		}
		return State_.CLOSED;
	}
	
	public State_ doorInOpeningState(String command) {
		if (BUTTON_CLICK.equals(command)) {
			return State_.STOPPED_WHILE_OPENING;
		}
		return State_.OPEN;
	}
	
	public State_ doorInStoppedWhileClosingState() {
		return State_.OPENING;
	}
	
	public State_ doorInStoppedWhileOpeningState() {
		return State_.CLOSING;
	}
	
	protected void printStatus(State_ status) {
    System.out.println("Door: " + status);
	}
	
	protected void printCommand(String command) {
	  System.out.println("> " + command);
	}
}
