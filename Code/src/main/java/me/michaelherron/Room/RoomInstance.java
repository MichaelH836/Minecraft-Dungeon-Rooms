package me.michaelherron.Room;

import me.michaelherron.Room.Entrance.Entrance;

import java.util.ArrayList;

public class RoomInstance {
    private DungeonRoom roomType;
    private ArrayList<Entrance> availableEntrances;
    private int entranceID;

    public RoomInstance(DungeonRoom roomType, Entrance entrance) {
        this.roomType = roomType;
        this.availableEntrances = roomType.getEntrances();
        this.availableEntrances.remove(entrance);
    }

    public RoomInstance(DungeonRoom roomType) {
        this.roomType = roomType;
        this.availableEntrances = roomType.getEntrances();
    }

    public ArrayList<Entrance> getAvailableEntrances() {
        return this.availableEntrances;
    }
}