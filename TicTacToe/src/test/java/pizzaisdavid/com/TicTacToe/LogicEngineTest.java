package pizzaisdavid.com.TicTacToe;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class LogicEngineTest {
	ArrayList<ArrayList<String>> expected;
	ArrayList<ArrayList<String>> board;
	ArrayList<ArrayList<String>> actual;
	
	@Before 
	public void before() {
		expected = new ArrayList<ArrayList<String>>();
		board = new ArrayList<ArrayList<String>>();
		actual = new ArrayList<ArrayList<String>>();
	}

	@Test
	public void takeTurn_easyWin() {
		expected = JunitHelper.arrayList.make(
	      new String[] {"X","X", "X"},
	      new String[] {"O","-", "-"},
	      new String[] {"-","O", "-"}
		);
		board = JunitHelper.arrayList.make(
	      new String[] {"X","-", "X"},
	      new String[] {"O","-", "-"},
	      new String[] {"-","O", "-"}
		);
		
		LogicEngine logic = new LogicEngine("X");
		
		actual = logic.takeTurn(board);
		
		assertEquals(expected, actual);
	}

}
