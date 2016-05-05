import java.util.ArrayList;

public class CodeSort {
	private ArrayList<String> program;
	
	public CodeSort(ArrayList<String> program) {
		this.program = program;
	}
	
	public ArrayList<String> sort() {
		this.program = initializeVariablesBeforeUse(this.program);
    this.program = putIncludeStatementsFirst(this.program);
		return this.program;
	}
	
  private ArrayList<String> putIncludeStatementsFirst(ArrayList<String> program) {
    return putStatementsWithKeywordFirst(program, "#include");
  }
  
  private ArrayList<String> initializeVariablesBeforeUse(ArrayList<String> program) {
    return putStatementsWithKeywordFirst(program, "var ");
  }
  
  private ArrayList<String> putStatementsWithKeywordFirst(ArrayList<String> program, String keyword) {
		ArrayList<String> keywordStatements = new ArrayList<String>();
		ArrayList<String> otherStatements = new ArrayList<String>();
		for (String statement : program) {
			if (statement.contains(keyword)) {
			  keywordStatements.add(statement);
			} else {
				otherStatements.add(statement);
			}
		}
		return append(keywordStatements, otherStatements);
	}
  
  private ArrayList<String> append(ArrayList<String> leadingArray, ArrayList<String> trailingArray) {
    ArrayList<String> newArray = new ArrayList<String>();
    newArray.addAll(leadingArray);
    newArray.addAll(trailingArray);
    return newArray;
  }
}
