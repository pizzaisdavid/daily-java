import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class MainTests {

	@Test
	public void sort_putIncludeStatementFirst() {
		ArrayList<String> program = new ArrayList<String>();
		program.add("}");
		program.add("#include <iostream>");
		
		CodeSort x = new CodeSort(program);
		ArrayList<String> output = x.sort();
		
		assertEquals("#include <iostream>", output.get(0));
		assertEquals("}", output.get(1));
		assertEquals(2, output.size());
	}

}
