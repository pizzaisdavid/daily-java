package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
  
  private List<ArrayList<String>> table_;
  private int rowLength_;
  
  public Matrix(int rowLength) {
    table_ = new ArrayList<ArrayList<String>>();
    rowLength_ = rowLength;
  }
  
  public Matrix(ArrayList<ArrayList<String>> input) {
    table_ = input;
  }
  
  public void transpose() {
    int rowLength = getLengthOfLongestRow(table_);
    Matrix matrix = new Matrix(rowLength);
    for (ArrayList<String> row : table_) {
      matrix.appendColumn(row);
    }
    table_ = matrix.getContent(); 
  }
  
  private int getLengthOfLongestRow(List<ArrayList<String>> table) {
    List<Integer> lengths = new ArrayList<Integer>();
    for (ArrayList<String> row : table) {
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
    // TODO detect the need to make " " on its own. 
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
    table_.add(newRow);
  }
  
  public void appendEntryToRow(String entry, int position) throws Exception {
    ArrayList<String> updatedRow = table_.get(position);
    updatedRow.add(entry);
    table_.set(position, updatedRow);
  }
  
  public List<ArrayList<String>> getContent() {
    return table_;
  }
}
