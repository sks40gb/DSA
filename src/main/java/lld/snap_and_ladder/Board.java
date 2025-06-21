package lld.snap_and_ladder;

import java.util.List;

public class Board {
    private List<Cell> cells;
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.cells = createCells(size, snakes, ladders);
    }

    private List<Cell> createCells(int size, List<Snake> snakes, List<Ladder> ladders) {
        // Initialize cells and assign snakes and ladders to specific cells
        // ...
        return null;
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }

    public int getSize() {
        return size;
    }
}
