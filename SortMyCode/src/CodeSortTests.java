import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import test.java.com.mycompany.daily.JunitHelper;

public class CodeSortTests {

	@Test
	public void sort_putIncludeStatementFirst() {
		ArrayList<String> expected = JunitHelper.make("#include <iostream>", "}");
    ArrayList<String> program = JunitHelper.make("}", "#include <iostream>");
		CodeSort code = new CodeSort(program);
		ArrayList<String> output = code.sort();
		assertEquals(expected, output);
	}
	
	@Test
	public void sort_initializeVariablesBeforeUse() {
	  ArrayList<String> expected = JunitHelper.make("var sum = 0;", "sum + i = sum;");
	  ArrayList<String> program = JunitHelper.make("sum + i = sum;", "var sum = 0;");
	  CodeSort code = new CodeSort(program);
	  ArrayList<String> output = code.sort();
	  assertEquals(expected, output);
	}
	
	@Test
  public void sort() {
    ArrayList<String> program = JunitHelper.make(
      "sum + i = sum;",
      "var sum = 0;",
      "}",
      "#include <iostream>"
    );
    CodeSort code = new CodeSort(program);
    ArrayList<String> output = code.sort();
    assertEquals("#include <iostream>", output.get(0));
    assertEquals("var sum = 0;", output.get(1));
    assertEquals(4, output.size());
  }
}
