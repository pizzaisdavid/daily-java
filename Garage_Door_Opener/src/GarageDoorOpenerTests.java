import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class GarageDoorOpenerTests {
	// TODO put this in its own project.

	@Test
	public void main_startingStateIsClosed() {
		ArrayList<String> commands = new ArrayList<String>();
		
		GarageDoorOpener opener = new GarageDoorOpener();
		opener.setInput(commands);
		opener.process();
		
		ArrayList<String> outputResults = opener.getOutputResults();
		assertEquals("CLOSED", outputResults.get(0));
	}
	
	@Test
	public void main_completeUninterruptedCycle() {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("button_clicked");
		commands.add("cycle_complete");

		GarageDoorOpener opener = new GarageDoorOpener();
		opener.setInput(commands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("CLOSED", outputResults.get(0));
		assertEquals("OPENING", outputResults.get(1));
		assertEquals("OPEN", outputResults.get(2));
	}
	
	@Test
	public void main_setDifferentStartingState() {
		GarageDoorOpener opener = new GarageDoorOpener("CLOSING");
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("CLOSING", outputResults.get(0));
		assertEquals(1, outputResults.size());
	}
	
	@Test
	public void main_interruptedWhileClosing() {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("button_clicked");
		
		GarageDoorOpener opener = new GarageDoorOpener("CLOSING");
		opener.setInput(commands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("CLOSING", outputResults.get(0));
		assertEquals("STOPPED_WHILE_CLOSING", outputResults.get(1));
	}
	
	@Test
	public void main_interruptedWhileOpening() {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("button_clicked");
		
		GarageDoorOpener opener = new GarageDoorOpener("OPENING");
		opener.setInput(commands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("OPENING", outputResults.get(0));
		assertEquals("STOPPED_WHILE_OPENING", outputResults.get(1));
	}
	
	@Test
	public void main_changeFromStoppedWhileOpeningToClosing() {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("button_clicked");
		
		GarageDoorOpener opener = new GarageDoorOpener("STOPPED_WHILE_OPENING");
		opener.setInput(commands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("STOPPED_WHILE_OPENING", outputResults.get(0));
		assertEquals("CLOSING", outputResults.get(1));
	}
	
	@Test
	public void main_changeFromStoppedWhileClosingToOpening() {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("button_clicked");
		
		GarageDoorOpener opener = new GarageDoorOpener("STOPPED_WHILE_CLOSING");
		opener.setInput(commands);
		opener.process();
		ArrayList<String> outputResults = opener.getOutputResults();
		
		assertEquals("STOPPED_WHILE_CLOSING", outputResults.get(0));
		assertEquals("OPENING", outputResults.get(1));
	}
	
}
