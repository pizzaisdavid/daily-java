
import java.util.ArrayList;

public class GarageDoorOpener {
  enum State {CLOSED, OPENING, OPEN, CLOSING, STOPPED_WHILE_CLOSING, STOPPED_WHILE_OPENING}
	private String BUTTON_CLICK = "button_clicked";
	protected State status;
	private String command;
	private ArrayList<String> commands;
			
  public GarageDoorOpener(ArrayList<String> commands) {
    this.commands = commands;
    status = State.CLOSED;
  }
  
  public void process() {
    for (String command : commands) {
      this.command = command;
      displayInformation();
      printStatus();
      printCommand();
      processState();
    }
    printStatus();
  }

  private void processState() {
	  switch (status) {
  	  case CLOSED:
  	    doorInClosedState();
  	    break;
  	  case OPEN:
  	    doorInOpenState();
        break;
  	  case CLOSING:
  	    doorInClosingState();
  	    break;
  	  case OPENING:
  	    doorInOpeningState();
  	    break;
  	  case STOPPED_WHILE_CLOSING:
  	    doorInStoppedWhileClosingState();
  	    break;
  	  case STOPPED_WHILE_OPENING:
  	    doorInStoppedWhileOpeningState();
  	    break;
  	  default:
  	    break;
	  }
	}
	
	public void doorInClosedState() {
		status = State.OPENING;
	}
	
	public void doorInOpenState() {
		status = State.CLOSING;
	}
	
	public void doorInClosingState() {
		if (BUTTON_CLICK.equals(command)) {
			status = State.STOPPED_WHILE_CLOSING;
		} else {
		  status = State.CLOSED;
		}
	}
	
	public void doorInOpeningState() {
		if (BUTTON_CLICK.equals(command)) {
		  status = State.STOPPED_WHILE_OPENING;
		} else {
		  status = State.OPEN;
		}
	}
	
	public void doorInStoppedWhileClosingState() {
	  status = State.OPENING;
	}
	
	public void doorInStoppedWhileOpeningState() {
	  status = State.CLOSING;
	}
	
	protected void printStatus() {
    System.out.println("Door: " + status);
	}
	
	protected void printCommand() {
	  System.out.println("> " + command);
	}
}
