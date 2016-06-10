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

  public void appendColumn(ArrayList<String> row) {
    for (int i = 0; i < rowLength_; i++) {
      String entry = "";
      try {
        entry = row.get(i);
      } catch (IndexOutOfBoundsException e) {
        entry = " ";
      }
      try {
        ArrayList<String> updatedRow = table_.get(i);
        updatedRow.add(entry);
        table_.set(i, updatedRow);
      } catch (Exception e) {
        ArrayList<String> newRow = new ArrayList<String>();
        newRow.add(entry);
        table_.add(newRow);
      }
    }
  }
  
  public List<ArrayList<String>> getContent() {
    return table_;
  }
}
