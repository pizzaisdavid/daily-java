import java.util.ArrayList;

public class Main {
	
	public void main() {
		
	}
	
	public static ArrayList<String> putIncludeStatementFirst(ArrayList<String> program) {
		ArrayList<String> includeStatements = new ArrayList<String>();
		ArrayList<Integer> indicesToRemove = new ArrayList<Integer>();
		for (int i = 0; i < program.size(); i++) {
			String statement = program.get(i);
			if (isIncludeStatement(statement)) {
				includeStatements.add(statement);
				indicesToRemove.add(i);
			}
		}
		program = removeIndices(program, indicesToRemove);
		includeStatements.addAll(program);
		return includeStatements;
	}
	
	public static boolean isIncludeStatement(String statement) {
		String keyword = "#include";
		return statement.contains(keyword);
	}
	
	public static ArrayList<String> removeIndices(ArrayList<String> array, ArrayList<Integer> indices) {
		for (int index : indices) {
			array.remove(index);
		}
		return array;
	}
}