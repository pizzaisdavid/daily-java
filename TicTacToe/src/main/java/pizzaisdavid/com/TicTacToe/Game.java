package pizzaisdavid.com.TicTacToe;

public class Game {
  
  public static boolean isPlayerTurn(String player) {
    TextFile file = new TextFile("whos_turn");
    System.out.println(file.getLines());
    return file.getLines().get(0).equals(player);
  }

}
