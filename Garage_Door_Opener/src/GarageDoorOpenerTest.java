import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pizzaisdavid.JunitHelper.JunitHelper;

import java.util.ArrayList;
import java.util.Arrays;


class SpecializationGarageDoor extends GarageDoorOpener {

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

@RunWith(Parameterized.class)
public class GarageDoorOpenerTest {
  
  @Parameters
  public static Iterable<Object[]> data() {
    String USE_DEFAULT_STARTING_VALUE = null;
    ArrayList<String> ISSUE_NO_COMMANDS = new ArrayList<String>();
    ArrayList<String> BUTTON_CLICKED = buttonClicked();
    ArrayList<GarageDoorOpener.State> completeCycle = JunitHelper.arrayList.make(
      GarageDoorOpener.State.CLOSED,
      GarageDoorOpener.State.OPENING,
      GarageDoorOpener.State.OPEN,
      GarageDoorOpener.State.CLOSING,
      GarageDoorOpener.State.STOPPED_WHILE_CLOSING,
      GarageDoorOpener.State.OPENING,
      GarageDoorOpener.State.STOPPED_WHILE_OPENING,
      GarageDoorOpener.State.CLOSING,
      GarageDoorOpener.State.CLOSED
    );
    
    return Arrays.asList(new Object[][] { 
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(0, 1)),
        ISSUE_NO_COMMANDS,
        USE_DEFAULT_STARTING_VALUE
      },
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(0, 3)),
        JunitHelper.arrayList.make(
          "button_clicked",
          "cycle_complete"
        ),
        USE_DEFAULT_STARTING_VALUE
      },
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(1, 2)),
        ISSUE_NO_COMMANDS,
        GarageDoorOpener.State.OPENING
      },
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(3, 5)),
        BUTTON_CLICKED,
        GarageDoorOpener.State.CLOSING
      },
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(5, 7)),
        BUTTON_CLICKED,
        GarageDoorOpener.State.OPENING
      },
      {
        new ArrayList<GarageDoorOpener.State>(completeCycle.subList(6, 8)),
        BUTTON_CLICKED,
        GarageDoorOpener.State.STOPPED_WHILE_OPENING
      }
    });
  }
  
  private ArrayList<GarageDoorOpener.State> expected;
  private ArrayList<String> commands;
  private GarageDoorOpener.State startingState;

  public GarageDoorOpenerTest(ArrayList<GarageDoorOpener.State> expected, ArrayList<String> commands, GarageDoorOpener.State startingState) {
    this.expected = expected;
    this.commands = commands;
    this.startingState = startingState;
  }

  @Test
  public void test() {
    SpecializationGarageDoor opener = makeOpener(this.commands, this.startingState);
    opener.validate(this.expected);
  }
  
//  
//  @Test
//  public void changeFromStoppedWhileClosingToOpening() {
//    ArrayList<GarageDoorOpener.State> expected = JunitHelper.arrayList.make(
//      GarageDoorOpener.State.STOPPED_WHILE_CLOSING,
//      GarageDoorOpener.State.OPENING
//    ); 
//    ArrayList<String> commands = buttonClicked();
//    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.STOPPED_WHILE_CLOSING);
//    opener.validate(expected);
//  }
//  
//  @Test
//  public void changeFromOpenToClosing() {
//    ArrayList<GarageDoorOpener.State> expected = JunitHelper.arrayList.make(
//        GarageDoorOpener.State.OPEN,
//        GarageDoorOpener.State.CLOSING
//      );
//    ArrayList<String> commands = buttonClicked();
//    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.OPEN);
//    opener.validate(expected);
//  }
//  
//  @Test
//  public void changeFromClosingToClosed() {
//    ArrayList<GarageDoorOpener.State> expected = JunitHelper.arrayList.make(
//        GarageDoorOpener.State.CLOSING,
//        GarageDoorOpener.State.CLOSED
//      );
//    ArrayList<String> commands = cycleComplete();
//    SpecializationGarageDoor opener = makeOpener(commands, GarageDoorOpener.State.CLOSING);
//    opener.validate(expected);
//  }

  public static ArrayList<String> buttonClicked() {
    return JunitHelper.arrayList.make("button_clicked");
  }
  
  public static ArrayList<String> cycleComplete() {
    return JunitHelper.arrayList.make("cycle_complete");
  }
  
  public SpecializationGarageDoor makeOpener(ArrayList<String> commands, GarageDoorOpener.State status) {
    if (status == null) {
      return new SpecializationGarageDoor(commands);
    }
    return new SpecializationGarageDoor(commands, status);
  }
}
