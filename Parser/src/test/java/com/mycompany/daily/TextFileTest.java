package test.java.com.mycompany.daily;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import main.java.com.mycompany.daily.TextFile;

import com.pizzaisdavid.JunitHelper.JunitHelper;

class SpecializationTextFile extends TextFile {
  
  private String content;
  
  public SpecializationTextFile(String relativePath, String content) {
    super(relativePath);
    this.content = content;
  }

  protected Scanner createScanner(String filePath) throws FileNotFoundException {
    return new Scanner(this.content);
  }
}

public class TextFileTest {
  
  public String makeTestFile(String...strings) {
    String file = "";
    for (String string : strings) {
      file += string + "\n";
    }
    return file;
  }
  
  @Test
  public void getLines() {
    ArrayList<String> expected = JunitHelper.arrayList.make("1", "2");
    String input = makeTestFile("1", "2");
    SpecializationTextFile file = new SpecializationTextFile("test.txt", input);
    assertEquals(expected, file.getLines());
  }
  
  @Test
  public void fileNotFound() {
    TextFile file = new TextFile("non-existing_file.txt");
    file.getLines();
  }
}
