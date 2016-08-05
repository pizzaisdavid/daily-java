package pizzaisdavid.com.TicTacToe;

import java.util.ArrayList;

public class LogicEngine {

	private static final String EMPTY_CELL = "-";
	private String playerSymbol;

	public LogicEngine(String playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	
	public ArrayList<ArrayList<String>> takeTurn(ArrayList<ArrayList<String>> board) {
		for (int y = 0; y < board.size(); y++) {
			ArrayList<String> row = board.get(y);
			for (int x = 0; x < row.size(); x++) {
				String cell = row.get(x);
				if (cell.equals(EMPTY_CELL)) {
					row.set(x, playerSymbol);
					board.set(y,  row);
					return board;
				}
			}
		}
		return board;
	}
}
