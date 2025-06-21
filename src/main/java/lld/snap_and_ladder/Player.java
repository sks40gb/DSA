package lld.snap_and_ladder;

public class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Start position
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps) {
        position += steps;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
