import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class CodeSortTests {

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
	
	@Test
	public void sort_initializeVariablesBeforeUse() {
	  ArrayList<String> program = new ArrayList<String>();
	  program.add("sum + i = sum;");
	  program.add("var sum = 0;");
	  
	  CodeSort x = new CodeSort(program);
	  ArrayList<String> output = x.sort();
	  
	  assertEquals("var sum = 0;", output.get(0));
	  assertEquals("sum + i = sum;", output.get(1));
	  assertEquals(2, output.size());
	}
	
	 @Test
	  public void sort() {
	    ArrayList<String> program = new ArrayList<String>();
	    program.add("sum + i = sum;");
	    program.add("var sum = 0;");
	    program.add("}");
	    program.add("#include <iostream>");
	    
	    CodeSort x = new CodeSort(program);
	    ArrayList<String> output = x.sort();
	    
	    assertEquals("#include <iostream>", output.get(0));
	    assertEquals("var sum = 0;", output.get(1));
	    assertEquals(4, output.size());
	  }
	

}
