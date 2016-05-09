package test.java.com.mycompany.daily;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import main.java.com.mycompany.daily.TextFile;

public class TextFileTest {
  
  public ArrayList<String> make(String... strings) {
    ArrayList<String> expected = new ArrayList<String>();
    for (String string : strings) {
      expected.add(string);
    }
    return expected;
  }
  
  public SpecializationTextFile makeFile(String input) {
    return new SpecializationTextFile("test.txt", input);
    
  }
  
  private class SpecializationTextFile extends TextFile {
    
    public boolean throwFileNotFoundException;
    private String content;
    
    public SpecializationTextFile(String relativePath, String content) {
      this(relativePath);
      this.content = content;
    }
    
    public SpecializationTextFile(String relativePath) {
      super(relativePath);
      this.throwFileNotFoundException = false;
    }

    protected Scanner createScanner(String filePath) throws FileNotFoundException {
      if (this.throwFileNotFoundException) {
        throw new FileNotFoundException();
      } else {
        return new Scanner(this.content);
      }
    }
  }

  @Test
  public void fileNotFound() {
    SpecializationTextFile file = makeFile(null);
    file.throwFileNotFoundException = true;
    file.getLines();
  }
  
  @Test
  public void tset() {
    ArrayList<String> expected = make("1", "2");
    String input = "1\n" +
                   "2";
    SpecializationTextFile file = makeFile(input);
    assertEquals(expected, file.getLines());
  }
  
}
