import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class CodeSortTests {
	ArrayList<String> expected;
	ArrayList<String> program;
	ArrayList<String> output;
	
	@Before
	public void before() {
		expected = new ArrayList<String>();
		program = new ArrayList<String>();
		output = new ArrayList<String>();
	}

	@Test
	public void sort_putIncludeStatementFirst() {
		expected = JunitHelper.arrayList.make("#include <iostream>", "}");
    program = JunitHelper.arrayList.make("}", "#include <iostream>");
		CodeSort code = new CodeSort(program);
		output = code.sort();
		assertEquals(expected, output);
	}
	
	@Test
	public void sort_initializeVariablesBeforeUse() {
	  expected = JunitHelper.arrayList.make("var sum = 0;", "sum + i = sum;");
	  program = JunitHelper.arrayList.make("sum + i = sum;", "var sum = 0;");
	  CodeSort code = new CodeSort(program);
	  output = code.sort();
	  assertEquals(expected, output);
	}
	
	@Test
  public void sort() {
    program = JunitHelper.arrayList.make(
      "sum + i = sum;",
      "var sum = 0;",
      "}",
      "#include <iostream>"
    );
    CodeSort code = new CodeSort(program);
    output = code.sort();
    assertEquals("#include <iostream>", output.get(0));
    assertEquals("var sum = 0;", output.get(1));
    assertEquals(4, output.size());
  }
}
