package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends ArrayList<ArrayList<String>> {
  private static final long serialVersionUID = 1L;
  private int columnLength_;
  
  public Matrix() {
    columnLength_ = 0;
  }
  
  public Matrix(ArrayList<ArrayList<String>> input) {
    clear();
    addAll(input);
  }
  
  public void transpose() {
    Matrix matrix = new Matrix();
    for (ArrayList<String> row : this) {
      matrix.appendColumn(row);
    }
    clear();
    addAll(matrix); 
  }

  public void appendColumn(ArrayList<String> column) {
    if (column.size() > columnLength_) {
      columnLength_ = column.size();
      appendWhiteSpaceToOldColumns();
    }
    for (int i = 0; i < columnLength_; i++) {
      String entry = getEntryFromRowOrSpace(column, i);
      appendToRow(entry, i);
    }
  }
  
  private void appendWhiteSpaceToOldColumns() {
    // TODO
  }

  private String getEntryFromRowOrSpace(ArrayList<String> row, int position) {
    // TODO make better names
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
    add(newRow);
  }
  
  public void appendEntryToRow(String entry, int position) throws Exception {
    ArrayList<String> updatedRow = get(position);
    updatedRow.add(entry);
    set(position, updatedRow);
  }
}
