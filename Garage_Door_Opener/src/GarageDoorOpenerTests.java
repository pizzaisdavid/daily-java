import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class GarageDoorOpenerTests {
	
  private class SpecializationGarageDoor extends GarageDoorOpener {

    private State output;
    
    public SpecializationGarageDoor(ArrayList<String> commands) {
      super(commands);
    }
    
    protected void printStatus(State status) {
      this.output = status;
    }
    
    protected void printCommand(String command) {
      // Don't print things during testing.
    }
    
    public void validate(GarageDoorOpener.State input) {
      assertEquals(input, this.output);
    }
  }

	@Test
	public void startingStateIsClosed() {
	  ArrayList<String> expected = new ArrayList<String>();
	  expected.add("CLOSED");
	  
		ArrayList<String> commands = new ArrayList<String>(
		    Arrays.asList("click")
		    );
		
		SpecializationGarageDoor opener = new SpecializationGarageDoor(commands);
		
		opener.validate(GarageDoorOpener.State.CLOSED);
	}
}
