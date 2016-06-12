package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;
import java.util.List;

public class Matrix extends ArrayList<ArrayList<String>> {
  private static final long serialVersionUID = 1L;
  private int columnLength_;
  String PLACEHOLDER_CELL_VALUE = " ";
  
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
    }
    for (int i = 0; i < columnLength_; i++) {
      String cell = getCellOrPlaceholder(column, i);
      appendColumnCell(cell, i);
    }
  }

  private String getCellOrPlaceholder(ArrayList<String> list, int index) {
    if (list.size() < index + 1) {
      return PLACEHOLDER_CELL_VALUE;
    }
    return list.get(index);
  }
  
  public void appendColumnCell(String cell, int index) {
    try {
      appendEntryToRow(cell, index);
    } catch (Exception e) {
      startColumn(cell);
    }
  }
  
  public void startColumn(String cell) {
    ArrayList<String> newColumn = new ArrayList<String>();
    newColumn.add(cell);
    add(newColumn);
  }
  
  public void appendEntryToRow(String cell, int index) throws Exception {
    ArrayList<String> updatedRow = get(index);
    updatedRow.add(cell);
    set(index, updatedRow);
  }
}
