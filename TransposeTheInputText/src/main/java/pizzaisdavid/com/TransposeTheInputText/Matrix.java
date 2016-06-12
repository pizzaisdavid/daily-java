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
      ArrayList<ArrayList<String>> column = convertRowToColumn(row);
      matrix.append(column);
    }
    clear();
    addAll(matrix); 
  }

  private ArrayList<ArrayList<String>> convertRowToColumn(ArrayList<String> row) {
    ArrayList<ArrayList<String>> column = new ArrayList<ArrayList<String>>();
    for (String cell : row) {
      ArrayList<String> singleCellRow = new ArrayList<String>();
      singleCellRow.add(cell);
      column.add(singleCellRow);
    }
    return column;
  }

  public void append(ArrayList<ArrayList<String>> column) {
    if (column.size() > longestColumnLength) {
      longestColumnLength = column.size();
    }
    for (int i = 0; i < longestColumnLength; i++) {
      String cell = getCellOrPlaceholder(column, i);
      appendCellToColumn(cell, i);
    }
  }

  private String getCellOrPlaceholder(ArrayList<ArrayList<String>> column, int index) {
    if (column.size() < index + 1) {
      return PLACEHOLDER_CELL_VALUE;
    }
    int FIRST_VALUE = 0;
    return column.get(index).get(FIRST_VALUE);
  }
  
  public void appendCellToColumn(String cell, int index) {
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
