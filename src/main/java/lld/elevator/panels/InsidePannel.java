package lld.elevator.panels;

import lld.elevator.DoorAction;
import lld.elevator.FloorNumber;
import lld.elevator.buttons.DoorButton;
import lld.elevator.buttons.ElevatorButton;

import java.util.ArrayList;
import java.util.List;

public class InsidePannel implements Pannel{
    private List<ElevatorButton> elevatorButtonList;
    private List<DoorButton> doorButtons;

    public InsidePannel() {
        elevatorButtonList=new ArrayList<>();
        doorButtons=new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            elevatorButtonList.add(new ElevatorButton(false, FloorNumber.values()[i]));
        }

        for (int i = 0; i <3 ; i++) {
            doorButtons.add(new DoorButton(false, DoorAction.values()[i]));
        }
    }

    public boolean pressFloorButton(int floorNumber) {
        return elevatorButtonList.get(floorNumber).press();
    }
    public boolean pressDoorButton(int doorNumber) {
        return doorButtons.get(doorNumber).press();
    }
}
