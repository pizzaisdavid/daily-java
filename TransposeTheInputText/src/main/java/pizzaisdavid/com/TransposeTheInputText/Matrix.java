package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;

public class Matrix extends ArrayList<ArrayList<String>> {
  private static final long serialVersionUID = 1L;
  private int longestColumnLength;
  String PLACEHOLDER_CELL_VALUE = " ";
  
  public Matrix() {
    longestColumnLength = 0;
  }
  
  public Matrix(ArrayList<ArrayList<String>> input) {
    clear();
    addAll(input);
  }
  
  public void transpose() {
    Matrix matrix = new Matrix();
    for (ArrayList<String> row : this) {
      Column column = new Column(row);
      matrix.append(column);
    }
    clear();
    addAll(matrix); 
  }

  public void append(Column column) {
    setLongestColumnLength(column);
    for (int i = 0; i < longestColumnLength; i++) {
      String cell = column.getCell(i);
      appendToColumn(cell, i);
    }
  }
  
  private void setLongestColumnLength(Column column) {
    if (column.size() > longestColumnLength) {
      longestColumnLength = column.size();
    }
  }

  private void appendToColumn(String cell, int index) {
    if (size() < index + 1) {
      startColumn(cell);
    } else {
      appendToRow(cell, index);
    }
  }

  public void startColumn(String cell) {
    ArrayList<String> newColumn = new ArrayList<String>();
    newColumn.add(cell);
    add(newColumn);
  }
  
  public void appendToRow(String cell, int index) {
    ArrayList<String> updatedRow = get(index);
    updatedRow.add(cell);
    set(index, updatedRow);
  }
}
