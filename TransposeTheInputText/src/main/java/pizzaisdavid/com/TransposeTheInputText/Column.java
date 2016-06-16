package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;

public class Column extends ArrayList<ArrayList<String>> {

  private static final long serialVersionUID = 1L;
  
  private Column(ArrayList<String> row) {
    for (String cell: row) {
      add(cell);
    }
  }

  public static Column convertRowToColumn(ArrayList<String> row) {
    return new Column(row);
  }

  public void add(String cell) {
    ArrayList<String> singleCellRow = new ArrayList<String>();
    singleCellRow.add(cell);
    add(singleCellRow);
  }
  
  public String get_(int index) {
    int FIRST_VALUE = 0;
    return get(index).get(FIRST_VALUE);
  }
}
