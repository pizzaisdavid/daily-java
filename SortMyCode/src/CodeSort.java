import java.util.ArrayList;

public class CodeSort {
	private ArrayList<String> program;
	
	public CodeSort(ArrayList<String> program) {
		this.program = program;
	}
	
	public ArrayList<String> sort() {
		initializeVariablesBeforeUse();
    putIncludeStatementsFirst();
		return program;
	}
	
  private void putIncludeStatementsFirst() {
    putStatementsWithKeywordFirst("#include");
  }
  
  private void initializeVariablesBeforeUse() {
    putStatementsWithKeywordFirst("var ");
  }
  
  private void putStatementsWithKeywordFirst(String keyword) {
		ArrayList<String> keywordStatements = new ArrayList<String>();
		ArrayList<String> otherStatements = new ArrayList<String>();
		for (String statement : program) {
			if (statement.contains(keyword)) {
			  keywordStatements.add(statement);
			} else {
				otherStatements.add(statement);
			}
		}
		program = combine(keywordStatements, otherStatements);
	}
  
  private ArrayList<String> combine(ArrayList<String> leadingArray, ArrayList<String> trailingArray) {
    ArrayList<String> newArray = new ArrayList<String>();
    newArray.addAll(leadingArray);
    newArray.addAll(trailingArray);
    return newArray;
  }
}
