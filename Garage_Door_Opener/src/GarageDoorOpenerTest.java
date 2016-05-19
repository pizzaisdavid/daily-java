import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.pizzaisdavid.JunitHelper.JunitHelper;

import java.util.ArrayList;
import java.util.Arrays;


class SpecializationGarageDoor extends GarageDoorOpener {

  public ArrayList<State> outputs;
  
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
  
  public void validate(ArrayList<GarageDoorOpener.State> expected) {
    assertEquals(expected, this.outputs);
  }
}

@RunWith(Parameterized.class)
public class GarageDoorOpenerTest {
  
  @Parameters(name = "{0}")
  public static Iterable<Object[]> data() {
    ArrayList<String> NO_COMMAND = new ArrayList<String>();    
    return Arrays.asList(
      new Object[][] { 
        
        {
          "verifyStartingStateIsClosed",
          NO_COMMAND,
          JunitHelper.arrayList.make(
            GarageDoorOpener.State.CLOSED
          )
        },
        
        {
          "rotateThroughCombinations",
          JunitHelper.arrayList.make(
            "button_clicked",
            "cycle_complete",
            "button_clicked",
            "button_clicked",
            "button_clicked",
            "button_clicked",
            "button_clicked",
            "cycle_complete"
          ),
          JunitHelper.arrayList.make(
            GarageDoorOpener.State.CLOSED,
            GarageDoorOpener.State.OPENING,
            GarageDoorOpener.State.OPEN,
            GarageDoorOpener.State.CLOSING,
            GarageDoorOpener.State.STOPPED_WHILE_CLOSING,
            GarageDoorOpener.State.OPENING,
            GarageDoorOpener.State.STOPPED_WHILE_OPENING,
            GarageDoorOpener.State.CLOSING,
            GarageDoorOpener.State.CLOSED
          )
        }
        
      }
    );
  }
  
  @Parameter
  public String testName;
  
  @Parameter(value = 1)
  public ArrayList<String> commands;
  
  @Parameter(value = 2)
  public ArrayList<GarageDoorOpener.State> expected;


  @Test
  public void test() {
    SpecializationGarageDoor opener = new SpecializationGarageDoor(this.commands);
    opener.validate(this.expected);
  }
}
