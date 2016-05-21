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

  public ArrayList<State_> outputs_;
  
  public SpecializationGarageDoor(ArrayList<String> commands) {
    super(commands);
  }
  
  protected void printStatus(State_ status) {
    if (outputs_ == null) {
      outputs_ = new ArrayList<State_>();
    }
    outputs_.add(status);
  }
  
  protected void printCommand(String command) {
    // Don't print things during testing.
  }
  
  public void validate(ArrayList<GarageDoorOpener.State_> expected) {
    assertEquals(expected, outputs_);
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
            GarageDoorOpener.State_.CLOSED
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
            GarageDoorOpener.State_.CLOSED,
            GarageDoorOpener.State_.OPENING,
            GarageDoorOpener.State_.OPEN,
            GarageDoorOpener.State_.CLOSING,
            GarageDoorOpener.State_.STOPPED_WHILE_CLOSING,
            GarageDoorOpener.State_.OPENING,
            GarageDoorOpener.State_.STOPPED_WHILE_OPENING,
            GarageDoorOpener.State_.CLOSING,
            GarageDoorOpener.State_.CLOSED
          )
        }
        
      }
    );
  }
  
  @Parameter
  public String testName_;
  
  @Parameter(value = 1)
  public ArrayList<String> commands_;
  
  @Parameter(value = 2)
  public ArrayList<GarageDoorOpener.State_> expected_;


  @Test
  public void test() {
    SpecializationGarageDoor opener = new SpecializationGarageDoor(commands_);
    opener.validate(expected_);
  }
}
