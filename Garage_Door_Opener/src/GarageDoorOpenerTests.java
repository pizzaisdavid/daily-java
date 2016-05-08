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
    
    protected void printStatus(State status) {
      if (this.outputs == null) {
        this.outputs = new ArrayList<State>();
      }
      this.outputs.add(status);
    }
    
    protected void printCommand(String command) {
      // Don't print things during testing.
    }
    
    public void validate(ArrayList<GarageDoorOpener.State> input) {
      assertEquals(input, this.outputs);
    }
  }

	@Test
	public void startingStateIsClosed() {
	  ArrayList<GarageDoorOpener.State> expected = new ArrayList<GarageDoorOpener.State>(
	    Arrays.asList(GarageDoorOpener.State.CLOSED)
	  );	  
		ArrayList<String> commands = new ArrayList<String>(
		  Arrays.asList("button_clicked")
		);
		SpecializationGarageDoor opener = new SpecializationGarageDoor(commands);
		opener.validate(expected);
	}
}
