package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;

public class Column extends ArrayList<String> {

  private static final long serialVersionUID = 1L;
  private String CELl_PLACEHOLDER_VALUE = " ";
  
  public Column(ArrayList<String> row) {
    clear();
    addAll(row);
  }
  
  public String getCell(int index) {
    try {
      return get(index);
    } catch (IndexOutOfBoundsException e) {
      return CELl_PLACEHOLDER_VALUE;
    }
  }
}
