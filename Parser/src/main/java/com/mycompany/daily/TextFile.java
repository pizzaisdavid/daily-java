package main.java.com.mycompany.daily;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFile {
  
  private String filePath;
  private ArrayList<String> content;
  
  public TextFile(String filePath) {
    this.filePath = filePath;
    this.content = new ArrayList<String>();
  }
  
  public ArrayList<String> lines() {
    try {
      return load(this.filePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new ArrayList<String>();
    }
  }
  
  public ArrayList<String> load(String filePath) throws FileNotFoundException {
    this.content.clear();
    Scanner scanner = createScanner(filePath);
    while (scanner.hasNextLine()){
      this.content.add(scanner.nextLine());
    }
    scanner.close();
    return this.content;
  }
  
  public Scanner createScanner(String filePath) throws FileNotFoundException {
    return new Scanner(new File(filePath));
  }
}
