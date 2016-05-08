import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class GarageDoorOpenerTests {
	
  private class SpecializationGarageDoor extends GarageDoorOpener {

    private ArrayList<State> outputs;
    
    public SpecializationGarageDoor(ArrayList<String> commands) {
      super(commands);
    }
    
    public SpecializationGarageDoor(ArrayList<String> commands, State status) {
      super(commands, status);
    }
    
    protected void printStatus(State status) {
      if (this.outputs == null) {
        this.outputs = new ArrayList<State>();
      }
      this.outputs.add(status);
    }
    
    protected void printCommand(String command) {
      // Don't print things during testing.
    }
    
    public void validate(ArrayList<GarageDoorOpener.State> expected) {
      assertEquals(expected, this.outputs);
    }
  }

	@Test
	public void startingStateIsClosed() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
	    GarageDoorOpener.State.CLOSED
	  );	  
		ArrayList<String> commands = new ArrayList<String>();
		SpecializationGarageDoor opener = new SpecializationGarageDoor(commands);
		opener.validate(expected);
	}
	
	@Test
  public void completeUninterruptedCycle() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.CLOSED,
      GarageDoorOpener.State.OPENING,
      GarageDoorOpener.State.OPEN
	  );  
	  ArrayList<String> commands = new ArrayList<String>(
	    Arrays.asList(
        "button_clicked",
        "cycle_complete"
	    )
	  );
	  SpecializationGarageDoor opener = new SpecializationGarageDoor(commands);
    opener.validate(expected);
  }
  
  @Test
  public void setDifferentStartingState() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.CLOSING
    ); 
    ArrayList<String> commands = new ArrayList<String>();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.CLOSING);
    opener.validate(expected);
  }
  
  @Test
  public void interruptedWhileClosing() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.CLOSING,
      GarageDoorOpener.State.STOPPED_WHILE_CLOSING
    ); 
    ArrayList<String> commands = buttonClicked();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.CLOSING);
    opener.validate(expected);
  }
  
  @Test
  public void interruptedWhileOpening() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.OPENING,
      GarageDoorOpener.State.STOPPED_WHILE_OPENING
    ); 
    ArrayList<String> commands = buttonClicked();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.OPENING);
    opener.validate(expected);
  }
  
  @Test
  public void changeFromStoppedWhileOpeningToClosing() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.STOPPED_WHILE_OPENING,
      GarageDoorOpener.State.CLOSING
    ); 
    ArrayList<String> commands = buttonClicked();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.STOPPED_WHILE_OPENING);
    opener.validate(expected);
  }
  
  @Test
  public void changeFromStoppedWhileClosingToOpening() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
      GarageDoorOpener.State.STOPPED_WHILE_CLOSING,
      GarageDoorOpener.State.OPENING
    ); 
    ArrayList<String> commands = buttonClicked();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.STOPPED_WHILE_CLOSING);
    opener.validate(expected);
  }
  
  @Test
  public void changeFromOpenToClosing() {
    ArrayList<GarageDoorOpener.State> expected = makeStateArrayList(
        GarageDoorOpener.State.OPEN,
        GarageDoorOpener.State.CLOSING
      );
    ArrayList<String> commands = buttonClicked();
    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.OPEN);
    opener.validate(expected);
  }
  
  public ArrayList<GarageDoorOpener.State> makeStateArrayList(GarageDoorOpener.State...states) {
    ArrayList<GarageDoorOpener.State> expected = new ArrayList<GarageDoorOpener.State>();
    for (GarageDoorOpener.State state: states) {
      expected.add(state);
    }
    return expected;
  }
  
  public ArrayList<String> buttonClicked() {
    return new ArrayList<String>(
      Arrays.asList(
        "button_clicked"
      )
    );
  }
  
  public SpecializationGarageDoor makeOpener(ArrayList<String> commands, GarageDoorOpener.State status) {
    return new SpecializationGarageDoor(commands, status);
    
  }
}
