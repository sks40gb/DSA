package lld.snap_and_ladder;

import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private Dice dice;

    public Game(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
        this.dice = new Dice();
    }

    public void startGame() {
        boolean isWon = false;
        while (!isWon) {
            for (Player player : players) {
                int diceValue = dice.roll();
                int newPosition = player.getPosition() + diceValue;

                if (newPosition >= board.getSize()) {
                    isWon = true;
                    System.out.println(player.getName() + " wins!");
                    break;
                } else {
                    Cell cell = board.getCell(newPosition);
                    if (cell.getSnake() != null) {
                        System.out.println(player.getName() + " got bitten by a snake!");
                        player.setPosition(cell.getSnake().getEnd());
                    } else if (cell.getLadder() != null) {
                        System.out.println(player.getName() + " climbed a ladder!");
                        player.setPosition(cell.getLadder().getEnd());
                    } else {
                        player.setPosition(newPosition);
                    }
                }

                System.out.println(player.getName() + " is now at position " + player.getPosition());
            }
        }
    }
}
