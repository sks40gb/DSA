package lld.elevator.panels;

import lld.elevator.Direction;
import lld.elevator.buttons.HallButton;

import java.util.ArrayList;
import java.util.List;

public class OutsidePannel implements Pannel {
    private List<HallButton> hallButtons;

    public OutsidePannel() {
        hallButtons = new ArrayList<>();
        hallButtons.add(new HallButton(false, Direction.UP));
        hallButtons.add(new HallButton(false, Direction.DOWN));
        hallButtons.add(new HallButton(false, Direction.IDLE));
    }

    public void moveUp() {

    }

    public void moveDown() {

    }
}
