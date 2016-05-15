package main.java.com.mycompany.daily;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFile {
  
  private String relativePath;
  
  public TextFile(String relativePath) {
    this.relativePath = relativePath;
  }
  
  public ArrayList<String> getLines() {
    try {
      return load(this.relativePath);
    } catch (FileNotFoundException e) {
      return noFileFound(e);
    }
  }
  
  protected ArrayList<String> load(String path) throws FileNotFoundException {
    ArrayList<String> content = new ArrayList<String>();
    Scanner scanner = createScanner(path);
    while (scanner.hasNextLine()){
      content.add(scanner.nextLine());
    }
    scanner.close();
    return content;
  }
  
  protected Scanner createScanner(String path) throws FileNotFoundException {
    return new Scanner(new File(path));
  }
  
  protected ArrayList<String> noFileFound(FileNotFoundException e) {
    e.printStackTrace();
    return null;
  }
}
