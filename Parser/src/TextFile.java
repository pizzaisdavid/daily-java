import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFile {
  
  private String filePath;
  
  public TextFile(String filePath) {
    this.filePath = filePath;
  }
  
  public ArrayList<String> lines() {
    ArrayList<String> content = new ArrayList<String>();
    try {
      Scanner s = new Scanner(new File(this.filePath));
      while (s.hasNextLine()){
        content.add(s.nextLine());
      }
      s.close();
      return content;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new ArrayList<String>();
    }
  }
}
