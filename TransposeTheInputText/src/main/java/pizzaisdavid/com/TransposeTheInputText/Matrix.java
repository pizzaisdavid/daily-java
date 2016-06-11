package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends ArrayList<ArrayList<String>> {
  private static final long serialVersionUID = 1L;
  // private List<ArrayList<String>> table_;
  private int rowLength_;
  
  public Matrix(int rowLength) {
    // this = new ArrayList<ArrayList<String>>();
    rowLength_ = rowLength;
  }
  
  public Matrix(ArrayList<ArrayList<String>> input) {
    this.addAll(input);
  }
  
  public void transpose() {
    int rowLength = getLengthOfLongestRow();
    Matrix matrix = new Matrix(rowLength);
    for (int i = 0; i < this.size(); i++) {
      ArrayList<String> row = this.get(i);
      matrix.appendColumn(row);
    }
    this.clear();
    this.addAll(matrix); 
  }
  
  private int getLengthOfLongestRow() {
    List<Integer> lengths = new ArrayList<Integer>();
    for (ArrayList<String> row : this) {
      lengths.add(row.size());
    }
    return max(lengths);
  }
  
  private int max(List<Integer> values) {
    int highest = values.get(0);
    for (int value : values) {
      if (value > highest) {
        highest = value;
      }
    }
    return highest;
  }  

  public void appendColumn(ArrayList<String> row) {
    for (int i = 0; i < rowLength_; i++) {
      String entry = getEntryFromRowOrSpace(row, i);
      appendToRow(entry, i);
    }
  }
  
  private String getEntryFromRowOrSpace(ArrayList<String> row, int position) {
    String entry = " ";
    try {
      entry = row.get(position);
    } catch (IndexOutOfBoundsException e) {}
    return entry;
  }
  
  public void appendToRow(String entry, int position) {
    try {
      appendEntryToRow(entry, position);
    } catch (Exception e) {
      startNewColumn(entry);
    }
  }
  
  public void startNewColumn(String entry) {
    ArrayList<String> newRow = new ArrayList<String>();
    newRow.add(entry);
    this.add(newRow);
  }
  
  public void appendEntryToRow(String entry, int position) throws Exception {
    ArrayList<String> updatedRow = this.get(position);
    updatedRow.add(entry);
    this.set(position, updatedRow);
  }
}
