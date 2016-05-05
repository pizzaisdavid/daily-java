import java.util.ArrayList;

public class CodeSort {
	private ArrayList<String> program;
	
	public CodeSort(ArrayList<String> program) {
		this.program = program;
	}
	
	public ArrayList<String> sort() {
		return putIncludeStatementsFirst(this.program);
	}
	
	private ArrayList<String> putIncludeStatementsFirst(ArrayList<String> program) {
		ArrayList<String> includeStatements = new ArrayList<String>();
		ArrayList<String> otherStatements = new ArrayList<String>();
		for (String statement : program) {
			if (isIncludeStatement(statement)) {
				includeStatements.add(statement);
			} else {
				otherStatements.add(statement);
			}
		}
		includeStatements.addAll(otherStatements);
		return includeStatements;
	}
	
	private boolean isIncludeStatement(String statement) {
		String keyword = "#include";
		return statement.contains(keyword);
	}
}
