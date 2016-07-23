package pizza.Recktangles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square {
	private String word;
	private int width;
	private int height;
	public int numberOfCharactersWidth;
	public int numberOfCharactersHeight;
	private ArrayList<ArrayList<String>> grid;

	public Square(String word, int width, int height) {
		this.word = word;
		this.width = width;
		this.height = height;
	}
	
	public ArrayList<ArrayList<String>> parse() {
		grid = new ArrayList<ArrayList<String>>();
		int length = word.length();
		calculateSquareDimensions();
		appendFirstRow();
		for (int i = 0; i < length; i++) {
			appendRow(i);
		}
		return grid;
	}

	public void calculateSquareDimensions() {
		numberOfCharactersWidth = calculateCharacters(width);
		numberOfCharactersHeight = calculateCharacters(height);
	}

	private int calculateCharacters(int dimension) {
		int EXCLUDE_FIRST_LENGTH = 1;
		int length = word.length();
		int numberOfOverlappingCharacters = dimension - EXCLUDE_FIRST_LENGTH;
		return (dimension * length) - numberOfOverlappingCharacters;
	}

	private void appendRow(int i) {
		ArrayList<String> row = new ArrayList<String>();
		
		grid.add(row);
	}

	private void appendFirstRow() {
		String[] characters = word.split("");
		List<String> list = Arrays.asList(characters);
		ArrayList<String> row = new ArrayList<String>(list);
		grid.add(row);
	}
}
