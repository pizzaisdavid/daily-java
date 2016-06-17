package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;

public class Column extends ArrayList<String> {

  private static final long serialVersionUID = 1L;
  
  public Column(ArrayList<String> row) {
    clear();
    addAll(row);
  }
}
